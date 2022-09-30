package f21_COLLECTIONS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*Сортировка коллекции выполняется с помощью Collections.sort(Collection) для сортировки значений. Этот метод предназначен для тех, 
 кто реализует интерфейс Comparable . Этот интерфейс определяет метод compare , который выполняет попарное сравнение элементов и
 возвращает -1, если элемент меньше, чем сравниваемый элемент, 0, если он равен и 1, если он больше. Общим примером является класс
 Integer.
 Если что Сортировать по-другому, вы можете определить свою собственную реализацию на основе интерфейса Comparator. 
 Этот подход заключается в том, что вы затем сортируете любой объект по любому атрибуту или даже комбинации атрибутов. 
 Например, если у вас есть объекты типа Person с атрибутом income и dateOfBirth, вы можете определить различные реализации компаратора 
 и отсортировать объекты в соответствии с вашими потребностями. */


public class t13_Collections_Sort_List {
public static void main(String[] args) {
	ArrayList<String> strArray = new ArrayList<String>();
	strArray.add("Tom");		strArray.add("Kristina");		strArray.add("Misha");		strArray.add("Liza");
			
			// 1_sort(list) сортирует список по default алгоритму (доступен только для Sting, Integer..)
	System.out.println("1_sort(list)_Словарь list до default метода - \t\t" + strArray);
	Collections.sort(strArray);
	System.out.println("1_sort(list)_Словарь list после default метода - \t\t" + strArray + "\n");
	
			// 2_sort(list, Comparator) сортирует список по заданному пользователем алгоритму 
	strArray.add("Anna");		strArray.add("Barbara");
	System.out.println("2_sort(list, Comparator)_Словарь list до метода с заданным Comparator - \t\t" + strArray);
	Comparator<String> lenComp = new LengthComparator();
	Collections.sort(strArray, lenComp);
	System.out.println("2_sort(list, Comparator)_Словарь list после метода с заданным Comparator - \t\t" + strArray + "\n");
	
			// 3_sort(list, Comparator) С ОПРЕДЕЛЕНИЕМ сразу в теле программы
	System.out.println("3_Создание объекта Comparator сразу в теле программы");
	System.out.println("3_sort(list, Comparator)_сразу в теле программы,    list до метода  - \t\t" + strArray);
	Collections.sort(strArray, new Comparator<String>() {
		@Override												// Сравнение по второй букве
		public int compare(String o1, String o2) {
			if (o1.charAt(1) > o2.charAt(1)) return 1; 
			else if (o1.charAt(1) < o2.charAt(1)) return -1; 
			else return 0; }		
	});
	System.out.println("3__sort(list, Comparator)_сразу в теле программы,    list после метода  - \t" + strArray + "\n");
	
			
	} 
}

class LengthComparator implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		if (o1.length() > o2.length())		return 1;
		else if (o1.length() < o2.length())	return -1;
		else return 0;}
}