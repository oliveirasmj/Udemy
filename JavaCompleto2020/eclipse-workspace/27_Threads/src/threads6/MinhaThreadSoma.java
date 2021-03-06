package threads6;

public class MinhaThreadSoma implements Runnable{
	
	private String nome;
	private int[] nums;
	private static Calculadora calc = new Calculadora(); //todas as instancias serão partilhadas
	
	public MinhaThreadSoma(String nome, int[] nums) {
		this.nome = nome;
		this.nums = nums;
	}

	@Override
	public void run() {
		System.out.println(this.nome + " iniciada");
		int soma = calc.somaArray(this.nums);
		System.out.println("Resultado da soma para thread " + this.nome + " é: " + soma);
		System.out.println(this.nome + " terminada");
	}
	
	
}
