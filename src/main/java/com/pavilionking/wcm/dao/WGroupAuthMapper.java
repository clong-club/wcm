package com.pavilionking.wcm.dao;

import com.pavilionking.wcm.dto.WGroupAuth;
import com.pavilionking.wcm.dto.WGroupAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WGroupAuthMapper {
    long countByExample(WGroupAuthExample example);

    int deleteByExample(WGroupAuthExample example);

    int insert(WGroupAuth record);

    int insertSelective(WGroupAuth record);

    List<WGroupAuth> selectByExample(WGroupAuthExample example);

    int updateByExampleSelective(@Param("record") WGroupAuth record, @Param("example") WGroupAuthExample example);

    int updateByExample(@Param("record") WGroupAuth record, @Param("example") WGroupAuthExample example);
}