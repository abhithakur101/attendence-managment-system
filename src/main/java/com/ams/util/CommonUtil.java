package com.ams.util;

import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GlobalPosition;

public class CommonUtil {

	public static Boolean checklocation() {
		GeodeticCalculator geoCalc = new GeodeticCalculator();
		Ellipsoid reference = Ellipsoid.WGS84;
		GlobalPosition pointA = new GlobalPosition(23.237920, 77.425470, 0.0);
		GlobalPosition userPos = new GlobalPosition(23.229891, 77.437286, 0.0);
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
}
