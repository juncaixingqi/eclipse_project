package cn.tedu.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.service.CostService;

@Controller
@Scope("prototype")
public class CheckCostNameAction {

	@Resource
	private CostService costService;
	
	//传入的参数
	private String name;

	//传出的参数
	private boolean pass;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}
	
	public String execute() {
		pass = costService.checkName(name);
		return "success";
	}
	
}















