package exame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Faker f = new Faker();
		String s = "#####aaaaaaa?????";
		System.out.println(f.letterify(s));
		System.out.println(f.numerify(s));
		System.out.println(f.bothify(s));
	}

}
