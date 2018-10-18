package com.qa.myblackjack;


import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Assert.*;
import static org.junit.Assert.assertEquals;




@RunWith(Parameterized.class)

public class ExampleTest {
	
	Blackjack b = new Blackjack();
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {{0,0,0}, {1,1,0}, {2,1,2}, {3,2,3}, {4,3,4}, {5,5,0}, {6,8,8}});
	}
	
	private int intPut1;
	private int intPut2;
	private int intPected;
	
	
	public ExampleTest(int input, int input2, int expected) {
		intPut1 = input;
		intPut2 = input2;
		intPected = expected;
	}
	
	@Test
	public void test() {
		
		assertEquals(intPected, b.play(intPut1, intPut2));
	}
	
}
