package com.qa.myblackjack;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BlackjackTestNormal {
	
	Blackjack b = new Blackjack();
	
	@Test
	public void testy1() {
		Blackjack b = new Blackjack();
		assertEquals("1 low valid 1 low valid entries",21, b.play(21, 10)); // Player wins
	}
	
	@Test
	public void testy2() {
		Blackjack b = new Blackjack();
		assertEquals("1 low valid 1 low valid entries",20, b.play(10, 20));
	}

}
