package aula240_ProjetoDAO.application;

import java.util.Date;

import aula240_ProjetoDAO.db.DB;
import aula240_ProjetoDAO.model.dao.DaoFactory;
import aula240_ProjetoDAO.model.dao.SellerDao;
import aula240_ProjetoDAO.model.dao.impl.SellerDaoJDBC;
import aula240_ProjetoDAO.model.entities.Department;
import aula240_ProjetoDAO.model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
//		Department obj = new Department(1, "Books");
//		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		
		
		//SellerDao sellerDao = new SellerDaoJDBC(DB.getConnection()); // com injecao de dependencia v1 (igual a v2)
		SellerDao sellerDao = DaoFactory.createSellerDao(); // com injecao de dependencia v2
		System.out.println(sellerDao.findById(3));
	}

}
