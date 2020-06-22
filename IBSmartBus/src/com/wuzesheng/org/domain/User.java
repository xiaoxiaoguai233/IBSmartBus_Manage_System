package com.wuzesheng.org.domain;

/**
 * @Author 作者 : 吴泽胜
 * @Date 创建时间：2020年6月12日 上午1:06:45
 */

public class User {
	
	private Integer ID;
	private String UserName;
	private String PassWord;
	private String Name;
	private String phone;
	private String IdCard;
	private String Role;
	private String Driving;
	private String Status;
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [ID=" + ID + ", UserName=" + UserName + ", PassWord="
				+ PassWord + ", Name=" + Name + ", phone=" + phone
				+ ", IdCard=" + IdCard + ", Role=" + Role + ", Driving="
				+ Driving + ", Status=" + Status + ", getID()=" + getID()
				+ ", getUserName()=" + getUserName() + ", getPassWord()="
				+ getPassWord() + ", getName()=" + getName() + ", getPhone()="
				+ getPhone() + ", getIdCard()=" + getIdCard() + ", getRole()="
				+ getRole() + ", getDriving()=" + getDriving()
				+ ", getStatus()=" + getStatus() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return UserName;
	}
	/**
	 * @return the passWord
	 */
	public String getPassWord() {
		return PassWord;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return IdCard;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return Role;
	}
	/**
	 * @return the driving
	 */
	public String getDriving() {
		return Driving;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return Status;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}
	/**
	 * @param passWord the passWord to set
	 */
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		IdCard = idCard;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		Role = role;
	}
	/**
	 * @param driving the driving to set
	 */
	public void setDriving(String driving) {
		Driving = driving;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}
	
	
	
}
