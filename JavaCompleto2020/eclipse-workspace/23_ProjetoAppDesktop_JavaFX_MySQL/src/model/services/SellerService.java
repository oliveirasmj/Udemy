package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class SellerService {
	
	private SellerDao dao = DaoFactory.createSellerDao();
	
	public List<Seller> findAll(){ //Listar todos os departamentos
		return dao.findAll();
		
//		//Com dados fixos para teste
//		List<Seller> list = new ArrayList<>();
//		list.add(new Seller(1, "Books"));
//		list.add(new Seller(2, "Computers"));
//		list.add(new Seller(3, "Electronics"));
//		return list;
	}
	
	public void saveOrUpdate(Seller obj) { //Guardar novo departamento ou atualizar
		if(obj.getId() == null) { //se for id nulo então é um novo departamento a inserir
			dao.insert(obj);
		}
		else { //se id nao for nulo então id já existe, logo é para atualizar
			dao.update(obj);
		}
	}
	
	public void remove(Seller obj) { //Remover departamento
		dao.deleteById(obj.getId());
	}
}
