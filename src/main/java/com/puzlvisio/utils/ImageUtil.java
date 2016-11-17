package com.puzlvisio.utils;

import com.puzlvisio.entity.Gallery;
import com.puzlvisio.entity.Picture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

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

	public void saveImage(MultipartFile file, Picture picture) {

		File rootFolder = new File(getPathToImage(picture.getGallery()));

		if (!file.isEmpty()) {
			try {
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(rootFolder + picture.getId() + EXT_JPG)));
				FileCopyUtils.copy(file.getInputStream(), stream);
				stream.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private String getPathToImage(Gallery gallery) {
		return mainDir + gallery.getType() + File.separator + gallery.getName() + File.separator;
	}
}
