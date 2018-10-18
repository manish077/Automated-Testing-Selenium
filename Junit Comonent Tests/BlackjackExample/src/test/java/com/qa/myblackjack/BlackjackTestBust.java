package com.qa.myblackjack;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class BlackjackTestBust {
	
	Blackjack b = new Blackjack();
	
	@Test
	public void testy1() {
		Blackjack b = new Blackjack();
		assertEquals("1 high valid 1 low valid entries",33, b.play(30, 10));
	}
	
	@Test
	public void testy2() {
		Blackjack b = new Blackjack();
		assertEquals("2 high valid entries",0, b.play(30, 30));
	}
	
	@Test
	public void testy3() {
		Blackjack b = new Blackjack();
		assertEquals("1 low valid 1 high valid entries",10, b.play(10, 30));
	}
	
}
