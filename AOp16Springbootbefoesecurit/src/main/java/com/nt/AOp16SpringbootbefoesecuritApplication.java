package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.manager.AuthenticationManager;
import com.nt.service.BankMgmtService;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AOp16SpringbootbefoesecuritApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ctx = SpringApplication.run(AOp16SpringbootbefoesecuritApplication.class, args);

		AuthenticationManager manager = null;
		BankMgmtService proxy = null;
		// create IOC conatiner

		// Get Manager
		manager = ctx.getBean("authManager", AuthenticationManager.class);
		proxy = ctx.getBean("bankService", BankMgmtService.class);
		manager.signIn("raja", "rani");
		try {
			// withdraw
			System.out.println(proxy.withdrawMoney(101, 20));

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(".................................");
		try {
			// withdraw
			System.out.println(proxy.depositeMoney(101, 20000));

		} catch (Exception e) {
			e.printStackTrace();
		}

		manager.singnOut();

		// close container
		((AbstractApplicationContext) ctx).close();
	}

}
