package com.gree.bdc.shiro.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.gree.bdc.shiro.mapper.TuserMapper;
import com.gree.bdc.shiro.service.TuserService;
@Service
public class TuserServiceImpl implements TuserService{

    @Resource
    private TuserMapper tuserMapper;

}
