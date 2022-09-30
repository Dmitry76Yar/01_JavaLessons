package f01_Converts;
public class t2_String_to_int { 
public static void main(String args[]) {
	// String to int
	String MyString = "100";
	
/*	int i = Integer.parseInt (MyString);
 Если строка, обозначенная переменной myString, является допустимым целым числом, например «1», «200», Java спокойно преобразует её в
примитивный тип данных int. Если по какой-либо причине это не удается, подобное действие может вызвать исключение NumberFormatException,
 поэтому чтобы программа работала корректно для любой строки, нам нужно немного больше кода. */

try
    {
      // именно здесь String преобразуется в int
      int i = Integer.parseInt(MyString.trim());
      // выведем на экран значение после конвертации
      System.out.println("int i = " + i);
    }
    catch (NumberFormatException nfe)
    {
      System.out.println("NumberFormatException: " + nfe.getMessage());
    }
}
}
	