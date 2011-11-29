package hierarchydisplay;

import shapes.RightAngledConnector;

public cclass AdjustedAngularHierarchyDisplay extends AdjustedHierarchyDisplay & AngularHierarchyDisplay{

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
