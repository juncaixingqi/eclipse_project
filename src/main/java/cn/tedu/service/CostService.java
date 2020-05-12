package cn.tedu.service;

import java.util.List;

import cn.tedu.entity.Cost;

public interface CostService {
	
	/**
	 * @param name
	 * @return
	 * 	检查通过: true
	 */
	boolean checkName(String name);
	
	List<Cost> findAll();

	Cost findById(int id);
	
	void update(Cost cost);
	
	Cost add(Cost cost);
	
	void delete(Cost cost);
	
}






