package shapes;

import java.awt.Point;

/**
 * Abstract multi-point shape
 */
abstract public cclass MultiPointShape extends Shape {
	
	/* State variables */
	protected Point[] _points;
    
	/* Set points for the shape */
    public void setPoints(Point[] points){
    	_points = points;
    }
    
    /* Get point count */
    public int getPointCount(){
        return _points.length;
    }
    
    /* Get i1-th point */
    public Point getPointAt(int i){
        return _points[i];
    }
	
	/* Get shape position */
	public Point getPos() { 
		return _points[0];
	}
	
	/* Move shape to given position */
	public void moveTo(Point pt) {
		int dx = pt.x - _points[0].x;
		int dy = pt.y - _points[0].y;
		for (int i1 = 0; i1 < _points.length; i1++) {
			_points[i1].x += dx;
			_points[i1].y += dy;
		}		 
	}
	
	/* Calculate shape width */
	public int getWidth() {
		int minX = _points[0].x;
		int maxX = minX;
		for (int i1 = 1; i1 < _points.length; i1++) {
			if (_points[i1].x < minX) {
				minX = _points[i1].x;
			}
			else if (_points[i1].x > maxX) {
				maxX = _points[i1].x;
			}			
		}
		return maxX - minX;
	}
	
	/* Calculate shape height */
	public int getHeight() {
		int minY = _points[0].y;
		int maxY = minY;
		for (int i1 = 1; i1 < _points.length; i1++) {
			if (_points[i1].y < minY) {
				minY = _points[i1].y;
			}
			else if (_points[i1].getY() > maxY) {
				maxY = _points[i1].y;
			}			
		}
		return maxY - minY;
	}
}
