package datastructures;

public class Bin {

	/**
	 * The identifier of the bin type.
	 */
	private String binType;
	
	/**
	 * The length of the bin.
	 */
	private long length;
	
	/**
	 * The width of the bin.
	 */
	private long width;
	
	/**
	 * The height of the bin.
	 */
	private long height;
	
	/**
	 * The maximum weight of the bin.
	 */
	private long maxWeight;
	
	/**
	 * The current weight of the items in the bin.
	 */
	private long currentWeight;

	/**
	 * Constructor.
	 * @param binType the type of the bin used.
	 * @param length  the length of the bin.
	 * @param width   the width of the bin.
	 * @param height  the height of the bin.
	 * @param maxWeight the maximum weight of the bin.
	 */
	public Bin(String binType, long length, long width, long height,
			long maxWeight) {
		super();
		this.binType = binType;
		this.length = length;
		this.width = width;
		this.height = height;
		this.maxWeight = maxWeight;
		this.currentWeight = 0;
	}
	
	/**
	 * Evaluate if an additional stack fits in the container.
	 * @param toAdd the stack for which we want to check if it fits.
	 * @return true if the stack fits in the container, false otherwise.
	 */
	public boolean fitsIn(IStack toAdd) {
		//TODO code the function.
		return false;
	}
	
	/**
	 * @return the last position of a stack in the container.
	 */
	public long maxX() {
		//TODO code the function.
		return length;
	}

	
}
