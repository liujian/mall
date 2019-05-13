package com.mall.common.param;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class BasicData<T> extends Basic {
	public BasicData(T data){
		super();
		this.data = data;	
	}

	public BasicData(){}
	public BasicData(int status, String msg){super(status,msg);}
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private T data;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public static BasicData CreateSucess() {
		return new BasicData(ErrorMsg.E200.getCode(),ErrorMsg.E200.getMsg());
	}
	public static<T> BasicData<T> CreateSucess(T data) {
		BasicData basicData = new BasicData(ErrorMsg.E200.getCode(),ErrorMsg.E200.getMsg());
		basicData.setData(data);
		return basicData;
	}
	public static BasicData CreateError() {
		BasicData basic = new BasicData(ErrorMsg.E901.getCode(),ErrorMsg.E901.getMsg());
		return basic;
	}
	public static BasicData CreateErrorMsg(String msg ) {
		BasicData basic = new BasicData(ErrorMsg.E901.getCode(),msg);
		return basic;
	}


	public static BasicData CreateErrorInvalidEmail(String languagetype) {
		BasicData basic=null;
		if("ZW".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E906.getCode(),ErrorMsg.E906.getMsg());
		}else if("JT".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E906.getCode(),ErrorMsg.E906.getMsg_jt());
		}else if("YW".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E906.getCode(),ErrorMsg.E906.getMsg_yw());
		}else{
			basic = new BasicData(ErrorMsg.E901.getCode(),ErrorMsg.E906.getMsg());
		}

		return basic;
	}
	public static BasicData CreateErrorInvalidPassWord(String languagetype) {
		BasicData basic=null;
		if("ZW".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E907.getCode(),ErrorMsg.E907.getMsg());
		}else if("JT".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E907.getCode(),ErrorMsg.E907.getMsg_jt());
		}else if("YW".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E907.getCode(),ErrorMsg.E907.getMsg_yw());
		}else{
			basic = new BasicData(ErrorMsg.E907.getCode(),ErrorMsg.E907.getMsg());
		}
		return basic;
	}

	public static BasicData CreateErrorRegist(String languagetype) {
		BasicData basic=null;
		if("ZW".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E908.getCode(),ErrorMsg.E908.getMsg());
		}else if("JT".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E908.getCode(),ErrorMsg.E908.getMsg_jt());
		}else if("YW".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E908.getCode(),ErrorMsg.E908.getMsg_yw());
		}else{
			basic = new BasicData(ErrorMsg.E908.getCode(),ErrorMsg.E908.getMsg());
		}
		return basic;
	}

	public static BasicData CreateErrorEmailOrPassword(String languagetype) {
		BasicData basic=null;
		if("ZW".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E909.getCode(),ErrorMsg.E909.getMsg());
		}else if("JT".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E909.getCode(),ErrorMsg.E909.getMsg_jt());
		}else if("YW".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E909.getCode(),ErrorMsg.E909.getMsg_yw());
		}else{
			basic = new BasicData(ErrorMsg.E909.getCode(),ErrorMsg.E909.getMsg());
		}
		return basic;
	}

	public static BasicData CreateErrorAccount(String languagetype) {
		BasicData basic=null;
		if("ZW".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E910.getCode(),ErrorMsg.E910.getMsg());
		}else if("JT".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E910.getCode(),ErrorMsg.E910.getMsg_jt());
		}else if("YW".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E910.getCode(),ErrorMsg.E910.getMsg_yw());
		}else{
			basic = new BasicData(ErrorMsg.E910.getCode(),ErrorMsg.E910.getMsg());
		}
		return basic;
	}

	public static BasicData CreateErrorOption(String languagetype) {
		BasicData basic=null;
		if("ZW".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E911.getCode(),ErrorMsg.E911.getMsg());
		}else if("JT".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E911.getCode(),ErrorMsg.E911.getMsg_jt());
		}else if("YW".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E911.getCode(),ErrorMsg.E911.getMsg_yw());
		}else{
			basic = new BasicData(ErrorMsg.E911.getCode(),ErrorMsg.E911.getMsg());
		}
		return basic;
	}

	public static BasicData CreateErrorCardExists(String languagetype) {
		BasicData basic=null;
		if("ZW".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E912.getCode(),ErrorMsg.E912.getMsg());
		}else if("JT".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E912.getCode(),ErrorMsg.E912.getMsg_jt());
		}else if("YW".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E912.getCode(),ErrorMsg.E912.getMsg_yw());
		}else{
			basic = new BasicData(ErrorMsg.E912.getCode(),ErrorMsg.E912.getMsg());
		}
		return basic;
	}

	public static BasicData CreateErrorInvalidUser(String languagetype) {
		BasicData basic=null;
		if("ZW".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E900.getCode(),ErrorMsg.E900.getMsg());
		}else if("JT".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E900.getCode(),ErrorMsg.E900.getMsg_jt());
		}else if("YW".equals(languagetype)){
			basic = new BasicData(ErrorMsg.E900.getCode(),ErrorMsg.E900.getMsg_yw());
		}else{
			basic = new BasicData(ErrorMsg.E900.getCode(),ErrorMsg.E900.getMsg());
		}
		return basic;
	}

	@JsonIgnore
	public boolean isError() {
		return 200!=this.getStatus();
	}

	@JsonIgnore
	public boolean issucess() {
		return 200==this.getStatus();
	}
}
