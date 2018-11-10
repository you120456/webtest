package com.entity;

import java.sql.Timestamp;

/**
 * 用户信息管理的实体类
 * 
 * @author zhangjinyou
 * 
 */
public class UserInfo {

	private Integer userId;

	private Integer roleId;

	private String userNumber;

	private String userPw;

	private String userName;

	private String userSex;

	private Integer userAge;

	private String userAddress;

	private Timestamp userBirthday;

	private String userPhone;

	private String userMark;

	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Timestamp getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Timestamp userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserMark() {
		return userMark;
	}

	public void setUserMark(String userMark) {
		this.userMark = userMark;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", roleId=" + roleId
				+ ", userNumber=" + userNumber + ", userPw=" + userPw
				+ ", userName=" + userName + ", userSex=" + userSex
				+ ", userAge=" + userAge + ", userAddress=" + userAddress
				+ ", userBirthday=" + userBirthday + ", userPhone=" + userPhone
				+ ", userMark=" + userMark + "]";
	}

}
