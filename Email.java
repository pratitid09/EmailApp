package emailapp;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Email {
	private String firstName; // enforcing encapsulation , as we dont want data members of a class to directly available to access outside the class
	private String lastName;
	private String password;
	private String department;
	private String alternateEmailAddress;
	private int mailboxCapacity = 500; // default mail capacity
	private String employeeEmailAddress;
	private String compnaySuffix = "ItAdminCo.com";
	private final Scanner sc = new Scanner(System.in); 
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$", Pattern.CASE_INSENSITIVE);

	// constructor to receive the firstName and lastName
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		String empDepartment = this.setDepartment();
		if(!empDepartment.isEmpty()) {
			this.employeeEmailAddress = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + empDepartment + "."+compnaySuffix; 
		} else {
			this.employeeEmailAddress = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@"  + compnaySuffix; 
		}
		System.out.println("Employee email address: " + this.employeeEmailAddress);
		this.setPassword();
		this.setMailboxCapacity();
		this.setAlternateEmailAddress();
		
	}
	
	private String setDepartment() {
		System.out.print("Enter the department of the employee: ");
		System.out.println("Enter \n1 for Sale \n2 for Development \n3 for Admin \n4 for none");
		int input = sc.nextInt();
		switch(input) {
		case 1:
			this.department = "Sales";
			break;
		case 2:
			this.department = "Development";
			break;
		case 3: 
			this.department = "Admin";
			break;
		case 4:
			this.department ="";
			break;
		}
		return this.department;
		
	}
	// ask for the department of the individual
	public String getDepartment() {
		return department;
	}
	
	//Generate a random string as password
	private void setPassword() {
		 String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	        StringBuilder salt = new StringBuilder();
	        Random rnd = new Random();
	        while (salt.length() < 8) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr = salt.toString();
	       this.password = saltStr;
	       System.out.println("Your password is:" + saltStr);
	}
	
	// Set the mailboxCapacity
	private void setMailboxCapacity() {
		System.out.println("Enter the mail box capacity for the employee: ");
		int mailCapacity = sc.nextInt();
		if(mailCapacity > 0) { // keeping the mail capacity to default when no value given from input
			this.mailboxCapacity = mailCapacity;
		}
		System.out.println("The mailbox capacity is set to: " + this.mailboxCapacity);
	}
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	// Set alternateEmailAddress
	private void setAlternateEmailAddress() {
		System.out.print("Enter the alternative email address of the employee: ");
		String altEmailAddr = sc.next();
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(altEmailAddr);
        if( matcher.matches())
        	this.alternateEmailAddress = altEmailAddr;
        else 
        	System.out.println("Entered email address is not in correct format");
	}
	public String getAlternateEmailAddress() {
		return alternateEmailAddress;
	}
	// Change the password
	public void changePassword(String newPassword) {
		this.password = (!newPassword.isEmpty()) ? newPassword : this.password;
	}
	// show employee email
	public String getEmployeeEmail() {
		return this.employeeEmailAddress;
	}
	// show employee details
	public void showEmployeeDetails() {
		System.out.println("Employee name : " +  this.firstName + " " + this.lastName);
		System.out.println("Employee email address : " + this.getEmployeeEmail());
		System.out.println("Employee mailbox capacity: " + this.mailboxCapacity);
		System.out.println("Employee alternate email address capacity: " + this.alternateEmailAddress);
	}
	
}
