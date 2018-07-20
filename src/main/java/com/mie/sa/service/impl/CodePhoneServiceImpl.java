package com.mie.sa.service.impl;

import com.mie.base.core.entity.PageView;
import com.mie.sa.dao.CodePhoneMapper;
import com.mie.sa.entity.CodePhone;
import com.mie.sa.entity.CodePhoneExample;
import com.mie.sa.service.CodePhoneService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultCodePhoneService")
public class CodePhoneServiceImpl implements CodePhoneService {
    @Resource
    protected CodePhoneMapper codePhoneMapper;

    @CacheEvict(value={"codePhone"}, allEntries=true)
    @Override
    public void addObj(CodePhone t) {
        this.codePhoneMapper.insertSelective(t);
    }

    @CacheEvict(value={"codePhone"}, allEntries=true)
    @Override
    public void deleteObjById(String id) {
        this.codePhoneMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"codePhone"}, allEntries=true)
    @Override
    public void modifyObj(CodePhone t) {
        if (StringUtils.isBlank(t.getId())) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.codePhoneMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="codePhone", keyGenerator="redisKeyGenerator")
    @Override
    public CodePhone queryObjById(String id) {
        return this.codePhoneMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="codePhone", key="'CodePhoneService_' + #root.methodName + '_'+ T(com.mie.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<CodePhone> queryAllObjByExample(CodePhoneExample example) {
        return this.codePhoneMapper.selectByExample(example);
    }

    @Cacheable(value="codePhone", key="'CodePhoneService_' + #root.methodName + '_'+ T(com.mie.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<CodePhone> queryObjByPage(CodePhoneExample example) {
        PageView<CodePhone> pageView = example.getPageView();
        pageView.setQueryResult(this.codePhoneMapper.selectByExampleByPage(example));
        return pageView;
    }
}