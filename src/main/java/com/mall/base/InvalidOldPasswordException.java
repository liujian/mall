package com.mall.base;

public class InvalidOldPasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	private Object invalidParameter;

	public InvalidOldPasswordException(){}

	public InvalidOldPasswordException(Object invalidParameter) {
		super();
		this.invalidParameter = invalidParameter;
	}

	public Object getInvalidParameter() {
		return invalidParameter;
	}

	public void setInvalidParameter(Object invalidParameter) {
		this.invalidParameter = invalidParameter;
	}
}
