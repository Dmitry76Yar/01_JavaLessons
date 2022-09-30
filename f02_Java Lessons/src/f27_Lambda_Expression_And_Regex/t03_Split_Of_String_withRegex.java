package f27_Lambda_Expression_And_Regex;

public class t03_Split_Of_String_withRegex {
public static void main(String[] args) {
	System.out.println("Сравнение отдельных символов     Соответствует Regex abc  ?");
	String s = "One:Two;Three|Four\tFive";
	String regex = "[:;|\\t]";
	String strings[] = s.split(regex);
	for (String word : strings)	System.out.print(word + "\t");		System.out.println();
	
	}					
}
        
        
  