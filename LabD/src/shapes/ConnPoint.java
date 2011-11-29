package shapes;

import java.awt.Point;


/*************************************************************** 
 * Connection point abstraction
 */
abstract public cclass ConnPoint {
	
	/* Get target snap point */
	abstract public Point getTargetPoint();
	
	/* Get actual (visible) snap point */
	abstract public Point getSnapPoint(Point pt2);
}
