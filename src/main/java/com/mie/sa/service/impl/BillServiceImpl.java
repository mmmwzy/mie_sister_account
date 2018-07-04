package com.mie.sa.service.impl;

import com.mie.base.core.entity.PageView;
import com.mie.sa.dao.BillMapper;
import com.mie.sa.entity.Bill;
import com.mie.sa.entity.BillExample;
import com.mie.sa.service.BillService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultBillService")
public class BillServiceImpl implements BillService {
    @Resource
    protected BillMapper billMapper;

    @CacheEvict(value={"bill"}, allEntries=true)
    @Override
    public void addObj(Bill t) {
        this.billMapper.insertSelective(t);
    }

    @CacheEvict(value={"bill"}, allEntries=true)
    @Override
    public void deleteObjById(String id) {
        this.billMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"bill"}, allEntries=true)
    @Override
    public void modifyObj(Bill t) {
        if (StringUtils.isBlank(t.getId())) {
            throw new NullPointerException("id ???????");
        }
        this.billMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="bill", keyGenerator="redisKeyGenerator")
    @Override
    public Bill queryObjById(String id) {
        return this.billMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="bill", key="'BillService_' + #root.methodName + '_'+ T(com.mie.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<Bill> queryAllObjByExample(BillExample example) {
        return this.billMapper.selectByExample(example);
    }

    @Cacheable(value="bill", key="'BillService_' + #root.methodName + '_'+ T(com.mie.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<Bill> queryObjByPage(BillExample example) {
        PageView<Bill> pageView = example.getPageView();
        pageView.setQueryResult(this.billMapper.selectByExampleByPage(example));
        return pageView;
    }
}