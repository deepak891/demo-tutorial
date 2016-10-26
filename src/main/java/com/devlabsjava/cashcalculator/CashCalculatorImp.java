package com.devlabsjava.cleancode.cashcalculator;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CashCalculatorImp implements CashCalculator {

	//use logging framework
	private static final Logger log = LoggerFactory.getLogger(CashCalculatorImp.class);
	@Override
	public BigDecimal getCalculatedAvailableBalance(BigDecimal currentBalance,
			BigDecimal totalDebits, BigDecimal totalCredits) {

		//imporved readability
		BigDecimal result = new Balance(currentBalance)
						.less(totalDebits)
						.more(totalCredits)
						.getBalance();
		
		//use a logging framework
		if(log.isDebugEnabled()){
			log.debug("The calculated result is {0}", result);
		}
		return result;
	}
	
	//an innter class that abstracts out the calculation logic
	private class Balance {
		
		private BigDecimal balance;
		
		public Balance(BigDecimal balance) {
			
			//check for precondition
			if(balance == null){
				throw new IllegalArgumentException("Invalid balance " + balance); //fail fast
			}
			this.balance = balance;
		}
		
		public BigDecimal getBalance() {
			return balance;
		}
		
		public Balance less(BigDecimal amount) {
			//check for pre-condition
			if(!isPositiveOrZero(amount)){
				throw new IllegalArgumentException("Invalid amount" + amount); //fail fast
			}
			balance = balance.subtract(amount);
			
			//check for post condition
			if(!isPositiveOrZero(balance)){
				throw new IllegalArgumentException("Balance is negative " + balance); //fail fast
			}
			return this;
		}
		
		public Balance more(BigDecimal amount) {
			//check for pre-condition
			if(!isPositiveOrZero(amount)){
				throw new IllegalArgumentException("Invalid amount" + amount); //fail fast
			}
			
			balance = balance.add(amount);
			return this;
		}

		private boolean isPositiveOrZero(BigDecimal amount) {
			return amount !=null && amount.signum() != -1;
		}
	}

}
