package restaurante;

public interface FormaPagamento {
	void Debito(float total);

	void Credito(float total);

	void PIX(float total);

	void Dinheiro(float total);
}
