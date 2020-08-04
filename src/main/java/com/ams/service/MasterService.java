package com.ams.service;

import java.util.List;

import com.ams.modal.Location;
import com.ams.modal.Sublocation;

public interface MasterService {

	public List<Location> getLocation();

	List<Sublocation> getSubLocation(Long locId);
}
