package com.ming.service.relation.impl;

import com.ming.dao.RelationShipDao;
import com.ming.service.relation.RelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Donghua.Chen on 2018/4/30.
 */
@com.alibaba.dubbo.config.annotation.Service
public class RelationShipServiceImpl implements RelationShipService {

    @Autowired
    private RelationShipDao relationShipDao;


}
