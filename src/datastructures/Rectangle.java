package datastructures;

import java.security.InvalidParameterException;
import java.util.Vector;

public class Rectangle implements IRectangleCoordinates {

	
	/**
	 * Coordinate
	 */
	private long x1;
	/**
	 * Coordinate
	 */
	private long y1;
	/**
	 * Coordinate
	 */
	private long x2;
	/**
	 * Coordinate
	 */
	private long y2;
	
	/**
	 * Length of the rectangle.
	 */
	private long length;
	
	/**
	 * Width of the rectangle.
	 */
	private long width;
	
	
	/**
	 * Constructor. 
	 * @param x1 origin coordinate.
	 * @param y1 origin coordinate.
	 * @param x2 end coordinate.
	 * @param y2 end coordinate.
	 */
	public Rectangle(long x1, long y1, long x2, long y2) throws InvalidParameterException{
		super();
		if(x2 <= x1) {
			throw new InvalidParameterException("x2 must be greater than x1");
		}
		if(y2 <= y1) {
			throw new InvalidParameterException("y2 must be greater than y1");
		}
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		length = x2-x1;
		width = y2-y1;
	}
	
	/**
	 * compute if the stack fits in the rectangle.
	 * @param stack
	 * @return
	 */
	public boolean fitsIn(IStack stack) {
		return length>=stack.getLength() && width>=stack.getWidth();
	}
	
	/**
	 * compute if the coordinates intersect the rectangle.
	 * @param other the coordinates
	 * @return true if the coordinates intersect the rectangle, false otherwise.
	 */
	public boolean intersects(IRectangleCoordinates other) {
		return !(x2 <= other.getX1() 
				  || x1 >= other.getX2()
				  || y2 <= other.getY1()
				  || y1 >= other.getY2());
	}
	
	/**
	 * compute if a rectangle completely contains some coordinates.
	 * @param other the coordinates
	 * @return true if the coordinates are contained in the rectangle, false otherwise.
	 */
	public boolean contains(IRectangleCoordinates other) {
		return x1 <= other.getX1()
				&& y1 <= other.getY1()
				&& x2 >= other.getX2()
				&& y2 >= other.getY2();
	}
	
	public Vector<Rectangle> createNewRectangles(IRectangleCoordinates cause) {
		Vector<Rectangle> rectangles = new Vector<Rectangle>();
		return rectangles;
	}

	@Override
	public long getX1() {
		return x1;
	}

	@Override
	public long getY1() {
		return y1;
	}

	@Override
	public long getX2() {
		return x2;
	}

	@Override
	public long getY2() {
		return y2;
	}

	/**
	 * Simple getter.
	 * @return the length of the rectangle.
	 */
	public long getLength() {
		return length;
	}

	/**
	 * Simple getter.
	 * @return the width of the rectangle.
	 */
	public long getWidth() {
		return width;
	}
	
	
	

}
