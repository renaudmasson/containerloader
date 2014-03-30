package datastructures;

public class Rectangle {

	
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
	public Rectangle(long x1, long y1, long x2, long y2) {
		super();
		assert(x2 > x1);
		assert(y2 > y1);
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
		return length>stack.getLength() && width>stack.getWidth();
	}
	
	/**
	 * compute if the stack intersect the rectangle.
	 * @param stack
	 * @return true if the stack intersect the rectangle.
	 */
	public boolean intersect(IStack stack) {
		return true;
	}
	
	
	

}
