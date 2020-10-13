package aula234_PrimeiroProjeto.application;

import java.sql.Connection;

import aula234_PrimeiroProjeto.db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = DB.getConnection(); 
		DB.closeConnection();
		
	}

}
