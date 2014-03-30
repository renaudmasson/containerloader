package datastructures;

import java.util.Comparator;

public class RectangleComparator implements Comparator<Rectangle> {

	@Override
	public int compare(Rectangle arg0, Rectangle arg1) {
		double returnVal = 0;
		returnVal += Math.copySign(1000.0, arg0.getX1() - arg1.getX1());
		returnVal += Math.copySign(100.0, arg0.getY1() - arg1.getY1());
		returnVal += Math.copySign(10.0, arg1.getY2() - arg0.getY2());
		returnVal += Math.copySign(1.0, arg1.getX2() - arg0.getX2());
		return (int) returnVal;
	}

}
