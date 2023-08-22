package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
//		System.out.println("\n=== TEST 7: department findById ===");
//		Department dep = departmentDao.findById(1);
//		System.out.println(dep);
//		
//		System.out.println("\n=== TEST 8: department findAll ===");
//		List<Department> list = departmentDao.findAll();
//		list.stream().forEach(e -> System.out.println(e));
//		
//		System.out.println("\n=== TEST 9: department insert ===");
//		Department dep1 = new Department("RH", null);
//		departmentDao.insert(dep1);
//		System.out.println("Inserted! new Id: " + dep.getId()); 
//		
//		System.out.println("\n=== TEST 10: department update ===");
//		dep = departmentDao.findById(5);
//		dep.setName("Games");
//		departmentDao.update(dep);
//		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 11: department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = scan.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
	}
}
