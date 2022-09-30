package f22_In_Out_Streams;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

class WorkWithFile {
	private String path;			// Переменная-путь к файлу
	private RandomAccessFile file;	// Экземпляр класса, который позволит работать с файлом 
	
	public WorkWithFile(String path) {	//Конструктор инициализирует путь к файлу
		this.path = path; 	}

		// Метод демонстрирует переход на указанный символ
	public long goTo (int num) {
		long pointer = 0;
		try { file = new RandomAccessFile(path, "r"); } 	// инициализируем класс RandomAccessFile, в параметры передаем путь к файлу
		catch (FileNotFoundException e) {					// и модификатор который говорит, что файл откроется только для чтения
			e.printStackTrace();
			System.out.println("Файл не найден"); } 	 
		// переходим на num символ	
		try {
			file.seek(num);
				// получаем текущее состояние курсора в файле
			pointer = file.getFilePointer();}
		catch (IOException e) { System.out.println("Ошибка чтения файла"); }
		try {
			file.close();}
		catch (IOException e) {System.out.println("Ошибка закрытия файла"); }
			return pointer;}
	
		// Метод чтения файла и записи его в строку
	public String read( ) {
		String result = "";
		int b = 0;
		try { file = new RandomAccessFile(path, "r"); } 	// инициализируем класс RandomAccessFile, в параметры передаем путь к файлу
		catch (FileNotFoundException e) {					// и модификатор который говорит, что файл откроется только для чтения
			e.printStackTrace();
			System.out.println("Файл не найден"); }
		try {
			while (b!=-1) {
				b = file.read();
				result = result + (char)b;}}
		catch (IOException e) { System.out.println("Ошибка чтения файла"); }
		try {
			file.close();}
		catch (IOException e) {System.out.println("Ошибка закрытия файла"); }
			return result;}
	
		// Метод чтения файла с определенного символа и записи его в строку
	public String readFrom (int numberSymbol) {
		String result = "";
		int b = 0;
		try { file = new RandomAccessFile(path, "r"); } 	
		catch (FileNotFoundException e) {					
			e.printStackTrace();
			System.out.println("Файл не найден"); }
		try {
				// ставим указатель на нужный вам символ
			file.seek(numberSymbol);
			while (b!=-1) {
				b = file.read();
				result = result + (char)b;}}
		catch (IOException e) { System.out.println("Ошибка чтения файла"); }
		try {
			file.close();}
		catch (IOException e) {System.out.println("Ошибка закрытия файла"); }
			return result;}

		// Метод записи в файл строки
	public void write (String str) {
		try { file = new RandomAccessFile(path, "rw"); } 	// открываем файл для записи, для этого указываем модификатор rw (read & write)
		catch (FileNotFoundException e) {					
			e.printStackTrace();
			System.out.println("Файл не найден"); }
			// записываем строку переведенную в биты
		try {
			file.write(str.getBytes());}
		catch (IOException e) { System.out.println("Ошибка записи в файл"); }
		try {
			file.close();}
		catch (IOException e) {System.out.println("Ошибка закрытия файла"); }
	}
}
		
public class t21_RandomAccessFile_Exam {
public static void main(String[] args) {
		// создаем экземпляр класса что мы создали
	WorkWithFile worker; 
		// инициализируем класс передавая в него путь к файлу
	worker = new WorkWithFile("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Data1");
	
		// пишем передаваемый текст в файл
	worker.write("Give me a break from your take and your take. \n" +
            "Come on and give me a break,\n" +
            "what do you want from me?\n" +
            "Feeding the rich with that son of a bitch.\n" +
            "Well that son of a bitch,\n" +
            "he looks just like me!\n" +
            "Yeah, yeah");
	
		// переходим на указанный символ в файле
    System.out.println(worker.goTo(100));
    System.out.println("*******");	

    	// читаем весь файл
    System.out.println(worker.read());
    System.out.println("*******");
    
    	// читаем файл с указанного символа
    System.out.println(worker.readFrom(105));
	
	}
}
