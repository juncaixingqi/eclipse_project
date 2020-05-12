package cn.tedu.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.dao.CostDao;
import cn.tedu.entity.Cost;

@Service
@Transactional
//从服务器接收指令，控制dao层的交互
public class CostServiceImpl implements CostService {

	@Resource
	private CostDao costDao;
	
	public boolean checkName(String name) {
		Cost c = costDao.findByName(name);
		return c == null;
	}

	public List<Cost> findAll() {
		return costDao.findAll();
	}

	public Cost findById(int id) {
		return costDao.findById(id);
	}

	public void update(Cost cost) {
		//有3个字段不需要修改:
		//status,creatime,startime
		//但由于映射文件中所有字段都配置了,
		//因此Hibernate默认会修改所有字段.
		Cost old = costDao.findById(cost.getCostId());
		old.setName(cost.getName());
		old.setBaseDuration(cost.getBaseDuration());
		old.setBaseCost(cost.getBaseCost());
		old.setUnitCost(cost.getUnitCost());
		old.setDescr(cost.getDescr());
		old.setCostType(cost.getCostType());
		costDao.update(old);
	}

	public Cost add(Cost cost) {
		Timestamp nowdate = new Timestamp(System.currentTimeMillis());
		cost.setCreatime(nowdate);
		costDao.add(cost);
		return cost;
	}

	public void delete(Cost cost) {
		System.out.println("delete跑起来");
		costDao.delete(cost);
	}

}






