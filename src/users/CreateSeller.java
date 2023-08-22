package users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Department;
import model.entities.Seller;

public class CreateSeller {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static Seller instantiateSeller(Scanner scan) throws ParseException {
		System.out.println("\nEnter seller data: ");
		System.out.print("Name: ");
		String name = scan.nextLine();
		System.out.print("Email: ");
		String email = scan.nextLine();
		System.out.print("Birth Date (dd/MM/yyyy): ");
		Date date = sdf.parse(scan.nextLine());
		System.out.print("Base Salary: ");
		double baseSalary = scan.nextDouble();
		System.out.println("Enter department id: ");
		Department dep = new Department(null, scan.nextInt());
		Seller seller = new Seller(null, name, email, date, baseSalary, dep);
		
		return seller;
	}
}
