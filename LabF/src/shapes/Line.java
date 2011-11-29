package shapes;

import java.awt.Graphics;

import java.awt.Point;

/*************************************************************** 
 * Basic line shape
 */
public cclass Line extends TwoPointShape {
	
	/* Initialize line */
    public Line(Point start, Point end) {
    	setPoints(start, end);
    }
    
    /* Draw shape */
	public void draw(Graphics g) {
		g.drawLine(getPointA().x, 
		           getPointA().y, 
		           getPointB().x, 
		           getPointB().y);
	}
}
