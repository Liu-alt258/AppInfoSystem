package cn.appsys.dao.backend;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.BackendUser;

public interface BackendMapper {
	//ºóÌ¨µÇÂ¼
	public BackendUser getBackendByCode(@Param("userCode")String userCode);

}
