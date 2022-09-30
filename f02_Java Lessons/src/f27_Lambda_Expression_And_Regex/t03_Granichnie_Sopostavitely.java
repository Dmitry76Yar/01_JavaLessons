package f27_Lambda_Expression_And_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Граничные сопоставители
Иногда бывает нужно выполнить сопоставление с шаблоном в начале строки, на границе слов, в конце текста и т.д.
Сделать это можно с помощью одного из граничных сопоставителей класса Pattern, представляющих собой конструкции регулярных
выражений для поиска совпадений в следующих местоположениях:	 */

public class t03_Granichnie_Sopostavitely {
public static void main(String[] args) {
	/* 	^: Начало строки;
		$: Конец строки;
		\b: Граница слова;
		\B: Граница псевдослова;
		\A: Начало текста;
		\G: Конец предыдущего совпадения;
		\Z: Конец текста, не считая итогового разделителя строк (если таковой присутствует);
		\z: Конец текста  */
	
		//Использование ^ для поиска строк, начинающиеся на regex, за которыми следует ноль или более словообразующих символов
	System.out.println("\t Использование ^ для поиска строк, начинающиеся на regex");
	String regex = "^The*";
	String text = "The capital of Moscow is...   The.. \n The.....";
	Pattern pattern = Pattern.compile(regex);		
	Matcher matcher = pattern.matcher(text);
	System.out.print("Строка начинается начинается на    ");
	while (matcher.find())  System.out.println(text.substring(matcher.start(), matcher.end()));	
		// При наличии пробела перед The условие не выполняется
	String text2 = "  The capital of Moscow is...args   The.. \n The.....";
	matcher = pattern.matcher(text2);
	System.out.print("Строка начинается начинается на    ");
	while (matcher.find())  System.out.println(text.substring(matcher.start(), matcher.end()));
	System.out.println();
	
		//Использование ^ для поиска строк, заканчивающиеся на regex
	System.out.println("\t Использование $ для поиска строк, заканчивающиеся на regex");
	regex = "aa$";
	text = "The capital of Moscow is.......567aa";
	pattern = Pattern.compile(regex);		
	matcher = pattern.matcher(text);
	System.out.print("Строка заканчивается на    ");
	while (matcher.find())  System.out.println(text.substring(matcher.start(), matcher.end()));	
	
	
	
	
	
//	System.out.println("Сравнение отдельных символов     Соответствует Regex abc  ?");
//	String s = "One:Two;Three|Four\tFive";
//	String regex = "[:;|\\t]";
//	String strings[] = s.split(regex);
//	for (String word : strings)	System.out.print(word + "\t");		System.out.println();
	
	}					
}
        
        
  