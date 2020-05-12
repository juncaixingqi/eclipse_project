package cn.tedu.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.service.LoginService;

@Controller
@Scope("prototype")
public class LoginAction {

	@Resource
	private LoginService loginService;
	
	//传入的参数
	private String adminCode;//名字与jsp中的name名字一直。
	private String pwd;
	private String code;
	  
	//传出的参数
	private String error;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String execute() {
		//检查验证码
		HttpSession session = ServletActionContext.getRequest().getSession();
		String imgcode = (String)session.getAttribute("imgcode");//在VerifyCodeAction.java
		//中设定的
		if(code == null|| !code.equalsIgnoreCase(imgcode)) {
			error = "验证码错误";
			return "error";
		}
		
		int i = loginService.checkUser(adminCode, pwd);
		if(i == 1) {
			//账号错误
			error = "账号错误";
			return "error";
		} else if(i == 2) {
			//密码错误
			error = "密码错误";
			return "error";
		} else {
			//检查通过
			return "success";
		}
	}
	
}
















