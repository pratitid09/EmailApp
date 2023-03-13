package emailapp;
import java.io.*;

public class EmailApp {
// Mainly focuses on encapsluation , databinding and data hiding
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Email em1 = new Email("Pratiti", "Das");
		System.out.println("Employee details "); 
		em1.showEmployeeDetails();
		
	}

}
