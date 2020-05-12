package cn.tedu.service;

public interface LoginService {
	
	/**
	 * @return
	 * 	0-通过;
	 * 	1-账号错误;
	 * 	2-密码错误;
	 */
	int checkUser(String code, String pwd);

}
