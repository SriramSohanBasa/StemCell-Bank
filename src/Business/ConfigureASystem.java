/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 * This class is used to configure the entire system upon startup.
 * It sets up the initial state of the system with necessary data.
 */
public class ConfigureASystem {
     /**
      * This method sets up the system with initial data.
      * 
      * @return EcoSystem The fully configured ecosystem.
      */
     public static EcoSystem configure() {
        
        // Get the System's EcoSystem instance
        EcoSystem system = EcoSystem.getInstance();
        
        //TODO: Create a network
        //TODO: Create an enterprise
        //TODO: Initialize some organizations

        // Have some employees - in this case, we're creating a system administrator
        Employee employee = system.getEmployeeDirectory().createEmployee("sysadmin");
        
        // Create user account for the system admin with username and password as 'sysadmin'
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        // Return the configured system
        return system;
    }
}
