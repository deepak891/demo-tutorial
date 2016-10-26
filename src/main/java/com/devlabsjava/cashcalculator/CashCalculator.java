package com.devlabsjava.cleancode.cashcalculator;

import java.math.BigDecimal;

public interface CashCalculator {
	BigDecimal getCalculatedAvailableBalance(BigDecimal currentBalance, BigDecimal totalDebits, BigDecimal totalCredits);
}
