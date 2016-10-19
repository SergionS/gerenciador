package br.edu.ifsc.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsc.gerenciador.dao.EmpresaDAO;
import br.edu.ifsc.gerenciador.model.Empresa;

@WebServlet (urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

//		super.doGet(req, resp);

		PrintWriter writer = resp.getWriter();

		String filtro = req.getParameter("filtro");
		writer.println("<html>");
		writer.println("<boby>");
		writer.println("Resultado da busca:");
		
		for (Empresa empresa: new EmpresaDAO().buscaPorSimilaridade(filtro)){
			writer.println("<li>" +empresa.getId() +": " + empresa.getNome() + "</li>");
		}
		
		
		writer.println("</body>");
		writer.println("</html>");

	}
}
