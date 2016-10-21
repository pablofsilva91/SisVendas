package br.com.sisvendas.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sisvendas.domain.Cidade;
import br.com.sisvendas.domain.Estado;

public class CidadeDAOTest {
	@Test
	@Ignore
	public void salvar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		
		Estado estado = estadoDAO.buscar(1L);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Ceilândia");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}
	
	@Test
	@Ignore
	public void listar(){
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();
		
		for(Cidade cidade : resultado){
			System.out.println("Código: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Sigla do Estado:" +  cidade.getEstado().getSigla());
			System.out.println("Código do Estado:" +  cidade.getEstado().getCodigo());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
				
		System.out.println("Código: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		System.out.println("Sigla do Estado:" +  cidade.getEstado().getSigla());
		System.out.println("Código do Estado:" +  cidade.getEstado().getCodigo());
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 2L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		if(cidade == null){
			System.out.println("Nenhum registro encontrado!");
		}else{
			cidadeDAO.excluir(cidade);
			System.out.println("Registro removido!");
			System.out.println(cidade.getNome());
		}
	}
	
	@Test
	@Ignore
	public void editar(){
		Long codigoEstado = 4L;
		Long codigoCidade = 1L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);
		
		System.out.println("Código: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		System.out.println("Sigla do Estado:" +  cidade.getEstado().getSigla());
		System.out.println("Código do Estado:" +  cidade.getEstado().getCodigo());
		
		cidade.setNome("Guarulhos");
		cidade.setEstado(estado);
	
		
		cidadeDAO.editar(cidade);
		
		System.out.println("Cidade Editada: ");
		System.out.println("Código: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		System.out.println("Sigla do Estado:" +  cidade.getEstado().getSigla());
		System.out.println("Código do Estado:" +  cidade.getEstado().getCodigo());
		
		
	}
	
	@Test
	public void buscarPorEstado(){
		Long estadoCodigo = 5L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.buscarPorEstado(estadoCodigo);
		
		for(Cidade cidade : resultado){
			System.out.println("Código: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Sigla do Estado:" +  cidade.getEstado().getSigla());
			System.out.println("Código do Estado:" +  cidade.getEstado().getCodigo());
		}
	}

}
