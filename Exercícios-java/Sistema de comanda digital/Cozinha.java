package restaurante;

import java.util.List;

public class Cozinha {
    public void receberPedido(List<Menu> itensSelecionados) {
        System.out.println("A cozinha recebeu seu pedido!\n\n");

        for (Menu item : itensSelecionados) {
            System.out.println(item.getId() + " - " + item.getNome() + " - R$ " + item.getPreco());

            System.out.print("\nPreparando ");
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(".");
            }
            System.out.println(" Pronto!\n\n");
        }

        System.out.println("\nTodos os pedidos foram preparados!");
        System.out.println("\nO garçom levará os pedidos até você");
    }
}
