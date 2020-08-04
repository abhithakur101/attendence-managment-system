package com.ams.response;

import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

import com.ams.modal.Location;

@ResponseBody
public class LocationResponse {

	private List<Location> locations;

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

}
