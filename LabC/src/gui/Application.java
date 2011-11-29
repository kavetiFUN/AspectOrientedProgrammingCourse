/*
 * CaesarJ Tutorial
 *
 * Copyright 2004. TU-Darmstadt. Software Technology Group 
 */
package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Main application class: creates user interface, initializes data.
 */
public class Application implements ActionListener {

	/**
	 * State variables
	 */
	private HierarchyView view = new HierarchyView();
	private JFrame frame = new JFrame();
	private HierarchyDisplayControl displayControl = new HierarchyDisplayControl(view);
	
	/* Entry point to the application */ 
	public static void main(String[] args) {
		new Application().start();
	}

	/* Starts the application by initializing GUI */
	public void start()	{
		buildInterface();
		displayControl.showBaseHierarchy();
		view.repaint();
	}
	
	/* Build application window */
	private void buildInterface() {
		frame.setSize(800, 600);
		frame.setContentPane(view);
		displayOnScreen(frame);
		frame.setTitle("CaesarJ - Lab 2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(buildMenuBar());
		frame.setVisible(true);
	}
	
	/* Build application menu bar. */
	private JMenuBar buildMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Options");
		
		JMenuItem menuItem = new JMenuItem("Base Hierarchy");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Adjusted Hierarchy");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Angular Hierarchy");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Adjusted Angular Hierarchy");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuBar.add(menu);
		
		return menuBar;
    }
	
	public void actionPerformed(ActionEvent e) {
    	String actionCmd = e.getActionCommand();
    	if (actionCmd.equals("Base Hierarchy")) {
    		displayControl.showBaseHierarchy();
    	}
    	else if (actionCmd.equals("Adjusted Hierarchy")) {
    		displayControl.showAdjustedHierarchy();
    	}
    	else if (actionCmd.equals("Angular Hierarchy")) {
    		displayControl.showAngularHierarchy();
    	}
    	else if (actionCmd.equals("Adjusted Angular Hierarchy")) {
    		displayControl.showAdjustedAngularHierarchy();
    	}
    }
	
	/* Display application window at the screen center. */
	private void displayOnScreen(JFrame frame)	{
		Dimension paneSize   = frame.getSize();
		Dimension screenSize = frame.getToolkit().getScreenSize();
		frame.setLocation(
			(screenSize.width  - paneSize.width)  / 2,
			(screenSize.height - paneSize.height) / 2);
	}	
}