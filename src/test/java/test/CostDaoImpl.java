package test;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import cn.tedu.entity.Cost;
//dao层，与数据可以交互
@Repository
public class CostDaoImpl implements CostDao {

    public void update(String cost) {
       System.out.println("删除");
    }
	
	
}







