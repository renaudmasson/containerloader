package datastructures;

/**
 * An interface that represent a stack.
 * @author renaud
 *
 */
public interface IStack {
	
	/**
	 * 
	 * @return
	 */
	public long getLength();
	
	public long getWidth();
	
	public long getHeight();
	
	public long getWeight();
	
	public boolean isAssigned();
	
	public long getContainerId();
	
	public long getXOrigin();
	
	public long getYOrigin();
	
	public long getXDestination();
	
	public long getYDestination();

}
