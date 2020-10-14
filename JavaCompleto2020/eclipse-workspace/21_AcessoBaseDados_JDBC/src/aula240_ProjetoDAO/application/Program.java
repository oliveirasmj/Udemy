package aula240_ProjetoDAO.application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import aula240_ProjetoDAO.model.dao.DaoFactory;
import aula240_ProjetoDAO.model.dao.SellerDao;
import aula240_ProjetoDAO.model.entities.Department;
import aula240_ProjetoDAO.model.entities.Seller;

public class Program {

	public static void main(String[] args) { //Este Program é responsavel por consultas reclacionadas com a tabela de Vendedores
		
		Scanner sc = new Scanner(System.in);
		
//		Department obj = new Department(1, "Books");
//		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		
		
		//SellerDao sellerDao = new SellerDaoJDBC(DB.getConnection()); // com injecao de dependencia v1 (igual a v2) - sem usar DAOFactory
		SellerDao sellerDao = DaoFactory.createSellerDao(); // com injecao de dependencia v2
		
		
		//EXECUCAO DOS METODOS DE CONSULTAS
		
		System.out.println("=== Test 1: seller findById ===");
		Seller seller = sellerDao.findById(3); //seller = vendedor com Id 3
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: seller findByDepartment ===");
		Department department = new Department(2, null); //criar um departamento com id 2
		List<Seller> list = sellerDao.findByDepartment(department); //colocar numa lista todos os vendedores com o id do department criado (id = 2)
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 3: seller findAll ====");
		list = sellerDao.findAll(); //colocar numa lista todos os vendedores
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
//		System.out.println("\n=== TEST 4: seller insert ====");
//		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department); //criar um vendedor
//		sellerDao.insert(newSeller); //inserir o vendedor
//		System.out.println("Inserted! New id: " + newSeller.getId()); //retornar o seu id
		
		System.out.println("\n=== TEST 5: seller update ====");
		seller = sellerDao.findById(1); //procurar o vendedor com o id = 1
		seller.setName("Martha Waine"); //atualizar o nome do campo do objeto
		sellerDao.update(seller); //fazer update para a base de dados desse objeto
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: seller delete ====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
