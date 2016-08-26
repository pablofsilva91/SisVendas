package br.com.sisvendas.dao;

import org.junit.Test;

import br.com.sisvendas.domain.Estado;

public class EstadoDAOTest {
	@Test
	public void salvar(){
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		
		EstadoDAO estadoDAo = new EstadoDAO();
		estadoDAo.salvar(estado);
	}

}
