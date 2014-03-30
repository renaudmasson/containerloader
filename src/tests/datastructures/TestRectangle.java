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
	
	/**
	 * Check that some rectangles do not intersects.
	 * @see /analysis/tests/datastructures/rectangle/noIntersection.png
	 */
	@Test
	public void testNoIntersects() {
		Rectangle rect1 = new Rectangle(13, 2, 16, 6);
		Rectangle rect2 = new Rectangle(3, 12, 6, 16);
		Rectangle rect3 = new Rectangle(23, 12, 26, 16);
		Rectangle rect4 = new Rectangle(13, 32, 16, 36);
		Rectangle[] rectangles = new Rectangle[]{rect1, rect2, rect3, rect4};
		for(Rectangle rect: rectangles) {
			assertFalse(baseRectangle.intersects(rect));
		}
	}
	
	/**
	 * Check that some rectangles do intersects.
	 * @see /analysis/tests/datastructures/rectangle/intersection.png
	 */
	@Test
	public void testIntersects() {
		Rectangle rect1 = new Rectangle(8, 12, 16, 16);
		Rectangle rect2 = new Rectangle(12, 8, 16, 12);
		Rectangle rect3 = new Rectangle(18, 12, 23, 16);
		Rectangle rect4 = new Rectangle(12, 28, 16, 36);
		Rectangle rect5 = new Rectangle(12, 8, 16, 12);
		Rectangle rect6 = new Rectangle(12, 18, 16, 22);
		Rectangle rect7 = new Rectangle(8, 8, 28, 38);
		Rectangle[] rectangles = new Rectangle[]{rect1, rect2, rect3, rect4, rect5, rect6, rect7};
		for(Rectangle rect: rectangles) {
			assertTrue(baseRectangle.intersects(rect));
		}
	}
	
	/**
	 * Check that some rectangles contains or not other rectangles.
	 */
	@Test
	public void testContains() {
		// Rectangles not contained.
		Rectangle rect1 = new Rectangle(8, 12, 16, 16);
		Rectangle rect2 = new Rectangle(12, 8, 16, 12);
		Rectangle rect3 = new Rectangle(18, 12, 23, 16);
		Rectangle rect4 = new Rectangle(12, 28, 16, 36);
		Rectangle rect5 = new Rectangle(12, 8, 16, 12);
		Rectangle rect7 = new Rectangle(8, 8, 28, 38);
		Rectangle rect8 = new Rectangle(10, 8, 20, 38);
		Rectangle rect9 = new Rectangle(8, 10, 28, 30);
		Rectangle[] rectanglesNotContained = new Rectangle[]{rect1, rect2, rect3, rect4, rect5, rect7, rect8};
		
		// Rectangles contained.
		Rectangle rect6 = new Rectangle(12, 18, 16, 22);
		Rectangle rect10 = new Rectangle(10, 18, 20, 22);
		Rectangle rect11 = new Rectangle(12, 10, 16, 30);
		Rectangle[] rectanglesContained = new Rectangle[]{rect6, rect10, rect11};
		
		for(Rectangle rect: rectanglesNotContained) {
			assertFalse(baseRectangle.contains(rect));
		}
		
		for(Rectangle rect: rectanglesContained) {
			assertTrue(baseRectangle.contains(rect));
		}
	}

}
