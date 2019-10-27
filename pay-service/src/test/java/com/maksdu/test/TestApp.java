package com.maksdu.test;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.maksdu.pay.PayApplication;
import com.maksdu.pay.domain.PayAccount;
import com.maksdu.pay.service.PayService;
import com.maksdu.pay.util.PayMethod;
import com.maksdu.pay.util.PayUnit;
import com.maksdu.util.HttpUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {PayApplication.class})
public class TestApp {

	@Autowired private PayService payService;
	
	@Test
	public void testPay() {
		PayAccount account = payService.getByAccountId("10001");
		System.out.println(account);
	}
	
	@Test
	public void testCreatePay() throws InterruptedException {
		long start = System.currentTimeMillis();
		CountDownLatch latch = new CountDownLatch(12);
		for(int i=0;i<10;i++) {
			final int index = i+1;
			new Thread(new Runnable(){
				@Override
				public void run() {
					PayAccount account = new PayAccount();
					account.setId(HttpUtils.getUidAPI());
					account.setPayMethod(PayMethod.NATIVE);
					account.setPayUnit(PayUnit.UNIT_ONE);
					account.setSourceAccountId("100002");
					account.setTargetAccountId("100001");
					account.setAmount(new BigDecimal(100));
					account.setItem("个人转账");
					account.setDescription("账户号码："+account.getSourceAccountId()+"向账户号码: "+account.getTargetAccountId()+" 发起了第"+index+"次交易，转账金额为:"+account.getAmount()+"元");
					try {
						account = payService.createPayAccount(account);
					} catch (Throwable e) {
						e.printStackTrace();
					}
					try {
						latch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		latch.await();
		long end = System.currentTimeMillis();
		System.out.println("一共花费: "+(end-start)+"ms");
	}
	
}
