package cn.appsys.service.backend.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.backend.BackendMapper;
import cn.appsys.pojo.BackendUser;
import cn.appsys.service.backend.BackendService;
@Service
public class BackendServiceImpl implements BackendService {
		@Resource
		private BackendMapper backendMapper;
	@Override
	public BackendUser login(String userCode) {
		// TODO Auto-generated method stub
		return backendMapper.getBackendByCode(userCode);
	}

}
