package com.ams;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

public class Constants {
	static LocalDateTime d1 = LocalDateTime.of(2020, Month.JULY, 10, 10, 15);
	static LocalDateTime d2 = LocalDateTime.of(2020, Month.JULY, 10, 19, 00);
	public static final Date FIRST_MAX_IN = Date.from(d1.atZone(ZoneId.systemDefault()).toInstant());
	public static final Date FIRST_MIN_OUT = Date.from(d2.atZone(ZoneId.systemDefault()).toInstant());
	
	static LocalDateTime d3 = LocalDateTime.of(2020, Month.JULY, 10, 11, 15);
	static LocalDateTime d4 = LocalDateTime.of(2020, Month.JULY, 10, 20, 00);
	public static final Date SECOND_MAX_IN = Date.from(d1.atZone(ZoneId.systemDefault()).toInstant());
	public static final Date SECOND_MIN_OUT = Date.from(d2.atZone(ZoneId.systemDefault()).toInstant());
}
