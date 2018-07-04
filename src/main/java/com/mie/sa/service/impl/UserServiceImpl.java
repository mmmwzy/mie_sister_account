package com.mie.sa.service.impl;

import com.mie.base.core.entity.PageView;
import com.mie.sa.dao.UserMapper;
import com.mie.sa.entity.User;
import com.mie.sa.entity.UserExample;
import com.mie.sa.service.UserService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultUserService")
public class UserServiceImpl implements UserService {
    @Resource
    protected UserMapper userMapper;

    @CacheEvict(value={"user"}, allEntries=true)
    @Override
    public void addObj(User t) {
        this.userMapper.insertSelective(t);
    }

    @CacheEvict(value={"user"}, allEntries=true)
    @Override
    public void deleteObjById(String id) {
        this.userMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"user"}, allEntries=true)
    @Override
    public void modifyObj(User t) {
        if (StringUtils.isBlank(t.getId())) {
            throw new NullPointerException("id ???????");
        }
        this.userMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="user", keyGenerator="redisKeyGenerator")
    @Override
    public User queryObjById(String id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="user", key="'UserService_' + #root.methodName + '_'+ T(com.mie.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<User> queryAllObjByExample(UserExample example) {
        return this.userMapper.selectByExample(example);
    }

    @Cacheable(value="user", key="'UserService_' + #root.methodName + '_'+ T(com.mie.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<User> queryObjByPage(UserExample example) {
        PageView<User> pageView = example.getPageView();
        pageView.setQueryResult(this.userMapper.selectByExampleByPage(example));
        return pageView;
    }
}