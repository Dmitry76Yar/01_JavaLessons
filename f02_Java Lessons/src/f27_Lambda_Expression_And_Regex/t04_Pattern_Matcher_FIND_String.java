package f27_Lambda_Expression_And_Regex;
/* The matches method is fine for occasional use of regular expressions, but if you
want your program to do a lot of pattern matching, you should use the Pattern
and Matcher classes instead.  */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t04_Pattern_Matcher_FIND_String {
public static void main(String[] args) {
	String text = "Егор Алла Александр";
	
	System.out.println("\t Поиск совпадений в строке с заданным шаблоном");
	Pattern pattern1 = Pattern.compile("Егор");		
	Pattern pattern2 = Pattern.compile("егор");	
    Matcher matcher1 = pattern1.matcher(text);
    Matcher matcher2 = pattern2.matcher(text);
    System.out.print("Входит в строку Егор   " + matcher1.find() + "\t");
    System.out.print("Входит в строку егор   " + matcher2.find() + "\t");	System.out.println();
    
    System.out.println("\t Поиск совпадений в строке с заданным шаблоном");
    Pattern pattern3 = Pattern.compile("Е.[а-я]р");		
    Matcher matcher3 = pattern3.matcher(text);
    System.out.println("Входит в строку Е.[а-я]р   " + matcher3.find() + "\t");	
    
    System.out.println("\t Печать найденных совпадений в строке с заданным шаблоном");
    Pattern pattern4 = Pattern.compile("Е.[а-я]р");		
    Matcher matcher4 = pattern4.matcher(text);
    System.out.print("В строку входит следующеей совпадение к шаблону Е.[а-я]р : " + "\t");
    while (matcher4.find())  System.out.println(text.substring(matcher4.start(), matcher4.end()));	
    
    	//  Метод int start() и int end() можно определять позиции совпадения в тексте
    System.out.println("\t Метод int start() и int end()");
    String text10 = "Егор Алла Александр";
	Pattern pattern10 = Pattern.compile("а");
    Matcher matcher10 = pattern10.matcher(text10);
    	// Обязательно нужно сначала использовать метод find
    while (matcher10.find()) {
        int start = matcher10.start();
        int end = matcher10.end();
        System.out.println("Найдено совпадение с паттерном с " + start + " \t до  " + end + " символов");
    }
    
    		// "А.+а" // жадный режим
    System.out.println("\t Поиск совпадений в ЖАДНОМ режиме - ищет соответствие максимальной длины");
    String text2 = "11223324233344";
    Pattern pattern5 = Pattern.compile("2.+2");
	    /* 3 шага для шаблона "2.+2", т.к. 3 символа
	     * 1-ый шаг компилятора - сначала Matcher перебирает последовательно с начала текста ищет символ "2" 
	     2-ой шаг - Matcher сверяет соответствие со вторым символом шаблона - «.+ - это любой символ в любом кол-ве. 
	     Этому символу соответствуют все символы строки, коэтому Matcher доходит до конца
	     3-ий шаг, т.к. текст в прямом направлении закончился, проверка происходит в обратном направлении, начиная с последнего
	     символа в поисках символа 2	
	     Результат: 1-ый шаг - первый символ 2, 2-ой шаг - "223324233344", 3-ий шаг - "2233242" */
    Matcher matcher5 = pattern5.matcher(text2);
    System.out.print("В строку входит следующеей совпадение максимальное длины для паттерна 2.+2 : " + "\t");
    	while (matcher5.find())  System.out.println(text2.substring(matcher5.start(), matcher5.end()));	
    	// Результат - "2233242"

    		// "А.++а" // сверхжадный режим
   	System.out.println("\t Поиск совпадений в СВЕРХЖАДНОМ режиме - ищет соответствие максимальной длины");
    String text3 = "11223324233344";
    Pattern pattern6 = Pattern.compile("2.++2");
   	    /* В сверхжадном режиме работа матчера аналогична механизму жадного режима. Отличие состоит в том, что при
   	     захватывании текста до конца строки поиск в обратном направлении не происходит. */
    Matcher matcher6 = pattern6.matcher(text3);
    System.out.print("В строку входит следующеей совпадение максимальное длины для паттерна 2.+2 : " + "\t");
    	while (matcher6.find())  System.out.println(text3.substring(matcher6.start(), matcher6.end()));			System.out.println();
        // Результат - Не найдено соответствие, т.к. строка "223324233344" не соответствует паттерну "2.++2"
        	
        	// "А.+?а" // ленивый режим
    System.out.println("\t Поиск совпадений в ЛЕНИВОМ режиме - ищет соответствие максимальной длины");
    String text4 = "11223324233344";
    Pattern pattern7 = Pattern.compile("2.+?3");
        /* 3 шага для шаблона "2.+2", т.к. 3 символа
        * 1-ый шаг компилятора - как у жадного - сначала Matcher перебирает последовательно с начала текста ищет символ "2" 
          2-ой шаг - Matcher ищет ПЕРВОЕ соответствие со вторым символом шаблона - «.+ - это любой символ в любом кол-ве. 
     	  После нахождения ПЕРВОГО соответствия, шаг завершается и не происходит поиск до конца строки
       	  3-ий шаг, происходит проверка следующего символа на соответствие	
       	  Результат: 1-ый шаг - первый символ 2, 2-ой шаг - "22", 3-ий шаг - "223" */
    Matcher matcher7 = pattern7.matcher(text4);
    System.out.print("В строку входит следующеей совпадение максимальное длины для паттерна 2.+2 : " + "\t");
      	while (matcher7.find())  System.out.println(text4.substring(matcher7.start(), matcher7.end()));		System.out.println();
        // Результат - Не найдено соответствие, т.к. строка "223324233344" не соответствует паттерну "2.++2"
        
    System.out.println("The root directory is \u00A7Windows");
    
	}					
}
        
        
  