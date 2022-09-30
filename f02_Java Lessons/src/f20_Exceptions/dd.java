package f20_Exceptions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;



public class dd {
public static void main(String[] args) throws IllegalAccessException {

	List<String> numbers = new ArrayList<String>(Arrays.asList("first", "second", "third"));
	for (String number : numbers) {
	    if ("third".equals(number)) {
//	        numbers.add("fourth");
	    	System.out.println("ddd");
	    }
	    numbers.add("fourth");
	    
	}
	
	System.out.println(numbers.size());
	}

}
