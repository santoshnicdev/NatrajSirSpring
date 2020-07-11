package com.nt.test;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import com.nt.dto.ProductDTO;
import com.nt.service.ECommerceStore;
 
public class AroundAdvicetest {
 
public static void main(String[] args) {
ClassPathXmlApplicationContext ctx = null;
ECommerceStore proxy = null;
ProductDTO p1, p2, p3, p4, p5, p6, p7, p8 = null;
// create IOC container
ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
// get Taget bean class object
proxy = ctx.getBean("store", ECommerceStore.class);
System.out.println(proxy.getClass() + "  " + proxy.getClass().getSuperclass());
// Add Products in Strore
p1 = new ProductDTO(1, "Table", Double.valueOf("100000"), Integer.valueOf("1"));
p2 = new ProductDTO(2, "Chair", Double.valueOf("10000"), Integer.valueOf("2"));
p3 = new ProductDTO(3, "TV", Double.valueOf("100000"), Integer.valueOf("1"));
p4 = new ProductDTO(4, "RainCoat", Double.valueOf("1000"), Integer.valueOf("3"));
p5 = new ProductDTO(5, "Laptop", Double.valueOf("40000"), Integer.valueOf("1"));
p6 = new ProductDTO(6, "Mobile", Double.valueOf("15000"), Integer.valueOf("1"));
 
try {
System.out.println(".............................");
System.out.println(proxy.addtoCart(p1));// add first iteams
System.out.println(".............................");
System.out.println(proxy.addtoCart(p2)); // add second iteams
System.out.println(".............................");
System.out.println(proxy.removefromCart(p2));
System.out.println(".............................");
System.out.println(proxy.addtoCart(p2)); // add second iteams
System.out.println(".............................");
System.out.println(proxy.removefromCart(p2));
System.out.println(".............................");
proxy.showCart(); // showing cart iteams
System.out.println(".............................");
System.out.println("Bill Amount::" + proxy.billing(proxy.generateCoupon(), proxy.getCartValue()));
System.out.println(".............................");
                                System.out.println(proxy.addtoCart(p3)); // add one more iteams
System.out.println(".............................");
System.out.println("Bill Amount::" + proxy.billing(proxy.generateCoupon(), proxy.getCartValue()));
System.out.println(".............................");
System.out.println("Bill Amount::" + proxy.billing(proxy.generateCoupon(), proxy.getCartValue()));
System.out.println(".............................");
System.out.println(proxy.removefromCart(p2));
System.out.println(".............................");
System.out.println("Bill Amount::" + proxy.billing(proxy.generateCoupon(), proxy.getCartValue()));
System.out.println(".............................");
System.out.println(proxy.addtoCart(p4));
System.out.println(".............................");
System.out.println("Bill Amount::" + proxy.billing(5, proxy.getCartValue()));
 
} catch (Exception e) {
e.printStackTrace();
}
 
// close container
ctx.close();
 
}
 
}//eof main
 
