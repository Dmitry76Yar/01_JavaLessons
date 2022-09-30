package f22_In_Out_Streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/* FileReader и Scanner идут вместе
Не вдаваясь в подробности, запомните, что FileReader и Scanner идут вместе. Но не забывайте их "связать" 
		Методы Scanner
 - nextLine()   - это метод, который считывает строку (до ENTER), и возвращает это значение
 - hasNextLine() - метод, который возвращает boolean - true или false, показывая, есть ли следующая строка.
*/

public class t15_FileReader_with_Scanner {
public static void main(String[] args) {

		// Посимвольная запись строки с помощью FileWriter
	System.out.println("Посимвольная запись строки с помощью FileWriter началась");
	String str = "Recording \nwith FileWriter \nchar-by-char";
	try (FileWriter fwr = new FileWriter("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt")) {
		for (int i = 0; i<str.length(); i++) {
				fwr.write(str.charAt(i));
				System.out.print(str.charAt(i));}
	System.out.println("\nЗапись в файл завершена\n"); 
}
catch (FileNotFoundException e) {System.out.println("Файлы не найдены");}
catch (IOException e2) { System.out.println("Ошибка ввода - вывода");} 
	
		// Посимвольное чтение строки из файла
	System.out.println("Чтение строки из файла началось");
	try (FileReader fr = new FileReader("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt");
		Scanner scan = new Scanner(fr)) {
			// В отличии от FileWriter, FileReader не используется один:
			// Необходимо их связать, как указано выше
		while (scan.hasNextLine() == true) {
				// hasNextLine() - метод, который возвращает boolean - true или false, показывая, есть ли следующая строка.
			System.out.println(scan.nextLine()); }
				//  nextLine()   - это метод, который считывает строку (до ENTER), и возвращает это значение
		System.out.println("Чтение из файла завершено");
	}
	catch (FileNotFoundException e) {
		System.out.println("Файлы не найдены");
		e.printStackTrace();}
	catch (IOException e1) {
		System.out.println("Ошибка чтения или записи"); 
		e1.printStackTrace(); }
}
}