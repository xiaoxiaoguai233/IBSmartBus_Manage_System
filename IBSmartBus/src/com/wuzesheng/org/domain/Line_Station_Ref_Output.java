package com.wuzesheng.org.domain;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月17日 下午7:44:13
 */

public class Line_Station_Ref_Output {
	
	private Integer id;
	private String lineName;
	private String stationName;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Line_Station_Ref_Output [id=" + id + ", lineName=" + lineName
				+ ", stationName=" + stationName + "]";
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @return the lineName
	 */
	public String getLineName() {
		return lineName;
	}
	/**
	 * @return the stationName
	 */
	public String getStationName() {
		return stationName;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @param lineName the lineName to set
	 */
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	/**
	 * @param stationName the stationName to set
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}	
}
