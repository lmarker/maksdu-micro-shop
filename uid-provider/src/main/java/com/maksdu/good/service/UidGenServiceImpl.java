package com.maksdu.good.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baidu.fsg.uid.UidGenerator;

@Service
public class UidGenServiceImpl implements UidGenService {

	@Resource(name = "cachedUidGenerator")
    private UidGenerator uidGenerator;

    public long getUid() {
        return uidGenerator.getUID();
    }
	
}
