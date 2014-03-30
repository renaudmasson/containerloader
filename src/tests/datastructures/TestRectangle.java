package tests.datastructures;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datastructures.Rectangle;

public class TestRectangle {
	
	private Rectangle baseRectangle;

	@Before
	public void setUp() throws Exception {
		baseRectangle = new Rectangle(10, 10, 20, 30);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test if the length and width of the rectangle is correctly computed.
	 */
	@Test
	public void testLengthWidth() {
		assertEquals(10, baseRectangle.getLength());
		assertEquals(20, baseRectangle.getWidth());
	}
	
	/**
	 * Check that an exception is thrown when giving bad parameters
	 * to the Rectangle constructor.
	 */
	@Test(expected=InvalidParameterException.class)
	public void testExceptionBadXInput() {
		Rectangle badRectangle = new Rectangle(10, 10, 9, 20);
	}
	
	/**
	 * Check that an exception is thrown when giving bad parameters
	 * to the Rectangle constructor.
	 */
	@Test(expected=InvalidParameterException.class)
	public void testExceptionBadYInput() {
		Rectangle badRectangle = new Rectangle(10, 10, 20, 10);
	}
	
	/**
	 * Check for some stacks whether or not it fits in the rectangle.
	 */
	@Test
	public void testFits() {
		FakeStack stack1 = new FakeStack(5, 5, 5, 5, false, 0, 0, 0, 0, 0, 0);
		FakeStack stack2 = new FakeStack(10, 20, 5, 5, false, 0, 0, 0, 0, 0, 0);
		FakeStack stack3 = new FakeStack(8, 22, 5, 5, false, 0, 0, 0, 0, 0, 0);
		FakeStack stack4 = new FakeStack(11, 18, 5, 5, false, 0, 0, 0, 0, 0, 0);
		assertTrue(baseRectangle.fitsIn(stack1));
		assertTrue(baseRectangle.fitsIn(stack2));
		assertFalse(baseRectangle.fitsIn(stack3));
		assertFalse(baseRectangle.fitsIn(stack4));
	}

}
