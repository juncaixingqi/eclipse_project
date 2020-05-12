package cn.tedu.dao;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import cn.tedu.entity.Cost;
/*dao层，与数据可以交互
 * @SuppressWarnings("unchecked") 告诉编译器忽略 unchecked 警告信息，
 * 如使用List，ArrayList等未进行参数化产生的警告信息。
 */
@Repository
public class CostDaoImpl implements CostDao {
	@Resource
	private HibernateTemplate ht;

	public Cost findByName(String name) {
		if(name == null)
			return null;
		String hql = "from Cost where name=?";
		@SuppressWarnings("unchecked")
        List<Cost> list = ht.find(hql, name);
		return list == null || list.isEmpty()? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
    public List<Cost> findAll() {
		String hql = "from Cost";
		return ht.find(hql);
	}

	public Cost findById(int id) {
		return ht.load(Cost.class, id);
	}

	public void update(Cost cost) {
		ht.update(cost);
	}

	public void add(Cost cost) {
		ht.save(cost);
	}

	public void delete(Cost cost) {
		ht.delete(cost);
		
	}
}







