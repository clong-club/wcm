package com.pavilionking.wcm.dao;

import com.pavilionking.wcm.dto.WUser;
import com.pavilionking.wcm.dto.WUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WUserMapper {
    long countByExample(WUserExample example);

    int deleteByExample(WUserExample example);

    int insert(WUser record);

    int insertSelective(WUser record);

    List<WUser> selectByExample(WUserExample example);

    int updateByExampleSelective(@Param("record") WUser record, @Param("example") WUserExample example);

    int updateByExample(@Param("record") WUser record, @Param("example") WUserExample example);
}