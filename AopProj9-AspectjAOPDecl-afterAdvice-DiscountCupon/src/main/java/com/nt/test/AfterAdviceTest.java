package com.nt.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ShoppingStore;

public class AfterAdviceTest {

	public static void main(String[] args) {
		HashMap<String, Double> L=new HashMap<>();
		L.put("Roll", 30.40);
		L.put("paties", 20.80);
		ApplicationContext ctx=null;
		ShoppingStore proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		proxy=ctx.getBean("store",ShoppingStore.class);
		//invoke method
		try {
		  System.out.println("Bill Amount::"+proxy.shopping(new String[] {"shirt","trouser","table"},
				                                            new double[] {300,400,600}));	
		  System.out.println("BIll is"+proxy.shop(L));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
