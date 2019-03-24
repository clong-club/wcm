package com.pavilionking.wcm.dao;

import com.pavilionking.wcm.dto.WAuth;
import com.pavilionking.wcm.dto.WAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WAuthMapper {
    long countByExample(WAuthExample example);

    int deleteByExample(WAuthExample example);

    int insert(WAuth record);

    int insertSelective(WAuth record);

    List<WAuth> selectByExample(WAuthExample example);

    int updateByExampleSelective(@Param("record") WAuth record, @Param("example") WAuthExample example);

    int updateByExample(@Param("record") WAuth record, @Param("example") WAuthExample example);
}