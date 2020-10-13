package aula240_ProjetoDAO.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?");
			st.setInt(1, id); // dizer que o primeiro ponto de interrogação é o valor id
			rs = st.executeQuery(); // executar query e resultado vem em forma de tabela

			if (rs.next()) { // se consulta tiver registos - vai linha a linha
				Department dep = new Department(); // criar um Departamento para o retornar em forma de objeto
				dep.setId(rs.getInt("DepartmentId")); // o id do dep = coluna DepartmentId
				dep.setName(rs.getString("DepName")); // o Name do dep = coluna DepName

				Seller obj = new Seller(); // criar um Seller para o retornar em forma de objeto
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setDepartment(dep);

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

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
