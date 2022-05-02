
import java.sql.*;

public class Person extends Project{
    
    // attributes
    private String architectureName;
    private int architectureID;
    private String architectureEmailAddress;
    private String architecturePhysicalAddress;
    private String contractorName;
    private int contractorID;
    private String contractorEmailAddress;
    private String contractorPhysicalAddress;
    private String customerName;
    private int customerID;
    private String customerEmailAddress;
    private String customerPhysicalAddress;

    // constructor
    public Person(String architectureName, int architectureID, String architectureEmailAddress, String architecturePhysicalAddress, String contructorName, int contructorID, String contructorEmailAddress, String contructorPhysicalAddress, String customerName, int customerID, String customerEmailAddress, String customerPhysicalAddress, String projectName, int projectNumber, String buildingType, String address, int erf, double fee, double total, String deadline) {
        
        super(projectNumber, projectName, buildingType, address, erf, fee, total, deadline);
        this.architectureName = architectureName;
        this.architectureID = architectureID;
        this.architectureEmailAddress = architectureEmailAddress;
        this.architecturePhysicalAddress = architecturePhysicalAddress;
        this.contractorName = contructorName;
        this.contractorID = contructorID;
        this.contractorEmailAddress = contructorEmailAddress;
        this.contractorPhysicalAddress = contructorPhysicalAddress;
        this.customerName = customerName;
        this.customerID = customerID;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPhysicalAddress = customerPhysicalAddress;
    }

    // getter and setter methods
    public String getArchitectureName() {
        return architectureName;
    }

    public void setArchitectureName(String architectureName) {
        this.architectureName = architectureName;
    }

    public int getArchitectureID() {
        return architectureID;
    }

    public void setArchitectureID(int architectureNumber) {
        this.architectureID = architectureNumber;
    }

    public String getArchitectureEmailAddress() {
        return architectureEmailAddress;
    }

    public void setArchitectureEmailAddress(String architectureEmailAddress) {
        this.architectureEmailAddress = architectureEmailAddress;
    }

    public String getArchitecturePhysicalAddress() {
        return architecturePhysicalAddress;
    }

    public void setArchitecturePhysicalAddress(String architecturePhysicalAddress) {
        this.architecturePhysicalAddress = architecturePhysicalAddress;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public int getContractorID() {
        return contractorID;
    }

    public void setContractorID(int contractorNumber) {
        this.contractorID = contractorNumber;
    }

    public String getContractorEmailAddress() {
        return contractorEmailAddress;
    }

    public void setContructorEmailAddress(String contractorEmailAddress) {
        this.contractorEmailAddress = contractorEmailAddress;
    }

    public String getContractorPhysicalAddress() {
        return contractorPhysicalAddress;
    }

    public void setContractorPhysicalAddress(String contractorPhysicalAddress) {
        this.contractorPhysicalAddress = contractorPhysicalAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerNumber) {
        this.customerID = customerNumber;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }

    public String getCustomerPhysicalAddress() {
        return customerPhysicalAddress;
    }

    public void setCustomerPhysicalAddress(String customerPhysicalAddress) {
        this.customerPhysicalAddress = customerPhysicalAddress;
    }
   
    // an overridden method that displays user data
    @Override
    public void projectMethod(){

        super.projectMethod();
        contractorMethod();
        architectureMethod();
        customerMethod();
    }
    public void customerMethod(){
    
    	try{
    		// Connecting to the Project_Management_System database, via the jdbc:mysql:mchannel on localhost (this PC)
    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project_Management_System?useSSL=false","otheruser","swordfish");

    		// Creating a direct line to the database for running our queries
    		Statement statement = connection.createStatement();
    		//ResultSet results;
    		int rowsAffected;
    	
    		rowsAffected = statement.executeUpdate("INSERT INTO Customer_table VALUES ('"+customerID+"','"+customerName+"', '"+customerEmailAddress+"','"+customerPhysicalAddress+"')");
    		System.out.println("\nQuery complete, " + rowsAffected + " rows updated.");
		
    		// Close up our connections
    		statement.close();
    		connection.close();
    
    	}catch(Exception e){
    		System.out.println("\nError occurred. \nError message: " + e);
    	}
        
    }
    public void contractorMethod(){
    
    	try{
    		// Connecting to the Project_Management_System database, via the jdbc:mysql:mchannel on localhost (this PC)
    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project_Management_System?useSSL=false","otheruser","swordfish");

    		// Creating a direct line to the database for running our queries
    		Statement statement = connection.createStatement();
    		//ResultSet results;
    		int rowsAffected;
    	
    		rowsAffected = statement.executeUpdate("INSERT INTO Contractor_table VALUES ('"+contractorID+"','"+contractorName+"', '"+contractorEmailAddress+"','"+contractorPhysicalAddress+"')");
    		System.out.println("\nQuery complete, " + rowsAffected + " rows updated.");
		
    		// Close up our connections
    		statement.close();
    		connection.close();
    
    	}catch(Exception e){
    		System.out.println("\nError occurred. \nError message: " + e);
    	}
        
    }
    public void architectureMethod(){
    
    	try{
        	// Connecting to the Project_Management_System database, via the jdbc:mysql:mchannel on localhost (this PC)
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project_Management_System?useSSL=false","otheruser","swordfish");

        	// Creating a direct line to the database for running our queries
        	Statement statement = connection.createStatement();
        	//ResultSet results;
        	int rowsAffected;
        	
        	rowsAffected = statement.executeUpdate("INSERT INTO Architect_table VALUES ('"+architectureID+"','"+architectureName+"', '"+contractorEmailAddress+"','"+contractorPhysicalAddress+"')");
			System.out.println("\nQuery complete, " + rowsAffected + " rows updated.");
			
			// Close up our connections
			statement.close();
			connection.close();
        
        }catch(Exception e){
        
            System.out.println("\nError occurred. \nError message: " + e);
        }
        
    }
}

