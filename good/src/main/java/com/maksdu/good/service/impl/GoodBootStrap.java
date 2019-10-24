package com.maksdu.good.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maksdu.good.service.GoodProcessor;

@Service
public class GoodBootStrap {

    @Autowired private GoodProcessor goodProcessor;

    public void setGoodProcessor(GoodProcessor goodProcessor) {
        this.goodProcessor = goodProcessor;
    }

}
