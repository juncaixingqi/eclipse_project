package cn.tedu.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.entity.Cost;
import cn.tedu.service.CostService;

@Controller
@Scope("prototype")
public class ToUpdateCostAction {

	@Resource
	private CostService costService;
	
	private int id;
	
	private Cost cost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}
	
	public String execute() {
		cost = costService.findById(id);
		return "success";//两个页面不能放在一起
	}
	
}



















