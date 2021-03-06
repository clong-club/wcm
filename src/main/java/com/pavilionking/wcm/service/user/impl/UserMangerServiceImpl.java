package com.pavilionking.wcm.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pavilionking.wcm.common.constant.PageUtils;
import com.pavilionking.wcm.common.constant.ResponseMessage;
import com.pavilionking.wcm.dao.WUserMapper;
import com.pavilionking.wcm.dto.WUser;
import com.pavilionking.wcm.dto.WUserExample;
import com.pavilionking.wcm.service.user.UserManagerService;

@Service
public class UserMangerServiceImpl implements UserManagerService {

	@Resource
	private WUserMapper userMapper;
	
	@Override
	public void list(ResponseMessage result, PageUtils pageUtils) {
		WUserExample example = new WUserExample();
		long count = userMapper.countByExample(example);
		pageUtils.setCount(count);
		example.setLimitStart(pageUtils.getRows());
		example.setLimitEnd(pageUtils.getStartNum());
		List<WUser> list = userMapper.selectByExample(example);
		result.setPage(pageUtils);
		result.setData(list);
	}
}
