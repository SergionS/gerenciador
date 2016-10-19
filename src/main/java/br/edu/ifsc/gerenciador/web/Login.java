package br.edu.ifsc.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsc.gerenciador.dao.EmpresaDAO;
import br.edu.ifsc.gerenciador.dao.UsuarioDAO;
import br.edu.ifsc.gerenciador.model.Usuario;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter printer = resp.getWriter();

		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		 
		String mensagem = "";

		if (usuario != null) {
			
			HttpSession session = req.getSession();
			session.setAttribute("usuario.logado", email);
			session.setMaxInactiveInterval(10 * 10);
			
			System.out.println("Login OK");
			mensagem =  "Usuário logado:" + email;
		}else{
			System.out.println("Login inválido");
			printer.println("<html><body>Usuário inválido!</boby></html>");
			mensagem =  "Usuário inválido!";
		}

		req.setAttribute("mensagem", mensagem);
		
		String pagina = "/index.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
		dispatcher.forward(req, resp);

		
	}
	

}
