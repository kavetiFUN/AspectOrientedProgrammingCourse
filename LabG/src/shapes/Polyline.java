package shapes;

import java.awt.Graphics;

import java.awt.Point;

/**
 * Poly line shape
 */
public cclass Polyline extends MultiPointShape {
	
	/* Initialize line */
    public Polyline(Point points[]) {
    	setPoints(points);
    }
    
    /* Get start point */
    public Point getStart() {
    	return getPointAt(0);
    }
    
    /* Get end point */
    public Point getEnd() {
    	return getPointAt(getPointCount()-1);
    }
    
    /* Calculate center point */
    public Point getCenter() {
    	if (getPointCount() % 2 == 1) {
    		return getPointAt(getPointCount() / 2);
    	}
    	else {
    		Point pt1 = getPointAt(getPointCount() / 2 - 1);
    		Point pt2 = getPointAt(getPointCount() / 2);
    		return new Point((pt1.x + pt2.x) / 2,
						 	 (pt1.y + pt2.y) / 2);
    	}
	}
    
    /* Draw shape */
	public void draw(Graphics g) {
		
		int cnt = getPointCount();
		for (int i1 = 0; i1 < cnt-1; i1++)
		{
			g.drawLine(	getPointAt(i1).x, 
						getPointAt(i1).y, 
						getPointAt(i1+1).x, 
						getPointAt(i1+1).y );				
		}
	}
}
