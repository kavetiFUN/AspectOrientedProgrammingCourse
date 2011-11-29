package shapes;

import java.awt.Point;

/**
 * Right-angled connector
 */
public cclass RightAngledConnector extends Connector & Polyline {
	
	/* Get point count */
	public Point getPointCount() {
		return 4;
	}
	
	/* Get end point */
	public Point getPointAt(int i) {
		
		Point fromPt = _fromCpt.getTargetPoint();
		Point toPt = _toCpt.getTargetPoint();
		
		switch (i) {
		case 0:
			return _fromCpt.getSnapPoint(new Point(fromPt.x, toPt.y));
		case 1:
			return new Point(fromPt.x, (fromPt.y + toPt.y) / 2);
		case 2:
			return new Point(toPt.x, (fromPt.y + toPt.y) / 2);
		case 3:
			return _toCpt.getSnapPoint(new Point(toPt.x, fromPt.y));
		default:
			return null;
		}	        
    }
	
	public Point getStart() {
		return getPointAt(0);
	}
	
	public Point getEnd() {
		return getPointAt(3);
	}
}