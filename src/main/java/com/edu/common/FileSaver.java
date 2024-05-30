package com.edu.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileSaver {


	 public static boolean saveFile(MultipartFile file, String fileName,String username) {
		boolean upload = false;
		String fileStorePath= FileSaver.getPath(username);
		try {
				Files.copy(file.getInputStream(), Paths.get(fileStorePath + File.separator + fileName),
						StandardCopyOption.REPLACE_EXISTING);
				upload = true;
		} catch (IOException e) {
			return upload;
		}
		return upload;
	}
	 
	 public static String getPath(String username) {
		 String fileDirectory="";
		 String cDrivePath = new File("C:\\").getAbsolutePath() + File.separator + "Kashish//Educonnect//ImageFolder" ;
	        
	        String folderName = username;
	        String folderPath = cDrivePath + File.separator + folderName;

	        File folder = new File(folderPath);
	        if (!folder.exists()) {
	            boolean folderCreated = folder.mkdirs();
	            if (!folderCreated) {
	                System.err.println("Failed to create the folder.");
	            }
	        }
	        fileDirectory = folderPath;
	    return fileDirectory;
	 }
	
}
