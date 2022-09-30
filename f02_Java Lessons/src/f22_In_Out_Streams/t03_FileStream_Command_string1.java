package f22_In_Out_Streams;
/* Пример программы, в которой метод read () используется для получения отображения содержимого текстового файла.
  	Имя файла указывается в командной строке при запуске программы. 
  	Ошибки ввода-вывода обрабатываются с помощью блока try/catch.
  Байтовые потоки, связанные с файлами, создаются с помощью классов FilelnputStream или FileOutputStream. Чтобы открыть файл, 
достаточно создать объект одного из этих классов, передав конструктору имя файла в качестве параметра. Открытие файла
необходимо для того, чтобы с ним можно было выполнять файловые операции чтения  и записи.
  FilelnputStream - наследник класса InputStream,  FileOutputStream  - наследник класса OutputStream  
*/

import java.io.*;

public class t03_FileStream_Command_string1 {
public static void main(String[] args) {
	/*args — это массив входных параметров, передаваемых при запуске программы. 
	args[0] - выводит первое слово при введении из командной строки,   args[1] - выводит второе слово 	*/ 
		
	// Прежде всего необходимо убедиться в том, что программе передается имя файла
	System.out.println("Введите java f22_In_Out_Streams.t03_FileStream_Command_string1 ИМЯ ФАЙЛА и нажмите Enter");
	if (args.length !=1) {
		System.out.println("Вы не ввели или не правильно ввели имя файла (д.б. одно слово)");
		return;}

	// Чтобы открыть файл для чтения нужно создать объект типа FileInputStream
   FileInputStream fis = null;					// Инициализация ссылки на поток
   int i = 0;
   
   try { 
	   fis = new FileInputStream(args[0]);		// Открыть файл. Если файл не найден, то будет FileNotFoundException
   do {
	   i = fis.read();
	   if(i!=-1) System.out.print((char)(i));}		// Значение -1 означает достижение конца файла. При сбое - IOException
   while (fis.available() !=0);}
   catch (FileNotFoundException e) {
	   System.out.println("Файл не найден");}
   catch (IOException e) {
	   System.out.println("Ошибка ввода - вывода"); }

   /* Обратите внимание на то, что файловый поток закрывается после чтения данных. 
    Важно, что  close () находится в блоке finally. Данный способ имеет то преимущество, что в случае аварийного завершения программы
    из-за возникновения исключения, не связанного с операциями ввода-вывода, файл все равно будет закрываться в блоке finally.
    	Переменная fis инициализируется значением null. В блоке finally файл закрывается только в том случае, если значение переменной 
    fis не равно null. fis не содержит значение null лишь в том случае, если файл был успешно открыт.      */ 
      finally {
   try {
	   if (fis != null) fis.close(); } 
   catch (IOException e1) {
	e1.printStackTrace(); 
	System.out.println("Ошибка закрытия файла");}
   }
      
    /* Скомпилируем из командной строкиc: javac t03_FileStream_Command_string.java 
  (Для выбора нужной директории в командной строки набираем cd C:...скопировать полный адрес до файла...  cd - change directory) 
            C:\Users\dkuli\Documents\My_works\Lessons\src\f22_In_Out_Streams> javac t03_FileStream_Command_string1.java
           
  		Затем вызовем наш код с название файла     
  (Нужно вернуться на уровень папки src и вызвать имя класса с пакетом: java f22_Threads.t01_Args_in_command_string FileIn.txt 
            C:\Users\dkuli\Documents\My_works\Lessons\src>java f22_In_Out_Streams.t03_FileStream_Command_string1 FileIn.txt 	
         ФАЙЛ ДОЛЖЕН БЫТЬ РАЗМЕЩЕН В ПАПКЕ SRC   */
   	
	}
}
