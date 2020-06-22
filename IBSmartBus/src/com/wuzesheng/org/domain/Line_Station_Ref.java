package com.wuzesheng.org.domain;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月16日 下午2:47:13
 */

public class Line_Station_Ref {
	
	private Integer id;
	private String lineCode;
	private String stationCode;
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Line_Station_Ref [id=" + id + ", lineCode=" + lineCode
				+ ", stationCode=" + stationCode + "]";
	}
	
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @return the lineCode
	 */
	public String getLineCode() {
		return lineCode;
	}
	/**
	 * @return the stationCode
	 */
	public String getStationCode() {
		return stationCode;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @param lineCode the lineCode to set
	 */
	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}
	/**
	 * @param stationCode the stationCode to set
	 */
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	
}
