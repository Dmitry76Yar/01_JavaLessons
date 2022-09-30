package f27_Lambda_Expression_And_Regex;
/* The matches method is fine for occasional use of regular expressions, but if you
want your program to do a lot of pattern matching, you should use the Pattern
and Matcher classes instead.  */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t05_Pattern_Matcher_ {
public static void main(String[] args) {
	String text = "Егор Алла Александр";
	Pattern pattern1 = Pattern.compile("Егор");		
	Pattern pattern2 = Pattern.compile("егор");	
				//  МЕТОДЫ КЛАССА PATTERN
		// Метод String pattern() – возвращает строковое представление регулярного выражения, из которого был создан объект Pattern:
	System.out.println(" \t Метод String pattern()");
	System.out.println("Строковое представление регулярного выражения для pattern Егор  " + pattern1.pattern());	//"abc"	
	
		// static boolean matches(String regex, CharSequence input) – позволяет проверить регулярное выражение, переданное
	// в параметре regex на соответствие тексту, переданному в параметре input.
	System.out.println(" \t Метод  boolean matches(String regex, CharSequence input)");
	System.out.print("Строка Алла соответствует pattern А.+а  \t" + Pattern.matches("А.+а","Алла") + "\t");	//true
	System.out.print("\t   Строка Егор соответствует pattern А.+а  \t" + Pattern.matches("А.+а","Егор") + "\t");		/* false */ System.out.println();  
	
		// Метод int flags() – возвращает значения параметра flags шаблона, которые были установлены при его создании, или 0, 
	// если этот параметр не был установлен.
	System.out.println("\t Метод int flags()");
	Pattern pattern3 = Pattern.compile("abc");
	System.out.print(pattern3.flags());		// 0
	Pattern pattern4 = Pattern.compile("abc",Pattern.CASE_INSENSITIVE);
	System.out.print("\t" + pattern4.flags());		// 2 - второй  flag в списке flag
	
				// МЕТОД КЛАССА MATCHER
	// По поиску смотри в t04_Pattern_Matcher_Search_String
	System.out.println("\n\t Метод find");
	String text2 = "Егор Алла Александр";
	Pattern pattern5 = Pattern.compile("егор");	
    Matcher matcher4 = pattern5.matcher(text2);
    System.out.print("Входит в строку Егор   " + matcher4.find() + "\t");
    System.out.print("Входит в строку егор   " + matcher4.find() + "\t");	System.out.println();
    	
    	// Печать найденных совпадений
    text = "Егор Алла Егор1 Александр";
    System.out.println("\t Печать найденных совпадений в строке с заданным шаблоном");
    Pattern pn4 = Pattern.compile("Е.[а-я]р");		
    Matcher mr4 = pn4.matcher(text);
    System.out.print("В строку входит следующеей совпадение к шаблону Е.[а-я]р : " + "\t");
    while (mr4.find())  System.out.print(text.substring(mr4.start(), mr4.end()) + " \t");  System.out.println();
    
    	//  Метод int start() и int end() можно определять позиции совпадений в тексте
    System.out.println("\t Метод int start() и int end()");
    String text3 = "Егор Алла Александр";
	Pattern pattern6 = Pattern.compile("а");
    Matcher matcher5 = pattern6.matcher(text3);
        	// Обязательно нужно сначала использовать метод find
    		/* Объекты класса Matcher сохраняют информацию о состоянии. Иногда может понадобиться сбросить сопоставитель, 
    		 * чтобы очистить эту информацию после окончания поиска по шаблону. 
    		 * Метод Matcher reset() сбрасывает состояние сопоставителя, включая позицию для добавления в конец (сбрасываемую в 0).
    		 * Следующая операция поиска по шаблону начинается в начале текста сопоставителя.*/
    while (matcher5.find()) {
        int start = matcher5.start();
        int end = matcher5.end();
        System.out.println("Найдено совпадение с паттерном с " + start + " \t до  " + (end -1) + " символов");
    }
       
    	//  Метод String replaceFirst(String replacement) и String replaceAll(String replacement) заменять в тексте совпадения на
    // другой текст replacement
    System.out.println("\t Метод String replaceFirst(String replacement) и String replaceAll(String replacement)");
    String text4 = "Егор Алла Александр";
	Pattern pattern7 = Pattern.compile("а");
    Matcher matcher6 = pattern7.matcher(text4);
    System.out.println("Результат replaceFirst(String replacement)   \t " + matcher6.replaceFirst("__"));
    System.out.println("Результат replaceAll(String replacement)     \t" + matcher6.replaceAll("__"));
    
    	// ЗАМЕНА для удаления лишних дублирующихся пробелов
    Pattern pattern8 = Pattern.compile("\\s+");		//  Паттерн для любого количества пустых символов
    Matcher m = pattern8.matcher("Удаляем      \t\t лишние пробелы.   ");
    System.out.println(m.replaceAll(" "));
    
    text = "one cat, two cats, or three cats on a fence";
    Pattern p = Pattern.compile("cat");
    Matcher m1 = p.matcher(text);
    System.out.println(m1.replaceAll("caterpillar"));
    
//    
//    text = "one cat, two cats, or three cats on a fence";
//    Pattern p = Pattern.compile("(cat)");
//    Matcher m1 = p.matcher(text);
//    StringBuffer sb = new StringBuffer();
//    while (m1.find())
////       m1.appendReplacement(sb, "$1erpillar");
//    	System.out.println(text.substring(m1.start(), m1.end()));
//    System.out.println(sb);
    
    /* Добавление текста в конец
    Позиция сопоставителя для добавления в конец задает начало текста сопоставителя, добавляемого в конец объекта типа java.lang.StringBuffer. Эту позицию используют следующие методы:
    Метод Matcher appendReplacement(StringBuffer sb, String replacement) читает символы текста сопоставителя и присоединяет их в конец объекта StringBuffer, на который ссылается аргумент sb. Этот метод прекращает чтение на последнем символе, предшествующем предыдущему соответствию шаблону. Далее, метод добавляет символы из объекта типа String, на который ссылается аргумент replacement, в конец объекта StringBuffer (строка replacement может содержать ссылки на текстовые последовательности, захваченные во время предыдущего поиска; они указываются при помощи символов ($) и номеров захватываемых групп). Наконец, метод устанавливает значение позиции сопоставителя для добавления в конец равным позиции последнего совпавшего символа плюс единица, после чего возвращает ссылку на текущий сопоставитель.
//    */
//    System.out.println("\t Печать найденных совпадений в строке с заданным шаблоном");
//    Pattern pn4 = Pattern.compile("Е.[а-я]р");		
//    Matcher mr4 = pn4.matcher(text);
//    System.out.print("В строку входит следующеей совпадение к шаблону Е.[а-я]р : " + "\t");
//    while (mr4.find())  System.out.println(text.substring(mr4.start(), mr4.end()));
    
    
    
	}					
}
        
        
  