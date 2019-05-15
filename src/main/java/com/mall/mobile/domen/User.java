package com.mall.mobile.domen;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable{
	
	
    /**
	 * 用户信息表
	 */
	private static final long serialVersionUID = 762548305000257725L;

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 邮箱
	 */
	private String EmailAddress;

	/**
	 * 密码
	 */
	private String Password;

	/**
	 * 姓
	 */
	private String firstName;
	/**
	 * 名
	 */
	private String lastName;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 生日
	 */
	private String birthday;
	/**
	 * token
	 */
	private String token;
	/**
	 * 消息推送
	 */
	private String fireBaseToken;

	/**
	 * 用户创建时间
	 */
	private Date createDate;
	/**
	 * 修改时间
	 */
	private Date updateDate;

	/**
	 * 是否验证
	 */
	private String verified;

	/**
	 * 肤色
	 */
	private String skincolour;

	/**
	 * 肤质
	 */
	private String skintexture;


	/**
	 * 发型
	 */
	private String hairstyle;


	/**
	 * 发质
	 */
	private String hairquality;

	/**
	 * 眼睛颜色
	 */
	private String eyecolor;

	/**
	 * 所选语言种类
	 */
	private String languagetype;

	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getFireBaseToken() {
		return fireBaseToken;
	}

	public void setFireBaseToken(String fireBaseToken) {
		this.fireBaseToken = fireBaseToken;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public String getSkincolour() {
		return skincolour;
	}

	public void setSkincolour(String skincolour) {
		this.skincolour = skincolour;
	}

	public String getSkintexture() {
		return skintexture;
	}

	public void setSkintexture(String skintexture) {
		this.skintexture = skintexture;
	}

	public String getHairstyle() {
		return hairstyle;
	}

	public void setHairstyle(String hairstyle) {
		this.hairstyle = hairstyle;
	}

	public String getHairquality() {
		return hairquality;
	}

	public void setHairquality(String hairquality) {
		this.hairquality = hairquality;
	}

	public String getEyecolor() {
		return eyecolor;
	}

	public void setEyecolor(String eyecolor) {
		this.eyecolor = eyecolor;
	}

	public String getLanguagetype() {
		return languagetype;
	}

	public void setLanguagetype(String languagetype) {
		this.languagetype = languagetype;
	}
}