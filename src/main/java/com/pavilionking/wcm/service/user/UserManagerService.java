package com.pavilionking.wcm.service.user;

import com.pavilionking.wcm.common.constant.PageUtils;
import com.pavilionking.wcm.common.constant.ResponseMessage;

public interface UserManagerService {

	void list(ResponseMessage result, PageUtils pageUtils);

}
