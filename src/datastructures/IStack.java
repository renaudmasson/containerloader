package datastructures;

/**
 * An interface that represent a stack.
 * @author renaud
 *
 */
public interface IStack extends IRectangleCoordinates{
	
	/**
	 * @return the stack length.
	 */
	public long getLength();
	
	/**
	 * @return the stack width.
	 */
	public long getWidth();
	
	
	/**
	 * @return the stack height.
	 */
	public long getHeight();
	
	/**
	 * @return the stack weight.
	 */
	public long getWeight();
	
	/**
	 * @return true if the stack is a assigned to a container, false otherwise.
	 */
	public boolean isAssigned();
	
	/**
	 * @return the id of the container to which this Stack is assigned.
	 */
	public long getContainerId();
	
	/**
	 * @return the id of the stack.
	 */
	public long getStackId();

}
