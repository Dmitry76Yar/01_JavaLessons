package f22_In_Out_Streams;
/* Поскольку файлы в большинстве современных операционных систем понимаются как последовательность байтов, для файлового ввода/вывода
  создаются байтовые потоки с помощью классов Fiieinputstream и FiieOutputstream. Это особенно удобно для бинарных файлов, хранящих
  байт-коды, архивы, изображения, звук.
 	Но очень много файлов содержат тексты, составленные из символов. Несмотря на то, что символы могут храниться в кодировке Unicode, 
  эти тексты чаще всего записаны в байтовых кодировках. Поэтому и для текстовых файлов можно использовать байтовые потоки.
  В таком случае со стороны программы придется организовать преобразование байтов в символы и обратно.  */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class t04_FileOutputStreams {
public static void main(String[] args) {
	
	FileOutputStream fos = null;   	FileOutputStream fos1 = null;
	
	/*	Чтобы открыть файл для записи, следует создать объект типа FileOutputStream
	 	Существует 2 конструктора:
	FileOutputStream(String имя_файла) throws FileNotFoundException
	FileOutputStream(String имя_файла, boolean append) throws FileNotFoundException
	В случае невозможности создания файла возникает исключение FileNotFoundException. Если файл с указанным именем уже существует, то 
в тех случаях, когда используется первая форма конструктора, этот файл удаляется.  */
	
	try {fos = new FileOutputStream("FileOut.txt"); } // Файл FileOut.txt создается в папке C:\Users\dkuli\Documents\My_works\Lessons
	catch (FileNotFoundException e) { 
		System.out.println("Ошибка создания файла");
		e.printStackTrace(); }
		
	/* FileOutputStream(String имя_файла, boolean append) отличается от FileOutputStream(String имя_файла) наличием append.
	Если append== true, то записываемые данные добавляются в конец файла. В противном случае старые  данные в файле перезаписываются новыми.  */
	
	try {fos1 = new FileOutputStream("FileOut1.txt", true); } 
	catch (FileNotFoundException e) { 
		System.out.println("Ошибка создания файла");
		e.printStackTrace(); }
	
	/* Для записи данных в файл вызывается метод write (). Наиболее простая - void write(int byteval) throws IOException 
Данный метод записывает в поток байтовое значение, передаваемое с помощью параметра byteva 1. Несмотря на то что этот параметр 
объявлен как int, учитываются только младшие 8 бит его значения. Если в процессе записи возникает ошибка, генерируется исключение IOException. */ 
	
	String input = "abcdefghikl";
	
	try { 
		for (int i = 0; i<input.length(); i++)  fos.write(input.charAt(i));	}		// Запись в файл
	catch (IOException e) {
		System.out.println("Ошибка записи в файл");
		e.printStackTrace();}
		
	 /*     Важно, что  close () находится в блоке finally. Данный способ имеет то преимущество, что в случае аварийного завершения программы
    из-за возникновения исключения, не связанного с операциями ввода-вывода, файл все равно будет закрываться в блоке finally.*/
	finally {
		try {fos.close(); }
		catch (IOException e2) {
			System.out.println("Ошибка закрытия в файл");
			e2.printStackTrace();}
	}
	
	System.out.println("Main завершен успешно");
	
	}
}
 