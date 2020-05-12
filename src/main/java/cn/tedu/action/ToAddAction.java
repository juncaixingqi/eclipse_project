package cn.tedu.action;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.tedu.entity.Cost;
import cn.tedu.service.CostService;
@Controller
@Scope("prototype")

public class ToAddAction {
	@Resource
	private CostService costService;
	
	
	public CostService getCostService() {
		return costService;
	}

	public void setCostService(CostService costService) {
		this.costService = costService;
	}

	private Cost cost;//浏览器传cost进来


	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}
	
	public String execute() {
		System.out.println("ToAddAction1");
		cost = costService.add(cost);
		System.out.println("ToAddAction2");
		return "success";
	}
	
}
