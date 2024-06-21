package app;

import model.ContaBancaria;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.Movimentacao;
import utils.UtilData;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Criando nosso banco digital\n");
		
		
		 
		ContaCorrente conta1 = new ContaCorrente("60482267305", "0001", "7542", 5, 350.0); //criei uma conta corrente;
		
		System.out.println("Saldo atual de R$"+conta1.getSaldo());
		System.out.println("");
		
		
		Double valor = conta1.sacar(150.0);
		
		System.out.println("O valor sacado foi R$"+valor);
		System.out.println("Saldo atual da conta1 apos o saque: R$"+conta1.getSaldo());
		System.out.println("");
		
		conta1.depositar(3500.0);
		
		System.out.println("O valor do deposito foi: R$"+3500.0);
		System.out.println("Saldo atual da conta1 apos o segundo deposito: R$"+conta1.getSaldo());
		System.out.println("");
		
		System.out.println("Cpf do titular da conta1: "+conta1.getCpf());
		System.out.println("------------------------------------------------------------");
		
		
		
		ContaPoupanca conta2 = new ContaPoupanca("60482268307", "0001", "68974", 5, 0.0);
		
		conta2.depositar(100.0);
		
		System.out.println("Saldo atual da conta2: R$" +conta2.getSaldo());
		System.out.println("");
		
		conta1.transferir(3500.0, conta2); //transferir esse valor da conta 1 para a conta 2
		
		System.out.println("Valor da conta2 apos a transferencia: R$"+ conta2.getSaldo());
		System.out.println("Valor da conta1 apos a tranferencia: R$" +conta1.getSaldo());
		
		
		System.out.println("Data de abertura da conta2: "+conta2.getDataAbertura());
		
		System.out.println();
		
		
		
		 //Extrato bancario é composto por movimentações bancarias
		 //Ter algo que possa ser a movimentação
		 //Ter uma lista de movimentações
	
		
		
		conta1.imprimirExtrato();
		System.out.println("");
		conta2.imprimirExtrato();
		
		
		
	}

}
