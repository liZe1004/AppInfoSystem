package cn.appsys.service.developer;

import cn.appsys.pojo.DevUser;

public interface DevUserService {
	public DevUser getLoginUser(String devCode);
}
