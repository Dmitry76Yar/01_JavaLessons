package f22_In_Out_Streams;
/* В этой программе данные разных типов сначала записываются в файл, а затем читаются из него.
 	Классы DataInputStream и DataOutputStream - работа с потоками примитивных типов (int, double,...)
 	Эти классы относятся к классам, управляющим потоком - они получают в своих конструкторах уже имеющийся поток и создают новый,
преобразованный поток. Можно представлять их себе как "переходное кольцо", после которого идет труба другого диаметра.

* В примерах раньше читались и записывались байтовые значения, содержащие символы в коде ASCII. Но аналогичным образом можно
организовать чтение и запись любых типов данных. Допустим, требуется создать файл, содержащий int, douЫe или short. 
Для чтения и записи простых типов данных в Java предусмотрены классы DatainputStream и DataOutputStream. 
	Класс DataOutputStream реализует интерфейс DataOutput, в котором определены методы, позволяющие записывать в файл значения любых 
примитивных типов. Следует, однако, иметь в виду, что данные записываются во внутреннем двоичном формате, а не в виде последовательности 
символов. 			При возникновении ошибки ввода- вывода каждый из них может генерировать исключение IOException.
	Методы DataOutputStream, наиболее часто применяемые для записи простых типов данных: 
- void writeBoolean (boolean va 1)  - Записывает логическое значение, определяемое параметром val
- void writeByte (int val) - Записывает младший байт целочисленного значения, определяемого параметром val
- void writeChar (int val) - Записывает значение, определяемое параметром val, интерпретируя его как символ
- void writeDouЬle(douЫe val) - Записывает значение типа douЫe, определяемое параметром val
- void writeFloat(float val) - Записывает значение типа float, определяемое параметром val
- void writeint (int val) - Записывает значение типа int, определяемое параметром val
- void writeLong(long val) - Записывает значение типа long, определяемое параметром val
- void writeShort (int val) - Записывает целочисленное значение, определяемое параметром val, преобразуя его в тип short
	Класс DatainputStream реализует интерфейс Datainput, предоставляющий методы для чтения всех примитивных типов данных Java 
При возникновении ошибки ввода-вывода каждый из них может генерировать исключение IOException.  В потоке типа DatainputStream
данные читаются в двоичном виде, а не в удобной для чтения форме. 
	Методы DatainputStream, наиболее часто применяемые для записи простых типов данных:
- boolean readBoolean () - Читает значение типа boolean
- byte readByte () 	- Читает значение типа byte
- char readChar () 	- Читает значение типа char
- douЫe readDouble () 	- Читает значение типа double
- float readFloat ()	- Читает значение типа float
- int readint ()		- Читает значение типа int
- long readLong ()		- Читает значение типа long
- short readShort ()	- Читает значение типа short */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class t08_DataInputStream_DataOutStream {
public static void main(String[] args) {
		/* Конструктор класса DatainputStream-  DatainputStream(InputStream inputStream)
	где inputStream - это поток, связанный с создаваемым экземпляром класса DataInputStream.
	Чтобы организовать чтение данных из файла, следует передать конструктору inputStream объект типа FileinputStream. */
		/* Конструктор класса DataOutputStream - DataOutputStream(OutputStream outputStream)
	 Обратите внимание на то, что при вызове ему передается экземпляр класса OutputStream. 	
	 Здесь outputStream - выходной поток, в который записываются данные. Для того чтобы организовать запись данных в файл, следует
	 передать конструктору в качестве параметра outputStream объект типа FileOutputStream.  */
	
	int i = 10;
	double d = 1023.56;
	boolean b = true;
			
try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\DataIn"))) {
	System.out.println("Записано в файл DataIn Int значение i");
		dataOut.writeInt(i);
	System.out.println("Записано в файл DataIn double значение d");
		dataOut.writeDouble(d);
	System.out.println("Записано в файл DataIn boolean значение b");
		dataOut.writeBoolean(b);
		}
catch (FileNotFoundException e) {
	System.out.println("Файлы не найдены"); }
catch (IOException e) {
	System.out.println("Ошибка записи"); }

try (DataInputStream dataIn = new DataInputStream(new FileInputStream("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\DataIn.txt"))){
	System.out.println("Прочитано Int значение  " + dataIn.readInt());
	System.out.println("Прочитано double значение  " + dataIn.readDouble());
	System.out.println("Прочитано boolean значение  " + dataIn.readBoolean());
	}
catch (FileNotFoundException e) {
	System.out.println("Файлы не найдены"); }
catch (IOException e) {
	System.out.println("Ошибка записи"); }
		
System.out.println("Main завершен успешно");
	
	
	}

}


