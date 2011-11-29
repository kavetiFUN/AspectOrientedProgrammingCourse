package shapes;

import java.awt.Graphics;

import java.awt.Point;

/*************************************************************** 
 * Abstract shape class
 */
abstract public cclass Shape extends ConnPoint {
	
	/* Get shape position */
	abstract public Point getPos();
		
	/* Calculate shape center */
	abstract public Point getCenter();
	
	/* Calculate shape width */
	abstract public int getWidth();
	
	/* Calculate shape height */
	abstract public int getHeight();
	
	/* Move shape to given position */
	abstract public void moveTo(Point pt);
	
	/* Draw shape */
	abstract public void draw(Graphics g);
	
	/* Get target snap point */
	public Point getTargetPoint() {
		return getCenter();
	}
	
	/* Get actual (visible) snap point */
	public Point getSnapPoint(Point pt2) {
		return getCenter();
	}
}
