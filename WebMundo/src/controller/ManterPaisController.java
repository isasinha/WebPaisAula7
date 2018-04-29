package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import model.PaisService;

/**
 * Servlet implementation class ManterPaisController
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/ 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		PaisService ps = new PaisService();
		Pais pais = new Pais();
		
		if(acao.equals("cadastrar")) {
		
		String pNome = request.getParameter("nome");
		long pPopulacao = Long.parseLong(request.getParameter("populacao"));
		int pArea = Integer.parseInt(request.getParameter("area"));
		String pContinente = request.getParameter("continente");
		
		pais.setNome(pNome);
		pais.setPopulacao(pPopulacao);
		pais.setArea(pArea);
		pais.setContinente(pContinente);

		ps.criar(pais);
		
	    request.setAttribute("pais", pais); 
	    
        RequestDispatcher view = request.getRequestDispatcher("Pais.jsp");
        view.forward(request, response);
		
		}if(acao.equals("listar")) {

						
			List<Pais> lista = ps.vetPais();

		    request.setAttribute("lista", lista); 
		    
	        RequestDispatcher view = request.getRequestDispatcher("Lista.jsp");
	        view.forward(request, response);
			
		}if(acao.equals("listarCont")) {

			String pContinente = request.getParameter("continente");
						
			List<Pais> lista = ps.vetPaisContinente(pContinente);

		    request.setAttribute("lista", lista); 
		    
	        RequestDispatcher view = request.getRequestDispatcher("Lista.jsp");
	        view.forward(request, response);
			
		}
		
		if(acao.equals("buscar")) {
			
			String pNome = request.getParameter("nome");
			
			Pais paisRetorno = ps.carregar(pNome);
		
		    request.setAttribute("pais", paisRetorno); 
		    
	        RequestDispatcher view = request.getRequestDispatcher("Busca.jsp");
	        view.forward(request, response);
			
		}
		
		if(acao.equals("alterar")) {
		    
			
			int pId = Integer.parseInt(request.getParameter("id"));
			String pNome = request.getParameter("nome");
			long pPopulacao = Long.parseLong(request.getParameter("populacao"));
			int pArea = Integer.parseInt(request.getParameter("area"));
			String pContinente = request.getParameter("continente");
			
			pais.setNome(pNome);
			pais.setPopulacao(pPopulacao);
			pais.setArea(pArea);
			pais.setContinente(pContinente);

			ps.atualizar(pId, pNome, pPopulacao, pArea, pContinente);
			
		    request.setAttribute("pais", pais); 
		    
	        RequestDispatcher view = request.getRequestDispatcher("Alterado.jsp");
	        view.forward(request, response);
		
		}
	
		if(acao.equals("excluir")) {
		    
			
			int pId = Integer.parseInt(request.getParameter("id"));
			
			ps.excluir(pId);
		
		   // request.setAttribute("pais", paisRetorno); 
			
	        RequestDispatcher view = request.getRequestDispatcher("Excluido.jsp");
	        view.forward(request, response);
		
		}
		
	}

}	