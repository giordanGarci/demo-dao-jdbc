package view;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;

public class ConsoleView {
		Scanner scan;
		SellerDao sellerDao;
		DepartmentDao departmentDao;
		
		public ConsoleView() {
			scan = new Scanner(System.in);
			sellerDao = DaoFactory.createSellerDao();
			departmentDao = DaoFactory.createDepartmentDao();
		}
		
		public int showMenu() {
			System.out.println("\n=== MENU ===");
			System.out.println("1. Manipulate sellers");
			System.out.println("2. Manipulate departments");
			System.out.println("3. Exit");
			System.out.print("Enter an option: ");
			
			return scan.nextInt();
		}
		
		public int showManipulateSellers() {
			System.out.println("\nManipulating sellers:");
			System.out.println("1 - insert.");
			System.out.println("2 - update.");
			System.out.println("3 - delete.");
			System.out.println("4 - findById");
			System.out.println("5 - findAll.");
			System.out.println("6 - findByDepartment.");
			System.out.print("Enter an option: ");
			
			return scan.nextInt();
		}
		
		public int showManipulateDeparment() {
			System.out.println("\nManipulating departments:");
			System.out.println("1 - insert.");
			System.out.println("2 - update.");
			System.out.println("3 - delete.");
			System.out.println("4 - findAll.");
			System.out.println("5 - findById.");
			System.out.print("Enter an option: ");
			
			return scan.nextInt();
		}
		
		public void closeScanner() {
			scan.close();
		}

		public SellerDao getSellerDao() {
			return sellerDao;
		}

		public void setSellerDao(SellerDao sellerDao) {
			this.sellerDao = sellerDao;
		}

		public DepartmentDao getDepartmentDao() {
			return departmentDao;
		}

		public void setDepartmentDao(DepartmentDao departmentDao) {
			this.departmentDao = departmentDao;
		}
}
