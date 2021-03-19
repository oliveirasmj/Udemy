package diversos.SetAndMaps;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ArrayToSet {

	public static void main(String[] args) {
		
		Integer[] sourceArray = { 0, 1, 2, 3, 4, 5, 5, 5, 5 };
	    Set<Integer> targetSet = new HashSet<Integer>();
	    Collections.addAll(targetSet, sourceArray);
	    
	    for(Integer set : targetSet) {
	    	System.out.println(set);
	    }
	}

}
