package com.demo.storage.cloud.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.storage.cloud.service.FCSService;
import com.google.firebase.auth.FirebaseAuthException;

@RestController
@RequestMapping("/upload")
public class FcsStorageController {

	
	@Autowired
	private	FCSService serv;

	@PostMapping("/files")
	public String guardar (@RequestParam("file") MultipartFile file, String nameFile) throws IOException, FirebaseAuthException {
		if(file.isEmpty()) {
			return "Archivo vacio";
		}
		return serv.uploadFiles(file, nameFile);
	}
	
}
