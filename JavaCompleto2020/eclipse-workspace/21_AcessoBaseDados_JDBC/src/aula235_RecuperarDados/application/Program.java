package aula235_RecuperarDados.application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import aula235_RecuperarDados.db.DB;


public class Program {

	public static void main(String[] args) {
		
		Connection conn = null; // conectar com BD
		Statement st = null; // preparar uma consulta sql
		ResultSet rs = null; // guardar o resultado da consulta
		
		try {
			conn = DB.getConnection(); //conectar com a BD
			st = conn.createStatement(); //iniciar um statement
			rs = st.executeQuery("select * from department"); //escrever a query e atribuir ao rs
			
			//Imprimir dados
			while(rs.next()) { //enquanto existir uma proxima linha na tabela rs
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
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
