package com.qa.myblackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BlackjackTestInvalid {
	
	Blackjack b = new Blackjack();
	
	
	@Test
	public void testy1() {
		Blackjack b = new Blackjack();
		assertEquals("2 low invalid entries",0, b.play(-10, -10));
	}
	@Test
	public void testy2() {
		Blackjack b = new Blackjack();
		assertEquals("1 low valid 1 low invalid entries, ",0, b.play(-10, 10));
	}
	
	@Test
	public void testy3() {
		Blackjack b = new Blackjack();
		assertEquals("1 low invalid 1 high valid entries",0, b.play(-10, 30));
	}
	
	@Test
	public void testy4() {
		Blackjack b = new Blackjack();
		assertEquals("1 low invalid 1 high invalid entries",0, b.play(-10, 50));
	}
	
	@Test
	public void testy5() {
		Blackjack b = new Blackjack();
		assertEquals("1 high valid 1 low invalid entries",0, b.play(30, -10));
	}

	
	@Test
	public void testy6() {
		Blackjack b = new Blackjack();
		assertEquals("1 high valid 1 high invalid entries ",0, b.play(30, 50));
	}
	
	@Test
	public void testy7() {
		Blackjack b = new Blackjack();
		assertEquals("1 high invalid 1 low invalid entries",0, b.play(50, -10));
	}
	
	@Test
	public void testy8() {
		Blackjack b = new Blackjack();
		assertEquals("1 high invalid 1 low invalid entries",0, b.play(50, 10));
	}
	
	@Test
	public void testy9() {
		Blackjack b = new Blackjack();
		assertEquals("1 high invalid 1 high valid entries",0, b.play(50, 30));
	}
	
	@Test
	public void testy10() {
		Blackjack b = new Blackjack();
		assertEquals("1 high invalid 1 high invalid entries",0, b.play(50, 50));
	}
	
	@Test
	public void testy11() {
		Blackjack b = new Blackjack();
		assertEquals("1 low valid 1 low invalid entries",0, b.play(10, -10));
	}
	
	@Test
	public void testy12() {
		Blackjack b = new Blackjack();
		assertEquals("1 low valid 1 high invalid entries",0, b.play(10, 50));
	}
	
	
	

}
