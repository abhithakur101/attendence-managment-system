package com.ams.request;

public class SubLocationRequest {

	private Long locId;

	private String locationName;

	private Double latitude;

	private Double longitude;

	public Long getLocId() {
		return locId;
	}

	public void setLocId(Long locId) {
		this.locId = locId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public boolean checkNull() throws IllegalAccessException {
		for (java.lang.reflect.Field f : getClass().getDeclaredFields())
			if (f.get(this) != null)
				return false;
		return true;
	}

}
