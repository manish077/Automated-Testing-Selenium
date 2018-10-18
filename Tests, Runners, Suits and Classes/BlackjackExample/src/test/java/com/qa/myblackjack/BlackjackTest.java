package com.qa.myblackjack;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.*;
import org.junit.Test;

public class BlackjackTest {
	
	static int x = 0;
	
	@BeforeClass
	static public void First() {
		System.out.println("Welcome to my test");
	}
	
	@Before
	public void setup() {
		System.out.println("Test" + x +"/17");
	}
	
	@Test
	public void testy() {
		
		Blackjack b = new Blackjack();
		
		assertEquals(0, b.play(-10, -10));  //1 - -10, change dealer
		assertEquals(0, b.play(-10, 10));			// all invalid
		assertEquals(0, b.play(-10, 30));
		assertEquals(0, b.play(-10, 50));
		
		assertEquals(0, b.play(30, -10)); // 30, change dealer
		assertEquals(10, b.play(30, 10)); // Bust
		assertEquals(0, b.play(30, 30));
		assertEquals(0, b.play(30, 50));
		
		assertEquals(0, b.play(50, -10)); // 50 change dealer all invalid
		assertEquals(0, b.play(50, 10));
		assertEquals(0, b.play(50, 30));
		assertEquals(0, b.play(50, 50));
		
		assertEquals(0, b.play(10, -10 ));  // 10 change dealer
		assertEquals(20, b.play(10, 20)); //win
		assertEquals(10, b.play(10, 30)); //bust
		assertEquals(0, b.play(10, 50));
		assertEquals(21, b.play(21, 10)); // Where player has a higher card than dealer

	}
	
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
		assertEquals("1 high valid 1 low valid entries",10, b.play(30, 10));
	}
	
	@Test
	public void testy7() {
		Blackjack b = new Blackjack();
		assertEquals("2 high valid entries",0, b.play(30, 30));
	}
	
	@Test
	public void testy8() {
		Blackjack b = new Blackjack();
		assertEquals("1 high valid 1 high invalid entries ",0, b.play(30, 50));
	}
	
	@Test
	public void testy9() {
		Blackjack b = new Blackjack();
		assertEquals("1 high invalid 1 low invalid entries",0, b.play(50, -10));
	}
	
	@Test
	public void testy10() {
		Blackjack b = new Blackjack();
		assertEquals("1 high invalid 1 low invalid entries",0, b.play(50, 10));
	}
	
	@Test
	public void testy11() {
		Blackjack b = new Blackjack();
		assertEquals("1 high invalid 1 high valid entries",0, b.play(50, 30));
	}
	
	@Test
	public void testy12() {
		Blackjack b = new Blackjack();
		assertEquals("1 high invalid 1 high invalid entries",0, b.play(50, 50));
	}
	
	@Test
	public void testy13() {
		Blackjack b = new Blackjack();
		assertEquals("1 low valid 1 low invalid entries",0, b.play(10, -10));
	}
	
	@Test
	public void testy14() {
		Blackjack b = new Blackjack();
		assertEquals("1 low valid 1 low valid entries",20, b.play(10, 20));
	}
	
	@Test
	public void testy15() {
		Blackjack b = new Blackjack();
		assertEquals("1 low valid 1 high valid entries",10, b.play(10, 30));
	}
	
	@Test
	public void testy16() {
		Blackjack b = new Blackjack();
		assertEquals("1 low valid 1 high invalid entries",0, b.play(10, 50));
	}
	
	@Test
	public void testy17() {
		Blackjack b = new Blackjack();
		assertEquals("1 low valid 1 low valid entries",21, b.play(21, 10)); // Player wins
	}
	
	@After
	public void teardown() {
		System.out.println("Test" + x + "/17 is finished");
		x++;
	}
	
	@AfterClass
	static public void finish() {
		System.out.println("Testing has finished");
	}

}
