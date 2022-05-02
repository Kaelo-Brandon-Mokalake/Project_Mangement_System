
 /*
    A Project management program
 */

import java.sql.*;
import java.util.*;

public class ProjectManagementSystem {

	static Scanner input = new Scanner(System.in);
	
    public static void main(String[] args) {
        // calling a method
        start();
        
    }
    public static void start(){
    
        // project variables
        String projectName;
        int projectNumber;
        String buildingType;
        String address;
        int erfNumber;
        double projectFee;
        double total;
        String deadline;
        String choice;
        
        // Architecture variables
        String achitectureName;
        int architectureID;
        String achitectureEmailAddress;
        String achitecturePhysicalAddress;
        
        // contractor variables
        String contractorName;
        int contractorID;
        String contractorEmailAddress;
        String contractorPhysicalAddress;
        
        // customer variables
        String customerName;
        int customerID;
        String customerEmailAddress;
        String customerPhysicalAddress;
                
        // getting user input
        System.out.print("\nWelcome to our Project Management System. \nWhat would you like to do\n\tc - create a new project\n\tr - read existing projects\n\tu - update project details\n\ts - search for a specific project\n\t: ");
        choice = input.nextLine();
        
        if (choice.equalsIgnoreCase("c")){
            
            try{
                // getting user input
                System.out.print("Enter project name: ");
                projectName = input.nextLine();
        
                System.out.print("Enter project number: ");
                projectNumber = input.nextInt();
                input.nextLine();
        
                System.out.print("Enter building type: ");
                buildingType = input.nextLine();
          
                System.out.print("Enter project address: ");
                address = input.nextLine();
        
                System.out.print("Enter ERF number: ");
                erfNumber = input.nextInt();
                input.nextLine();
        
                System.out.print("Enter project fee: ");
                projectFee = input.nextDouble();
        
                System.out.print("Enter total amount paid to date: ");
                total = input.nextDouble();
                input.nextLine();
        
                System.out.print("Enter deadline for the project: ");
                deadline = input.nextLine();
        
                // architecture user input
                System.out.println("\nDetails of an Achitecture");
                System.out.print("Enter name of the achitecture: ");
                achitectureName = input.nextLine();
        
                System.out.print("Enter number of the achitecture: ");
                architectureID = input.nextInt();
                input.nextLine();
        
                System.out.print("Enter email address of the achitecture: ");
                achitectureEmailAddress = input.nextLine();
        
                System.out.print("Enter physical address of the achitecture: ");
                achitecturePhysicalAddress = input.nextLine();
            
                // contractor user input
                System.out.println("\ndetails of a Contractor");
                System.out.print("Enter name of the contractor: ");
                contractorName = input.nextLine();
        
                System.out.print("Enter number of the contractor: ");
                contractorID = input.nextInt();
                input.nextLine();
        
                System.out.print("Enter email address of the contractor: ");
                contractorEmailAddress = input.nextLine();
        
                System.out.print("Enter physical address of the contractor: ");
                contractorPhysicalAddress = input.nextLine();
            
                // customer user input
                System.out.println("\nDetails of a Customer");
                System.out.print("Enter name of the customer: ");
                customerName = input.nextLine();
        
                System.out.print("Enter number of the customer: ");
                customerID = input.nextInt();
                input.nextLine();
        
                System.out.print("Enter email address of the customer: ");
                customerEmailAddress = input.nextLine();
        
                System.out.print("Enter physical address of the customer: ");
                customerPhysicalAddress = input.nextLine();
        
                if (projectName == null) {
                    String temp = buildingType + " " + customerName;
                    
                    // calling the 'Person' constructor
                    Person user = new Person(achitectureName, architectureID, achitectureEmailAddress, achitecturePhysicalAddress, contractorName, contractorID, contractorEmailAddress, contractorPhysicalAddress, customerName, customerID, customerEmailAddress, customerPhysicalAddress, temp, projectNumber, buildingType, address, erfNumber, projectFee, total, deadline);
            
                    // writing details to a database table
                    user.projectMethod();
                }else{
                    // calling the 'Person' constructor
                    Person user = new Person(achitectureName, architectureID, achitectureEmailAddress, achitecturePhysicalAddress, contractorName, contractorID, contractorEmailAddress, contractorPhysicalAddress, customerName, customerID, customerEmailAddress, customerPhysicalAddress, projectName, projectNumber, buildingType, address, erfNumber, projectFee, total, deadline);
            
                    // writing details to a database table
                    user.projectMethod();
                }
                System.out.print("\nInformation updated successfully.");
            
            }catch(Exception e){
            	System.out.println("\nError has occurred. \nError message: " + e);
            }
            
        }else if (choice.equalsIgnoreCase("r")){
            // calling a method
            read();
                
        }else if (choice.equalsIgnoreCase("u")){
            // calling a method
            update();
            
        }else if (choice.equalsIgnoreCase("s")){
            // calling a method
            search();
            
        }else{
            System.out.println("Incorrect input. Please try again.");
        }
    }
    
    // a method that searches for specific data from a database and displays it on the screen
    public static void search() {
    	
		try {
			// Connecting to the Project_Management_System database, via the jdbc:mysql:mchannel on localhost (this PC)
    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project_Management_System?useSSL=false","otheruser","swordfish");

    		// Creating a direct line to the database for running our queries
    		Statement statement = connection.createStatement();
    		ResultSet results;
    		
    		// getting user input
            System.out.print("\nEnter unique number associated with the record you wish to view: ");
            int number = input.nextInt();
            input.nextLine();
            
            // executeQuery: runs a SELECT statement and returns the results.
    		results = statement.executeQuery("SELECT * FROM Project_table WHERE projectNumber = '"+number+"'");
		
    		// displaying the results to the output device
    		while (results.next()) {
    			System.out.println("\nRecord(s) found:\n " + results.getInt("projectNumber") + ", " + results.getString("projectName") + ", " + results.getString("buildingType") + ", " + results.getString("address") + ", " + results.getInt("erfNumber") + ", " + results.getDouble("projectFee") + ", " + results.getDouble("total") + ", " + results.getString("deadline"));
    		}
    		// closing the connections
    		results.close();
    		
		} catch (Exception e) {
			System.out.println("\nError occurred. \nError message: " + e);
		}
	}
	// a method that reads data from a database and displays it on the screen
    public static void read(){        
        
        try{
        	// Connecting to the Project_Management_System database, via the jdbc:mysql:mchannel on localhost (this PC)
    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project_Management_System?useSSL=false","otheruser","swordfish");

    		// Creating a direct line to the database for running our queries
    		Statement statement = connection.createStatement();
    		ResultSet results;
    		
        	System.out.print("What would you like to view \n\tp - projects \n\ta - architect(s) data \n\tt - contractor(s) data \n\tc - customer(s) data \n\t\t: ");
        	char choice = input.next().charAt(0);
        	
        	if (choice == 'p') {
        		// executeQuery: runs a SELECT statement and returns the results.
        		results = statement.executeQuery("SELECT * FROM Project_table");
			
        		// displaying the results to the output device
        		while (results.next()) {
        			System.out.println("\nRecord(s) found:\n " + results.getInt("projectNumber") + ", " + results.getString("projectName") + ", " + results.getString("buildingType") + ", " + results.getString("address") + ", " + results.getInt("erfNumber") + ", " + results.getDouble("projectFee") + ", " + results.getDouble("total") + ", " + results.getString("deadline"));
        		}
        		results.close();
        		
        	}else if(choice == 'a') {
        	
        		// executeQuery: runs a SELECT statement and returns the results.
        		results = statement.executeQuery("SELECT * FROM Architect_table");
			
        		// displaying the results to the output device
        		while (results.next()) {
        			System.out.println("\nRecord(s) found:\n " + results.getInt("architectureNumber") + ", " + results.getString("architectureName") + ", " + results.getString("architectureEmailAddress") + ", " + results.getString("architecturePhysicalAddress"));
        		}
        		results.close();
        		
        	}else if(choice == 't') {
        	
        		// executeQuery: runs a SELECT statement and returns the results.
        		results = statement.executeQuery("SELECT * FROM Contractor_table");
			
        		// displaying the results to the output device
        		while (results.next()) {
        			System.out.println("\nRecord(s) found:\n " + results.getInt("contractorNumber") + ", " + results.getString("contractorName") + ", " + results.getString("contractorEmailAddress") + ", " + results.getString("contractorPhysicalAddress"));
        		}
        		results.close();
        		
        	}else if(choice == 'c') {
        	
        		// executeQuery: runs a SELECT statement and returns the results.
        		results = statement.executeQuery("SELECT * FROM Customer_table");
			
        		// displaying the results to the output device
        		while (results.next()) {
        			System.out.println("\nRecord(s) found:\n " + results.getInt("customerNumber") + ", " + results.getString("customerName") + ", " + results.getString("customerEmailAddress") + ", " + results.getString("customerPhysicalAddress"));
        		}
        		results.close();
        	}	
            
        }catch(Exception e){
        	System.out.println("\nError has occurred. \nError message: " + e);
        }
    }
    
    // a method that update data to a file
    public static void update() {
        
        try{
        	// Connecting to the Project_Management_System database, via the jdbc:mysql:mchannel on localhost (this PC)
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project_Management_System?useSSL=false","otheruser","swordfish");

			// Creating a direct line to the database for running our queries
			Statement statement = connection.createStatement();
			int rowsAffected;
			
            // getting user input
        	System.out.print("What would you like to view \n\tp - projects \n\ta - architect(s) data \n\tt - contractor(s) data \n\tc - customer(s) data \n\t\t: ");
        	char choice = input.next().charAt(0);
        
            // evaluating the option based on user input
            if (choice == ('a')) {
                // variables declaration
                String architectureName;
                String architectureEmailAddress;
                String architecturePhysicalAddress;
            
                // getting user input
                System.out.print("\nEnter unique number associated with the record you wish to update: ");
                int number = input.nextInt();
                input.nextLine();
                                
                // getting user input
                System.out.print("\nEnter new name of the architecture: ");
                architectureName = input.nextLine();
        
                System.out.print("Enter new email address of the architecture: ");
                architectureEmailAddress = input.nextLine();
        
                System.out.print("Enter new physical address of the architecture: ");
                architecturePhysicalAddress = input.nextLine();
                
                // adding data to a database table
    			rowsAffected = statement.executeUpdate("UPDATE Architect_table SET architectureName = '"+architectureName+"', architectureEmailAddress = '"+architectureEmailAddress+"', architecturePhysicalAddress = '"+architecturePhysicalAddress+"' WHERE architectureNumber = '"+number+"'");
    			System.out.println("\nQuery complete, " + rowsAffected + " rows updated.");
                    
                System.out.print("\nInformation updated successfully.");
             
            }else if(choice == ('c')){
                // variables declaration
                String customerName;
                String customerEmailAddress;
                String customerPhysicalAddress;                
               
                // getting user input
                System.out.print("\nEnter unique number associated with the record you wish to update: ");
                int number = input.nextInt();
                input.nextLine();
                
                // getting user input
                System.out.print("\nEnter new name of the customer: ");
                customerName = input.nextLine();
        
                System.out.print("Enter new email address of the customer: ");
                customerEmailAddress = input.nextLine();
        
                System.out.print("Enter new physical address of the customer: ");
                customerPhysicalAddress = input.nextLine();
                
                // adding data to a database table
    			rowsAffected = statement.executeUpdate("UPDATE Customer_table SET customerName = '"+customerName+"', customerEmailAddress = '"+customerEmailAddress+"', customerPhysicalAddress = '"+customerPhysicalAddress+"' WHERE customerNumber = '"+number+"'");
    			System.out.println("\nQuery complete, " + rowsAffected + " rows updated.");
                    
                System.out.print("\nInformation updated successfully.");
                 
            }else if(choice == 't'){
                // variables declaration
                String contractorName;
                String contractorEmailAddress;
                String contractorPhysicalAddress;     
            
                // getting user input
                System.out.print("\nEnter unique number associated with the record you wish to update: ");
                int number = input.nextInt();
                input.nextLine();
                
                // getting user input
                System.out.print("\nEnter new name of the contractor: ");
                contractorName = input.nextLine();
                
                System.out.print("Enter new email address of the contractor: ");
                contractorEmailAddress = input.nextLine();
        
                System.out.print("Enter new physical address of the contractor: ");
                contractorPhysicalAddress = input.nextLine();
                
                // adding data to a database table
    			rowsAffected = statement.executeUpdate("UPDATE Contractor_table SET contractorName = '"+contractorName+"', contractorEmailAddress = '"+contractorEmailAddress+"', contractorPhysicalAddress = '"+contractorPhysicalAddress+"' WHERE contractorNumber = '"+number+"'");
    			System.out.println("\nQuery complete, " + rowsAffected + " rows updated.");
                    
                System.out.print("\nInformation updated successfully.");
                
            }else if(choice == 'p'){
                // variables declaration
                String projectName;
                String buildingType;
                String address;
                int erfNumber;
                double projectFee;
                double total;
                String deadline;
                            
                // getting user input
                System.out.print("\nEnter unique number associated with the record you wish to update: ");
                int number = input.nextInt();
                input.nextLine();
                                
                // getting user input
                System.out.print("Enter project name: ");
                projectName = input.nextLine();
        
                System.out.print("Enter building type: ");
                buildingType = input.nextLine();
          
                System.out.print("Enter project address: ");
                address = input.nextLine();
        
                System.out.print("Enter ERF number: ");
                erfNumber = input.nextInt();
                input.nextLine();
        
                System.out.print("Enter project fee: ");
                projectFee = input.nextDouble();
        
                System.out.print("Enter total amount paid to date: ");
                total = input.nextDouble();
                input.nextLine();
        
                System.out.print("Enter deadline for the project: ");
                deadline = input.nextLine();
                
                // adding data to a database table
    			rowsAffected = statement.executeUpdate("UPDATE Project_table SET projectName = '"+projectName+"', buildingType = '"+buildingType+"', address = '"+address+"', erfNumber = '"+erfNumber+"', projectFee = '"+projectFee+"', total = '"+total+"', deadline = '"+deadline+"' WHERE projectNumber = '"+number+"'");
    			System.out.println("\nQuery complete, " + rowsAffected + " rows updated.");
                    
                System.out.print("\nInformation updated successfully.");
     
            }else{
                System.out.print("Incorrect entry. Please try again.");
            }
         // Close up our connections
         statement.close();
         connection.close();

        }catch(Exception e){
            System.out.println("\nError has occurred. \nError message: " + e);
        }
    }
}
