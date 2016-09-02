package br.com.sisvendas.dao;

import org.junit.Test;

import br.com.sisvendas.domain.Pessoa;
import br.com.sisvendas.domain.Usuario;

public class UsuarioDAOTest {
	@Test
	public void salvar(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		System.out.println("Pessoa encontrada");
		System.out.println("Nome: " + pessoa.getNome());
		
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setPessoa(pessoa);
		usuario.setSenha("123456");
		usuario.setTipo('A');
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		
		System.out.println("Usuário salvo com sucesso!");
	}

}
