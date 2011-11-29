package hierarchydisplay;

import java.awt.Graphics;
import java.awt.Point;

/**
 * Hierarchy display extension with node sizes adjusted to text
 */
abstract public cclass AdjustedHierarchyDisplay extends HierarchyDisplay {
	
	abstract public cclass Node {
		
		protected int _maxWidth = 0;
		protected Point _pos = new Point();
		
		/* Text if text fits in the shape */
		public boolean textFits(String text) {
			return calcTextWidth(text) < _maxWidth;
		}
		
		/* 
		 * overrides HierarchyDispl.....positionNode
		 * Position node at given place */
		protected void positionNode(Point pt, int maxWidth) {
			_maxWidth = maxWidth;
			_pos = pt;
			adjustShape(pt, calcTextWidth(getText()));
			shape.setText(getText());
		}
		
		/* update text */
		public void textChanged() {
			adjustShape(_pos, calcTextWidth(getText()));
			shape.setText(getText());
		}
	}
}
