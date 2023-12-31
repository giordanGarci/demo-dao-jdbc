package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department dep = new Department(null, 2);
		List<Seller> list = sellerDao.findByDepartment(dep);
		list.stream().forEach(e -> System.out.println(e));

		System.out.println("\n=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		list.stream().forEach(e -> System.out.println(e));

		System.out.println("\n=== TEST 4: seller insert ===");
		Seller obj = new Seller(null, "carlos", "carlos@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(obj);
		System.out.println("Inserted! new Id: " + obj.getId());

		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Marta Waine");
		sellerDao.update(seller);
		System.out.println("Update complete!");

		System.out.println("\n=== TEST 6: seller delete ===");
		System.out.println("Enter id for delete test: ");
		int id = scan.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		scan.close();
	}
}
