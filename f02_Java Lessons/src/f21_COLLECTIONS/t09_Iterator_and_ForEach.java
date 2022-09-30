package f21_COLLECTIONS;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/*	 А как вывести список всех элементов HashSet и других коллекций на экран? Ведь методов get() и set() у множества нет!
 * 
Итератор — это специальный объект у коллекции, который помогает обойти все элементы коллекции и не повторяться.
Получить итератор у любой коллекции можно с помощью кода:
	Iterator<Тип> it = имя.iterator();   
Где имя — это имя переменной-коллекции, Тип — это тип элементов коллекции. iterator() — это метод коллекции. 
it — это имя переменной-объекта-итератора.
	У объекта-итератора есть 3 метода:
- next() - возвращает очередной элемент коллекции 
- boolean hasNext() - проверяет, есть ли еще не пройденные элементы
- void remove()  - удаляет текущий элемент коллекции
Основной минус итератора в том, что с его использованием код получается еще более громоздким, чем с использованием цикла for-each.
Да, элементы списка ArrayList гораздо лучше обходить с помощью цикла for-each — все короче получается.
	Важно!
У цикла for-each есть один минус: он не умеет правильно удалять элементы.
Есть три способа обойти это ограничениe - смотри ниже 
*/

public class t09_Iterator_and_ForEach {
public static void main(String[] args) {
	HashSet<String> set = new HashSet<String>();
	set.add("Привет");			set.add("Hello");			set.add("Hola");
	set.add("Bonjour");			set.add("Cialo");			set.add("Namaste");
	
		// Получаем объект-итератор у множества set, пока есть еще элементы
	Iterator<String> it = set.iterator();
	while (it.hasNext())	{
	   String str = it.next();
	   System.out.print(str + "\t");	} System.out.println();
	   
		   // Цикл for-each для ArrayList
	ArrayList<String> list = new ArrayList<String>();
	list.add("Привет");			list.add("Hello");			list.add("Hola");
	list.add("Bonjour");		list.add("Cialo");			list.add("Namaste");
	for (String element : list) System.out.print(element + "\t"); 		System.out.println("\n");
	
		/* У цикла for-each есть один минус: он не умеет правильно удалять элементы. Если вы напишете такой код, получите ошибку
	for (String element : list) 
		if (element.equals("Hello"))  list.remove(element); */
	
		//	1-ый споспоб обойти это ограничение - использовать цикл for.   Но этот вариант не подходит для коллекций HashSet и HashMap
	System.out.println("Array лист до методa remove() в цикле for-each\t\t\t"  + list);
	for (int i = 0; i < list.size(); i++) {
	   String str = list.get(i);
	   if (str.equals("Hello"))  {
	      list.remove(str);
	      i--; }}				  // нужно уменьшить i, т.к. после удаления элементы сдвинулись 
	System.out.println("Array лист после метода remove() в цикле for-each\t\t"  + list + "\n");
	   
		// 2-ой способ  - использование метода remove() итератора
	System.out.println("Хэш-таблица до метода remove() в Iterator \t\t\t"  + set);
	Iterator<String> it1 = set.iterator();
	while (it1.hasNext()) 	{
	   String str = it1.next();
	   if (str.equals("Hello"))
	       it1.remove(); 	}	//	Обратите внимание, что метод remove() мы вызываем у объекта-итератора!
	System.out.println("Хэш-таблица после методa remove()  в Iterator \t\t\t"  + set  + "\n");
	
		// 3-ий способ - использование копии коллекции
//	Можно создать копию коллекции и использовать в цикле for-each коллекцию-копию, а удалять элементы из оригинальной коллекци
	System.out.println("Array лист до методa remove() в цикле for-each для копии \t"  + list);
	ArrayList <String> listCopy = new ArrayList<String>(list);
		for (String str: listCopy) {
			if (str.equals("Hola"))    list.remove(str); }
	System.out.println("Array лист после метода remove() в цикле for-each для копии \t"  + list + "\n");
	
	
	
	}
}