package aula238_DeletarDados.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import aula238_DeletarDados.db.DB;
import aula238_DeletarDados.db.DbIntegrityException;


public class Program {

	public static void main(String[] args) {
		
		Connection conn = null; // conectar com BD
		PreparedStatement st = null; // permite montar consulta SQL
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement( // apagar o departamento x
					"DELETE FROM department "
					+ "WHERE "
					+ "Id = ?");
			
			st.setInt(1, 5); // departamento x = 5

			int rowsAffected = st.executeUpdate(); //saber numero de linhas afetadas e executar
			System.out.println("Done! Rows affected: " + rowsAffected);
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage()); //lançar a excepção personalizada de integridade referencial
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
