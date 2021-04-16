package diversos.SetAndMaps;
import java.util.ArrayList;
import java.util.List;

public class SomarValoresArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		
		//FORMA 1
		int total = 0;
		for(Integer a : nums) {
			total += a.intValue();
		}
		System.out.println(total);
		
		//FORMA 2
		double soma = nums.stream().mapToInt(Integer::intValue).sum();
		System.out.println(soma);
	}

}
