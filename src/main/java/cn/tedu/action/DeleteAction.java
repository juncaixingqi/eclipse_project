package cn.tedu.action;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.tedu.entity.Cost;
import cn.tedu.service.CostService;
@Controller
@Scope("prototype")

public class DeleteAction {
	@Resource
	private CostService costService;
	private int id;
	private Cost cost;//浏览器传cost进来
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CostService getCostService() {
		return costService;
	}

	public void setCostService(CostService costService) {
		this.costService = costService;
	}
	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}
	
	public String execute() {
		cost = costService.findById(id);//要先根据这个读取来的ID，找到他的属性，再删掉这个元素，
        //要不然cost只是空的。数据库找ID，但是hibernate找的是属性，完整的属性
		System.out.println("deleteAction1");
		costService.delete(cost);//复制过来，这里没有改，add空指针异常
		System.out.println("deleteAction2");
		return "success";
	}
	
}
