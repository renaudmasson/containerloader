package datastructures;

public interface IRectangleCoordinates {
	
	/**
	 * 
	 * @return the x origin of the rectangle.
	 */
	public long getX1();
	
	/**
	 * 
	 * @return the y origin of the rectangle.
	 */
	public long getY1();
	
	/**
	 * 
	 * @return the x destination of the rectangle.
	 */
	public long getX2();
	
	/**
	 * 
	 * @return the y destination of the rectangle.
	 */
	public long getY2();
	
	/**
	 * 
	 * @param x1 the origin of the rectangle.
	 */
	public void setX1(long x1);
	
	/**
	 * 
	 * @param x2 the destination of the rectangle.
	 */
	public void setX2(long x2);
	
	/**
	 * 
	 * @param y1 the origin of the rectangle.
	 */
	public void setY1(long y1);
	
	
	/**
	 * 
	 * @param y2 the destination of the rectangle.
	 */
	public void setY2(long y2);

	


}
