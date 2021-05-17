package ws;

public class Program {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(1, "Mike", 26);
		Pessoa p2 = new Pessoa(2, "Hugo", 28);
		
		Atividade a1 = new Atividade(1, "Beber cerveja", p1);
		Atividade a2 = new Atividade(2, "Jogar Uno", p2);
		
		Atividades at = new Atividades();
		at.addActivity(a1);
		at.addActivity(a2);
	}

}
