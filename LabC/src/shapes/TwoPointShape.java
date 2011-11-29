package shapes;

import java.awt.Point;

/**
 * @author vaidas
 *
 * A shape defined by two points
 */
abstract public cclass TwoPointShape extends Shape {
	/* State variables */
	protected Point _pointA = new Point();
	protected Point _pointB = new Point();
	
	/* set points */
	public void setPoints(Point pointA, Point pointB) {
		_pointA = pointA;
		_pointB = pointB;
	}
	
	public void setPoints(int x1, int y1, int x2, int y2) {
    	setPoints(new Point(x1, y1), new Point(x2, y2));
    }
	
	/* Get shape position */
	public Point getPos() { 
		return getPointA();
	}
	
	/* Get point A */
	public Point getPointA() {
		return _pointA;
	}
	
	/* Get point B */
	public Point getPointB() {
		return _pointB;
	}
	
	/* Calculate shape width */
	public int getWidth() {
		return Math.abs(_pointA.x - _pointB.x);
	}
	
	/* Calculate shape height */
	public int getHeight() {
		return Math.abs(_pointA.y - _pointB.y);
	}
		
	/* Move shape to given position */
	public void moveTo(Point pt) {
		_pointB.x += pt.x - _pointA.x;
		_pointB.y += pt.y - _pointA.y;
		_pointA.x = pt.x;
		_pointA.y = pt.y;
	}
      
    /* Calculate center point */
    public Point getCenter() {
		return new Point((getPointA().x + getPointB().x) / 2,
						 (getPointA().y + getPointB().y) / 2);
	}
}
