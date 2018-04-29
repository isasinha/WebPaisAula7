package model;
import java.util.ArrayList;

public class PaisService {
	PaisDAO paisDao = new PaisDAO();
	Pais pais = new Pais();
	ArrayList<Pais> vet = new ArrayList<Pais>();

	public int criar(Pais pais) {
		return paisDao.criar(pais);
	}

	public void atualizar(int id, String nome, long populacao, double area, String continente) {
		paisDao.atualizar(id, nome, populacao, area, continente);
	}

	public void excluir(int id) {
		paisDao.excluir(id);
	}

	public Pais carregar(String nome) {
		return paisDao.carregar(nome);
	}
	
	public Pais maiorPop(){
		return paisDao.maiorPop();		
	}
	
	public Pais menorArea() {
		return paisDao.menorArea();
	}
	
	public ArrayList<Pais> vetPais() {
		return paisDao.vetPais();
	}
		
	public ArrayList<Pais> vetPaisContinente(String continente) {
		return paisDao.vetPaisContinente(continente);
	}
	
}