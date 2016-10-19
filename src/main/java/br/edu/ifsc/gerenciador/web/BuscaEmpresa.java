package br.edu.ifsc.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsc.gerenciador.dao.EmpresaDAO;

@WebServlet (urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		String filtro = req.getParameter("filtro");

		req.setAttribute("empresas", new EmpresaDAO().buscaPorSimilaridade(filtro));
		
		String pagina = "/lista.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
		dispatcher.forward(req, resp);
			
	}
}
