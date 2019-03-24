package com.pavilionking.wcm.dao;

import com.pavilionking.wcm.dto.WGroup;
import com.pavilionking.wcm.dto.WGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WGroupMapper {
    long countByExample(WGroupExample example);

    int deleteByExample(WGroupExample example);

    int insert(WGroup record);

    int insertSelective(WGroup record);

    List<WGroup> selectByExample(WGroupExample example);

    int updateByExampleSelective(@Param("record") WGroup record, @Param("example") WGroupExample example);

    int updateByExample(@Param("record") WGroup record, @Param("example") WGroupExample example);
}