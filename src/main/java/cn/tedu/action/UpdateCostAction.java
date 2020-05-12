package cn.tedu.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.entity.Cost;
import cn.tedu.service.CostService;

@Controller
@Scope("prototype")
public class UpdateCostAction {
	
	@Resource
	private CostService costService;
	
	private Cost cost;

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}
	
	public String execute() {
		costService.update(cost);
		return "success";
	}

}















