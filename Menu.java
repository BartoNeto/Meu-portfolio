package restaurante;

public abstract class Menu {
    protected int id;
    protected String nome;
    protected double preco;

    public Menu(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public abstract void exibirDetalhes();
}