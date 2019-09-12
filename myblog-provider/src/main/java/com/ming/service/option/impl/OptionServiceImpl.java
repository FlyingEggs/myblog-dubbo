package com.ming.service.option.impl;

import com.ming.constant.ErrorConstant;
import com.ming.dao.OptionDao;
import com.ming.exception.BusinessException;
import com.ming.model.OptionsDomain;
import com.ming.service.option.OptionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 网站配置服务层
 * Created by Donghua.Chen on 2018/4/28.
 */
@com.alibaba.dubbo.config.annotation.Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionDao optionDao;

    @Override
    @CacheEvict(value={"optionsCache","optionCache"},allEntries=true,beforeInvocation=true)
    public void deleteOptionByName(String name) {
        if(StringUtils.isBlank(name))
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        optionDao.deleteOptionByName(name);

    }

    @Override
    @Transactional
    @CacheEvict(value={"optionsCache","optionCache"},allEntries=true,beforeInvocation=true)
    public void updateOptionByName(String name, String value) {
        if(StringUtils.isBlank(name))
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        OptionsDomain option = new OptionsDomain();
        option.setName(name);
        option.setValue(value);
        optionDao.updateOptionByName(option);

    }

    @Override
    @Transactional
    @CacheEvict(value={"optionsCache","optionCache"},allEntries=true,beforeInvocation=true)
    public void saveOptions(Map<String, String> options) {
        if (null != options && !options.isEmpty()) {
            options.forEach(this::updateOptionByName);
        }
    }

    @Override
    @Cacheable(value = "optionCache", key = "'optionByName_' + #p0")
    public OptionsDomain getOptionByName(String name) {
        if(StringUtils.isBlank(name))
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        return optionDao.getOptionByName(name);
    }

    @Override
    @Cacheable(value = "optionsCache", key = "'options_'")
    public List<OptionsDomain> getOptions() {
        return optionDao.getOptions();
    }
}
