package com.mall.common.param;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class Basic {
	
	private int status;
	private String msg;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date time ;
	public Basic(){
		this.status=200;
		this.msg="成功";
		this.time=new Date();
	}
	
	public Basic(int status, String msg){
		this.status=status;
		this.msg=msg;
		this.time=new Date();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	


}
