package com.pengbo.utils;

import java.math.BigDecimal;

/**
 * @description: 计算经纬度
 * @author: Mr.Liu
 * @version: v1.0
 * @create: 2019-06-24 23:29
 **/
public class GoogleMap {
	private static final double EARTH_RADIUS = 6378.137;

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 计算距离，精度到km
	 * 
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return
	 */
	public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(
				Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}
	/**
	 * 计算距离，精确到11位小数
	 * @param wd1
	 * @param jd1
	 * @param wd2
	 * @param jd2
	 * @return
	 */
	public static double d_jw(double wd1, double jd1, double wd2, double jd2) {
		double x, y, out;
		double PI = 3.14159265;
		double R = 6.371229 * 1e6;

		x = (jd2 - jd1) * PI * R * Math.cos(((wd1 + wd2) / 2) * PI / 180) / 180;
		y = (wd2 - wd1) * PI * R / 180;
		out = Math.hypot(x, y);
		return out / 1000;
	}
	/**
	 * 精确到米，0为小数，向上取整
	 * @param wd1
	 * @param jd1
	 * @param wd2
	 * @param jd2
	 * @return
	 */
	public static BigDecimal getDistanceByBigDecimal(BigDecimal wd1, BigDecimal jd1, BigDecimal wd2, BigDecimal jd2) {
		double distance = d_jw(wd1.doubleValue(), jd1.doubleValue(), wd2.doubleValue(), jd2.doubleValue());
		BigDecimal bigDistance = BigDecimal.valueOf(distance);
		bigDistance = bigDistance.setScale(3, BigDecimal.ROUND_UP);
		return bigDistance;
	}


}
