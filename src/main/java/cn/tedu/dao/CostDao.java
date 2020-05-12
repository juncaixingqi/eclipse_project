package cn.tedu.dao;

import java.util.List;

import cn.tedu.entity.Cost;

public interface CostDao {
	
	Cost findByName(String name);
	
	List<Cost> findAll();
	
	Cost findById(int id);
	
	void update(Cost cost);
	
	void add(Cost cost);
	
	void delete(Cost cost);

}







