package datastructures;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Vector;

public class Bin {

	/**
	 * The identifier of the bin type.
	 */
	protected String binType;
	
	/**
	 * The length of the bin.
	 */
	protected long length;
	
	/**
	 * The width of the bin.
	 */
	protected long width;
	
	/**
	 * The height of the bin.
	 */
	protected long height;
	
	/**
	 * The maximum weight of the bin.
	 */
	protected long maxWeight;
	
	/**
	 * The current weight of the items in the bin.
	 */
	protected long currentWeight;
	
	/**
	 * the id of the bin.
	 */
	protected long binId;
	
	/**
	 * The maximum value.
	 */
	protected long maxX;
	
	/**
	 * All the available spaces in the bin.
	 */
	protected PriorityQueue<Rectangle> availableSpace;

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
		availableSpace = new PriorityQueue<Rectangle>(1, new RectangleComparator());
		availableSpace.add(new Rectangle(0, 0, length, width));
		maxX = 0;
	}
	
	/**
	 * Evaluate if an additional stack fits in the container.
	 * @param toAdd the stack for which we want to check if it fits.
	 * @return true if the stack fits in the container, false otherwise.
	 */
	public boolean fitsIn(IStack toAdd) {
		if(toAdd.getHeight() > height) {
			return false;
		}
		if(toAdd.getWeight() + currentWeight > maxWeight) {
			return false;
		}
		for(Rectangle rect: availableSpace) {
			if(rect.fitsIn(toAdd)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Adds a stack to the bin and update the available space.
	 * @param toAdd
	 */
	public void add(IStack toAdd) {
		Rectangle usedRectangle = null;
		for(Rectangle rect: availableSpace) {
			if(rect.fitsIn(toAdd)) {
				usedRectangle = rect;
				toAdd.setX1(rect.getX1());
				toAdd.setX2(rect.getX1() + toAdd.getLength());
				if(rect.getX1() + toAdd.getLength() > maxX) {
					maxX = rect.getX1() + toAdd.getLength();
				}
				toAdd.setY1(rect.getY1());
				toAdd.setY2(rect.getY1() + toAdd.getWidth());
				toAdd.setContainerId(binId);
				toAdd.setAssigned(true);
				break;
			}
		}
		recomputeAvailableSpaces(toAdd);
		currentWeight += toAdd.getWeight();
	}
	
	private void recomputeAvailableSpaces(IStack toAdd) {
		Vector<Rectangle> toRemove = new Vector<Rectangle>();
		HashSet<Rectangle> rectanglesToAdd = new HashSet<Rectangle>();
		for(Rectangle rect: availableSpace) {
			if(rect.intersects(toAdd)) {
				Vector<Rectangle> result = rect.createNewRectangles(toAdd);
				rectanglesToAdd.addAll(result);
				toRemove.add(rect);
			}
		}
		availableSpace.removeAll(toRemove);
		availableSpace.addAll(rectanglesToAdd);
	}
	
	/**
	 * @return the last position of a stack in the container.
	 */
	public long maxX() {
		//TODO code the function.
		return maxX;
	}

	
}
