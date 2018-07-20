package com.mie.sa.dao;

import com.mie.sa.entity.CodePhone;
import com.mie.sa.entity.CodePhoneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodePhoneMapper {
    int countByExample(CodePhoneExample example);

    int deleteByExample(CodePhoneExample example);

    int deleteByPrimaryKey(String id);

    int insert(CodePhone record);

    int insertSelective(CodePhone record);

    List<CodePhone> selectByExample(CodePhoneExample example);

    CodePhone selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CodePhone record, @Param("example") CodePhoneExample example);

    int updateByExample(@Param("record") CodePhone record, @Param("example") CodePhoneExample example);

    int updateByPrimaryKeySelective(CodePhone record);

    int updateByPrimaryKey(CodePhone record);

    void insertBatch(List<CodePhone> list);

    List<CodePhone> selectByExampleByPage(CodePhoneExample example);
}