package br.com.barrostech.bar.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fotos")
public class FotosController {
	
	@PostMapping
	public String upload(MultipartFile[] files) {
		
		
		return "ok";
	}

}
