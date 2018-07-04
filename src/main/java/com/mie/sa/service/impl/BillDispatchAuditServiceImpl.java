package com.mie.sa.service.impl;

import com.mie.base.core.entity.PageView;
import com.mie.sa.dao.BillDispatchAuditMapper;
import com.mie.sa.entity.BillDispatchAudit;
import com.mie.sa.entity.BillDispatchAuditExample;
import com.mie.sa.service.BillDispatchAuditService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultBillDispatchAuditService")
public class BillDispatchAuditServiceImpl implements BillDispatchAuditService {
    @Resource
    protected BillDispatchAuditMapper billDispatchAuditMapper;

    @CacheEvict(value={"billDispatchAudit"}, allEntries=true)
    @Override
    public void addObj(BillDispatchAudit t) {
        this.billDispatchAuditMapper.insertSelective(t);
    }

    @CacheEvict(value={"billDispatchAudit"}, allEntries=true)
    @Override
    public void deleteObjById(String id) {
        this.billDispatchAuditMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"billDispatchAudit"}, allEntries=true)
    @Override
    public void modifyObj(BillDispatchAudit t) {
        if (StringUtils.isBlank(t.getId())) {
            throw new NullPointerException("id ???????");
        }
        this.billDispatchAuditMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="billDispatchAudit", keyGenerator="redisKeyGenerator")
    @Override
    public BillDispatchAudit queryObjById(String id) {
        return this.billDispatchAuditMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="billDispatchAudit", key="'BillDispatchAuditService_' + #root.methodName + '_'+ T(com.mie.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<BillDispatchAudit> queryAllObjByExample(BillDispatchAuditExample example) {
        return this.billDispatchAuditMapper.selectByExample(example);
    }

    @Cacheable(value="billDispatchAudit", key="'BillDispatchAuditService_' + #root.methodName + '_'+ T(com.mie.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<BillDispatchAudit> queryObjByPage(BillDispatchAuditExample example) {
        PageView<BillDispatchAudit> pageView = example.getPageView();
        pageView.setQueryResult(this.billDispatchAuditMapper.selectByExampleByPage(example));
        return pageView;
    }
}