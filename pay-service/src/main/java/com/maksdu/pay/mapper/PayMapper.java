package com.maksdu.pay.mapper;

import org.springframework.stereotype.Repository;

import com.maksdu.pay.domain.PayAccount;

@Repository
public interface PayMapper {

	PayAccount Sel(String id);

	int postPayment(PayAccount pay);
	
}
