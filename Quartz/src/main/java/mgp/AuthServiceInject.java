package mgp;

import mgp.HelloJob.AuthDao;

public class AuthServiceInject {

	private AuthDao dao;
	
	public boolean isLogin(String id) {
		boolean isLogin = dao.isLogin(id);
		if(isLogin) {
			
		}
		return isLogin;
	}
}
