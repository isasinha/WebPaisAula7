package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaisDAO {

	Pais pais = new Pais();

	public int criar(Pais pais) {
		String sqlInsert = "INSERT INTO pais(nome, populacao, area, continente) VALUES (?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = PaisConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());
			stm.setString(4, pais.getContinente());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					pais.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pais.getId();
	}

	public void atualizar(int id, String nome, long populacao, double area, String continente) {
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=?, continente=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = PaisConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, nome);
			stm.setLong(2, populacao);
			stm.setDouble(3, area);
			stm.setString(4, continente);
			stm.setInt(5, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void excluir(int id) {
		String sqlDelete = "DELETE FROM pais WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = PaisConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Pais carregar(String nome) {
		String sqlSelect = "SELECT id, nome, populacao, area, continente FROM pais WHERE nome = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		
		Pais pais = new Pais();
		
		try (Connection conn = PaisConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, nome);
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					pais.setContinente(rs.getString("continente"));
				}else {
					
					System.out.println("Pais nao cadastrado");
				}
				return pais;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		}
		return pais;
	}
	

	public Pais maiorPop() {

		String query = "SELECT * FROM pais WHERE populacao IN (SELECT MAX(populacao) FROM pais)";

		try (Connection conn = PaisConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(query);) {

			ResultSet rs = stm.executeQuery();

			Pais pais = new Pais();

			if (rs.next()) {
				pais.setId(rs.getInt("id"));
				pais.setNome(rs.getString("nome"));
				pais.setPopulacao(rs.getLong("populacao"));
				pais.setArea(rs.getDouble("area"));
				pais.setContinente(rs.getString("continente"));

			}

			return pais;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public Pais menorArea() {

		String query = "SELECT * FROM pais WHERE area IN (SELECT MIN(area) FROM pais)";

		try (Connection conn = PaisConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(query);) {

			ResultSet rs = stm.executeQuery();

			Pais pais = new Pais();

			if (rs.next()) {
				pais.setId(rs.getInt("id"));
				pais.setNome(rs.getString("nome"));
				pais.setPopulacao(rs.getLong("populacao"));
				pais.setArea(rs.getDouble("area"));
				pais.setContinente(rs.getString("continente"));

			}

			return pais;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Pais> vetPais() {

		String query = "SELECT * FROM pais";

		try (Connection conn = PaisConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(query);) {

			ResultSet rs = stm.executeQuery();

			ArrayList<Pais> vet = new ArrayList<Pais>();

			while (rs.next()) {

				Pais pais = new Pais();
				pais.setId(rs.getInt("id"));
				pais.setNome(rs.getString("nome"));
				pais.setPopulacao(rs.getLong("populacao"));
				pais.setArea(rs.getDouble("area"));
				pais.setContinente(rs.getString("continente"));

				vet.add(pais);

			}

			return vet;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Pais> vetPaisContinente(String continente) {
		String sqlSelect = "SELECT id, nome, populacao, area, continente FROM pais WHERE pais.continente = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = PaisConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, continente);
			try (ResultSet rs = stm.executeQuery();) {
				ArrayList<Pais> vet = new ArrayList<Pais>();

				while (rs.next()) {

					Pais pais = new Pais();
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					pais.setContinente(rs.getString("continente"));

					vet.add(pais);

				}

				return vet;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());

		}
		return null;

	}

}
