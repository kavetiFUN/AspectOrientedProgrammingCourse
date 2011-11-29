package shapes;

import java.awt.Point;

/*************************************************************** 
 * Abstract connector shape
 */
abstract public cclass Connector extends Shape {
	
	/* State variables */
	protected ConnPoint _fromCpt;
	protected ConnPoint _toCpt;
	
	/* Initialize connector */
	public Connector(ConnPoint from, ConnPoint to) {
		_fromCpt = from;
		_toCpt = to;
	}
	
	/* Get start point */
	abstract public Point getStart();
	
	/* Get end point */
	abstract public Point getEnd();
}
