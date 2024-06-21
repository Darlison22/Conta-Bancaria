package model;

import java.util.Date;

import utils.UtilData;

public class ContaPoupanca extends ContaBancaria{

	public ContaPoupanca(String cpf, String agencia, String conta, Integer digito, Double saldoInicial) {
		super(cpf, agencia, conta, digito, saldoInicial);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void imprimirExtrato() {
		// TODO Auto-generated method stub
		
		System.out.println("************************************");
		System.out.println("******    Extrato Poupança   *******");
		System.out.println("************************************");
		System.out.println("");
		
		System.out.println("Gerado em: "+UtilData.converterDateParaDataEHora(new Date()));
		System.out.println("");
		
		for(Movimentacao movimentacao: this.movimentacoes) {
			System.out.println(movimentacao);
			System.out.println("------------------------------------");
		}
		System.out.println("");
		System.out.println("************************************");
		System.out.println("************************************");
		System.out.println("************************************");
		
	}
	

}
