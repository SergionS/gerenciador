package br.edu.ifsc.gerenciador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		writer.println("<html>");
		writer.println("<boby>");
		writer.println("Resultado da busca:");
		writer.println("</body>");
		writer.println("</html>");

	}
}
