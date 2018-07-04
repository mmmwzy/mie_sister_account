package com.mie.sa.dao;

import com.mie.sa.entity.BookChecking;
import com.mie.sa.entity.BookCheckingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookCheckingMapper {
    int countByExample(BookCheckingExample example);

    int deleteByExample(BookCheckingExample example);

    int deleteByPrimaryKey(String id);

    int insert(BookChecking record);

    int insertSelective(BookChecking record);

    List<BookChecking> selectByExample(BookCheckingExample example);

    BookChecking selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BookChecking record, @Param("example") BookCheckingExample example);

    int updateByExample(@Param("record") BookChecking record, @Param("example") BookCheckingExample example);

    int updateByPrimaryKeySelective(BookChecking record);

    int updateByPrimaryKey(BookChecking record);

    void insertBatch(List<BookChecking> list);

    List<BookChecking> selectByExampleByPage(BookCheckingExample example);
}