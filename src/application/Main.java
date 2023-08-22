package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
import users.CreateSeller;
import view.ConsoleView;

public class Main {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static Scanner scan = new Scanner(System.in);
	private static DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	private static SellerDao sellerDao = DaoFactory.createSellerDao();

	public static void main(String[] args) throws ParseException {

		ConsoleView consoleView = new ConsoleView();
		boolean exit = false;

		do {
			int choice = consoleView.showMenu();
			switch (choice) {
				case 1:
					int manipulateChoiceSeller = consoleView.showManipulateSellers();
					Main.performSellerCRUD(manipulateChoiceSeller);
					break;
				case 2:
					int manipulateChoiceDepartment = consoleView.showManipulateDeparment();
					Main.performDepartmentCRUD(manipulateChoiceDepartment);
					break;
				case 3:
					exit = true;
					break;
				default:
					System.out.println("Error! Try again. ");
				}

			} while (!exit);

	}

	private static void performSellerCRUD(int selection) throws ParseException {

		switch (selection) {
		
		case 1:
			Seller seller = CreateSeller.instantiateSeller(scan);
			sellerDao.insert(seller);
			System.out.println("Successfully inserted seller! new Id: " + seller.getId());
			break;
			
		case 2:
			System.out.print("\nEnter seller id: \n");
			int id = scan.nextInt();
			seller = sellerDao.findById(id);
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
			
			sellerDao.update(seller);
			break;
			
		case 3:
			System.out.print("Enter seller id: ");
			id = scan.nextInt();
			sellerDao.deleteById(id);
			System.out.println("Successfully deleted seller!");
			break;
			
		case 4:
			System.out.print("Enter seller id: ");
			id = scan.nextInt();
			Seller sellerFound = sellerDao.findById(id);
			System.out.println(sellerFound);
			break;
			
		case 5:
			List<Seller> list = sellerDao.findAll();
			list.stream().forEach(e -> System.out.println(e));
			System.out.println();
			break;
			
		case 6:
			System.out.println("\nEnter department id: ");
			Department dep = new Department(null, scan.nextInt());
			List<Seller> list2 = sellerDao.findByDepartment(dep);
			list2.stream().forEach(e -> System.out.println(e));
			break;
			
		}
	}
	
	private static void performDepartmentCRUD(int selection) {
		switch (selection) {
			case 1:
				scan.nextLine();
				System.out.print("\nDepartment name: ");
				Department dep = new Department(scan.nextLine(), null);
				departmentDao.insert(dep);
				System.out.println("Successfully inserted department! Id: " + dep.getId());
				break;
			case 2:
				System.out.print("Enter department id: ");
				dep = departmentDao.findById(scan.nextInt());
				scan.nextLine();
				System.out.print("Enter the new department name: ");
				dep.setName(scan.nextLine());
				departmentDao.update(dep);
				System.out.println("Successfully updated department");
				break;
			case 3:
				System.out.print("Enter department id: ");
				int id = scan.nextInt();
				departmentDao.deleteById(id);
				System.out.println("Successfully deleted department");
				break;
			case 4:
				List<Department> list = departmentDao.findAll();
				list.stream().forEach(e -> System.out.println(e));
				break;
			case 5:
				System.out.print("Enter department id: ");
				dep = departmentDao.findById(scan.nextInt());
				System.out.println(dep);
				break;
		}
	}

}
