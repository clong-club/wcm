package com.pavilionking.wcm.dao;

import com.pavilionking.wcm.dto.WUserGroup;
import com.pavilionking.wcm.dto.WUserGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WUserGroupMapper {
    long countByExample(WUserGroupExample example);

    int deleteByExample(WUserGroupExample example);

    int insert(WUserGroup record);

    int insertSelective(WUserGroup record);

    List<WUserGroup> selectByExample(WUserGroupExample example);

    int updateByExampleSelective(@Param("record") WUserGroup record, @Param("example") WUserGroupExample example);

    int updateByExample(@Param("record") WUserGroup record, @Param("example") WUserGroupExample example);
}