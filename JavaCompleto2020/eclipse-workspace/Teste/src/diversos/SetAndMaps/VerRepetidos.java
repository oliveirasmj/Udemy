package diversos.SetAndMaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class VerRepetidos {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(new Integer[]{1,2,1,3,4,4});  
		
		numbers.stream().filter(i -> Collections.frequency(numbers, i) >1)
        .collect(Collectors.toSet()).forEach(System.out::println);
	}

}
