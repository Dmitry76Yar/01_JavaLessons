package f23_Scanner;

import java.io.IOException;

/* Для чтения символа с клавиатуры достаточно вызвать метод System. in. read () , где
   System. in - объект ввода (с клавиатуры), дополняющий объект вывода System. out.
   Метод read () ожидает нажатия пользователем клавиш, после чего возвращает результат. */

public class t05_System_in_Guess_the_Symbol {
public static void main(String[] args) {
	char Target = '9';
	char A='2';
	char ignore = '2';
do {        
	try {
	    System.out.println("Введите цифру от 1 до 10, а затем клавишу ENTER: ");  
	    A = (char)System.in.read(); }
	catch (IOException e) {
	     e.getStackTrace(); }
	
    	/* Отбросить все остальные символы во входном буфере,а именно символ Enter, который мы нажимаем для ввода цифры
	Нажатие на <Enter> приводит к формированию последовательности символов перевода строки и возврата каретки. Эти символы
	сохраняются во входном буфере вместе с введенными с клавиатуры.  
		Если вместо 3 ввести случайно 333, то цикл выполнится 3 раза для символа 3. 
    Цикл ignore присваивает переменной ignore все символы пока не дойдем до конца строки
    Присваивание символов ignore означает, что они считаны из буфера, а значит очистились из System.in.read(); */
	
	do{
	   try {ignore = (char)System.in.read(); } 
	   catch (IOException e) {e.printStackTrace();} 	   }
	while (ignore != '\n');

	if (A == Target) System.out.println("\t Вы угадали загаданное число");
	else System.out.println("\t Неправильно, попробуйте еще раз");
}
	while (A != Target);

}
}
