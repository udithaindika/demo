package com.uditha.autogeneral.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class BracketsUtilTest {

	@Test
	public void test() {

		assertEquals(true, BracketsUtil.isValidBrackets(null));
		assertEquals(true, BracketsUtil.isValidBrackets("   "));
		assertEquals(true, BracketsUtil.isValidBrackets(""));
		
		assertEquals(true, BracketsUtil.isValidBrackets("{}"));
		assertEquals(true, BracketsUtil.isValidBrackets("[{}]"));
		assertEquals(true, BracketsUtil.isValidBrackets("([{Hello World}])"));
		assertEquals(true, BracketsUtil.isValidBrackets("(Hello[{Hello World}]World)"));
		
		assertEquals(false, BracketsUtil.isValidBrackets("}"));
		assertEquals(false, BracketsUtil.isValidBrackets("{"));
		assertEquals(false, BracketsUtil.isValidBrackets("[{"));
		assertEquals(false, BracketsUtil.isValidBrackets("}}"));
		assertEquals(false, BracketsUtil.isValidBrackets("((({{{[{"));
	}

}
