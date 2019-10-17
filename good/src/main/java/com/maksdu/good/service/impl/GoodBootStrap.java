package com.maksdu.good.service.impl;

import com.maksdu.good.service.GoodActionService;
import com.maksdu.good.service.GoodDataSourceService;
import com.maksdu.good.service.GoodProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodBootStrap {

    @Autowired private GoodProcessor goodProcessor;

    public void setGoodProcessor(GoodProcessor goodProcessor) {
        this.goodProcessor = goodProcessor;
    }

}
