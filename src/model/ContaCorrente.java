package model;

import java.util.Date;

import utils.UtilData;

public class ContaCorrente extends ContaBancaria{

	public ContaCorrente(String cpf, String agencia, String conta, Integer digito, Double saldoInicial) {
		//Aqui por baixo ele cria uma conta bancaria
		super(cpf, agencia, conta, digito, saldoInicial);
	}

	@Override
	public void imprimirExtrato() {
		// TODO Auto-generated method stub
		
		System.out.println("************************************");
		System.out.println("******    Extrato Bancario   *******");
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
