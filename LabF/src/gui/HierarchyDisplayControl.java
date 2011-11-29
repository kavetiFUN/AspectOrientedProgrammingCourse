package gui;

import java.awt.Component;

import company.Company;
import company.Database;

import guidisplay.*;
import hierarchydisplay.*;
import companydisplay.*;

public class HierarchyDisplayControl {
	
	protected HierarchyView view;
	protected Company company;
	protected boolean companyDisplayed = false;
	
	public HierarchyDisplayControl(HierarchyView view, Company company) {
		this.view = view;
		this.company = company;
	}
	
	public void showCompanyHierarchy() {
		switchCompanyHierarchy(new CompanyHierarchyDisplay());
	}
	
	public void showAdjustedCompanyHierarchy() {
		/* fill in */			
	}
	
	public void showAngularCompanyHierarchy() {
		/* fill in */
	}
	
	public void showAdjustedAngularCompanyHierarchy() {
		/* fill in */		
	}
	
	public void showGUIHierarchy() {
		/* fill in */		
	}
	
	public void showAdjustedGUIHierarchy() {
		/* fill in */
	}
	
	public void showAngularGUIHierarchy() {
		/* fill in */
	}
	
	public void showAdjustedAngularGUIHierarchy() {
		/* fill in */
	}
	
	protected void switchCompanyHierarchy(CompanyHierarchyBinding hier) {
		if (companyDisplayed) {
			undeploy view.getHierarchy();
		}
		hier.setCompany(company);
		view.setHierarchy(hier);
		deploy hier;
		companyDisplayed = true;
	}
	
	protected void switchGUIHierarchy(GUIHierarchyBinding hier) {
		if (companyDisplayed) {
			undeploy view.getHierarchy();
		}
		hier.setRootComponent(view.getTopLevelAncestor());
		view.setHierarchy(hier);
		companyDisplayed = false;
	}
}
