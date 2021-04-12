package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Consulta2 {

public static void main(String[] args) { //ver o user 14 com a dor do tipo 1
		
		Connection conn = null; // conectar com BD
		Statement st = null; // preparar uma consulta sql
		ResultSet rs = null; // guardar o resultado da consulta
		
		try {
			conn = DB.getConnection(); //conectar com a BD
			st = conn.createStatement(); //iniciar um statement
			rs = st.executeQuery("select * from record r\r\n"
					+ "inner join users u\r\n"
					+ "on r.user_id = u.id\r\n"
					+ "where u.id = 14 and r.record_type_id = 1"); //escrever a query e atribuir ao rs
			
			//Imprimir dados
			while(rs.next()) { //enquanto existir uma proxima linha na tabela rs
				System.out.println(rs.getInt("id") + ", " + rs.getString("name"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally { //fechar os recursos necessários
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
