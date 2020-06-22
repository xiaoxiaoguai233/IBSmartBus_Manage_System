package com.wuzesheng.org.domain;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月17日 上午9:35:46
 */

public class Scheduling {
	
	private Integer schedulingCode;
	private String lineCode;
	private String busLicense;
	private String tcNumber;
	private String tcTime;
	private String userCode;
	private String startStation;
	private String endStation;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Scheduling [schedulingCode=" + schedulingCode + ", lineCode="
				+ lineCode + ", busLicense=" + busLicense + ", tcNumber="
				+ tcNumber + ", tcTime=" + tcTime + ", userCode=" + userCode
				+ ", startStation=" + startStation + ", endStation="
				+ endStation + "]";
	}

	/**
	 * @return the schedulingCode
	 */
	public Integer getSchedulingCode() {
		return schedulingCode;
	}

	/**
	 * @return the lineCode
	 */
	public String getLineCode() {
		return lineCode;
	}

	/**
	 * @return the busLicense
	 */
	public String getBusLicense() {
		return busLicense;
	}

	/**
	 * @return the tcNumber
	 */
	public String getTcNumber() {
		return tcNumber;
	}

	/**
	 * @return the tcTime
	 */
	public String getTcTime() {
		return tcTime;
	}

	/**
	 * @return the userCode
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * @return the startStation
	 */
	public String getStartStation() {
		return startStation;
	}

	/**
	 * @return the endStation
	 */
	public String getEndStation() {
		return endStation;
	}

	/**
	 * @param schedulingCode the schedulingCode to set
	 */
	public void setSchedulingCode(Integer schedulingCode) {
		this.schedulingCode = schedulingCode;
	}

	/**
	 * @param lineCode the lineCode to set
	 */
	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}

	/**
	 * @param busLicense the busLicense to set
	 */
	public void setBusLicense(String busLicense) {
		this.busLicense = busLicense;
	}

	/**
	 * @param tcNumber the tcNumber to set
	 */
	public void setTcNumber(String tcNumber) {
		this.tcNumber = tcNumber;
	}

	/**
	 * @param tcTime the tcTime to set
	 */
	public void setTcTime(String tcTime) {
		this.tcTime = tcTime;
	}

	/**
	 * @param userCode the userCode to set
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * @param startStation the startStation to set
	 */
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	/**
	 * @param endStation the endStation to set
	 */
	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}
	
	
	
}
