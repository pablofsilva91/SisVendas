package br.com.sisvendas.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass // será usada por outros para gerar tabelas
public class GenericDomain implements Serializable{
	@Id // chave primária
	@GeneratedValue(strategy = GenerationType.AUTO) // chave criada pelo banco
	private Long codigo; 
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
	    return String.format("%s[codigo=%d]", getClass().getSimpleName(), getCodigo());
	}
	
}
