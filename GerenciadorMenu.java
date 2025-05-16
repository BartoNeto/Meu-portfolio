package restaurante;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorMenu {
    private List<Menu> itensMenu;

    public GerenciadorMenu() {
        itensMenu = new ArrayList<>();
    }

    public void adicionarItem(Menu item) {
        itensMenu.add(item);
    }

    public void exibirMenu() {
        for (Menu item : itensMenu) {
            item.exibirDetalhes();
        }
    }

    public Menu escolherItem(int id) {
        for (Menu item : itensMenu) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void configurarMenu() {
    	//Prato Principal
        adicionarItem(new PratoPrincipal(1, "Bife com fritas", 25.90));
        adicionarItem(new PratoPrincipal(2, "Frango à milanesa", 25.90));
        adicionarItem(new PratoPrincipal(3, "Panqueca de carne", 25.90));
        
        //Sobremesa
        adicionarItem(new Sobremesa(4, "Sorvete de chocolate", 12.50));
        adicionarItem(new Sobremesa(5, "Açai", 12.50));
        adicionarItem(new Sobremesa(6, "Salada de frutas", 12.50));
        
        //Bebida
        adicionarItem(new Bebida(7, "Refrigerante", 5.00));
        adicionarItem(new Bebida(8, "Suco de laranja", 7.00));
        adicionarItem(new Bebida(9, "Suco de limão", 7.00));
    }
}