package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class SellerService {
	
	private DepartmentDao dao = DaoFactory.createDepartmentDao();
	
	public List<Department> findAll(){ //Listar todos os departamentos
		return dao.findAll();
		
//		//Com dados fixos para teste
//		List<Department> list = new ArrayList<>();
//		list.add(new Department(1, "Books"));
//		list.add(new Department(2, "Computers"));
//		list.add(new Department(3, "Electronics"));
//		return list;
	}
	
	public void saveOrUpdate(Department obj) { //Guardar novo departamento ou atualizar
		if(obj.getId() == null) { //se for id nulo então é um novo departamento a inserir
			dao.insert(obj);
		}
		else { //se id nao for nulo então id já existe, logo é para atualizar
			dao.update(obj);
		}
	}
	
	public void remove(Department obj) { //Remover departamento
		dao.deleteById(obj.getId());
	}
}
