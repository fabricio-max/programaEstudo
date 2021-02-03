package pincipio.responsabilidade;

public class TestConta {

	public static void main(String[] args) {
		ContaBancaria conta = new ContaBancaria();
		conta.setDescricao("Conta bancária do Fabrício");

		System.out.println(conta);

		conta.diminui100reais();
		conta.diminui100reais();

		System.out.println(conta);

		conta.sacarDinheiro(400);

		System.out.println(conta);
		conta.depositoDinheiro(1000);
		conta.soma100reais();
		System.out.println(conta);

	}

}
