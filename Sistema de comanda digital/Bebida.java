package restaurante;

public class Bebida extends Menu {
    public Bebida(int id, String nome, double preco) {
        super(id, nome, preco);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("ID: " + id + " - Bebida: " + nome + " - R$ " + preco);
    }
}
