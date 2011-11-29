package shapes;

import java.awt.Point;

/*************************************************************** 
 * Rectangle shape
 */
public cclass Rectangle extends Polygon & TwoPointShape {
    
	/* Initialize rectangle */
    public Rectangle(int x1, int y1, int x2, int y2){
    	setPoints(x1, y1, x2, y2);
    }
    
    /* Get number of vertices */
	public int getVerticeCount() {
		return 4;
	}
	
	/* Get i1-th vertice */
	public Point getVerticeAt(int i1) {
		
		return new Point(
				(i1 == 0 || i1 == 3) ? getPointA().x :  getPointB().x,
				(i1 < 2) ? getPointA().y : getPointB().y
			);
	}
}
