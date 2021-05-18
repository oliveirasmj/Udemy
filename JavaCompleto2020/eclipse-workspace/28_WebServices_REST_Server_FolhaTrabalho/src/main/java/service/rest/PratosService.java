package service.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

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
				Prato p = new Prato(rs.getString("nome"), rs.getInt("quantidade"), rs.getDouble("preco"));
				pratos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // fechar os recursos necessários
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}

		for (Prato p : pratos) {
			Gson gson = new Gson();
			String jsonResp = gson.toJson(p);
			return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
		}
		return null;
	}
}
