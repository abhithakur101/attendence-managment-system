package com.ams.util;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GlobalPosition;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class CommonUtil {

	public static Boolean checklocation(Double latitude,Double longitude) {
		GeodeticCalculator geoCalc = new GeodeticCalculator();
		Ellipsoid reference = Ellipsoid.WGS84;
		//cedmap pos
		GlobalPosition pointA = new GlobalPosition(23.237920, 77.425470, 0.0);
		//Mpeb location
		GlobalPosition pointB = new GlobalPosition(23.253870,77.441272, 0.0);
		
		GlobalPosition userPos = new GlobalPosition(latitude, longitude, 0.0);
		double distance = geoCalc.calculateGeodeticCurve(reference, userPos, pointA).getEllipsoidalDistance();
		int flag = Double.compare(distance, 500);
		if (flag < 0) {
			return true;
		} else if (flag > 0) {
			return false;
		} else {
			return true;
		}
	}
	


	public static void uploadImage(MultipartFile file, String empId) {
		try {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			String uploadDir = "./upload/" + empId + "/"+LocalDate.now();
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
