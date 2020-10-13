package aula240_ProjetoDAO.model.dao;

import aula240_ProjetoDAO.db.DB;
import aula240_ProjetoDAO.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
}
