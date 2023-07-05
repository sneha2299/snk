package com.testingAPI.blog.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.testingAPI.blog.payload.FileResponse;
import com.testingAPI.blog.services.FileService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/file")
public class FileController {
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	@PutMapping("/upload/postID/{postID}")
	public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image,@PathVariable Integer postID ){
		
		String filename = null;
		try {
			filename = this.fileService.uploadImage(path, image,postID);
		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<FileResponse>(new FileResponse(null, "Image is not uploaded due to some error on server!!!"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<FileResponse>(new FileResponse(filename, "Image is successfully uploaded"),HttpStatus.OK);
	}
	
	//method to serve file
	
	@GetMapping(value = "/post/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadFile(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException
	{
		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}
}
