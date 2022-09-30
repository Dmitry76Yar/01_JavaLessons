package f22_In_Out_Streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* 	Символьные потоки
 Байтовые потоки Java отличаются эффективностью и удобством использования. Но во всем, что касается ввода-вывода символов, они
 далеки от идеала. Для преодоления этого недостатка в Java определены классы символьных потоков.
	Потоки байтов в Java позволяют произвести ввод и вывод 8-битных байтов, в то время как потоки символов используются для ввода и вывода
16-битного юникода. Не смотря на множество классов, связанных с потоками символов, наиболее распространено использование следующих 
классов: FileReader и FileWriter. 
	Не смотря на тот факт, что внутренний FileReader использует FileInputStream, и FileWriter использует FileOutputStream, основное 
различие состоит в том, что FileReader производит считывание двух байтов в конкретный момент времени, в то время как FileWriter 
производит запись двух байтов за то же время.
			Методы, определенные в классе Reader
 - abstract void close ()	- Закрывает источник ввода. Дальнейшие лопытки чтения будут генерировать исключение IOException
 - void mark (int numChars) - Помещает в текущую позицию входного потока метку, которая будет находиться там до тех пор, пока не будет прочитано количество байтов, определяемое параметром numChars
 - boolean markSupported () - Возвращает значение true, если методы mark () и reset () поддерживаются вызывающим потоком
 - int read()				- Возвращает целочисленное представление следующего символа в вызывающем входном потоке. По достижении конца потока возвращается значение -1
 - int read(char buffer[])	- Пытается прочитать buffer.length символов в массив buffer, возвращая фактическое количество успешно 
 							  прочитанных символов. По достижении конца потока возвращается значение -1
 - abstract int read(char buffer[], int offset, int numChars) - Пытается прочитать количество символов, определяемое параметром numChars,
  							в массив buffer, начиная с элемента buffer[offset]. По достижении конца потока возвращается значение -1
 - int read (CharBuffer buffer)  - Пытается заполнить буфер, определяемый параметром buffer, и возвращает количество успешно 
 							прочитанных символов. По достижении конца потока возвращается значение -1.
 - boolean ready ()			- Возвращает значение true, если следующий запрос на получение символа может быть выполнен без ожидания. В противном случае возвращается значение false
 - void reset ()			- Сбрасывает входной указатель на ранее установленную метку 
 - long skip(long numChars) - Пропускает numChars символов во входном потоке, возвращая фактическое количество пропущенных символов
			
			Методы, определенные в классе Writer
 - Writer append (char ch)	- Добавляет символ ch в конец вызывающего выходного потока, возвращая ссылку но вызывающий поток
 - Writer append (CharSequencechars)	- Добавляет последовательность символов ch rs в конец вызывающего потока, возвращая ссылку на
  							вызывающий поток. CharSequence- это интерфейс, определяющий операции над последовательностями символов, 
  							выполняемые в режиме "только чтение"
 - Writer append (CharSequence chars, int begin, int еnd) - Добавляет последовательность символов chars в конец текущего потока,
							начиная с позиции, определяемой параметром begin, и заканчивая позицией, определяемой параметром end.
							Возвращает ссылку но вызывающий поток. CharSequence - это интерфейс, определяющий операции над 
							последовательностями символов, выполняемые 
 - abstract void close ()	- Закрывает выходной поток. Дальнейшие попытки чтения будут генерировать исключение IOException
 - abstract void flush ()	- Выполняет принудительную передачу содержимого выходного буфера в место назначения {тем самым очищая выходной буфер)
 - void write (int ch)		- Записывает один символ в вызывающий выходной поток. Обратите внимание но то, что параметр имеет тип int,
  							  что позволяет вызывать метод write () с выражениями, не приводя их к типу char
 - void write (char buffer[]) - Записывает полный массив символов buffer в вызывающий выходной поток
 - abstract void write (char buffer(], int offset, int numChars) -  Записывает часть массива символов Ьuffer в количестве numChars
  							                символов, начиная с элемента buffer[offset], в вызывающий выходной поток
 - void write(String str)	- Записывает строку str в вызывающий выходной поток
 - void write (String str, int offset, int numChars) - Записывает часть строки str в количестве numChars символов, начиная с позиции, 
 													определяемой параметром offset, в вызывающий поток	 */ 
/* 	Класс FileReader
    Является входным символьным потоком для работы с файлами (считывает файлы посимвольно)
 	FileReader является наследником класса InputStreamReader, который в свою очередь наследуется от Reader
 Reader  ->  InputStreamReader  ->  FileReader
  		Чаще всего используется следующая форма конструктора этого класса:
 - FileReader(String fileName) - Конструктор создает новый FileReader, учитывая имя файла для чтения. 
 - FileReader(File file) - Конструктор создает новый FileReader с учетом файла, который требуется прочитать.
 - FileReader(FileDescriptor fd) - Конструктор создает новый FileReader, с учетом FileDescriptor для чтения.
 		Методы:
 - public int read() throws IOException - Читает один символ. Возвращает int, который представляет прочитанный символ.
 - public int read(char [] c, int offset, int len) - Читает символы в массив. Возвращает количество прочитанных символов.
Если указанный файл не существует, генерируется исключение FileNotFoundException. 

	Класс FileWriter 
Является выходным символьным потоком для работы с файлами (записывает текст в файл посимвольно)
FileWriter является наследником класса OutputStreamWriter, который в свою очередь наследуется от Writer
 Writer  ->  OutputStreamWriter  ->  FileWriter
		Конструкторы данного класса: 
 - FileWriter(String fileName) -  Конструктор создает объект FileWriter, учитывая имя файла.
 - FileWriter(String fileName, boolean append) - Конструктор создает объект FileWriter с именем файла с логическим значением append.
 		Если append = true то данные записываются в конец файла, в противном случае запись осуществляется поверх существующих данных
 - FileWriter(File file) - Конструктор создает объект FileWriter для объекта File.
 - FileWriter(File file, boolean append) - Конструктор создает объект FileWriter, заданный объектом File с логическим значением apend
 - FileWriter(FileDescriptor fd) - Конструктор создает объект FileWriter, связанный с данным файловым дескриптором.
При возникновении ошибки в каждом из указанных конструкторов генерируется исключение IOException. 
		Список методов FileWriter (другие методы приходят от класса Writer)
 - public void write(int c) - Записывает один символ.
 - public void write(char [] c, int offset, int len) - Записывает часть массива символов, начиная с offset, длиной len.
 - public void write(String s, int offset, int len) - Напишите часть строки, начиная со смещения и длины len.
 
	Ниже пример по записи и затем чтения файла Copy1.txt   */

public class t14_FileReader_FileWriter {
public static void main(String[] args) {
			// Посимвольная запись строки с помощью FileWriter
	System.out.println("Посимвольная запись строки с помощью FileWriter началась");
	String str = "Recording with FileWriter char-by-char";
	try (FileWriter fwr = new FileWriter("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt")) {
		for (int i = 0; i<str.length(); i++) {
			fwr.write(str.charAt(i));
			System.out.print(str.charAt(i));}
		System.out.println("\nЗапись в файл завершена\n"); 
	}
	catch (FileNotFoundException e) {System.out.println("Файлы не найдены");}
	catch (IOException e2) { System.out.println("Ошибка ввода - вывода");} 
		
		// Построчная запись строки с помощью FileWriter
	System.out.println("Построчная запись строки с помощью FileWriter");
	String str1 = "Recording with \nFileWriter \string-by-string";
	try (FileWriter fwr1 = new FileWriter("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt")) {
		 fwr1.write(str1);
//		 System.out.print(str.charAt(i));}
		System.out.println("Запись в файл завершена\n");
	}
	catch (FileNotFoundException e) {System.out.println("Файлы не найдены");}
	catch (IOException e2) { System.out.println("Ошибка ввода - вывода");}
			
			// Посимвольное чтение строки из файла
	System.out.println("Посимвольное чтение строки из файла началось");
	int a = 0;
	try (FileReader fr = new FileReader("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt")) {
		while ((a = fr.read()) != -1) {
			System.out.print((char)a); }
		System.out.println("\nЧтение из файла завершено");
	}
	catch (FileNotFoundException e) {
		System.out.println("Файлы не найдены");
		e.printStackTrace();}
	catch (IOException e1) {
		System.out.println("Ошибка чтения или записи"); 
		e1.printStackTrace(); }
	}
}
