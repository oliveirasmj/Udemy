package aula240_ProjetoDAO.application;

import java.util.List;

import aula240_ProjetoDAO.model.dao.DaoFactory;
import aula240_ProjetoDAO.model.dao.SellerDao;
import aula240_ProjetoDAO.model.entities.Department;
import aula240_ProjetoDAO.model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
//		Department obj = new Department(1, "Books");
//		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		
		
		//SellerDao sellerDao = new SellerDaoJDBC(DB.getConnection()); // com injecao de dependencia v1 (igual a v2) - sem usar DAOFactory
		SellerDao sellerDao = DaoFactory.createSellerDao(); // com injecao de dependencia v2
		
		
		//EXECUCAO DOS METODOS DE CONSULTAS
		System.out.println("=== Test 1: seller findById ===");
		System.out.println(sellerDao.findById(3));
		
		System.out.println("\n=== Test 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 3: seller findAll ====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
	}

}
