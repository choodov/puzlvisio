package com.puzlvisio.utils;

import com.puzlvisio.domain.entities.Gallery;
import com.puzlvisio.domain.entities.Picture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by Chudov A.V. on 11/17/2016.
 */
@Component
public class ImageUtil {

	@Value("${main.dir}")
	private String mainDir;

	private static final String EXT_JPG = ".jpg";
	private static final String CONTENT_TYPE = "image/jpeg";

	public File getImage(Picture picture) {
		return new File(getPathToImage(picture.getGallery()) + picture.getId() + EXT_JPG);
	}

	public File getGalleryImage(Gallery gallery) {
		return new File(getPathToImage(gallery) + gallery.getName() + EXT_JPG);
	}

	public void saveImage(MultipartFile file, Picture picture) {

		File rootFolder = new File(getPathToImage(picture.getGallery()));

		if (!file.isEmpty()) {
			try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
					new File(rootFolder + File.separator + picture.getId() + EXT_JPG)))) {
				FileCopyUtils.copy(file.getInputStream(), stream);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private String getPathToImage(Gallery gallery) {
		return mainDir + gallery.getType() + File.separator + gallery.getName() + File.separator;
	}

	public void getImage(HttpServletResponse response, BufferedImage imgP) throws IOException {
		response.setContentType(CONTENT_TYPE);
		OutputStream osP = response.getOutputStream();
		ImageIO.write(imgP, EXT_JPG, osP);
		osP.close();
	}
}
