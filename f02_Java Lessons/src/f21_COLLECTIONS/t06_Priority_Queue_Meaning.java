package f21_COLLECTIONS;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/* PriorityQueue � ��� ����� ������� � ������������.
  �������� - ��������� Queue - ����� AbstractQueue - ����� PriorityQueue
  ������ ������������� - ����� ������� �������� ������� � ������ ����������, �� ���������� �������, �� �� ����� ���������� ������� 
  �������� �������, � ������� �������� ��� ����� ���. ������ � ���� ������ ��� ����� ����� ����� ������������ PriorityQueue.
  
  �� ��������� ������� � ������������ ��������� �������� �������� ������������� ������� ���������� ��������� Comparable. 
  �������� � ���������� ��������� ������������� ���������� ���������. ���� ��������� ��������� ����� ���������� ��������� ������� � 
  ����� ������������ �����������. 
  ����� ����� ������� ����������� ������� ����������, ��������� Comparator.
  
  PriorityQueue �� ��������� ��������� null-�������� � non-comparable �������.
  PriorityQueue �� �������� ����������������! ��� ���� ����� � Java ���������� ����� PriorityBlockingQueue, ����������� ���������
BlockingQueue. ������ �� ������������ � ������������� �����.    */

public class t06_Priority_Queue_Meaning {
public static void main(String[] args) {
	PriorityQueue<Integer> nubmers_list = new PriorityQueue<Integer>(); 
	nubmers_list.add(750);		nubmers_list.add(500);
	nubmers_list.add(900);		nubmers_list.add(100);
	
		// �������� ������������� � ������� �� � ������� �� ��������, � ����� ��������������� �� ���������� 
		// �� ��������� ��� Integer - �������� ����� ������������� �� ����������� 
	System.out.print("�� Default - ������� ������ ��������� - ����� ���������� �� �� ����������� - \t\t");
	for (int element : nubmers_list) System.out.print(element + "\t"); System.out.println();	
	System.out.print("�� Default - ������� ���������� ����� ����� ���������� �� �� ����������� - \t\t");
	while (nubmers_list.isEmpty()!= true) {
        System.out.print(nubmers_list.remove() + "\t");    } 			System.out.println();
	
        // �� ��������� ��� String - �������� ����� ������������� �� �������� + ���� �������� ��� ���������
	PriorityQueue<String> name_list = new PriorityQueue<>();
	name_list.add("lisa");		name_list.add("Robert"); 		name_list.add("John");
	name_list.add("Chris"); 	name_list.add("Angelina");		name_list.add("Joe");
			
	System.out.print("�� Default - ������� ������ ����� - �� �������� + ���� �������� ��� ��������� - \t");
	for (String element : name_list) System.out.print(element + "\t"); System.out.println();	
	System.out.print("�� Default - ������� ���������� ����� - �� �������� + ���� �������� ��� ��������� - \t");
	while (name_list.isEmpty()!= true) {
	System.out.print(name_list.remove() + "\t");    }
	
		// �������� ���������� � �������������� Comparator ��� �������������� ����� �� �� ����� 
	// ������ ��� - �������� ������� Comparator ��� �������� ���������� ���������
	Comparator<String> stringLengthComparator  = new Comparator<String>() {
		@Override
	public int compare(String o1, String o2) {
	return (o1.length() - o2.length());	} 	
	};
		/*����������� Comparator ����� ���� ������ � ������������� ������-��������� ����
	 	Comparator<String> stringLengthComparator = (01, o2) ->  { return (o1.length() - o2.length()); }; 	
		������� ����� ���� �������� �� Comparator<String> stringLengthComparator = Comparator.comparingInt(String::length);*/
	//	������ ��� - �������� ������� � �������������� ���������� Comparator
	PriorityQueue<String> namePriorityQueue = new PriorityQueue<String>(stringLengthComparator);
    namePriorityQueue.add("Lisa");	    namePriorityQueue.add("Robert");	    namePriorityQueue.add("John");
    namePriorityQueue.add("Chris");		namePriorityQueue.add("Angelina");	    namePriorityQueue.add("Joe"); System.out.println();
    
    System.out.print("������ �� ����� ������ � ���������� ��������� Comparator \t\t\t\t");
	for (String element : namePriorityQueue) System.out.print(element + "\t"); System.out.println();	
	System.out.print("�������� �� ����� ������ � ���������� ��������� Comparator \t\t\t\t");
	while (namePriorityQueue.isEmpty()!= true) {
	System.out.print(namePriorityQueue.remove() + "\t");    }
	
			/* �������� ���������� ��� ��������, ������������� �������, ��������� �������������
	���������� 2 ��������
	1-�� ������� - ��������� ����� ������ ���������������� ��������� Comparable � ����������� ����� compareTo(), �� �������� ���� ���������
	2-�� ������� - �������� Comparator ��� �������� PriorityQueue  
	���� ������ ��� 1-�� ��������, ��� ��� ������ Employee � PriorityQueue ���� �������������� ����������� �� ��������	*/
	
	PriorityQueue<Employee> employeePriorityQueue = new PriorityQueue<>();
    employeePriorityQueue.add(new Employee("Rajeev", 100000.00));		employeePriorityQueue.add(new Employee("Chris", 145000.00));
    employeePriorityQueue.add(new Employee("Andrea", 115000.00));		employeePriorityQueue.add(new Employee("Jack", 167000.00));
    System.out.println();
       
    	//   ����� compareTo(), ������������ � ������ Employee ������������ ��� ���������� ������ �������������� �� ��������
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