package diversos;
import java.util.Scanner;

public class ParImpar {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();

		if(num%2==0) {
			System.out.println("Par");
		} else {
			System.out.println("impar");
		}
		
		sc.close();
		
	}

}
