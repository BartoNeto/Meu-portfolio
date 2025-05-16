package restaurante;

import java.util.Scanner;

public class Caixa implements FormaPagamento {
	Scanner scanner = new Scanner(System.in);

	float total;

	float troco;

	public void Debito(float total) {
		System.out.println("Pagamento de R$ " + total + " realizado com cartão de débito.\n");
	}

	public void Credito(float total) {
		System.out.println("Pagamento de R$ " + total + " realizado com cartão de crédito.\n");
	}

	public void PIX(float total) {
		System.out.println("Pagamento de R$ " + total + " realizado via PIX.\n");
	}

	public void Dinheiro(float total) {

		System.out.println("Troco para quanto?");

		while (true) {
			float valor = scanner.nextFloat();

			if (valor < total) {
				System.out.println("O valor é menor que o total a pagar...\n\nPague o valor correto:");
			} else if (valor > total) {
				System.out.println("Pagamento de R$ " + total + " realizado em dinheiro.\nTroco = " + (valor - total));
				break;
			} else {

			}
		}
	}
}