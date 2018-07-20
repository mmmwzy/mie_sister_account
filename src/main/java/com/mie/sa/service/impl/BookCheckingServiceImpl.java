package com.mie.sa.service.impl;

import com.mie.base.core.entity.PageView;
import com.mie.sa.dao.BookCheckingMapper;
import com.mie.sa.entity.BookChecking;
import com.mie.sa.entity.BookCheckingExample;
import com.mie.sa.service.BookCheckingService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultBookCheckingService")
public class BookCheckingServiceImpl implements BookCheckingService {
    @Resource
    protected BookCheckingMapper bookCheckingMapper;

    @CacheEvict(value={"bookChecking"}, allEntries=true)
    @Override
    public void addObj(BookChecking t) {
        this.bookCheckingMapper.insertSelective(t);
    }

    @CacheEvict(value={"bookChecking"}, allEntries=true)
    @Override
    public void deleteObjById(String id) {
        this.bookCheckingMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"bookChecking"}, allEntries=true)
    @Override
    public void modifyObj(BookChecking t) {
        if (StringUtils.isBlank(t.getId())) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.bookCheckingMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="bookChecking", keyGenerator="redisKeyGenerator")
    @Override
    public BookChecking queryObjById(String id) {
        return this.bookCheckingMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="bookChecking", key="'BookCheckingService_' + #root.methodName + '_'+ T(com.mie.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<BookChecking> queryAllObjByExample(BookCheckingExample example) {
        return this.bookCheckingMapper.selectByExample(example);
    }

    @Cacheable(value="bookChecking", key="'BookCheckingService_' + #root.methodName + '_'+ T(com.mie.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<BookChecking> queryObjByPage(BookCheckingExample example) {
        PageView<BookChecking> pageView = example.getPageView();
        pageView.setQueryResult(this.bookCheckingMapper.selectByExampleByPage(example));
        return pageView;
    }
}