package com.maksdu.pay.service;

import com.maksdu.pay.domain.PayAccount;

public interface PayService {

	PayAccount getByAccountId(String accountId);
	
	PayAccount createPayAccount(PayAccount pay) throws Throwable;
}
