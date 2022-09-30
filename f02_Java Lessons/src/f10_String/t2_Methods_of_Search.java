package f10_String;

public class t2_Methods_of_Search {
public static void main(String[] args) {
String s1 = new String("Strings");   
String s2 = "java";
String s3 = "effective";
String s4 = (s1 + "  " + s2 + "  " + s3);
int result1;
    
		/******  ПОИСK СТРОК ****/
		/* int indexOf(String str) находит индекс первого вхождения подстроки str в строку s4
	Возвращает индекс первого вхождения подстроки s tr или -1, если поиск завершается неудачно */
	System.out.println("\t indexOf(String str)");
	result1 = s4.indexOf(s2); 
	if (result1 != -1)  System.out.println("индекс 1-го вхождения строки  " + s2 + "  в строку   " + s4 +"   =   " + result1);
	if (result1 == -1)  System.out.println("поиск завершается неудачно");	System.out.println();
	        
	    /* int lastIndexOf (String str)   Производит в текущей строке поиск подстроки, определяемой параметром str. 
	Возвращает индекс последнего вхождения подстроки s t r или -1, если поиск завершается неудачно */ 
	System.out.println("\t lastIndexOf (String str)");
	result1 = s4.lastIndexOf(s2); 
	if (result1 != -1)  System.out.println("индекс последнего вхождения строки  " + s2 + "  в строку   " + s4 +"   =   " + result1);
	if (result1 == -1)  System.out.println("поиск завершается неудачно");	System.out.println();
	   
		// boolean startsWith(String str): определяет, начинается ли строка с подстроки 
	System.out.println("\t boolean startsWith(String str): определяет, начинается ли строка с подстроки ");
	String s14 = "123456789";
	String s15 = "123";		String s16 = "234"; 
	System.out.println(s14.startsWith(s15));
	System.out.println(s14.startsWith(s16)); 	System.out.println();

		//boolean startsWith(String str, int a): определяет, начинается ли строка с подстроки c символа с инжексом а
	System.out.println("\t boolean startsWith(String str, int a): определяет, начинается ли строка с подстроки ");
	System.out.println(s14.startsWith(s16, 0));
	System.out.println(s14.startsWith(s16, 1)); 	System.out.println();
		
		//boolean endsWith(String str): определяет, заканчивается ли строка на определенную подстроку  
	System.out.println("\t boolean endsWith(String str): определяет, заканчивается ли строка на определенную подстроку ");
	s14 = "123456789";
	String s17 = "789";		 
	System.out.println(s14.endsWith(s17));	System.out.println();

	}

}
