package br.edu.ifsc.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsc.gerenciador.dao.UsuarioDAO;
import br.edu.ifsc.gerenciador.model.Usuario;

/**
 * Servlet implementation class BuscaUsuario
 */
@WebServlet(urlPatterns = "/buscaUsuario")
public class BuscaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		String filtro = request.getParameter("filtro");
		writer.println("<html>");
		writer.println("<boby>");
		writer.println("Resultado da busca:");
		
		for (Usuario usuario: new UsuarioDAO().buscaPorEmail(filtro)){
			writer.println("<li>" +usuario.getEmail() + "</li>");
		}
		
		writer.println("</body>");
		writer.println("</html>");
		
	}


}
