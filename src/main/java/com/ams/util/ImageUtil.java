package com.ams.util;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {

	public static void uploadImage(MultipartFile file, String empId) {
		try {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			String uploadDir = "./upload/" + empId + "/"+LocalDate.now();
			System.out.println(uploadDir);
			Path path = Paths.get(uploadDir);
			if (!Files.exists(path)) {
				Files.createDirectories(path);
			}
			InputStream inputStream = file.getInputStream();
			Path uploadPath = path.resolve(fileName);
			Files.copy(inputStream, uploadPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.getStackTrace().toString();
		}
	}
}
