
import java.sql.*;

public class Project {
    
    // attributes
    private int projectNumber;
    private String projectName;
    private String buildingType;
    private String address;
    private int erfNumber;
    private double projectFee;
    private double total;
    private String deadline;
    
    // constructor
    public Project(int projectNumber, String projectName, String buildingType, String address, int erf, double fee, double total, String deadline){
    
        this.projectNumber = projectNumber;
        this.projectName = projectName;
        this.buildingType = buildingType;
        this.address = address;
        this.erfNumber = erf;
        this.projectFee = fee;
        this.total = total;
        this.deadline = deadline;
        
    }

    // getter and setter methods
    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getErfNumber() {
        return erfNumber;
    }

    public void setErfNumber(int erfNumber) {
        this.erfNumber = erfNumber;
    }

    public double getProjectFee() {
        return projectFee;
    }

    public void setProjectFee(double projectFee) {
        this.projectFee = projectFee;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    
    // a method that displays user data
public void projectMethod(){
        
        try{
        	// Connecting to the Project_Management_System database, via the jdbc:mysql:mchannel on localhost (this PC)
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project_Management_System?useSSL=false","otheruser","swordfish");

        	// Creating a direct line to the database for running our queries
        	Statement statement = connection.createStatement();
        	//ResultSet results;
        	int rowsAffected;
        	
        	rowsAffected = statement.executeUpdate("INSERT INTO Project_table VALUES ('"+projectNumber+"','"+projectName+"', '"+buildingType+"','"+address+"', '"+erfNumber+"', '"+projectFee+"', '"+total+"', '"+deadline+"')");
			System.out.println("\nQuery complete, " + rowsAffected + " rows updated.");
			
			// Close up our connections
			statement.close();
			connection.close();
        
        }catch(Exception e){
        
            System.out.println("Error: " + e);
        }
        
    }
    
}

