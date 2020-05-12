package cn.tedu.dao;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import cn.tedu.entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Resource
	private HibernateTemplate ht;
	public Admin findByCode(String code) {
		if(code == null) 
			return null;
		String hql = "from Admin where adminCode=?";
		List<Admin> list = ht.find(hql, code);
		return list == null || list.isEmpty() ? null : list.get(0);
	}
}
















