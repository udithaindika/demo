package com.uditha.autogeneral.service;

import org.springframework.stereotype.Service;

import com.uditha.autogeneral.model.BalanceTestResult;
import com.uditha.autogeneral.utils.BracketsUtil;

@Service
public class TaskService {

	public BalanceTestResult validateBrackets(String input) {
		BalanceTestResult results = new BalanceTestResult();
		results.setInput(input);
		results.setIsBalanced(BracketsUtil.isValidBrackets(input));
		return results;
	}

}
