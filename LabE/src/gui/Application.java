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

import company.Company;
import company.Database;

/**
 * Main application class: creates user interface, initializes data.
 */
public class Application implements ActionListener {

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
		frame.setJMenuBar(buildMenuBar());
		frame.setVisible(true);
	}
	
	/* Build application menu bar. */
	private JMenuBar buildMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Company");
		
		JMenuItem menuItem = new JMenuItem("Company Hierarchy");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Adjusted Company Hierarchy");
		menuItem.addActionListener(this);
		menu.add(menuItem);
				
		menuBar.add(menu);
		
		menu = new JMenu("Change");
		
		menuBar.add(menu);
		
		RandomCompanyChange change = new RandomCompanyChange(company);
		
		menuItem = new JMenuItem("Transfer Worker");
		menuItem.addActionListener(change);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Rename Worker");
		menuItem.addActionListener(change);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Rename Manager");
		menuItem.addActionListener(change);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Rename CEO");
		menuItem.addActionListener(change);
		menu.add(menuItem);
		
		return menuBar;
    }
	
	public void actionPerformed(ActionEvent e) {
    	String actionCmd = e.getActionCommand();
    	if (actionCmd.equals("Company Hierarchy")) {
    		displayControl.showCompanyHierarchy();
    	}
    	else if (actionCmd.equals("Adjusted Company Hierarchy")) {
    		displayControl.showAdjustedCompanyHierarchy();
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