package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.entities.Department;
import model.entities.Seller;
import view.ConsoleView;

public class Main {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {

		ConsoleView consoleView = new ConsoleView();

		boolean exit = false;

		do {
			int choice = consoleView.showMenu();
			switch (choice) {
				case 1:
					int manipulateChoiceSeller = consoleView.showManipulateSellers();
					Main.performSellerCRUD(manipulateChoiceSeller, consoleView);
					break;
				case 2:
					int manipulateChoiceDepartment = consoleView.showManipulateDeparment();
					Main.performDepartmentCRUD(manipulateChoiceDepartment, consoleView);
					break;
				case 3:
					exit = true;
					break;
				default:
					System.out.println("Error! Try again. ");
				}

			} while (!exit);

	}

	private static void performSellerCRUD(int selection, ConsoleView consoleView) throws ParseException {

		switch (selection) {
		
		case 1:
			Seller seller = Main.instantiateSeller();
			consoleView.getSellerDao().insert(seller);
			System.out.println("Successfully inserted seller! new Id: " + seller.getId());
			break;
			
		case 2:
			System.out.print("\nEnter seller id: \n");
			int id = scan.nextInt();
			seller = consoleView.getSellerDao().findById(id);
			System.out.println("1 - Name.");
			System.out.println("2 - Email.");
			System.out.println("3 - Base salary.");
			System.out.println("4 - Birth date.");
			System.out.println("5 - Department id.");
			System.out.print("Enter the option to update: \n");
			int option = scan.nextInt();
			scan.nextLine();
			
			switch (option) {
			
				case 1:
					System.out.print("\nEnter the new name: \n");
					seller.setName(scan.nextLine());
					System.out.println("Successfully changed name!");
					break;
					
				case 2:
					System.out.print("\nEnter the new email: \n");
					seller.setEmail(scan.nextLine());
					System.out.println("Successfully changed email!");
					break;
					
				case 3:
					System.out.print("\nEnter the new base salary: \n");
					seller.setBaseSalary(scan.nextDouble());
					scan.nextLine();
					System.out.println("Successfully changed base salary!");
					break;
					
				case 4:
					System.out.print("\nEnter the new birth date (dd/MM/yyyy): \n");
					seller.setBirthDate(sdf.parse(scan.nextLine()));
					System.out.println("Successfully changed birth date!");
					break;
				
				case 5:
					System.out.print("\nEnter the new department id: \n");
					seller.getDepartment().setId(scan.nextInt());
					System.out.println("Successfully changed department id!");
					break;
			}
			
			consoleView.getSellerDao().update(seller);
			break;
			
		case 3:
			System.out.print("Enter seller id: ");
			id = scan.nextInt();
			consoleView.getSellerDao().deleteById(id);
			System.out.println("Successfully deleted seller!");
			break;
			
		case 4:
			System.out.print("Enter seller id: ");
			id = scan.nextInt();
			Seller sellerFound = consoleView.getSellerDao().findById(id);
			System.out.println(sellerFound);
			break;
			
		case 5:
			List<Seller> list = consoleView.getSellerDao().findAll();
			list.stream().forEach(e -> System.out.println(e));
			System.out.println();
			break;
			
		case 6:
			System.out.println("\nEnter department id: ");
			Department dep = new Department(null, scan.nextInt());
			List<Seller> list2 = consoleView.getSellerDao().findByDepartment(dep);
			list2.stream().forEach(e -> System.out.println(e));
			break;
			
		}
	}
	
	private static void performDepartmentCRUD(int selection, ConsoleView consoleView) {
		switch (selection) {
			case 1:
				System.out.print("Department name: ");
				Department dep = new Department(scan.nextLine(), null);
				consoleView.getDepartmentDao().insert(dep);
				System.out.println("Successfully inserted department!");
				break;
			case 2:
				System.out.print("Enter department id: ");
				dep = consoleView.getDepartmentDao().findById(scan.nextInt());
				scan.nextLine();
				System.out.print("Enter the new department name: ");
				dep.setName(scan.nextLine());
				consoleView.getDepartmentDao().update(dep);
				System.out.println("Successfully updated department");
				break;
			case 3:
				System.out.print("Enter department id: ");
				consoleView.getDepartmentDao().deleteById(scan.nextInt());
				scan.nextLine();
				System.out.println("Successfully deleted department");
				break;
			case 4:
				List<Department> list = consoleView.getDepartmentDao().findAll();
				list.stream().forEach(e -> System.out.println(e));
				break;
			case 5:
				System.out.print("Enter department id: ");
				dep = consoleView.getDepartmentDao().findById(scan.nextInt());
				System.out.println(dep);
				break;
		}
	}

	private static Seller instantiateSeller() throws ParseException {
		scan.nextLine();
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
