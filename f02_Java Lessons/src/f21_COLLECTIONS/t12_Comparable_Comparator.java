package f21_COLLECTIONS;
/* При добавлении элементов в TreeSet, TreeSet автоматически проводит сортировку, помещая новый объект на правильное для него место.
   Со строками и числами в TreeSet есть встроенный алгоритм по их сравнению.
   Для собственного класса есть 2 варианта - реализация интерфейса Comparable и реализация интерфейса Comparator
   Интерфейс Comparator используется в частности в том случае, если разработчик не реализовал в своем классе интерфейс Comparable 
      На этот случай есть еще более гибкий способ, предполагающий применение интерфейса Comparator<E>.
    
  */

import java.util.Comparator;
import java.util.TreeSet;

class Person implements Comparable<Person> {			// Пример класса с интефейсом Comparable 
	String name; 
	int id;
	public String getName() {return name;}		public void setName(String name) {this.name = name;	}
	public int getId() {return id;	}			public void setId(int id) {this.id = id;}
	public Person(String name, int id) {
		this.name = name;
		this.id = id; 	}
			/* Интерфейс Comparable содержит один единственный метод int compareTo(E item), который сравнивает текущий объект с объектом, 
	 переданным в качестве параметра. Если этот метод возвращает отрицательное число, то текущий объект будет располагаться перед тем,
	 который передается через параметр. Если метод вернет положительное число, то, наоборот, после второго объекта. 
	 Если метод возвратит ноль, значит, оба объекта равны. 	 */
		
		@Override
	public int compareTo(Person o) {
		System.out.println("Объект " + name + " \t сравнивается через Comparable по имени c\t объектом " + o.name + "\t результат сравнения = " + name.compareTo(o.getName()));
		return name.compareTo(o.getName());}
	// В данной реализации compareTo идет сравнение через встроенного механизма сравнения для строк (name)  
		
		@Override
	public String toString() {
		return (name + id + ", "); }
}

class PersonNameComparator implements Comparator<Person> {
		/*  Интерфейс Comparator содержит ряд методов, ключевым из которых является метод compare():
   Метод compare также возвращает числовое значение - если оно отрицательное, то объект a предшествует объекту b, иначе - наоборот.
   А если метод возвращает ноль, то объекты равны. Для применения интерфейса нам вначале надо создать класс компаратора, который 
   реализует этот интерфейс: 	 */
		@Override
	public int compare(Person o1, Person o2) {
		System.out.print("Объект " + o1.name + " \t сравнивается через Comparator по имени c\t объектом " + o2.name);
		System.out.println("\t результат сравнения = " + o1.getName().compareTo(o2.getName()));
	return (o1.getName().compareTo(o2.getName()));}
}

class PersonIdComparator implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) {
		int result;
		if (o1.getId() > o2.getId()) result = 1;
		else if (o1.getId() < o2.getId()) result = -1;
		else result = 0;
		System.out.println("Объект c id" + o1.id + "  сравнивается через Comparator по id c\t объектом c id " + o2.id + "\t с результатом =" + result);
		return result;	}
}

	//  Для того, чтобы объекты Person можно было сравнить и сортировать, они должны применять интерфейс Comparable<E>
public class t12_Comparable_Comparator  {	
public static void main(String[] args) {
		// Через интерфейс Comparable
	TreeSet <Person> people_list = new TreeSet<Person> ();
	people_list.add(new Person("Bob", 22355));   // Данная строка выдаст ClasCastException без переопределения метода compareTo()
	people_list.add(new Person("Tom", 32355));
	people_list.add(new Person("Mark", 12355));
	System.out.println(people_list.toString());
	
			//	Через интерфейс Comparator со сравнением по имени
	/* Для создания TreeSet здесь используется одна из версий конструктора, которая в качестве параметра принимает компаратор. 
	 Теперь вне зависимости от того, реализован ли в классе Person интерфейс Comparable, логика сравнения и сортировки будет 
	 использоваться та, которая определена в классе компаратора. 	 */
	PersonNameComparator pcomp = new PersonNameComparator();
	TreeSet<Person> people_list2 = new TreeSet<Person> (pcomp);	// Теперь используем класс компаратора для создания объекта TreeSet
	people_list2.add(new Person("Bob", 22355));   // Данная строка выдаст ClasCastException без переопределения метода compareTo()
	people_list2.add(new Person("Tom", 32355));
	people_list2.add(new Person("Mark", 12355));
	System.out.println(people_list2.toString());
		
			//	Через интерфейс Comparator со сравнением по возрасту
	PersonIdComparator pcomp2 = new PersonIdComparator();
	TreeSet<Person> people_list3 = new TreeSet<Person> (pcomp2);	
	people_list3.add(new Person("Bob", 22355));  
	people_list3.add(new Person("Tom", 32355));
	people_list3.add(new Person("Mark", 12355));
	System.out.println(people_list3.toString());
	
		//	Через интерфейс Comparator со сравнением СРАЗУ по имени и по возрасту
// Интерфейс компаратора определяет специальный метод по умолчанию thenComparing, который позволяет использовать цепочки 
// компараторов для сортировки набора
	Comparator<Person> pcomp3 = new PersonNameComparator().thenComparing(new PersonIdComparator());
	TreeSet<Person> people_list4 = new TreeSet<Person> (pcomp3);	
	people_list4.add(new Person("Bob", 22355));  
	people_list4.add(new Person("Tom", 32355));
	people_list4.add(new Person("Mark", 12355));
	System.out.println(people_list4.toString());
		}
}
