package f10_String;

public class t2_Methods_of_Comparison {
public static void main(String[] args) {
String s1 = new String("Strings");   String s0 = s1;
String s2 = "java";
String s3 = "effective";

		/******  СРАВНЕНИЕ СТРОК ******/
		/* matches() принимает регулярное выражение и возвращает true, если строка соответствует этому выражению.
В данном случае в регулярном выражение сначала определяется группа "(\\+*)". То есть вначале может идти знак плюса, но 
также он может отсутствовать. Далее смотрим, соответствуют ли последующие 11 символов цифрам. Выражение "\\d" представляет
цифровой символ, а число в фигурных скобках - {11} - сколько раз данный тип символов должен повторяться. То есть мы ищем строку,
где вначале может идти знак плюс (или он может отсутствовать), а потом идет 11 цифровых символов.  	 */
	System.out.println("\t matches()");
String input= "+79201056041";
boolean res = input.matches("(\\+*)\\d{11}");
if (res) System.out.println("Это номер телефона");
else System.out.println("Это не номер телефона");	System.out.println();

		/* boolean equals(): сравнивает строки с учетом регистра
Возвращает логическое значение true, если текущая строка содержит ту же последовательность символов, что и  строка str */ 
System.out.println("\t boolean equals (str)");
System.out.println("Строка  " + s0 + "    содержит те же символы, что и строка  " +s1+ "    - это  " + s1.equals(s0));
System.out.println("Строка  " + (s0+"1234")  + "    содержит теже символы, что и строка  " +s1+ "   - это  " + s1.equals(s0+"1234")); System.out.println();
	       
		// boolean equalsIgnoreCase(): сравнивает строки без учета регистра
System.out.println("\t boolean equalsIgnoreCase()");
String s10 = "JAVA"; 	String s11 = "java";
System.out.println("Строка  " + s10 + "    =  " +s11 + "    - это  " + s10.equalsIgnoreCase(s11));
System.out.println();
	     
		/* int compareTo (String str)   Возвращает отрицательное значение, если текущая строка меньше строки str;
	нуль, если эти строки ровны, и положительное значение, если текущая строка больше строки str  */
System.out.println("\t compareTo (String str)");
int result1 = s2.compareTo(s3); 
if (result1 < 0)  System.out.println("Строка  " + s2 + "   меньше строки    " + s3);
if (result1 == 0)  System.out.println("Строка  " + s2 + "   равна строке    " + s3);
if (result1 > 0)  System.out.println("Строка  " + s2 + "   больше строки    " + s3);	System.out.println();

		/* regionMatches(): сравнивает подстроки в строках
	Сравнивает строку s12 и s13, начиная с 3-го символа строки s12 и 1-го символа строки s13, длина символов сравнения - 3 */
	System.out.println("\t regionMatches(): сравнивает подстроки в строках");
	String s12 = "JAVA"; 	String s13 = "00JAVAISCOOL";	
	System.out.println(s12.regionMatches(1, s13, 3, 3));	System.out.println();

	}
}
