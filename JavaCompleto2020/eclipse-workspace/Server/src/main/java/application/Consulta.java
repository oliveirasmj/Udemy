package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;


public class Consulta { //listar todos os users

	public static void main(String[] args) {
		
		Connection conn = null; // conectar com BD
		Statement st = null; // preparar uma consulta sql
		ResultSet rs = null; // guardar o resultado da consulta
		
		try {
			conn = DB.getConnection(); //conectar com a BD
			st = conn.createStatement(); //iniciar um statement
			rs = st.executeQuery("select * from users"); //escrever a query e atribuir ao rs
			
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
