package cn.tedu.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.entity.Cost;
import cn.tedu.service.CostService;

@Controller
@Scope("prototype")
public class FindCostAction {
	
	@Resource
	private CostService costService;
	
	private List<Cost> costs;

	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}

	public String execute() {
		costs = costService.findAll();//形成集合以后再传给服务器的
		return "success";
	}
	
}































