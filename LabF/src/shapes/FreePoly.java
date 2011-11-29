package shapes;

import java.awt.Point;

/*************************************************************** 
 * Free polygon shape (with any number of vertices)
 */
public cclass FreePoly extends Polygon & MultiPointShape {
	
	/* Initialize polygon */
    public FreePoly(Point[] verts){
        setPoints(verts);
    }
    
    /* Get vertice count */
    public int getVerticeCount(){
        return getPointCount();
    }
    
    /* Get i1-th vertice */
    public Point getVerticeAt(int i){
        return getPointAt(i);
    }    
}
