package com.ams.response;

import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

import com.ams.modal.Sublocation;

@ResponseBody
public class SubLocationResponse {

	private List<Sublocation> subLocations;

	public List<Sublocation> getSubLocations() {
		return subLocations;
	}

	public void setSubLocations(List<Sublocation> subLocations) {
		this.subLocations = subLocations;
	}
	
	
}
