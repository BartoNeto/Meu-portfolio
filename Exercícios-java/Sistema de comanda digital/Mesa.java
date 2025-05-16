package restaurante;

public class Mesa {
    int id;
    int capacidade;

    public Mesa(int id, int capacidade) {
        this.id = id;
        this.capacidade = capacidade;
    }

    public int getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }
}
