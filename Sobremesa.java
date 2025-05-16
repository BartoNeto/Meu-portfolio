package restaurante;

public class Sobremesa extends Menu {
    public Sobremesa(int id, String nome, double preco) {
        super(id, nome, preco);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("ID: " + id + " - Sobremesa: " + nome + " - R$ " + preco);
    }
}