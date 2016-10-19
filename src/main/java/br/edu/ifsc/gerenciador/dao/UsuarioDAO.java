package br.edu.ifsc.gerenciador.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifsc.gerenciador.model.Usuario;


public class UsuarioDAO {
	private final static Map<String, Usuario> USUARIOS = new HashMap<>();
	static {
		USUARIOS.put("professor@sematecsolucoes.com.br", new Usuario(
				"professor@sematecsolucoes.com.br", "professor"));
		USUARIOS.put("diretor@sematecsolucoes.com.br", new Usuario(
				"diretor@sematecsolucoes.com.br", "diretor"));
	}

	public Usuario buscaPorEmailESenha(String email, String senha) {
		
		if (!USUARIOS.containsKey(email))
			return null;
		
		Usuario usuario = USUARIOS.get(email);
		if (usuario.getSenha().equals(senha))
			return usuario;
		
		return null;
		
	}

	public Collection<Usuario> buscaPorEmail(String email) {
		if (email == null)
			return USUARIOS.values();
		
		List<Usuario> similares = new ArrayList<>();
		for (Usuario usuario : USUARIOS.values()) {
			if (usuario.getEmail().toLowerCase().contains(email.toLowerCase()))
				similares.add(usuario);
		}
		return similares;
	}

	public void adiciona(Usuario usuario) {
		USUARIOS.put(usuario.getEmail(), usuario);
	}
}
