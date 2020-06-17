package com.assess.FileExplorerrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileDetailController {
	
	@GetMapping("/greeting")
	public String demoEndPoint() {
		return "Hellooooo Bandya!!!";
	}
}
