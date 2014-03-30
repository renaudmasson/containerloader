package datastructures;

import java.security.InvalidParameterException;
import java.util.Vector;

import org.w3c.dom.css.Rect;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

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
	
	/**
	 * Checks if two rectangles are equals.
	 * @param other the other rectangle
	 * @return true if the rectangles are equals, false otherwise.
	 */
	public boolean equals(Object other) {
		if (other instanceof IRectangleCoordinates) {
			IRectangleCoordinates otherRect = (IRectangleCoordinates) other;
			return x1 == otherRect.getX1()
					&& x2 == otherRect.getX2()
					&& y1 == otherRect.getY1()
					&& y2 == otherRect.getY2();
		}
		else {
			return false;
		}
		
	}
	
	public Vector<Rectangle> createNewRectangles(IRectangleCoordinates cause) {
		Vector<Rectangle> rectangles = new Vector<Rectangle>();
		long ix1 = findXFirstIntersectionPoint(cause);
		long ix2 = findXLastIntersectionPoint(cause);
		long iy1 = findYFirstIntersectionPoint(cause);
		long iy2 = findYLastIntersectionPoint(cause);
		if(ix1 > x1) {
			rectangles.add(new Rectangle(x1, y1, ix1, y2));
		}
		if(ix2 < x2) {
			rectangles.add(new Rectangle(ix2, y1, x2, y2));
		}
		if(iy1 > y1) {
			rectangles.add(new Rectangle(x1, y1, x2, iy1));
		}
		if(iy2 < y2) {
			rectangles.add(new Rectangle(x1, iy2, x2, y2));
		}
		return rectangles;
	}
	
	/**
	 * Finds the first intersection point of the two rectangle along the y axis.
	 * @param cause the other rectangle.
	 * @return the first intersection point of the two rectangle along the y axis.
	 */
	protected long findYFirstIntersectionPoint(IRectangleCoordinates cause) {
		return Math.max(y1, cause.getY1());
	}
	
	/**
	 * Finds the last intersection point of the two rectangle along the y axis.
	 * @param cause the other rectangle.
	 * @return the last intersection point of the two rectangle along the y axis.
	 */
	protected long findYLastIntersectionPoint(IRectangleCoordinates cause) {
		return Math.min(y2, cause.getY2());
	}
	
	/**
	 * Finds the first intersection point of the two rectangle along the x axis.
	 * @param cause the other rectangle.
	 * @return the first intersection point of the two rectangle along the x axis.
	 */
	protected long findXFirstIntersectionPoint(IRectangleCoordinates cause) {
		return Math.max(x1, cause.getX1());
	}
	
	/**
	 * Finds the last intersection point of the two rectangle along the x axis.
	 * @param cause the other rectangle.
	 * @return the last intersection point of the two rectangle along the x axis.
	 */
	protected long findXLastIntersectionPoint(IRectangleCoordinates cause) {
		return Math.min(x2, cause.getX2());
	}
	
	public String toString() {
		return x1 + ", " + x2 + ", " + y1 + ", " + y2;
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
