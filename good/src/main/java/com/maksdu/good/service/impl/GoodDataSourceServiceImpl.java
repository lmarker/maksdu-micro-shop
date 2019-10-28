package com.maksdu.good.service.impl;

import java.lang.ref.SoftReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.maksdu.good.domain.ShopBean;
import com.maksdu.good.repository.GoodEntityRepository;
import com.maksdu.good.service.GoodDataSourceService;

@Service
public class GoodDataSourceServiceImpl extends BaseDataSouceServiceImpl<ShopBean> implements GoodDataSourceService{

	@Autowired private GoodEntityRepository goodEntityRepository;
	
	@Override
	public void setRepository(JpaRepository<ShopBean, String> repository) {
		System.out.println("======= execute repository init =======");
		super.setRepository(goodEntityRepository);
	}
}
