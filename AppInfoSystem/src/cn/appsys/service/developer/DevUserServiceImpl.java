package cn.appsys.service.developer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.devuser.DevUserMapper;
import cn.appsys.pojo.DevUser;

@Service
public class DevUserServiceImpl implements DevUserService {

	@Resource
	private DevUserMapper devUserMapper;
	
	@Override
	public DevUser getLoginUser(String devCode) {
		return devUserMapper.getLoginUser(devCode);
	}
	
}
