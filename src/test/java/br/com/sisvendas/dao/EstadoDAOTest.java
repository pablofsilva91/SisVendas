package br.com.sisvendas.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sisvendas.domain.Estado;

public class EstadoDAOTest {
	@Test
	@Ignore
	public void salvar(){
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		
		EstadoDAO estadoDAo = new EstadoDAO();
		estadoDAo.salvar(estado);
	}
	
	@Test
	@Ignore
	public void listar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		
		System.out.println("Total de registros: " + resultado.size());
		
		for(Estado estado : resultado){
			System.out.println(estado.getSigla() + " - " + estado.getNome());
			
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 5L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado!");
		}else{
			System.out.println("Registro encontrado!");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 3L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado!");
		}else{
			estadoDAO.excluir(estado);
			System.out.println("Registro removido!");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
		
		
	}
	
	@Test
	public void editar(){
		Long codigo = 4L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado!");
		}else{
			
			System.out.println("Registro : " + estado.getSigla() + " - " + estado.getNome());
		
			estado.setSigla("BA");
			estado.setNome("Bahia");
			estadoDAO.editar(estado);
			
			System.out.println("Editado para: " + estado.getSigla() + " - " + estado.getNome());
		}
	}

}
