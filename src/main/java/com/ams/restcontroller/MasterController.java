package com.ams.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ams.modal.Location;
import com.ams.modal.Sublocation;
import com.ams.response.LocationResponse;
import com.ams.response.SubLocationResponse;
import com.ams.service.MasterService;

@RestController
public class MasterController {

	@Autowired
	MasterService service;
	
	LocationResponse  locResponse;
	
	SubLocationResponse subLocResponse;

	@GetMapping("/getloc")
	public ResponseEntity<LocationResponse> getlocation() {
		
		locResponse =  new LocationResponse();
		List<Location> location = service.getLocation();
		locResponse.setLocations(location);
		return ResponseEntity.status(HttpStatus.OK).body(locResponse);
		
	}
	
	@GetMapping("/getSubloc")
	public ResponseEntity<SubLocationResponse> getSublocation(@RequestParam Long locId) {
		subLocResponse =  new SubLocationResponse();
		List<Sublocation> subLocations = service.getSubLocation(locId);
		subLocResponse.setSubLocations(subLocations);
		return ResponseEntity.status(HttpStatus.OK).body(subLocResponse);
		
	}
	
}
