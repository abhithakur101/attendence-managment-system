package com.ams.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.modal.Location;
import com.ams.modal.Sublocation;
import com.ams.repository.LocationRepository;
import com.ams.repository.SubLocRepository;
import com.ams.request.LocationRequest;
import com.ams.request.SubLocationRequest;
import com.ams.service.MasterService;

@Service
public class MasterServiceImpl implements MasterService {
	@Autowired
	LocationRepository locRepo;

	@Autowired
	SubLocRepository subLocRepo;

	@Override
	public List<Location> getLocation() {
		return locRepo.findAll();
	}

	@Override
	public List<Sublocation> getSubLocation(Long locId) {

		return subLocRepo.getSubLocationByLocId(locId);
	}

	@Override
	public List<Location> addLocation(LocationRequest request) {
		try {
			if (!request.checkNull()) {
				Location location = new Location();
				location.setName(request.getLocationName());
				location.setLatitude(request.getLatitude());
				location.setLongitude(request.getLongitude());
				locRepo.save(location);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return locRepo.findAll();
	}

	@Override
	public List<Sublocation> addSubLocation(SubLocationRequest request) {
		
		try {
			
			if(!request.checkNull()) {
				Sublocation sublocation  = new Sublocation();
				sublocation.setLatitude(request.getLatitude());
				sublocation.setLocId(request.getLocId());
				sublocation.setLongitude(request.getLongitude());
				sublocation.setName(request.getLocationName());
				subLocRepo.save(sublocation);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subLocRepo.getSubLocationByLocId(request.getLocId());
	}

}
