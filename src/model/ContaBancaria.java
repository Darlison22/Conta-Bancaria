package model;

import java.util.*;
import utils.*;


public abstract class ContaBancaria {
	
	//start attributes
	protected String cpf;
	protected String agencia;
	protected String conta;
	protected Integer digito;
	protected Double saldo = 0.0;
	protected String dataAbertura;
	protected ArrayList<Movimentacao> movimentacoes;
	private Double VALOR_MINIMO_DEPOSITO = 10.0;
	//end attributes
	
	//constructors
	public ContaBancaria(String cpf, String agencia, String conta, Integer digito, Double saldoInicial) {
		super();		
		
		this.validarCPF(cpf);
		this.formatarData(new Date());
		this.agencia = agencia;
		this.conta = conta;
		this.digito = digito;
		this.saldo = saldoInicial;
		
		//Se não instanciar, vai dar uma exception de nullPointerException
		this.movimentacoes = new ArrayList<Movimentacao>();
		
		Movimentacao movimentacao = new Movimentacao("Abertura de conta", saldoInicial);
		
		//Aqui estou salvando a movimentacao em um array de movimentações
		//Aqui estou também iniciando o meu extrato bancario
		this.movimentacoes.add(movimentacao);
	}
	

	//end constructors




	//start getters and setters
	public String getCpf() {
		return cpf;
	}
	
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	
	public Integer getDigito() {
		return digito;
	}
	public void setDigito(Integer digito) {
		this.digito = digito;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	
	public String getDataAbertura() {
		return dataAbertura;
	}

	

	//end getters and setters
	
	
	//start methods
	

	public void depositar (Double valor) {
		
		//verifica se o valor de deposito é menor que o valor minimo, caso seja, é lançado 
		//uma excessão para o usuário afimarmando que o valor de saque tem que ser maior
		if(valor < VALOR_MINIMO_DEPOSITO) {
			throw new InputMismatchException("O valor minimo de deposito é R$"+ VALOR_MINIMO_DEPOSITO);
	
		}
		
	
		this.saldo += valor;
		
		//Abaixo faço uma movimentação no extrato
		Movimentacao movimentacao = new Movimentacao("Deposito", valor);
		this.movimentacoes.add(movimentacao);
	}
	
	public Double sacar (Double valor) {
		
		//verifica se o valor de saque é maior que o saldo e caso seja, é lançado uma
		//excessão afirmando que o valor de saque tem que ser menor que o saldo
		if(valor > this.saldo) {
			throw new InputMismatchException("Não foi possivel realizar a operação de saque");
		}
		
		this.saldo -= valor;
		
		Movimentacao movimentacao = new Movimentacao("Retirada de valor", valor);
		this.movimentacoes.add(movimentacao);	
		
		return valor;
	}
	
	public void transferir (Double valor, ContaBancaria conta) {
		
		//Efetua um saque na conta atual
		Double saque = this.sacar(valor);
		
		//Efetua um deposito na conta de destino
		conta.depositar(valor);
		
	}
	
	private void validarCPF(String cpf) {
		
		boolean verificacao1 = UtilCpf.verificarApenasNumeros(cpf);
		boolean verificacao2 = UtilCpf.verificarQuantidadeDigitos(cpf);
		
		if(verificacao1 && verificacao2) {
			this.cpf = cpf;
		} else {
			throw new InputMismatchException("Cpf invalido! Tente novamente.");
		}
	}
	
	private void formatarData(Date data) {
		
		String Data = UtilData.converterDateParaDataEHora(data);
		this.dataAbertura = Data;	
		
	}
	
	public abstract void imprimirExtrato(); //metodo abstrato -> polimorfismo
	
	//end methods
	
	
	

}
