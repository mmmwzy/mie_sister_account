package com.mie.sa.dao;

import com.mie.sa.entity.Sms;
import com.mie.sa.entity.SmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsMapper {
    int countByExample(SmsExample example);

    int deleteByExample(SmsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Sms record);

    int insertSelective(Sms record);

    List<Sms> selectByExample(SmsExample example);

    Sms selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Sms record, @Param("example") SmsExample example);

    int updateByExample(@Param("record") Sms record, @Param("example") SmsExample example);

    int updateByPrimaryKeySelective(Sms record);

    int updateByPrimaryKey(Sms record);

    void insertBatch(List<Sms> list);

    List<Sms> selectByExampleByPage(SmsExample example);
}