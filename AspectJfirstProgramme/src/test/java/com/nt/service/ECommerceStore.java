package com.nt.service;
 
import java.util.ArrayList;
import java.util.List;
 
import com.nt.dto.ProductDTO;
 
public class ECommerceStore {
private int counter=0;
private float billamt=0;
 
public float getBillamt() {
return billamt;
}
public int getCounter() {
return counter;
}
 
List<ProductDTO> ecart=new ArrayList<>();
 
public String addtoCart(ProductDTO dto)
{
ecart.add(dto);
counter++;
billamt=(float) (billamt+(dto.getPrice()*dto.getQty()));
 
return "added sucessfully ::now your have "+counter+" iteams in your cart worth"+billamt+" Rs";
}
public String removefromCart(ProductDTO dto)
{
ecart.remove(dto);
counter--;
billamt=(float) (billamt-(dto.getPrice()*dto.getQty()));;
 
return "slected iteams removed sucessfully from your cart ::now your have::"+counter  +" iteams in your cart worth::"+billamt+" Rs";
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
 
msg="Dear Customer your coupon of ::"+coupon+" percent has been applied sucessfully on your billamout of::"+billamt+" you got toatal discount of "+discount+" and your final amount is: "+finalamt;
return msg;
 
 
}
 
 
}//eofmain
