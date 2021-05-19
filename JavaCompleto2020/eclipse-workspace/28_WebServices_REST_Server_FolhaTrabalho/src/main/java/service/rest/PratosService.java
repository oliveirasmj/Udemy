package service.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import db.DB;
import entities.Prato;

@Path("/prato")
public class PratosService {

	@GET
	@Path("/pratos")
	public Response pratos() {
		Connection conn = null; // conectar com BD
		Statement st = null; // preparar uma consulta sql
		ResultSet rs = null; // guardar o resultado da consulta
		List<Prato> pratos = new ArrayList<Prato>();

		try {
			conn = DB.getConnection(); // conectar com a BD
			st = conn.createStatement(); // iniciar um statement
			rs = st.executeQuery("select * from pratos"); // escrever a query e atribuir ao rs

			// Imprimir dados
			while (rs.next()) { // enquanto existir uma proxima linha na tabela rs
				Prato prato = new Prato(rs.getInt("id"), rs.getString("nome"), rs.getInt("quantidade"), rs.getDouble("preco"));
				pratos.add(prato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // fechar os recursos necessários
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		Gson gson = new Gson();
		String jsonResp = "";
		
		for (Prato p : pratos) {
			jsonResp += gson.toJson(p);
			// return pratos.toString(); //Alterar assinatura do metodo para String
		}
		return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
//		return null;
	}

	@GET
	@Path("/pratos/{id}")
	public Response pratoID(@PathParam("id") int id) {
		Connection conn = null; // conectar com BD
		Statement st = null; // preparar uma consulta sql
		ResultSet rs = null; // guardar o resultado da consulta
		List<Prato> pratos = new ArrayList<Prato>();

		try {
			conn = DB.getConnection(); // conectar com a BD
			st = conn.createStatement(); // iniciar um statement
			rs = st.executeQuery("select * from pratos"); // escrever a query e atribuir ao rs

			// Imprimir dados
			while (rs.next()) { // enquanto existir uma proxima linha na tabela rs
				Prato prato = new Prato(rs.getInt("id"), rs.getString("nome"), rs.getInt("quantidade"), rs.getDouble("preco"));
				pratos.add(prato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // fechar os recursos necessários
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}

		for (Prato p : pratos) {
			if (p.getId() == id) {
				Gson gson = new Gson();
				String jsonResp = gson.toJson(p);
				return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
			}

			// return p.toString(); //Alterar assinatura do metodo para String
		}
		return null;
	}
	
	@POST
	@Path("/addpratos")
	public void adicionarPrato(@PathParam("nome") String nome, @PathParam("quantidade") int quantidade, @PathParam("preco") double preco) {
		Connection conn = null; // conectar com BD
		PreparedStatement st = null; // permite montar consulta SQL
		
		try {
			conn = DB.getConnection();
			// EXAMPLE 1:
			st = conn.prepareStatement(
					"INSERT INTO pratos "
					+ "(nome, quantidade, preco) "
					+ "VALUES "
					+ "(?, ?, ?)");
			
			st.setString(1, nome);
			st.setInt(2, quantidade);
			st.setDouble(3, preco);

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
