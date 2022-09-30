package f27_Lambda_Expression_And_Regex;
/*
 Character classes
[abc]	a, b, or c (simple class)
[^abc]	Any character except a, b, or c (negation)
[a-zA-Z]	a through z or A through Z, inclusive (range)
[a-d[m-p]]	a through d, or m through p: [a-dm-p] (union)
[a-z&&[def]]	d, e, or f (intersection)
[a-z&&[^bc]]	a through z, except for b and c: [ad-z] (subtraction)
[a-z&&[^m-p]]	a through z, and not m through p: [a-lq-z](subtraction)
 
Predefined character classes
.	Any character (may or may not match line terminators)
\d	A digit: [0-9]
\D	A non-digit: [^0-9]
\s	A whitespace character: [ \t\n\x0B\f\r]
\S	A non-whitespace character: [^\s]
\w	A word character: [a-zA-Z_0-9]
\W	A non-word character: [^\w]  

? 		Символ или может отсутствовать, или может быть один раз
* 		Символ или может отсутствовать, или может быть любое количество раз
+ 		Символ должен повторяться один или больше раз
{n}		Символ должен повторяться точное заданное число раз n 
{n,} 	Символ должен повторяться не менее заданного числа раз n
{n,m} 	Символ должен повторяться от n до m раз */

public class t02_Regex {
public static void main(String[] args) {
	System.out.println("Сравнение отдельных символов     Соответствует Regex abc  ?");
	String regex = "abc";
	System.out.print("abc - " + "abc".matches(regex) + "\t");
	System.out.print("abd - " + "abd".matches(regex) + "\t");		System.out.println();
	
	/*   ПОЛНОЕ ОПИСАНИЕ  https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html#CASE_INSENSITIVE
	
	/*.  Any character
	\d Any digit (0–9)
	\D Any nondigit (anything other than 0–9)
	\s Any white-space character (space, tab, new line, return, or backspace)
	\S Any character other than a white-space character
	\w Any word character (a–z, A–Z, 0–9, or an underscore)
	\W Any character other than a word character
	System.out.println("Сравнение c regex  символов     Соответствует Regex abc?");  */
	
	System.out.println("Соответствует Regex c.t  ?");
	regex = "c.t";
	System.out.print("cat - " + "cat".matches(regex)+ "\t");
	System.out.print("cot - " + "cot".matches(regex)+ "\t");
	System.out.print("Cat - " + "Cat".matches(regex)+ "\t");		
	System.out.print("c t - " + "c t".matches(regex)+ "\t");		System.out.println();
		
			// Использование в качестве regex символов из других строк
	String h = "c.t";
	regex = h.charAt(0) + "" +  h.charAt(1) + h.charAt(2);
	System.out.print("cat - " + "cat".matches(regex)+ "\t");
	System.out.print("cot - " + "cot".matches(regex)+ "\t");
	System.out.print("Cat - " + "Cat".matches(regex)+ "\t");		
	System.out.print("c t - " + "c t".matches(regex)+ "\t");		System.out.println();
	
	System.out.println("Номер телефона соответствует записи d-ddd-ddd-dd-dd ?");
	regex = "\\d-\\d\\d\\d-\\d\\d\\d-\\d\\d-\\d\\d";
	System.out.print("8-920-105-60-41   " + "8-920-105-60-41".matches(regex)+ "\t\t");
	System.out.print("+7-920-105-60-41   " + "+7-920-105-60-41".matches(regex)+ "\t\t");
	System.out.print("89201056041   " + "89201056041".matches(regex)+ "\t");	System.out.println();
	
	System.out.println("Клетка шахматного поля соответствует записи Dd-Dd = (Нецифра, цирфа - Нецифра, цирфа) ?");
	regex = "\\D\\d-\\D\\d";
	System.out.print("A2-D1   " + "A2-D1".matches(regex)+ "\t\t");
	System.out.print("AA-D1   " + "AA-D1".matches(regex)+ "\t\t");
	System.out.print("?2-D1   " + "?2-D1".matches(regex)+ "\t");	System.out.println();

	System.out.println("Regex с пробелом и другими пустыми символами (\\t,\\n..)");
	regex = "...\\s...";
	System.out.print("...\\s...   " + "abc def".matches(regex)+ "\t\t");
	System.out.print("...\\s...   " + "abc	def".matches(regex)+ "\t\t");	System.out.println();
	
	System.out.println("Regex с \\w - любой символ, который обычно используется в словах и \\W - противоположность \\w");
	regex = "\\w\\w\\w\\w\\w\\w";
	System.out.print("abcdef   " + "abcdef".matches(regex)+ "\t\t");
	System.out.print("ab def   " + "ab def".matches(regex)+ "\t\t");	
	System.out.print("ab2def   " + "ab2def".matches(regex)+ "\t\t");	
	System.out.print("ab-def   " + "ab-def".matches(regex)+ "\t\t");
	System.out.print("ab_def   " + "ab_def".matches(regex)+ "\t\t");	System.out.println();
	
	System.out.println("Использование групп символов для отдельной позиции");
	regex = "b[aeiou]t";
	System.out.print("bat   " + "bat".matches(regex)+ "\t\t");
	System.out.print("bit   " + "bit".matches(regex)+ "\t\t");	
	System.out.print("bqt   " + "bqt".matches(regex)+ "\t\t");		System.out.println();	
	
	System.out.println("Использование групп символов для отдельной позиции с прописными и ЗАГЛАВНЫМИ бувками");
	regex = "b[aAeEiIoOuU]t";
	System.out.print("bat   " + "bat".matches(regex)+ "\t\t");
	System.out.print("bAt   " + "bAt".matches(regex)+ "\t\t");	
	System.out.print("bqt   " + "bqt".matches(regex)+ "\t\t");		System.out.println();
	
	System.out.println("Использование диапазонов символов   [a-z][0-5]");
	regex = "[a-z][0-5]";
	System.out.print("a1   " + "a1".matches(regex)+ "\t\t");
	System.out.print("q4   " + "q4".matches(regex)+ "\t\t");	
	System.out.print("A5   " + "A5".matches(regex)+ "\t\t");		System.out.println();	
	
	System.out.println("Использование диапазонов символов   [a-zA-Z0-9][0-5]");
	regex = "[a-zA-Z0-9][0-5]";
	System.out.print("a1   " + "a1".matches(regex)+ "\t\t");	// true
	System.out.print("A1   " + "A1".matches(regex)+ "\t\t");	// true
	System.out.print("11   " + "11".matches(regex)+ "\t\t");	/* true	*/	System.out.println();
	
	System.out.println("Использование вложенных групп в группы ");
	regex = "[a-d[m-p]]";		// = [a-dm-p]
	System.out.print("a   " + "a".matches(regex)+ "\t\t");		// true
	System.out.print("f   " + "f".matches(regex)+ "\t\t");		// false
	System.out.print("n   " + "n".matches(regex)+ "\t\t");		/* true	*/ 	System.out.println();
	
	System.out.println("Использование вложенных групп в группы ");
	regex = "[a-z&&[^b-d]]";		// = от a до z, но кроме символов от b до d
	System.out.print("r   " + "r".matches(regex)+ "\t\t");		// true
	System.out.print("b   " + "b".matches(regex)+ "\t\t");		/* false	*/ 	System.out.println();
	
	System.out.println("Использование вложенных групп в группы ");
	regex = "[a-z&&[d-f]]";		// = общие симовлы на пересечении двух множеств, соответствует символам d, e и f. 
		// Пример, для проверки что каждый символ 3-ей строки попадает между двумя другими
	String x = "ab";
	String y = "dc";
	regex = "[" + x.charAt(0) + "-" + y.charAt(0) + "&&[" + x.charAt(1) + "-" + y.charAt(1) + "]]"; 	
	System.out.println("Строковое представление регулярного выражения для pattern Егор  " + regex.toString());
	
	
	System.out.println("Использование в regex символа ^ - в строке допускается любой символ кроме перечисленных");
	regex = "[^cf]at";
	System.out.print("bat   " + "bat".matches(regex)+ "\t\t");
	System.out.print("cat   " + "cat".matches(regex)+ "\t\t");	
	System.out.print("fat   " + "fat".matches(regex)+ "\t\t");		System.out.println();	
	regex = "[a-g^cf]at";		// Любой символ из диапазона a-g кроме c и f
	System.out.print("bat   " + "bat".matches(regex)+ "\t\t");
	System.out.print("cat   " + "cat".matches(regex)+ "\t\t");	
	System.out.print("tat   " + "tat".matches(regex)+ "\t\t");		System.out.println();	
	
	System.out.println("Использование в regex ПОВТОРЕНИЙ");
	/* 	? 		Символ или может отсутствовать, или может быть один раз
	 	* 		Символ или может отсутствовать, или может быть любое количество раз
		+ 		Символ должен повторяться один или больше раз
		{n}		Символ должен повторяться точное заданное число раз n 
		{n,} 	Символ должен повторяться не менее заданного числа раз n
		{n,m} 	Символ должен повторяться от n до m раз*/
	
	System.out.println("Соответствует Regex ca?t  ?     Символ или может отсутствовать, или может быть один раз");
	regex = "ca?t";
	System.out.print("cat - " + "cat".matches(regex)+ "\t");
	System.out.print("cbt - " + "cbt".matches(regex)+ "\t");
	System.out.print("сt - " + "ct".matches(regex)+ "\t");			System.out.println();
	
	System.out.println("Соответствует Regex ca*t  ?     Символ или может отсутствовать, или может быть любое количество раз");
	regex = "ca*t";
	System.out.print("cat - " + "cat".matches(regex)+ "\t");
	System.out.print("caaaat - " + "caaaat".matches(regex)+ "\t");
	System.out.print("сt - " + "ct".matches(regex)+ "\t");			System.out.println();
	
	System.out.println("Соответствует Regex ca+t  ?     Символ должен повторяться один или больше раз");
	regex = "ca+t";
	System.out.print("cat - " + "cat".matches(regex)+ "\t");
	System.out.print("caaaat - " + "caaaat".matches(regex)+ "\t");
	System.out.print("сt - " + "ct".matches(regex)+ "\t");			System.out.println();
	
	System.out.println("Номер телефона соответствует записи 3 числа - 2 числа - 4 числа ?    {n}	"
			+ "	Символ должен повторяться точное заданное число раз n");
	regex = "\\d{3}-\\d{2}-\\d{3}";		// Любой символ из диапазона a-g кроме c и f
	System.out.print("120-30-601   " + "120-30-601".matches(regex)+ "\t\t");
	System.out.print("120-3-601   " + "120-3-601".matches(regex)+ "\t\t");	
	System.out.print("120-305601   " + "120-305601".matches(regex)+ "\t\t");		System.out.println();
	
	System.out.println("Соответствует Regex ca+t  ?     Символ должен повторяться один или больше раз");
	regex = "ca+t";
	System.out.print("cat - " + "cat".matches(regex)+ "\t");
	System.out.print("caaaat - " + "caaaat".matches(regex)+ "\t");
	System.out.print("сt - " + "ct".matches(regex)+ "\t");			System.out.println();
	
	System.out.println("Использование в regex ПОВТОРЕНИЙ для групп		Группа должна повторяться один или больше раз");
	regex = "(bla)+";
	System.out.print("bla - " + "bla".matches(regex)+ "\t");
	System.out.print("blabla - " + "blabla".matches(regex)+ "\t");	System.out.println();

	System.out.println("Сложный пример с номером телефона ");
	regex = "(\\(\\d{3}\\))?\\s?\\d{3}-\\d{4}";
	System.out.print("555-1234 - " + "555-1234".matches(regex)+ "\t");
	System.out.print("(559) 555-1234 - " + "(559) 555-1234".matches(regex)+ "\t");
	System.out.print("(559)555-1239 - " + "(559)555-1239".matches(regex)+ "\t");	System.out.println();
	
	System.out.println("Применение пойманных групп ");
	// Группа, выделенная скобками(), называется пойманной и на нее можно дальше ссылаться
	regex = "\\w(\\d)-\\w\\1";		// Группа (\\d) является пойманной и цифра 1 ссылается на нее
	System.out.print("A2-B2 - " + "A2-B2".matches(regex)+ "\t");
	System.out.print("A2-Bd - " + "A2-Bd".matches(regex)+ "\t");	System.out.println();
	
 	System.out.println("Применение оператора OR ");
	regex = "(\\w\\d-\\w\\d)|(\\w-\\d\\w\\w)";		
	System.out.print("A2-B2 - " + "A2-B2".matches(regex)+ "\t");
	System.out.print("A2B-2 - " + "A-2B2".matches(regex)+ "\t");	System.out.println();
	System.out.println("Применение оператора OR с номером телефона");
	regex = "(\\(\\d{3}\\))?\\s?\\d{3}-\\d{4}";
	System.out.print("555-1234 - " + "555-1234".matches(regex)+ "\t");
	System.out.print("(559) 555-1234 - " + "(559) 555-1234".matches(regex)+ "\t");
	System.out.print("(559)555-1239 - " + "(559)555-1239".matches(regex)+ "\t");	System.out.println();
	
	
	
}					
}
        
        
  