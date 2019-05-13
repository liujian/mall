package com.mall.mobile.in;

public class LoginParam {

	private String password;
	private String emailAddress;
	private String fireBaseToken;

	private String languagetype;

	public String getLanguagetype() {
		return languagetype;
	}

	public void setLanguagetype(String languagetype) {
		this.languagetype = languagetype;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFireBaseToken() {
		return fireBaseToken;
	}

	public void setFireBaseToken(String fireBaseToken) {
		this.fireBaseToken = fireBaseToken;
	}
}
