package com.mie.sa.service.impl;

import com.mie.base.core.entity.PageView;
import com.mie.sa.dao.BookMapper;
import com.mie.sa.entity.Book;
import com.mie.sa.entity.BookExample;
import com.mie.sa.service.BookService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultBookService")
public class BookServiceImpl implements BookService {
    @Resource
    protected BookMapper bookMapper;

    @CacheEvict(value={"book"}, allEntries=true)
    @Override
    public void addObj(Book t) {
        this.bookMapper.insertSelective(t);
    }

    @CacheEvict(value={"book"}, allEntries=true)
    @Override
    public void deleteObjById(String id) {
        this.bookMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"book"}, allEntries=true)
    @Override
    public void modifyObj(Book t) {
        if (StringUtils.isBlank(t.getId())) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.bookMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="book", keyGenerator="redisKeyGenerator")
    @Override
    public Book queryObjById(String id) {
        return this.bookMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="book", key="'BookService_' + #root.methodName + '_'+ T(com.mie.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<Book> queryAllObjByExample(BookExample example) {
        return this.bookMapper.selectByExample(example);
    }

    @Cacheable(value="book", key="'BookService_' + #root.methodName + '_'+ T(com.mie.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<Book> queryObjByPage(BookExample example) {
        PageView<Book> pageView = example.getPageView();
        pageView.setQueryResult(this.bookMapper.selectByExampleByPage(example));
        return pageView;
    }
}