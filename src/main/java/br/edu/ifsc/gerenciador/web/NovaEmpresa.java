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

/**
 * Servlet implementation class NovaEmpresa
 */
@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		
		new EmpresaDAO().adiciona(empresa);
		
		PrintWriter printer = response.getWriter();
		printer.println("<html><body>Empresa " + nome + " adicionada!</body></html>");
	}

}
