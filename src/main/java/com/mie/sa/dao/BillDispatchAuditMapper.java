package com.mie.sa.dao;

import com.mie.sa.entity.BillDispatchAudit;
import com.mie.sa.entity.BillDispatchAuditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillDispatchAuditMapper {
    int countByExample(BillDispatchAuditExample example);

    int deleteByExample(BillDispatchAuditExample example);

    int deleteByPrimaryKey(String id);

    int insert(BillDispatchAudit record);

    int insertSelective(BillDispatchAudit record);

    List<BillDispatchAudit> selectByExample(BillDispatchAuditExample example);

    BillDispatchAudit selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BillDispatchAudit record, @Param("example") BillDispatchAuditExample example);

    int updateByExample(@Param("record") BillDispatchAudit record, @Param("example") BillDispatchAuditExample example);

    int updateByPrimaryKeySelective(BillDispatchAudit record);

    int updateByPrimaryKey(BillDispatchAudit record);

    void insertBatch(List<BillDispatchAudit> list);

    List<BillDispatchAudit> selectByExampleByPage(BillDispatchAuditExample example);
}