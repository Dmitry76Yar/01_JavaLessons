package f27_Lambda_Expression_And_Regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class t01_Basic_Lambda_Expressions {
public static void main(String[] args) {
	int[] numbers = {1,2,3,4,5};
	ArrayList<String> arl = new ArrayList<>();			arl.add("A");  	arl.add("B");	arl.add("C");
		// Краткая запись цикла for
    for(int num : numbers)	System.out.print(num + " \t ");	System.out.println();
    for(String i: arl)	System.out.print(i + " \t ");	System.out.println();
    	
    	// Краткая запись цикла for с условием
    System.out.println("Печать, если число равно 10");
    for (int num : numbers) {
    	if (num == 10) System.out.println(num);
	}
    	// Краткая запись цикла for с условием через ПОТОКи
    IntStream.of(numbers).filter(s -> s == 5).forEach(s -> System.out.println(s));		
    arl.stream().filter(s -> s.equals("A")).forEach(s -> System.out.print(s + "\t"));	
    
    
		// Краткая запись цикла forEach
//    numbers.forEach(System.out::println);
//    forEach(numbers[p]->System.out.print(numbers[p] + "\t"));
    
}
}
        
        
  