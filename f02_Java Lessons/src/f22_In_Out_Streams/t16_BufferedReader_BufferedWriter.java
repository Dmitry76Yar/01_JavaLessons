package f22_In_Out_Streams;
/*  Класс BufferedReader - входной поток символьного типа, наследник класса Reader 
 	BufferedReader читает текст из потока ввода символов, буферизуя прочитанные символы, чтобы обеспечить эффективное считывание 
 символов, массивов и строк. Можно указать в конструкторе вторым параметром размер буфера.
 		Конструкторы: 
 - BufferedReader(Reader in)  - Создает буферный поток ввода символов, который использует размер буфера по умолчанию.
 - BufferedReader(Reader in, int sz) - Создает буферный поток ввода символов, который использует указанный размер.
 		Методы
  - close() - закрыть поток
  - mark(int readAheadLimit) -  отметить позицию в потоке
  - markSupported() -  поддерживает ли отметку потока
  - int read() - прочитать буфер
  - int read(char[] cbuf, int off, int len) - прочитать буфер
  - String readLine() - следующая строка
  - boolean ready() - может ли поток читать
  - reset()  - сбросить поток
  - skip(long n) - пропустить символы
  
    Класс BufferedWriter - выходной поток символьного типа, наследник класса Writer
    FileWriter сразу записывает данные на диск и каждый раз к нему обращается, BufferedWriter работает как обертка и ускоряет работу
приложения.  Буфер будет записывать данные в себя, а потом большим куском файлы на диск.
	BufferedWriter записывает текст в поток вывода символов, буферизуя записанные символы, чтобы обеспечить эффективную 
запись символов, массивов и строк. Можно указать в конструкторе вторым параметром размер буфера.
		Конструкторы:
 - BufferedWriter(Writer out) - Создает буферный поток вывода символов, который использует размер буфера по умолчанию.
 - BufferedWriter(Writer out, int sz) - Создает буферный поток вывода символов, который использует указанный размер.
		Методы: 
 - сlose()  - закрыть поток
 - flush() - передать данные из буфера во Writer
 - newLine() - перенос на новую строку
 - write(char[] cbuf, int off, int len) - запись в буфер
 - write(int c) - запись в буфер
 - write(String s, int off, int len) - запись в буфер
  
  */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class t16_BufferedReader_BufferedWriter {
public static void main(String[] args) {
			// Построчная запись строки с помощью BufferedWriter
	System.out.println("Построчная запись строки с помощью BufferedWriter началась");
	String str = "Recording with BufferedWriter";
	try (BufferedWriter bfr = new BufferedWriter(new FileWriter("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt"))) {
		// Для потока FileWriter создается оболочка BufferedWriter
		bfr.write(str);
		System.out.print(str);
		System.out.println("\nЗапись в файл завершена\n"); 
	}
	catch (FileNotFoundException e) {System.out.println("Файлы не найдены");}
	catch (IOException e2) { System.out.println("Ошибка ввода - вывода");} 
		
			// Чтение из файла с помощью BufferedReader
	System.out.println("Чтение из файла с помощью BufferedReader началось");
	try (BufferedReader fr = new BufferedReader(new FileReader("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt"))) {
		// Для потока FileReader создается оболочка BufferedReader, который имеет метод readLine()
		int i = 0;
		while ((str  = fr.readLine())!= null) {
			System.out.print(str + i);
			i++;}
		}
	catch (FileNotFoundException e) {
		System.out.println("Файлы не найдены");
		e.printStackTrace();}
	catch (IOException e1) {
		System.out.println("Ошибка чтения или записи"); 
		e1.printStackTrace(); }
			
	System.out.println(("\nВыход из программы"));

	}

}
