package cn.tedu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.dao.AdminDao;
import cn.tedu.entity.Admin;

@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	private AdminDao adminDao;
	
	public int checkUser(
		String code, String pwd) {
		Admin a = adminDao.findByCode(code);//查找用户名
		if(a == null) {
			return 1;
		} else if(!a.getPassword().equals(pwd)) {
			return 2;
		} else {
			return 0;
		}
	}

}






