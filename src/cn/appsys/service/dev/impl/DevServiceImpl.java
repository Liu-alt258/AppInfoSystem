package cn.appsys.service.dev.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.dev.DevMapper;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.dev.DevService;
@Service
public class DevServiceImpl implements DevService {

	@Resource
	private DevMapper devMapper;
	
	@Override
	public DevUser login(String devCode) {
		// TODO Auto-generated method stub
		return devMapper.getDevByCode(devCode);
	}

}
