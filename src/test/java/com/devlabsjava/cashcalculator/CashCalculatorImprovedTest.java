package com.devlabsjava.cleancode.cashcalculator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CashCalculatorImprovedTest {
	
	CashCalculator calculator = null;

	@Before
	public void init(){
		//Prefer spring to inject the dependency
		calculator = new CashCalculatorImp();
	}
	
	@Test
	public void testCalculatorAvailableBalance() {
		BigDecimal result = calculator.getCalculatedAvailableBalance(new BigDecimal("1250.00"),new BigDecimal("250.00"),new BigDecimal("500.00") );
		Assert.assertEquals(new BigDecimal("1500.00"), result);
	}

	@Test
	public void testForZeroCalculatedAvailableBalance() {
		BigDecimal result = calculator.getCalculatedAvailableBalance(new BigDecimal("1250.00"),new BigDecimal("0.00"),new BigDecimal("00.00") );
		Assert.assertEquals(new BigDecimal("1250.00"), result);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void negativeTest1CalculatedAvailableBalance() {
		BigDecimal result = calculator.getCalculatedAvailableBalance(null,new BigDecimal("0.00"),new BigDecimal("00.00") );
		Assert.assertEquals(new BigDecimal("1250.00"), result);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void negativeTest2CalculatedAvailableBalance() {
		BigDecimal result = calculator.getCalculatedAvailableBalance(new BigDecimal("1250.00"),new BigDecimal("-25.00"),new BigDecimal("00.00") );
		Assert.assertEquals(new BigDecimal("1250.00"), result);
	}

	@Test(expected=IllegalArgumentException.class)
	public void negativeTest3CalculatedAvailableBalance() {
		BigDecimal result = calculator.getCalculatedAvailableBalance(new BigDecimal("1250.00"),new BigDecimal("250.00"),new BigDecimal("-250.00") );
		Assert.assertEquals(new BigDecimal("1250.00"), result);
	}

}
