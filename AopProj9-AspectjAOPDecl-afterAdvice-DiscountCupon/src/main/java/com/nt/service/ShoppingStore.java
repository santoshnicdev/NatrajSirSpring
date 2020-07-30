package com.nt.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;


public class ShoppingStore {
	
	/*public  double  shopping(String[] items, double prices[]) {
		double billAmt=0.0f;
		billAmt=Arrays.stream(prices,0,prices.length-1).sum();
		return billAmt;
	}*/
	
	/*public  int  shopping(String[] items,  int prices[]) {
		int billAmt=0;
		billAmt=IntStream.of(prices).sum();
	     return billAmt;
	}*/
	public double shop(HashMap<String, Double> R)
	{
		double integerSum = R.values().stream().mapToDouble(Double::doubleValue).sum();
		return integerSum;
	
	}
	
	
	public  double  shopping(String[] items, double prices[]) {
		double billAmt=0.0f;
		billAmt=DoubleStream.of(prices).sum();
		return billAmt;
	}
	

}
