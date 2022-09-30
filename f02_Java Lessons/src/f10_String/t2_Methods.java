package f10_String;

public class t2_Methods {
    public static void main (String [] args) {
        // Варианты создания строковых объектов
    String s1 = new String("Strings");   String s0 = s1;
    String s2 = "java";
    String s3 = "effective";
    String s4 = (s1 + "  " + s2 + "  " + s3);
    char ch;      int result;
    
     // int length()     Возвращает длину строки    
result = s3.length(); 

				/******  ВОЗВРАЩАЕТ ЧАСТЬ СТРОКИ *******/
	// substring(int StartIndex): возвращает подстроку, начиная с определенного индекса StartIndex до конца
System.out.println("\t substring(int StartIndex): возвращает подстроку, начиная с определенного индекса до конца");
System.out.println(s3.substring(3));	System.out.println();    

	// substring(int StartIndex, int EndIndex): возвращает подстроку, начиная с StartIndex до EndIndex
System.out.println("\t substring(int StartIndex, int EndIndex): возвращает подстроку, начиная с StartIndex до EndIndex");
System.out.println(s3.substring(2,5));	System.out.println(); 

    // char charAt(index)    getChars(): возвращает группу символов c 0 по 3 индексы в массив с 0 элемента
System.out.println("\t getChars(): возвращает группу символов");
int StartIndex = 0;
int EndIndex = 3;
char Array1[] = new char[EndIndex - StartIndex];
s2.getChars(StartIndex, EndIndex, Array1, 0);
System.out.println(Array1); 	System.out.println();    

				/******  ПРОВЕРКА СТРОК *******/
	// isEmpty() - проверяет строку на пустоту. Если строка пуста, он возвращает true:
System.out.println("\t isEmpty()");
String s5 = ""; 
System.out.println("is s5 empty? -  " + s5.isEmpty());	System.out.println();

	// Проверка строки на null. Для null строк нельзя вызывать меоды - ошибка
System.out.println("\t Проверка строки на null");
String s6 = null;
if(s6==null) System.out.println("String is null");	System.out.println();

				
					

    }
}