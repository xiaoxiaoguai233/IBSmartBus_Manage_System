package com.wuzesheng.org.domain;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月16日 上午11:46:29
 */

public class Station {
	
	private Integer stationCode;	//id
	private String stationName;		//站点名字
	private String longitude;		//经度
	private String latitude;		//维度
	private String reqion;			//地区名字
	private String street;			//街区名
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Station [stationCode=" + stationCode + ", stationName="
				+ stationName + ", longitude=" + longitude + ", latitude="
				+ latitude + ", reqion=" + reqion + ", street=" + street + "]";
	}
	/**
	 * @return the stationCode
	 */
	public Integer getStationCode() {
		return stationCode;
	}
	/**
	 * @return the stationName
	 */
	public String getStationName() {
		return stationName;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @return the reqion
	 */
	public String getReqion() {
		return reqion;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param stationCode the stationCode to set
	 */
	public void setStationCode(Integer stationCode) {
		this.stationCode = stationCode;
	}
	/**
	 * @param stationName the stationName to set
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @param reqion the reqion to set
	 */
	public void setReqion(String reqion) {
		this.reqion = reqion;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	
	
}
