package hello.world.exercicio5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class Escola {

	@WebMethod
	public String listarAlunos() {

		Connection conn = null; // conectar com BD
		Statement st = null; // preparar uma consulta sql
		ResultSet rs = null; // guardar o resultado da consulta
		String lista = "";

		try {
			conn = DB.getConnection(); // conectar com a BD
			st = conn.createStatement(); // iniciar um statement
			rs = st.executeQuery("select * from aluno"); // escrever a query e atribuir ao rs

			// Imprimir dados
			while (rs.next()) { // enquanto existir uma proxima linha na tabela rs
				lista += rs.getInt("Id") + ", " + rs.getString("Nome") + ", " + rs.getString("Numero") + ", " + rs.getString("Estatuto");
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Nome") + ", " + rs.getString("Numero") + ", " + rs.getString("Estatuto"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // fechar os recursos necessários
			DB.closeResultSet(rs);
			DB.closeStatement(st);
//			DB.closeConnection();
		}
		return lista;
	}
	
	@WebMethod
	public void inserirAluno(@WebParam(name="nome") String nome, @WebParam(name="numero") int numero, @WebParam(name="estatuto") String estatuto) {
		Connection conn = null; // conectar com BD
		PreparedStatement st = null; // permite montar consulta SQL
		
		try {
			conn = DB.getConnection();
			// EXAMPLE 1:
			st = conn.prepareStatement(
					"INSERT INTO aluno "
					+ "(Nome, Numero, Estatuto) "
					+ "VALUES "
					+ "(?, ?, ?)");
			
			st.setString(1, nome);
			st.setInt(2, numero);
			st.setString(3, estatuto);

			int rowsAffected = st.executeUpdate(); //saber numero de linhas afetadas e executar
			System.out.println("Done! Rows affected: " + rowsAffected);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
//			DB.closeConnection();
		}
	}
	
	@WebMethod
	public void removerAluno(@WebParam(name="id") int id) {
		Connection conn = null; // conectar com BD
		PreparedStatement st = null; // permite montar consulta SQL
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement( // apagar o departamento x
					"DELETE FROM aluno "
					+ "WHERE "
					+ "Id = ?");
			
			st.setInt(1, id); // aluno x = id

			int rowsAffected = st.executeUpdate(); //saber numero de linhas afetadas e executar
			System.out.println("Done! Rows affected: " + rowsAffected);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
//			DB.closeConnection();
		}
	}

	public static void main(String[] args) {
		Escola e = new Escola();
		//e.listarAlunos();
		//e.inserirAluno("Joao", 4, "Trabalhador");
		//e.removerAluno(5);
	}

}
