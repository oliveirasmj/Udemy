package diversos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ListToMap {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV", 900.0));
		list.add(new Product("Notebook", 1200.0));
		list.add(new Product("Tablet", 400.0));
		list.add(new Product("Tablet", 400.0));
		
		Map<String, Double> map = new HashMap<>(); 
		
		// put every value list to Map 
		for (Product p : list) { 
		    map.put(p.getName(), p.getPrice()); 
		} 
		System.out.println("Map  : " + map); 
	}

}
