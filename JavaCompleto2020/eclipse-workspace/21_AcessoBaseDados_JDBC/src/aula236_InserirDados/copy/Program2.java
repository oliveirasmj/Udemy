package aula236_InserirDados.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program2 {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null; // conectar com BD
		PreparedStatement st = null; // permite montar consulta SQL
		
		try {
			conn = DB.getConnection();
			
			// EXAMPLE 1:
			st = conn.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)", 
					Statement.RETURN_GENERATED_KEYS); // retorna a Key das ultimas linhas inseridas
			st.setString(1, "Carl Purple");
			st.setString(2, "carl@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);

			/*
			// EXAMPLE 2:
			st = conn.prepareStatement("insert into department (Name) values ('D1'), ('D2')",
					Statement.RETURN_GENERATED_KEYS);
			*/
			
			
			//saber numero de linhas afetadas e executar
			int rowsAffected = st.executeUpdate();

			//Ver os id's correspondentes aos dados inseridos
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys(); //Criar um ResultSet com os ultimos dados inseridos
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id = " + id);
				}
			}
			else {
				System.out.println("No rows affected!");
			}
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
