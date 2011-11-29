package hierarchydisplay;

import shapes.*;

/**
 * Hierarchy display extension with right-angled connectors 
 */
abstract public cclass AngularHierarchyDisplay extends HierarchyDisplay {
	
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