/*
 * Created on 11.04.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package gui;

import hierarchydisplay.*;

/**
 * @author vaidas
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class HierarchyDisplayControl {
	
	HierarchyView view;
	
	public HierarchyDisplayControl(HierarchyView view) {
		this.view = view;
	}
	
	public void showBaseHierarchy() {
		IHierarchyDisplay hier = new HierarchyDisplay();
		view.setHierarchy(hier);
		fillSampleData(hier);
		
	}
	
	public void showAdjustedHierarchy() {
		HierarchyDisplay hier = new AdjustedHierarchyDisplay();
		view.setHierarchy(hier);
		fillSampleData(hier);			
	}
	
	public void showAngularHierarchy() {
		HierarchyDisplay hier = new AngularHierarchyDisplay();
		view.setHierarchy(hier);
		fillSampleData(hier);
	}
	
	public void showAdjustedAngularHierarchy() {
		HierarchyDisplay hier = new AdjustedAngularHierarchyDisplay();
		view.setHierarchy(hier);
		fillSampleData(hier);
	}
	
	public void fillSampleData(final IHierarchyDisplay model) {
		model.CompositeNode node1 = model.new CompositeNode();
		node1.setText("Top");
		model.setRoot(node1);
		
		model.CompositeNode node2 = model.new CompositeNode();
		node2.setText("ChildA");
		node1.addChild(node2);
		
		model.CompositeNode node3 = model.new CompositeNode();
		node3.setText("ChildB");
		node1.addChild(node3);
		
		model.Node node4 = model.new Node();
		node4.setText("ChildA1");
		node2.addChild(node4);
		
		model.Node node5 = model.new Node();
		node5.setText("ChildA2");
		node2.addChild(node5);
		
		model.Node node6 = model.new Node();
		node6.setText("ChildB1");
		node3.addChild(node6);
		
		model.Node node7 = model.new Node();
		node7.setText("ChildB2");
		node3.addChild(node7);
	}
}
