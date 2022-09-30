package f22_In_Out_Streams;

public class t03_FileStream_Command_string {
public static void main(String[] args) {
	/*args — это массив входных параметров, передаваемых при запуске программы. 
	args[0] - выводит первое слово при введении из командной строки,   args[1] - выводит второе слово 	*/ 
   try { System.out.println("Hello, " + args[0]); } 
   catch (Exception e) { 
		e.printStackTrace();
		System.out.println("Не было введенно ни одного аргумента (слова)");	}
   // Если не передать никакой аргумент, мы  получим ошибку в ПОТОКЕ main: Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0     */
    
    /* Скомпилируем из командной строкиc: javac t03_FileStream_Command_string.java 
  (Для выбора нужной директории в командной строки набираем cd C:...скопировать полный адрес до файла...  cd - change directory) 
            C:\Users\dkuli\Documents\My_works\Lessons\src\f22_In_Out_Streams> javac t03_FileStream_Command_string.java
           
  Затем вызовем наш код с каким-нибудь параметром, например, Roger   - java HelloWorldApp Roger   
  (Нужно вернуться на уровень папки и вызвать имя класса с пакетом: java f22_Threads.t01_Args_in_command_string Roger 
            C:\Users\dkuli\Documents\My_works\Lessons\src>java f22_In_Out_Streams.t03_FileStream_Command_string Roger 	   */
        
    
}
}
