/*
 * Created on 11.04.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package gui;

import org.caesarj.runtime.DeploySupport;

import company.Company;
import company.Database;

import hierarchydisplay.*;
import companydisplay.*;

public class HierarchyDisplayControl {
	
	HierarchyView view;
	Company company;
	
	public HierarchyDisplayControl(HierarchyView view, Company company) {
		this.view = view;
		this.company = company;
	}
	
	public void showCompanyHierarchy() {
		switchCompanyHierarchy(new CompanyHierarchyDisplay());
	}
	
	public void showAdjustedCompanyHierarchy() {
		switchCompanyHierarchy(new AdjustedCompanyHierarchyDisplay());		
	}
	
	protected void switchCompanyHierarchy(CompanyHierarchyBinding hier) {
		if (view.getHierarchy() != null) {
			undeploy view.getHierarchy();
		}
		hier.setCompany(company);
		view.setHierarchy(hier);
		deploy hier;
	}	
}
