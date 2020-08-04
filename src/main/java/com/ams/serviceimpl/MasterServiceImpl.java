package com.ams.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.modal.Location;
import com.ams.modal.Sublocation;
import com.ams.repository.LocationRepository;
import com.ams.repository.SubLocRepository;
import com.ams.service.MasterService;

@Service
public class MasterServiceImpl implements MasterService {
	@Autowired
	LocationRepository locRepo;
	
	@Autowired
	SubLocRepository subLocRepo;

	@Override
	public List<Location> getLocation() {
		Object obj;
		return locRepo.findAll();
	}
	
	@Override
	public List<Sublocation> getSubLocation(Long locId) {
		
		return subLocRepo.getSubLocationByLocId(locId);
	}

}
