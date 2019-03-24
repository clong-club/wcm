package com.pavilionking.wcm.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pavilionking.wcm.common.constant.PageUtils;
import com.pavilionking.wcm.common.constant.ResponseMessage;
import com.pavilionking.wcm.dao.WGroupMapper;
import com.pavilionking.wcm.dto.WGroup;
import com.pavilionking.wcm.dto.WGroupExample;
import com.pavilionking.wcm.service.user.GroupManagerService;

@Service
public class GroupManagerServiceImpl implements GroupManagerService {

	
	@Resource
	private WGroupMapper groupMapper;
	
	@Override
	public void list(ResponseMessage result, PageUtils pageUtils) {
		// TODO Auto-generated method stub
		WGroupExample example = new WGroupExample();
		long count = groupMapper.countByExample(example);
		pageUtils.setCount(count);
		example.setLimitStart(pageUtils.getRows());
		example.setLimitEnd(pageUtils.getStartNum());
		List<WGroup> list = groupMapper.selectByExample(example);
		result.setPage(pageUtils);
		result.setData(list);
	}

}
