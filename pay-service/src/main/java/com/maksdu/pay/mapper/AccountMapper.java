package com.maksdu.pay.mapper;

import org.springframework.stereotype.Repository;

import com.maksdu.pay.domain.UserAccount;

@Repository
public interface AccountMapper {

	public UserAccount selectQuery(String accountId);
	
	public int updateAccount(UserAccount account);
	
}
