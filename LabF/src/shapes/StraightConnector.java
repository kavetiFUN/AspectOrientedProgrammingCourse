package shapes;

import java.awt.Point;

/**
 * Straight connector
 */
public cclass StraightConnector extends Connector & Line {
	
	/* Get start point */
	public Point getPointA() {
		return getStart();
	}
	
	/* Get end point */
	public Point getPointB() {
		return getEnd();
	}
	
	public Point getStart() {
		return _fromCpt.getSnapPoint(_toCpt.getTargetPoint());
	}
	
	public Point getEnd() {
		return _toCpt.getSnapPoint(_fromCpt.getTargetPoint());
	}
}