package gui;

import java.awt.Component;

import org.caesarj.runtime.rmi.CaesarHost;

import company.Company;
import company.Database;

import guidisplay.*;
import hierarchydisplay.*;
import companydisplay.*;

public class HierarchyDisplayControl {
	
	protected HierarchyView view;
	protected Company company;
	protected CaesarHost host;
	protected boolean companyDisplayed = false;
	
	public HierarchyDisplayControl(HierarchyView view, Company company, CaesarHost host) {
		this.view = view;
		this.company = company;
		this.host = host;
	}
	
	public void showCompanyHierarchy() {
		switchCompanyHierarchy(new CompanyHierarchyDisplay());
	}
	
	public void showAdjustedCompanyHierarchy() {
		switchCompanyHierarchy(new AdjustedCompanyHierarchyDisplay());		
	}
	
	public void showAngularCompanyHierarchy() {
		switchCompanyHierarchy(new AngularCompanyHierarchyDisplay());
	}
	
	public void showAdjustedAngularCompanyHierarchy() {
		switchCompanyHierarchy(new AdjustedAngularCompanyHierarchyDisplay());		
	}
	
	public void showGUIHierarchy() {
		switchGUIHierarchy(new GUIHierarchyDisplay());		
	}
	
	public void showAdjustedGUIHierarchy() {
		switchGUIHierarchy(new AdjustedGUIHierarchyDisplay());
	}
	
	public void showAngularGUIHierarchy() {
		switchGUIHierarchy(new AngularGUIHierarchyDisplay());
	}
	
	public void showAdjustedAngularGUIHierarchy() {
		switchGUIHierarchy(new AdjustedAngularGUIHierarchyDisplay());
	}
	
	protected void switchCompanyHierarchy(CompanyHierarchyBinding hier) {
		if (companyDisplayed) {
			/* fill in */
		}
		hier.setCompany(company);
		view.setHierarchy(hier);
		/* fill in */
		companyDisplayed = true;
	}
	
	protected void switchGUIHierarchy(GUIHierarchyBinding hier) {
		if (companyDisplayed) {
			/* fill in */			
		}
		hier.setRootComponent(view.getTopLevelAncestor());
		view.setHierarchy(hier);
		companyDisplayed = false;
	}
}
