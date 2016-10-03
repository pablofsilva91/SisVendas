package br.com.sisvendas.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Ignore;

import br.com.sisvendas.domain.Cliente;
import br.com.sisvendas.domain.Pessoa;

public class ClienteDAOTest {
	//@Test
	@Ignore
	public void salvar() throws ParseException{
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		Cliente cliente = new Cliente();
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2015"));
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);
		
		ClienteDAO clienteDAO = new ClienteDAO();	
		clienteDAO.salvar(cliente);
		
		System.out.println("Cliente salvo com sucesso!");
	}

}
