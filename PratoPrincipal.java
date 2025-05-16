package restaurante;

public class PratoPrincipal extends Menu {
    public PratoPrincipal(int id, String nome, double preco) {
        super(id, nome, preco);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("ID: " + id + " - Prato Principal: " + nome + " - R$ " + preco);
    }
}