package tests.datastructures;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datastructures.Bin;

public class TestBin {
	
	private Bin bin;
	private FakeStack stack1;
	private FakeStack stack2;
	private FakeStack stack3;
	private FakeStack stack4;
	private FakeStack stack5;
	private FakeStack stack6;
	private FakeStack stack7;
	private FakeStack stack8;

	@Before
	public void setUp() throws Exception {
		bin = new Bin("ABC", 100, 20, 5, 100);
		stack1 = new FakeStack(30, 10, 4, 25, false, 0, 0, 0, 0, 0, 0);
		stack2 = new FakeStack(30, 10, 5, 25, false, 0, 0, 0, 0, 0, 0);
		stack3 = new FakeStack(30, 10, 6, 25, false, 0, 0, 0, 0, 0, 0);
		stack4 = new FakeStack(50, 11, 3, 25, false, 0, 0, 0, 0, 0, 0);
		stack5 = new FakeStack(30, 10, 2, 25, false, 0, 0, 0, 0, 0, 0);
		stack6 = new FakeStack(30, 10, 4, 25, false, 0, 0, 0, 0, 0, 0);
		stack7 = new FakeStack(30, 10, 5, 25, false, 0, 0, 0, 0, 0, 0);
		stack8 = new FakeStack(30, 10, 5, 101, false, 0, 0, 0, 0, 0, 0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHeight() {
		assertFalse(bin.fitsIn(stack3));
	}
	
	@Test
	public void testWeight() {
		assertFalse(bin.fitsIn(stack8));
	}
	
	@Test
	public void testFits() {
		assertTrue(bin.fitsIn(stack1));
	}	
	
	@Test
	public void testInsertions() {
		assertTrue(bin.fitsIn(stack1));
		bin.add(stack1);
		assertEquals(30, bin.maxX());
		assertTrue(bin.fitsIn(stack2));
		bin.add(stack2);
		assertEquals(30, bin.maxX());
		assertTrue(bin.fitsIn(stack4));
		bin.add(stack4);
		assertEquals(80, bin.maxX());
		assertFalse(bin.fitsIn(stack5));
	}
	
	@Test
	public void testInsertionsB() {
		assertTrue(bin.fitsIn(stack1));
		bin.add(stack1);
		assertEquals(30, bin.maxX());
		assertTrue(bin.fitsIn(stack2));
		bin.add(stack2);
		assertEquals(30, bin.maxX());
		assertTrue(bin.fitsIn(stack5));
		bin.add(stack5);
		assertEquals(60, bin.maxX());
		assertTrue(bin.fitsIn(stack6));
		bin.add(stack6);
		assertEquals(60, bin.maxX());
		assertFalse(bin.fitsIn(stack7));
	}

}
