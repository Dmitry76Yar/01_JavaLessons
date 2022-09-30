package f21_COLLECTIONS;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/* PriorityQueue – это класс очереди с приоритетами.
  Иерархия - интерфейс Queue - класс AbstractQueue - класс PriorityQueue
  Пример использования - Когда клиенты посылают запросы к нашему приложению, то образуется очередь, но мы хотим обработать премиум 
  клиентов первыми, а обычных клиентов уже после них. Именно в этом случае нам будет лучше всего использовать PriorityQueue.
  
  По умолчанию очередь с приоритетами размещает элементы согласно естественному порядку сортировки используя Comparable. 
  Элементу с наименьшим значением присваивается наибольший приоритет. Если несколько элементов имеют одинаковый наивысший элемент – 
  связь определяется произвольно. 
  Также можно указать специальный порядок размещения, используя Comparator.
  
  PriorityQueue не позволяет добавлять null-значения и non-comparable объекты.
  PriorityQueue не является потокобезопасной! Для этих целей в Java реализован класс PriorityBlockingQueue, реализующий интерфейс
BlockingQueue. Именно он используется в многопоточной среде.    */

public class t06_Priority_Queue_Meaning {
public static void main(String[] args) {
	PriorityQueue<Integer> nubmers_list = new PriorityQueue<Integer>(); 
	nubmers_list.add(750);		nubmers_list.add(500);
	nubmers_list.add(900);		nubmers_list.add(100);
	
		// Элементы располагаются в очереди не в порядке их внесения, а сразу упорядачиваются по приоритету 
		// По умолчанию Для Integer - элементы сразу располагаются по возрастанию 
	System.out.print("По Default - Порядок печати элементов - чисел выбирается по их возрастанию - \t\t");
	for (int element : nubmers_list) System.out.print(element + "\t"); System.out.println();	
	System.out.print("По Default - Порядок исключения чисел также выбирается по их возрастанию - \t\t");
	while (nubmers_list.isEmpty()!= true) {
        System.out.print(nubmers_list.remove() + "\t");    } 			System.out.println();
	
        // По умолчанию Для String - элементы сразу располагаются по алфавиту + учет строчная или прописная
	PriorityQueue<String> name_list = new PriorityQueue<>();
	name_list.add("lisa");		name_list.add("Robert"); 		name_list.add("John");
	name_list.add("Chris"); 	name_list.add("Angelina");		name_list.add("Joe");
			
	System.out.print("По Default - Порядок печати строк - по алфавиту + учет строчная или прописная - \t");
	for (String element : name_list) System.out.print(element + "\t"); System.out.println();	
	System.out.print("По Default - Порядок исключения строк - по алфавиту + учет строчная или прописная - \t");
	while (name_list.isEmpty()!= true) {
	System.out.print(name_list.remove() + "\t");    }
	
		// Создание приоритета с использованием Comparator для упорядачивания строк по их длине 
	// Первый шаг - создание объекта Comparator для создания приоритета сравнения
	Comparator<String> stringLengthComparator  = new Comparator<String>() {
		@Override
	public int compare(String o1, String o2) {
	return (o1.length() - o2.length());	} 	
	};
		/*Аналогичный Comparator может быть создан с использованим лямбда-выражения ниже
	 	Comparator<String> stringLengthComparator = (01, o2) ->  { return (o1.length() - o2.length()); }; 	
		который может быть сокращен до Comparator<String> stringLengthComparator = Comparator.comparingInt(String::length);*/
	//	Второй шаг - создание очереди с использованием созданного Comparator
	PriorityQueue<String> namePriorityQueue = new PriorityQueue<String>(stringLengthComparator);
    namePriorityQueue.add("Lisa");	    namePriorityQueue.add("Robert");	    namePriorityQueue.add("John");
    namePriorityQueue.add("Chris");		namePriorityQueue.add("Angelina");	    namePriorityQueue.add("Joe"); System.out.println();
    
    System.out.print("Печать по длине строки с собственно созданным Comparator \t\t\t\t");
	for (String element : namePriorityQueue) System.out.print(element + "\t"); System.out.println();	
	System.out.print("Удаление по длине строки с собственно созданным Comparator \t\t\t\t");
	while (namePriorityQueue.isEmpty()!= true) {
	System.out.print(namePriorityQueue.remove() + "\t");    }
	
			/* Создание приоритета для объектов, принадлежащих классам, созданным программистом
	Существует 2 варианта
	1-ый вариант - Созданный класс должен имплементировать интерфейс Comparable и реализовать метод compareTo(), по которому идет сравнение
	2-ой вариант - Создание Comparator при создании PriorityQueue  
	Ниже пример для 1-го варианта, где для класса Employee в PriorityQueue идет упорядачивания сотрудников по зарплате	*/
	
	PriorityQueue<Employee> employeePriorityQueue = new PriorityQueue<>();
    employeePriorityQueue.add(new Employee("Rajeev", 100000.00));		employeePriorityQueue.add(new Employee("Chris", 145000.00));
    employeePriorityQueue.add(new Employee("Andrea", 115000.00));		employeePriorityQueue.add(new Employee("Jack", 167000.00));
    System.out.println();
       
    	//   Метод compareTo(), определенный в классе Employee используется для построения логики упорядачивания по зарплате
    while (!employeePriorityQueue.isEmpty()) { System.out.println(employeePriorityQueue.remove()); }
    	}
}

class Employee implements Comparable<Employee>{
	private String name; 
	private double salary;
	
	public String getName() {return name;}   	public void setName(String name) {this.name = name;	}
	public double getSalary() {return salary;}	public void setSalary(double salary) {this.salary = salary;	}
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary; 	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Employee employee = (Employee) obj;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name);}
	
	@Override
	public String toString() {
		return "Employee{ \t"+ "name=" + name +  ", \t salary=" + salary + '}';  	}
		
	@Override
	public int compareTo(Employee employee) {
		if(this.getSalary() < employee.getSalary()) { return 1; }
		else if (this.getSalary() > employee.getSalary()) { return -1; } 
		else {return 0; }
    }
}