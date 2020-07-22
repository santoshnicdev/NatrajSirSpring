package com.nt.service;
 
import java.util.ArrayList;
import java.util.List;
 
import com.nt.dto.ProductDTO;
 
public class ECommerceStore {
private int counter=0;
private float cartValue=0;
private int coupon=0;
 
List<ProductDTO> ecart=new ArrayList<>();

public float getCartValue() {
	return cartValue;
}
public int getCounter() {
return counter;
}
/*
 * public int generateCoupon() { if(this.cartValue >= 200000) coupon=10; else
 * if(this.cartValue>=100000) coupon=5; return coupon; }
 */
 
public String addtoCart(ProductDTO dto)
{
ecart.add(dto);
counter++;
cartValue=(float) (cartValue+(dto.getPrice()*dto.getQty()));
 
return "added sucessfully ::now your have "+counter+" iteams in your cart worth"+cartValue+" Rs";
}
public String removefromCart(ProductDTO dto)
{
ecart.remove(dto);
counter--;
cartValue=(float) (cartValue-(dto.getPrice()*dto.getQty()));;
 
return "slected iteams removed sucessfully from your cart ::now your have::"+counter  +" iteams in your cart worth::"+cartValue+" Rs";
}
public void showCart()
{
ecart.forEach(System.out::println);
}
public String billing(int coupon, float billamt)
{
float finalamt=0.0f;
String msg;
float discount;
 
//double bamt=(double)ecart.stream().mapToDouble(dto->dto.getPrice()*dto.getQty()).sum();
 discount=billamt*(coupon/100.0f);
  finalamt=billamt-discount;
 
msg="Dear Customer your coupon of ::"+coupon+" percent has been applied sucessfully on your billamount of::"+billamt+" you got total discount of "+discount+" and your final amount is: "+finalamt;
return msg;
 
 
}
 
 
}//eofmain
