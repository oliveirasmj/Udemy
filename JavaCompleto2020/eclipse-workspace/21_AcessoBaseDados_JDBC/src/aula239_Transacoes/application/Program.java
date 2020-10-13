package aula239_Transacoes.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import aula239_Transacoes.db.DB;
import aula239_Transacoes.db.DbException;
import aula239_Transacoes.db.DbIntegrityException;


public class Program {

	public static void main(String[] args) {
		
		Connection conn = null; // conectar com BD
		Statement st = null; // permite montar consulta SQL
		
		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false); // NÃO É PARA CONFIRMAR AS OPERAÇÕES AUTOMATICAMENTE
			st = conn.createStatement();
			
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1"); //OPERACAO 1
			//FORCAR UM ERRO ENTRE DUAS OPERACOES
			int x = 1;
			if(x < 2) {
				throw new SQLException("Fake error");
			}
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2"); //OPERACAO 2
			
			
			conn.commit(); // COMANDO QUE AVISA QUE A TRANSACAO TERMINOU
			
			System.out.println("rows 1:  " + rows1);
			System.out.println("rows 2:  " + rows2);
		}
		
		catch (SQLException e) { // caso haja um erro
			try {
				conn.rollback(); // voltar atras na transacao
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
			} catch (SQLException e1) { // Quando da erro no rollback
				throw new DbException("Erro trying to rollback! Caused by: " + e1.getMessage());
			} 
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
