package com.puzlvisio.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Chudov A.V. on 12/14/2016.
 */
@Controller
public class MainController {

	@GetMapping("/")
	public String getIndexPage(Model model) {
		return "index";
	}
}
