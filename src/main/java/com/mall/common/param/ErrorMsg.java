package com.mall.common.param;

public enum ErrorMsg {
	E200("Success", 200),
	E400("服务器不理解请求的语法。", 400), 
	E401("请求要求进行身份验证。", 401), 
	E403("服务器拒绝请求。",403), 
	E404("服务器找不到请求的接口。", 404), 
	E900("当前账户异常，请重新登录！", 900),
	E901("操作失败", 901),
	E902("系统错误", 902),
	E903("没有权限", 903),
	E904("调用核心系统失败",904),
	E905("访问缓存失败!",905),
	E906("无效邮箱!",906),
	E907("无效密码!",907),
	E908("该邮箱以存在!",908),
	E909("邮箱或密码不正确!",909),
	E910("此帐户不存在!",910),
	E911("请选择选项!",911),
	E912("该卡号已存在!",912),
	E913("邮箱或密码不正确!",913);
	// 成员变量
	private String msg;
	private int code;

	// 构造方法
	private ErrorMsg(String msg, int code) {
		this.msg = msg;
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

}
