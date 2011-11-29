/*
 * CaesarJ Tutorial
 *
 * Copyright 2004. TU-Darmstadt. Software Technology Group 
 */
package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import company.Company;
import company.Database;

/**
 * Main application class: creates user interface, initializes data.
 */
public class Application {

	/**
	 * State variables
	 */
	private HierarchyView view = new HierarchyView();
	private JFrame frame = new JFrame();
	private Company company = new Company();
	private HierarchyDisplayControl displayControl = new HierarchyDisplayControl(view, company);
	
	/* Entry point to the application */ 
	public static void main(String[] args) {
		new Application().start();
	}

	/* Starts the application by initializing GUI */
	public void start()	{
		buildInterface();
		Database.load(company);
		displayControl.showCompanyHierarchy();
		view.repaint();
	}
	
	/* Build application window */
	private void buildInterface() {
		frame.setSize(800, 600);
		frame.setContentPane(view);
		displayOnScreen(frame);
		frame.setTitle("CaesarJ - Lab 2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
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