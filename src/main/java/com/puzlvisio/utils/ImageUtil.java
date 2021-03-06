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

	public File getImage(Picture picture) {
		return new File(getPathToImage(picture.getGallery()) + picture.getId() + EXT_JPG);
	}

	public File getGalleryImage(Gallery gallery) {
		return new File(getPathToImage(gallery) + gallery.getName() + EXT_JPG);
	}

	public void savePictureImage(MultipartFile file, Picture picture) {
		saveFile(file, getImage(picture));
	}

	public void	saveGallery(MultipartFile file, Gallery gallery){
		if(createGalleryDir(gallery)){
			saveFile(file, getGalleryImage(gallery));
		}
	}

	private void saveFile(MultipartFile inputFile, File outputFile) {
		if (!inputFile.isEmpty()) {
			try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFile))){
				FileCopyUtils.copy(inputFile.getInputStream(), outputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private String getPathToImage(Gallery gallery) {
		return mainDir + gallery.getType() + File.separator + gallery.getName() + File.separator;
	}

	public boolean createGalleryDir(Gallery gallery) {
		File myPath = new File(getPathToImage(gallery));
		return myPath.mkdir();
	}
}
