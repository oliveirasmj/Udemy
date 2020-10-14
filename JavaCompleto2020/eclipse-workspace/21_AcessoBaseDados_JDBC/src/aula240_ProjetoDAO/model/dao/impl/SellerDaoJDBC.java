package aula240_ProjetoDAO.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aula239_Transacoes.db.DbException;
import aula240_ProjetoDAO.db.DB;
import aula240_ProjetoDAO.model.dao.SellerDao;
import aula240_ProjetoDAO.model.entities.Department;
import aula240_ProjetoDAO.model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn; // tem uma conexao com o banco

	public SellerDaoJDBC(Connection conn) { // recebe a conexao no construtor
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null; // começa na posicao 0
		try {
			st = conn.prepareStatement(
							"SELECT seller.*,department.Name as DepName " + 
							"FROM seller INNER JOIN department " + 
							"ON seller.DepartmentId = department.Id " + 
							"WHERE seller.Id = ?");
			st.setInt(1, id); // dizer que o primeiro ponto de interrogação é o valor id
			rs = st.executeQuery(); // executar query e resultado vem em forma de tabela

			if (rs.next()) { // SE consulta tiver registos - vai linha a linha
				
				//Opcao 1 - indicar as colunas
				Department dep = new Department(); // criar um Departamento para o retornar em forma de objeto
				dep.setId(rs.getInt("DepartmentId")); // o id do dep = coluna DepartmentId
				dep.setName(rs.getString("DepName")); // o Name do dep = coluna DepName
				Seller obj = new Seller(); // criar um Seller para o retornar em forma de objeto
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setDepartment(dep); //adicionar o departamento criado
				
//				//Opcao 2 - metodos ficam responsaveis por indicar as colunas
//				Department dep = instantiateDepartment(rs);
//				Seller obj = instantiateSeller(rs, dep);

				return obj;
			}
			return null; // se consulta não tiver registos: retorna nulo
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

//	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
//		Seller obj = new Seller();
//		obj.setId(rs.getInt("Id"));
//		obj.setName(rs.getString("Name"));
//		obj.setEmail(rs.getString("Email"));
//		obj.setBaseSalary(rs.getDouble("BaseSalary"));
//		obj.setBirthDate(rs.getDate("BirthDate"));
//		obj.setDepartment(dep);
//		return obj;
//	}
//	
//	private Department instantiateDepartment(ResultSet rs) throws SQLException {
//		Department dep = new Department();
//		dep.setId(rs.getInt("DepartmentId"));
//		dep.setName(rs.getString("DepName"));
//		return dep;
//	}
	
	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null; // começa na posicao 0
		try {
			st = conn.prepareStatement(
							"select seller.*, department.Name as DepName " + 
							"from seller INNER JOIN department " + 
							"ON seller.DepartmentId = department.id " + 
							"WHERE seller.DepartmentId = ? " + 
							"ORDER BY seller.Name");
			st.setInt(1, department.getId()); // dizer que o primeiro ponto de interrogação é o valor department.id
			rs = st.executeQuery(); // executar query e resultado vem em forma de tabela

			List<Seller> list = new ArrayList<>(); //criar a lista de retorno de dados
			Map<Integer, Department> map = new HashMap<>(); //criar um mapa para que não seja instanciado um departamento novo para cada vendedor
			
			while (rs.next()) { // ENQUANTO consulta tiver registos - vai linha a linha
				
				Department dep = map.get(rs.getInt("DepartmentId")); //ver se id já existe no mapa - se não existir retorna nulo - nao se vai criar mais que um departamento igual
				
				if(dep == null) { //se não existir no map
					//Opcao 1 - indicar as colunas
					dep = new Department(); //criar um novo departamento
					dep.setId(rs.getInt("DepartmentId"));
					dep.setName(rs.getString("DepName"));
					map.put(rs.getInt("DepartmentId"), dep); //guardar no map
					
//					//Opcao 2 - metodos ficam responsaveis por indicar as colunas
//					dep = instantiateDepartment(rs);
//					map.put(rs.getInt("DepartmentId"), dep);
				}

				//Opcao 1 - indicar as colunas
				Seller obj = new Seller(); // criar um Seller para o retornar em forma de objeto
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setDepartment(dep); //adicionar o departamento criado
				
//				//Opcao 2 - metodos ficam responsaveis por indicar as colunas
//				Seller obj = instantiateSeller(rs, dep);
//				list.add(obj);
			
				list.add(obj); //adicionar à lista
			}
			return list; // se consulta não tiver registos: retorna nulo
		} 
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null; // começa na posicao 0
		try {
			st = conn.prepareStatement(
							"select seller.*, department.Name as DepName " + 
							"from seller INNER JOIN department " + 
							"ON seller.DepartmentId = department.id " + 
							"ORDER BY seller.Name");
			rs = st.executeQuery(); // executar query e resultado vem em forma de tabela

			List<Seller> list = new ArrayList<>(); //criar a lista de retorno de dados
			Map<Integer, Department> map = new HashMap<>(); //criar um mapa para que não seja instanciado um departamento novo para cada vendedor
			
			while (rs.next()) { // ENQUANTO consulta tiver registos - vai linha a linha
				
				Department dep = map.get(rs.getInt("DepartmentId")); //ver se id já existe no mapa - se não existir retorna nulo - nao se vai criar mais que um departamento igual
				
				if(dep == null) { //se não existir no map
					//Opcao 1 - indicar as colunas
					dep = new Department(); //criar um novo departamento
					dep.setId(rs.getInt("DepartmentId"));
					dep.setName(rs.getString("DepName"));
					map.put(rs.getInt("DepartmentId"), dep); //guardar no map
					
//					//Opcao 2 - metodos ficam responsaveis por indicar as colunas
//					dep = instantiateDepartment(rs);
//					map.put(rs.getInt("DepartmentId"), dep);
				}

				//Opcao 1 - indicar as colunas
				Seller obj = new Seller(); // criar um Seller para o retornar em forma de objeto
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setDepartment(dep); //adicionar o departamento criado
				
//				//Opcao 2 - metodos ficam responsaveis por indicar as colunas
//				Seller obj = instantiateSeller(rs, dep);
//				list.add(obj);
			
				list.add(obj); //adicionar à lista
			}
			return list; // se consulta não tiver registos: retorna nulo
		} 
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
