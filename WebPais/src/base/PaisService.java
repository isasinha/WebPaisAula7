package base;
import java.util.ArrayList;

public class PaisService {
	PaisDAO paisDao = new PaisDAO();
	Pais pais = new Pais();
	ArrayList<Pais> vet = new ArrayList<Pais>();

	public int criar(Pais pais) {
		return paisDao.criar(pais);
	}

	public void atualizar() {
		paisDao.atualizar();
	}

	public void excluir() {
		paisDao.excluir();
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