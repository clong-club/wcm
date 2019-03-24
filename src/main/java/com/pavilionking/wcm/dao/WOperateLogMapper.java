package com.pavilionking.wcm.dao;

import com.pavilionking.wcm.dto.WOperateLog;
import com.pavilionking.wcm.dto.WOperateLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WOperateLogMapper {
    long countByExample(WOperateLogExample example);

    int deleteByExample(WOperateLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WOperateLog record);

    int insertSelective(WOperateLog record);

    List<WOperateLog> selectByExample(WOperateLogExample example);

    WOperateLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WOperateLog record, @Param("example") WOperateLogExample example);

    int updateByExample(@Param("record") WOperateLog record, @Param("example") WOperateLogExample example);

    int updateByPrimaryKeySelective(WOperateLog record);

    int updateByPrimaryKey(WOperateLog record);
}