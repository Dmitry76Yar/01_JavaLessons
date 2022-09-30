package f22_In_Out_Streams;

import java.io.*;

/*		StringReader и StringWriter
 	StringReader - символьный поток ввода, наследник абстрактного класса Reader
 	StringWriter - символьный поток вывода, наследник абстрактного класса Writer
 Эти классы – это простейшие реализации абстрактных классов Reader и Writer. И практически аналоги FileReader и FileWriter.
 Но, в отличие от них, они работают не с данными в файле на диске, а со строкой (String) находящейся в памяти Java-машины.
 	Иногда такие потоки бывают полезными 
StringReader – это, фактически, переходник между классом String и Reader. 
А StringWriter – это строка, которая унаследована от Writer.

Ниже пример, где строка переворачивается задом-наперед через строки-потоки StringReader и StringWriter
  */

public class t18_StringReader_StringWriter {
	
public static void execute (Reader reader, Writer writer) throws IOException {
		// Иницилизируем поток 	BufferedReader, передав в конструктор строку-поток reader
	BufferedReader bfr = new BufferedReader(reader);
		// Иницилизируем строку line для записи строк из потока BufferedReader bfr 
	String line; 
	while ((line = bfr.readLine()) != null) {
			// Иницилизируем объект класса StringBuilder, чтобы появился метод reverse 
		StringBuilder sbr = new StringBuilder (line);
		String newLine = sbr.reverse().toString();	
			// Получили из потока строку, преобразовали в StringBuilder, перевернули, записали во writer
	writer.write(newLine);	}
}
public static void main(String[] args) throws IOException {
	String test = "Hi!\n My name is Richard\n I'm a photographer\n";
		// Иницилизируем строку-поток StringWriter writer для записи результата метода execute 
	StringWriter writer = new StringWriter();
	
		// Оборачиваем строку test в оболочку cтроки-потока StringReader 
	StringReader reader = new StringReader(test);
		// Запускаем метод в который передаем преобразованную строку и получаем результат writer 
	execute(reader, writer);
	System.out.println(writer.toString());
	}
}
