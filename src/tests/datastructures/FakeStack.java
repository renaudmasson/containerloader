package tests.datastructures;

import datastructures.IStack;

public class FakeStack implements IStack {
	
	private long length;
	private long width;
	private long height;
	private long weight;
	private boolean isAssigned;
	private long containerId;
	private long stackId;
	private long x1;
	private long x2;
	private long y1;
	private long y2;
	
	

	public FakeStack(long length, long width, long height, long weight,
			boolean isAssigned, long containerId, long stackId, long x1,
			long x2, long y1, long y2) {
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.isAssigned = isAssigned;
		this.containerId = containerId;
		this.stackId = stackId;
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	@Override
	public long getLength() {
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public long getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public long getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public long getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public boolean isAssigned() {
		// TODO Auto-generated method stub
		return isAssigned;
	}

	@Override
	public long getContainerId() {
		// TODO Auto-generated method stub
		return containerId;
	}

	@Override
	public long getStackId() {
		// TODO Auto-generated method stub
		return stackId;
	}

	@Override
	public long getX1() {
		// TODO Auto-generated method stub
		return x1;
	}

	@Override
	public long getY1() {
		// TODO Auto-generated method stub
		return y1;
	}

	@Override
	public long getX2() {
		// TODO Auto-generated method stub
		return x2;
	}

	@Override
	public long getY2() {
		// TODO Auto-generated method stub
		return y2;
	}




}
