package com.puzlvisio.web;

import com.puzlvisio.service.PictureService;
import com.puzlvisio.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Chudov A.V. on 11/17/2016.
 */
@Controller
public class ImageController {

	@Autowired
	private ImageUtil imageUtil;

	@Autowired
	private PictureService pictureService;

	private static final String JPG = "jpg";
	private static final String CONTENT_TYPE = "image/jpeg";

	@RequestMapping(value = "/picture/{pictureId}/image", method = RequestMethod.GET)
	public void service(@PathVariable String pictureId, HttpServletRequest request,
						HttpServletResponse response) throws IOException {

		response.setContentType(CONTENT_TYPE);
		OutputStream osP = response.getOutputStream();
		BufferedImage imgP = ImageIO.read(imageUtil.getImage(pictureService.getById(pictureId)));
		ImageIO.write(imgP, JPG, osP);
		osP.close();
	}
}
