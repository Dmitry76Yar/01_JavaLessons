package f23_Scanner;

import java.util.Scanner;

/* Другой способ преобразования числовой строки в ее внутреннее представление в двоичной форме состоит в использовании одного 
 из методов, определенных в классе Scanner из пакета java. util. 
 	Этот класс, реализованный в версии JDK 5, читает данные, вводимые в удобном для чтения виде, преобразуя их в двоичную форму.
Средствами класса Scanner можно организовать чтение данных, вводимых из самых разных источников, в том числе с консоли и из файлов
Следовательно, его можно использовать для чтения числовой строки, введенной с клавиатуры, присвоив полученное значение переменной.
	Для организации ввода с клавиатуры средствами класса Scanner необходимо сначала создать объект этого класса, связанный с 
потоком ввода с консоли. Для этой цели служит следующий конструктор: Scanner(InputStream from)
	Этот конструктор создает объект типа Scanner, который использует поток ввода, определяемый параметром from, в качестве
 источника ввода данных. С помощью этого конструктора можно создать объект типа Scanner, связанный с потоком ввода с консоли, 
 	Это оказывается возможным благодаря тому, что поток System. in является объектом типа InputStream.   */

public class t01_Scanner_for_Digital_Input {
public static void main(String[] args) {
double a = 0.0;	  
       		// Создание объекта Scanner, связанного с потоком чтения с консоли
Scanner sc1 = new Scanner(System.in);
System.out.println("Введите Double число");
       		/* Методы hasNextInt(), hasNextDouble()
       Данные методы hasNext___ возвращают логическое значение true, если очередной элемент данных, имеющийся в потоке ввода, 
       относится к нужному типу данных, а иначе - логическое значение false. */ 
if (sc1.hasNextDouble() == true)
       				
       		/* Методы nextInt(), nextDouble()
       Читают данные заданного типа. Эти методы преобразуют данные соответствующего типа из удобной для чтения формы во 
       внутреннее их представление в двоичном виде, возвращая полученный результат.
       Если методу из группы next не удастся обнаружить данные искомого типа, то он сгенерирует исключение InputMismatchException.
       Поэтому лучше сначала воспользоваться методом hasNext  */
a = sc1.nextDouble(); 
else {System.out.println("извините, но это явно не число. Перезапустите программу и попробуйте снова!");}
System.out.println("Вы ввели число " + a);
        	// Как и любой поток, объект Scanner также нужно закрывать
sc1.close();
    }
}
        
        
  