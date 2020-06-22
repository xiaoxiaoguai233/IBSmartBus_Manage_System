package com.wuzesheng.org.domain;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月15日 下午11:02:17
 */

public class Bus {
	
	private Integer BusCode;
	private String BusLicense;
	private String BusType;
	private String Status;
	private String StartTime;
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bus [BusCode=" + BusCode + ", BusLicense=" + BusLicense
				+ ", BusType=" + BusType + ", Status=" + Status
				+ ", StartTime=" + StartTime + "]";
	}
	/**
	 * @return the busCode
	 */
	public Integer getBusCode() {
		return BusCode;
	}
	/**
	 * @return the busLicense
	 */
	public String getBusLicense() {
		return BusLicense;
	}
	/**
	 * @return the busType
	 */
	public String getBusType() {
		return BusType;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return Status;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return StartTime;
	}
	/**
	 * @param busCode the busCode to set
	 */
	public void setBusCode(Integer busCode) {
		BusCode = busCode;
	}
	/**
	 * @param busLicense the busLicense to set
	 */
	public void setBusLicense(String busLicense) {
		BusLicense = busLicense;
	}
	/**
	 * @param busType the busType to set
	 */
	public void setBusType(String busType) {
		BusType = busType;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	
	
}
