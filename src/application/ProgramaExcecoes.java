package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.DomainException;

public class ProgramaExcecoes {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Digite os dados da conta:");
			System.out.print("Número: ");
			int numero = sc.nextInt();
			sc.nextLine();
			System.out.print("Titular: ");
			String titular = sc.nextLine();
			System.out.print("Saldo inicial: ");
			double saldo = sc.nextDouble();
			Conta teste = new Conta(numero, titular, saldo);
			System.out.print("Limite de saque: ");
			double limiteSaque = sc.nextDouble();
			Conta conta = new Conta(numero, titular, saldo, limiteSaque);


			System.out.println();
			System.out.print("Digite a quantia para saque: ");
			double quantia = sc.nextDouble();
			conta.saque(quantia);

			System.out.println(conta);
		}
		catch (DomainException d) {
			System.out.println(d.getMessage());
		}
		catch (RuntimeException d) {
			System.out.println("Erro inesperado");
		}

		
		sc.close();
	}
}
