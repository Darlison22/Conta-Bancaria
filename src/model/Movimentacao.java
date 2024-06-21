package model;

import java.util.Date;

import utils.UtilData;

public class Movimentacao {
	
	private String descricao;
	private Date data;
	private Double valor;
	
	public Movimentacao(String descricao, Double valor) {
		super();
		this.descricao = descricao;
		this.data = new Date();
		this.valor = valor;
	}
	
	
	//Start Getters and Setters
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Date getData() {
		return data;
	}
	
	public Double getValor() {
		return valor;
	}
	//And Getters and Setters
	
	
	//Start Methods
	
	
	//serve para indicar que o metodo irá sobreescrever um metodo que já existe.
	//Por exemplo, o metodo toString ja existe mas o @Override me permite
	//escrever um novo metodo com esse mesmo nome
	@Override 
	public String toString() {
		
		String dataFormatada = UtilData.converterDateParaDataEHora(this.getData());
		return this.getDescricao() + "\n" + dataFormatada + " - R$" + this.getValor();
		
		//Descrição 
		//Data e hora - valor
	}
	
	//End Methods
	
	
	

}
