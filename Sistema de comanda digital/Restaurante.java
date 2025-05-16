//Integrantes: 
//Pedro Ribeiro de Oliveira - RA: 197947
//Bartolomeu Gomes Rabelo Neto - RA: 199824

package restaurante;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurante {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        Mesa[] mesas = {
                new Mesa(1, 2),
                new Mesa(2, 4),
                new Mesa(3, 6),
                new Mesa(4, 8),
                new Mesa(5, 12)
        };

		System.out.println("Bem-vindo ao nosso restaurante!");
		String nome;

		System.out.println("Informe o seu nome: ");
		nome = scanner.nextLine();

		int numPessoas;
		while (true) {
			System.out.println("Mesa para quantos?");
			numPessoas = scanner.nextInt();

			if (numPessoas > 12) {
				System.out.println("O número de pessoas excede o máximo permitido (12)");
			} else if (numPessoas < 1) {
				System.out.println("Se não quiser entrar, não gaste meu tempo >:(");
			} else {
				break;
			}
		}

		System.out.println("Quantidade de pessoas: " + numPessoas);

		Mesa mesaEscolhida = null;
		for (Mesa mesa : mesas) {
			if (mesa.getCapacidade() >= numPessoas) {
				mesaEscolhida = mesa;
				break;
			}
		}

		if (mesaEscolhida != null) {
			System.out.println(
					"\nPor favor, " + nome + ", sente-se na mesa " + mesaEscolhida.getId() + " que acomoda até "
							+ mesaEscolhida.getCapacidade() + " pessoas.\nO garçom logo levará o menu até você.");
		} else {
			System.out.println(
					"\nDesculpe, não temos uma mesa disponível para esse número de pessoas.\nO garçom logo levará o menu até você.");
		}

		GerenciadorMenu gerenciadorMenu = new GerenciadorMenu();
		gerenciadorMenu.configurarMenu();

		System.out.println("\n##################  Menu  ##########################\n");
		gerenciadorMenu.exibirMenu();
		System.out.println("\n####################################################\n");

		List<Menu> itensSelecionados = new ArrayList<>();
		float total = 0;

		while (true) {
			System.out.println("\nEscolha um item do menu pelo ID (ou 0 para terminar a seleção):");
			int escolha = scanner.nextInt();

			if (escolha == 0) {
				break;
			}

			Menu itemEscolhido = gerenciadorMenu.escolherItem(escolha);

			if (itemEscolhido != null) {
				itensSelecionados.add(itemEscolhido);
				total += itemEscolhido.getPreco();
			} else {
				System.out.println("Escolha inválida.");
			}
		}

		System.out.println("\n################## Resumo do Pedido ##################\n");
		System.out.println("Cliente: " + nome);
		System.out.println("Mesa: " + mesaEscolhida.getId() + "\n");
		System.out.println("Pedido: ");

		for (Menu item : itensSelecionados) {
			System.out.println(item.getNome() + " |" + " R$" + item.getPreco());
		}
		System.out.println("\nTotal a pagar: R$ " + total);
		System.out.println("\n####################################################\n");

		System.out.println("Gostaria de pedir algo mais?\n1. Sim\n2. Não");
		int r;
		r = scanner.nextInt();

		if (r == 1) {

			while (r == 1) {
				System.out.println("\n##################  Menu  ##########################\n");
				gerenciadorMenu.exibirMenu();
				System.out.println("\n####################################################\n");

				while (true) {
					System.out.println("\nEscolha um item do menu pelo ID (ou 0 para terminar a seleção):");
					int escolha = scanner.nextInt();

					if (escolha == 0) {
						break;
					}

					Menu itemEscolhido = gerenciadorMenu.escolherItem(escolha);

					if (itemEscolhido != null) {
						itensSelecionados.add(itemEscolhido);
						total += itemEscolhido.getPreco();
					} else {
						System.out.println("Escolha inválida.");
					}
				}

				System.out.println("\n################## Resumo do Pedido ##################\n");
				System.out.println("Cliente: " + nome);
				System.out.println("Mesa: " + mesaEscolhida.getId() + "\n");
				System.out.println("Pedido: ");

				for (Menu item : itensSelecionados) {
					System.out.println(item.getNome() + " |" + " R$" + item.getPreco());
				}
				System.out.println("\nTotal a pagar: R$ " + total);
				System.out.println("\n####################################################\n");
				System.out.println("Gostaria de pedir algo mais?\n1. Sim\n2. Não");
				r = scanner.nextInt();
			}
		} else if (r == 2) {

		}

		System.out.println("\nEscolha a forma de pagamento: \n1. Débito\n2. Crédito\n3. PIX\n4. Dinheiro");

		Caixa caixa = new Caixa();

		while (true) {
			int escolha = scanner.nextInt();

			if (escolha == 1) {
				caixa.Debito(total);
				break;
			} else if (escolha == 2) {
				caixa.Credito(total);
				break;
			} else if (escolha == 3) {
				caixa.PIX(total);
				break;
			} else if (escolha == 4) {
				caixa.Dinheiro(total);
				break;
			} else {
				System.out.println("Escolha inválida. Tente novamente.");
			}
		}

		System.out.println("\nEnviando pedido para a cozinha");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println(" Pronto!\n");

		Cozinha cozinha = new Cozinha();
		cozinha.receberPedido(itensSelecionados);

		scanner.close();
	}
}