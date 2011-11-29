package shapes;

import java.awt.Graphics;

import util.Intersection;
import java.awt.Point;

/*************************************************************** 
 * Abstract polygon class
 */
abstract public cclass Polygon extends TextShape {
    
	/* Get polygon vertice count */
	abstract public int getVerticeCount();
	
	/* Get i1-th vertice of the polygon */
    abstract public Point getVerticeAt(int i1);
           
    /* Calculate polygon center */
    public Point getCenter() {
		int cnt = getVerticeCount();
		Point center = new Point(0, 0); 
		
		for (int i1 = 0; i1 < cnt; i1++) {
			center.x += getVerticeAt(i1).x;
			center.y += getVerticeAt(i1).y;
		}
		
		center.x = center.x / cnt;
		center.y = center.y / cnt;
		return center;
	}
    
    /* Draw shape */
	public void draw(Graphics g) {
		
		int vertices = getVerticeCount();
		for (int i1 = 0; i1 < vertices; i1++)
		{
			int i2 = (i1 == vertices-1 ? 0 : i1+1);
			g.drawLine(	getVerticeAt(i1).x, 
			        	getVerticeAt(i1).y, 
			        	getVerticeAt(i2).x, 
			        	getVerticeAt(i2).y );				
		}
		
		drawText(g);		
	}
	
	/* Find the snap point at the polygon edge */
	public Point getSnapPoint(Point pt2) {
		Point pt1 = getTargetPoint();
		
		int vertices = getVerticeCount();
		for (int i1 = 0; i1 < vertices; i1++)
		{
			int i2 = (i1 == vertices-1 ? 0 : i1+1);
			Point pt3 = getVerticeAt(i1); 
			Point pt4 =	getVerticeAt(i2);
			
			if (Intersection.segmentsIntersect(
					pt1.x, pt1.y, 
					pt2.x, pt2.y,
					pt3.x, pt3.y,
					pt4.x, pt4.y)) {
				
				return Intersection.intersect(
					pt1.x, pt1.y, 
					pt2.x, pt2.y,
					pt3.x, pt3.y,
					pt4.x, pt4.y);
			}
		}
		return pt1;
	}
}
