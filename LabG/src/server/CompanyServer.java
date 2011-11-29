/*
 * CaesarJ Tutorial
 *
 * 2004. TU-Darmstadt. Software Technology Group 
 */
package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.caesarj.runtime.rmi.CaesarHost;
import org.caesarj.runtime.rmi.CaesarRemoteException;

import company.Database;
import company.Company;

/**
 * @author Vaidas Gasiunas
 *
 * Server process which creates TopoTree data model and loads it from database
 */
public class CompanyServer {

    public static void main(String[] args) 
    {
        try // fails if registry is already created
        {
            LocateRegistry.createRegistry( Registry.REGISTRY_PORT);
        }
        catch (RemoteException e)
        { }
        
        try
        {
            CaesarHost host = CaesarHost.LOCAL_HOST;
            
            deploy new CompanyRemoting();
            
            /* fill in */
            
            Company company = new Company();
            host.publish("Company", company);
            
            Database.load(company);
    
            System.out.println("Waiting for connections...");
        }
        catch (CaesarRemoteException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
