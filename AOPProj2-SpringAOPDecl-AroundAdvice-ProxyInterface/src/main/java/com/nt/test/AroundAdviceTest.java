package com.nt.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IBankService;

public class AroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IBankService proxy=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		//call getBean(-) to Proxy class object
		proxy=ctx.getBean("pfb",IBankService.class);
		System.out.println(proxy.getClass()+"  "+Arrays.toString(proxy.getClass().getInterfaces())+"  "+proxy.getClass().getSuperclass());
		
		try {
		  System.out.println("Simple Intrest Amount::"+proxy.calcSimpleIntrestAmount(100000, 12,2 ));
		  System.out.println("...........................");
		  System.out.println("compound Intrest amount::"+proxy.calcCompoundIntrestAmount(100000, 12,2));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
