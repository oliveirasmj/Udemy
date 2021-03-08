package exame;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Faker2 f = new Faker2();
		String s = "#####!!!!!!!!!!?????";
		System.out.println(s + "   ------> original string");
		System.out.println();
		System.out.println(f.letterify(s + "   ------> letterify"));
		System.out.println(f.numerify(s + "   ------> numerify"));
		System.out.println();
		System.out.println(f.bothify(s + "   ------> bothify"));
	}

}
