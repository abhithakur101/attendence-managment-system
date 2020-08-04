package com.ams.service;

import java.util.List;

import com.ams.modal.Location;
import com.ams.modal.Sublocation;
import com.ams.request.LocationRequest;
import com.ams.request.SubLocationRequest;

public interface MasterService {

	public List<Location> getLocation();

	List<Sublocation> getSubLocation(Long locId);

	public List<Location> addLocation(LocationRequest request);

	public List<Sublocation> addSubLocation(SubLocationRequest request);
}
