package f10_String;

import java.util.Arrays;

public class t2_Methods_of_transformation {
public static void main(String[] args) {
String s2 = "java";
String s3 = "effective";

    
		/******  ПРЕОБРАЗОВАНИЯ СТРОК *******/
		//Метод toCharArray() преобразовывает строку в массив символов
	System.out.println("\t toCharArray()");
	char Array[] = s2.toCharArray();
	System.out.print(Array);		System.out.println("\t" + Array[0]); System.out.println();

		// concat(): объединяет строки
	System.out.println("\t concat(): объединяет строки");
	String s7 = s2.concat(s3);
	System.out.println(s7);	System.out.println();

		// trim(): удаляет начальные и конечные пробелы
	System.out.println("\t trim(): удаляет начальные и конечные пробелы");
	String s23 = "  MAMA  ";
	System.out.println(s23.trim());	System.out.println();

		// replace(oldChar, newChar): заменяет в строке одну подстроку на другую
	System.out.println("\t replace(oldChar, newChar) : заменяет в строке одну подстроку на другую");
	String s18 = "1222223456789";
	String s19 = s18.replace('2', '0');
	System.out.println(s19);	System.out.println();	// Result - 1000003456789

		//replace(String SequenceTarget, String SequenceReplacement): заменяет в строке одну последовательность символов на другую
	System.out.println("\t replace(char SequenceTarget, char SequenceReplacement)");
	s18 = "10022200222003456789";
	String s20 = s18.replace("222", "__");
	System.out.println(s20);	System.out.println();  // Result - 100__00__003456789

		// replaceAll(String regex, Sting replacement) - заменяет все подстроки в строке на другую
	System.out.println("\t replaceAll(String regex, Sting replacement)");
	s18 = "10022200222003456789";
	String s21 = s18.replaceAll("222", "__");
	System.out.println(s21);	System.out.println();  // Result - 100__00__003456789

		//replaceFirst(String FirstRegex, Sting replacement)  - заменяет 1-ую подстроки в строке на другую
	System.out.println("\t replaceFirst(String FirstRegex, Sting replacement)");
	s18 = "10022200222003456789";
	String s22 = s18.replaceFirst("222", "__");
	System.out.println(s22);	System.out.println();  // Result - 100__00222003456789

		//Статический метод класса String   join(): соединяет строки с учетом разделителя
	System.out.println("\t join(): соединяет строки с учетом разделителя");
	String s8 = String.join("-", s2, s3);
	System.out.println(s8);	System.out.println();

		//Статический метод класса String  valueOf(): преобразует объект в строковый вид
	System.out.println("\t valueOf(): преобразует объект в строковый вид");
	Integer a = new Integer(8888);
	String s9 = String.valueOf(a);
	System.out.println(s9.concat(" - is a String"));	System.out.println();

		//toUpperCase() переводит все символы строки в нижний регистр
	System.out.println("\t toUpperCase() переводит все символы строки в нижний регистр");
	String s25 = "i_love_java";
	System.out.println(s25.toUpperCase());		System.out.println();

		//toLowerCase() переводит все символы строки в нижний регистр
	System.out.println("\t toLowerCase() переводит все символы строки в нижний регистр");
	String s26 = "I-LOVE-JAVA";
	System.out.println(s26.toLowerCase());		System.out.println();

		// split() позволяет разбить строку на подстроки по определенному разделителю
	System.out.println("\t  split() позволяет разбить строку на подстроки по определенному разделителю");
	String s27 = "I LOVE JAVA";
	String Array3[] = s27.split(" ");
	System.out.println("Array3[0] = " + Array3[0]);	
	System.out.println("Array3[1] = " + Array3[1]);	System.out.println();
	
	System.out.println("Для разделения через точку нужно использовать \\.");
	String s29 = "I.LOVE.JAVA";
	String Array5[] = s29.split("\\.");
	System.out.println(Arrays.toString(Array5));

		/* split() Регулярное выражение "\\s*(\\s|,|!|\\.)\\s*"
	Подвыражние "\\s" по сути представляет пробел. Звездочка указывает, что символ может присутствовать от 0 до бесконечного
	количества раз. То есть добавляем звездочку и мы получаем неопределенное количество идущих подряд пробелов - "\\s*" (то есть 
	неважно, сколько пробелов между словами). Причем пробелы может вообще не быть. В скобках указывает группа выражений, которая
	может идти после неопределенного количества пробелов. Группа позволяет нам определить набо значений через вертикальную черту,
	и подстрока должна соответствовать одному из этих значений. То есть в группе "\\s|,|!|\\." подстрока может соответствовать 
	пробелу, запятой, восклицательному знаку или точке. Причем поскольку точка представляет специальную последовательность, то, 
	чтобы указать, что мы имеем в виду имеено знак точки, а не специальную последовательность, перед точкой ставим слеши. */
	System.out.println("\t  split() Регулярное выражение для разделения через пробелы");
	String s28 = "FIFA will never regret it";
	String Array4[] = s28.split("\\s*(\\s|,|!|\\.)\\s*"); //  "\\s" - пробел
	for(String each : Array4) System.out.println(each + "  "); System.out.println();


	}

}
