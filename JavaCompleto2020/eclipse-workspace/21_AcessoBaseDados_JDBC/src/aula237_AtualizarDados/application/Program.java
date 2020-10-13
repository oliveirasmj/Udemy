package aula237_AtualizarDados.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import aula237_AtualizarDados.db.DB;


public class Program {

	public static void main(String[] args) {
		
		Connection conn = null; // conectar com BD
		PreparedStatement st = null; // permite montar consulta SQL
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement( // aumentar o salario em x vezes a todos os que pertencem ao departamento y
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "(DepartmentId = ?)");
			
			st.setDouble(1, 200.0); // aumentar o salario em x vezes
			st.setInt(2, 2); // departamento y

			int rowsAffected = st.executeUpdate(); //saber numero de linhas afetadas e executar
			System.out.println("Done! Rows affected: " + rowsAffected);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
