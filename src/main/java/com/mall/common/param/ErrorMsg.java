package com.mall.common.param;

public enum ErrorMsg {

	E200("成功!","成功!", "Success!",200),
	E900("当前账户异常，请重新登录!","當前帳戶异常，請重新登入!","Current account is abnormal, please log in again!", 900),
	E901("操作失败!","操作失敗!","operation failed!", 901),
	E906("无效邮箱!","無效郵箱!","Invalid mailbox!",906),
	E907("无效密码!","無效密碼!","Invalid password!",907),
	E908("该邮箱以存在!","該郵箱以存在!","The mailbox exists!",908),
	E909("邮箱或密码不正确!","郵箱或密碼不正確!","The mailbox or password is incorrect!",909),
	E910("此帐户不存在!","此帳戶不存在!","This account does not exist!",910),
	E911("请选择选项!","請選擇選項!","Please choose the option!",911),
	E912("该卡号已存在!","該卡號已存在!","The card number already exists!",912),
	E913("邮箱或密码不正确!","郵箱或密碼不正確!","The mailbox or password is incorrect!",913);
	// 成员变量
	private String msg;
	private String msg_ft;
	private String msg_yw;
	private int code;


	// 构造方法


	private ErrorMsg(String msg,String msg_ft,String msg_yw, int code) {
		this.msg = msg;
		this.msg_ft = msg_ft;
		this.msg_yw = msg_yw;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg_ft() {
		return msg_ft;
	}

	public void setMsg_ft(String msg_ft) {
		this.msg_ft = msg_ft;
	}

	public String getMsg_yw() {
		return msg_yw;
	}

	public void setMsg_yw(String msg_yw) {
		this.msg_yw = msg_yw;
	}
}
