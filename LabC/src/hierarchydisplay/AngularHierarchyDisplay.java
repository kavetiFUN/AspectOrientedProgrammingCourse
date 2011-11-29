package hierarchydisplay;

import java.awt.Graphics;
import java.awt.Point;
import shapes.Connector;
import shapes.RightAngledConnector;

public cclass AngularHierarchyDisplay extends HierarchyDisplay {

	public AngularHierarchyDisplay() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Connection between nodes
	 */
	public cclass Connection {
		
		/* initialize connection shape */
		protected void initShape() {
			connShape = new RightAngledConnector(parent.getShape(), child.getShape());
		}
	}
}
