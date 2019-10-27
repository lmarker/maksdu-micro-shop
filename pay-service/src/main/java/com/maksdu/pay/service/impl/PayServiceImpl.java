package com.maksdu.pay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maksdu.pay.domain.PayAccount;
import com.maksdu.pay.domain.UserAccount;
import com.maksdu.pay.mapper.AccountMapper;
import com.maksdu.pay.mapper.PayMapper;
import com.maksdu.pay.service.PayService;

@Service
public class PayServiceImpl implements PayService {

	@Autowired private PayMapper payMapper;
	
	@Autowired private AccountMapper accountMapper;
	
	@Override
	public PayAccount getByAccountId(String accountId) {
		return payMapper.Sel(accountId);
	}

	@Transactional
	@Override
	public PayAccount createPayAccount(PayAccount pay) throws Throwable {
		payMapper.postPayment(pay);
		UserAccount sourceAccount = accountMapper.selectQuery(pay.getSourceAccountId());
		UserAccount targetAccount = accountMapper.selectQuery(pay.getTargetAccountId());
		if(sourceAccount == null)
			throw new Throwable();
		sourceAccount.changeRemain(pay.getAmount(), false);
		if(targetAccount == null) {
			throw new Throwable();
		}
		targetAccount.changeRemain(pay.getAmount(), true);
		accountMapper.updateAccount(sourceAccount);
		accountMapper.updateAccount(targetAccount);
		return payMapper.Sel(pay.getId());
	}

	
	
}
