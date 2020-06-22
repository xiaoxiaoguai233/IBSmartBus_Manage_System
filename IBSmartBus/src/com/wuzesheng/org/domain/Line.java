package com.wuzesheng.org.domain;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月16日 下午1:36:44
 */

public class Line {

	private Integer lineCode;
	private String lineName;
	private String startLineTime;
	private String direction;
	private String status;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Line [lineCode=" + lineCode + ", lineName=" + lineName
				+ ", startLineTime=" + startLineTime + ", direction="
				+ direction + ", status=" + status + "]";
	}

	
	/**
	 * @return the lineCode
	 */
	public Integer getLineCode() {
		return lineCode;
	}

	/**
	 * @return the lineName
	 */
	public String getLineName() {
		return lineName;
	}

	/**
	 * @return the startLineTime
	 */
	public String getStartLineTime() {
		return startLineTime;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param lineCode the lineCode to set
	 */
	public void setLineCode(Integer lineCode) {
		this.lineCode = lineCode;
	}

	/**
	 * @param lineName the lineName to set
	 */
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	/**
	 * @param startLineTime the startLineTime to set
	 */
	public void setStartLineTime(String startLineTime) {
		this.startLineTime = startLineTime;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
