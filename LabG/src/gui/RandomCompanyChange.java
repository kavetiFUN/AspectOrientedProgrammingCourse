package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import company.*;

/**
 * Handles Change menu item action
 */
public class RandomCompanyChange implements ActionListener {
	
	public static final String[] firstNames = 
		{ "Mary", "Steve", "Robert", "Tom", "Anna", 
		  "Emily", "Paul", "Hary", "Sarah", "Jessica" };
	
	public static final String[] lastNames = 
	{ "A.", "B.", "C.", "D.", "E.", 
	  "F.", "G.", "H.", "I.", "J." };
	
	/**
	 * State variables
	 */
	private Company _company;
	
	private Random rand = new Random();
	
	/* Initialize action */
	public RandomCompanyChange(Company company) {
		_company = company;
	}

	/**
	 * Handle menu item 
	 * Exchanges the roles of two random emploees 
	 */
	public void actionPerformed(ActionEvent e) {
    
		String actionCmd = e.getActionCommand();
    	if (actionCmd.equals("Transfer Worker")) {
    		transferWorker();
    	}
    	else if (actionCmd.equals("Rename Worker")) {
    		renameWorker();
    	}
    	else if (actionCmd.equals("Rename Manager")) {
    		renameManager();
    	}
    	else if (actionCmd.equals("Rename CEO")) {
    		renameCEO();
    	}
    }
    	
    private void transferWorker() {
    	Employee empl1 = randomWorker();
		Department deptm = randomDeptm();
		while (deptm.equals(empl1.getDepartment())) {
			deptm = randomDeptm();
		}
		_company.transferTo(empl1, Employee.WORKER, deptm);
    }
    
    private void renameWorker() {
    	Employee empl1 = randomWorker();
    	empl1.setName(firstNames[rand.nextInt(10)], lastNames[rand.nextInt(10)]);    	
    }
    
    private void renameManager() {
    	Department deptm = randomDeptm();
    	deptm.getManager().setName(firstNames[rand.nextInt(10)], lastNames[rand.nextInt(10)]);    	
    }
    
    private void renameCEO() {
    	_company.getCEO().setName(firstNames[rand.nextInt(10)], lastNames[rand.nextInt(10)]);    	
    }
	
	/* Select random emploee */
	private Employee randomWorker() {
		Department deptm = randomDeptm();
		while (deptm.getWorkerCount() <= 0) {
			deptm = randomDeptm();
		}
		return deptm.getWorkerAt(rand.nextInt(deptm.getWorkerCount()));		
	}
	
	/* Select random department */
	private Department randomDeptm() {
		return _company.getDepartmentAt(rand.nextInt(_company.getDepartmentCount()));
	}
}
