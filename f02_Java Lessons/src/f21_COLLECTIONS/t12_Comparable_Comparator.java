package f21_COLLECTIONS;
/* ��� ���������� ��������� � TreeSet, TreeSet ������������� �������� ����������, ������� ����� ������ �� ���������� ��� ���� �����.
   �� �������� � ������� � TreeSet ���� ���������� �������� �� �� ���������.
   ��� ������������ ������ ���� 2 �������� - ���������� ���������� Comparable � ���������� ���������� Comparator
   ��������� Comparator ������������ � ��������� � ��� ������, ���� ����������� �� ���������� � ����� ������ ��������� Comparable 
      �� ���� ������ ���� ��� ����� ������ ������, �������������� ���������� ���������� Comparator<E>.
    
  */

import java.util.Comparator;
import java.util.TreeSet;

class Person implements Comparable<Person> {			// ������ ������ � ���������� Comparable 
	String name; 
	int id;
	public String getName() {return name;}		public void setName(String name) {this.name = name;	}
	public int getId() {return id;	}			public void setId(int id) {this.id = id;}
	public Person(String name, int id) {
		this.name = name;
		this.id = id; 	}
			/* ��������� Comparable �������� ���� ������������ ����� int compareTo(E item), ������� ���������� ������� ������ � ��������, 
	 ���������� � �������� ���������. ���� ���� ����� ���������� ������������� �����, �� ������� ������ ����� ������������� ����� ���,
	 ������� ���������� ����� ��������. ���� ����� ������ ������������� �����, ��, ��������, ����� ������� �������. 
	 ���� ����� ��������� ����, ������, ��� ������� �����. 	 */
		
		@Override
	public int compareTo(Person o) {
		System.out.println("������ " + name + " \t ������������ ����� Comparable �� ����� c\t �������� " + o.name + "\t ��������� ��������� = " + name.compareTo(o.getName()));
		return name.compareTo(o.getName());}
	// � ������ ���������� compareTo ���� ��������� ����� ����������� ��������� ��������� ��� ����� (name)  
		
		@Override
	public String toString() {
		return (name + id + ", "); }
}

class PersonNameComparator implements Comparator<Person> {
		/*  ��������� Comparator �������� ��� �������, �������� �� ������� �������� ����� compare():
   ����� compare ����� ���������� �������� �������� - ���� ��� �������������, �� ������ a ������������ ������� b, ����� - ��������.
   � ���� ����� ���������� ����, �� ������� �����. ��� ���������� ���������� ��� ������� ���� ������� ����� �����������, ������� 
   ��������� ���� ���������: 	 */
		@Override
	public int compare(Person o1, Person o2) {
		System.out.print("������ " + o1.name + " \t ������������ ����� Comparator �� ����� c\t �������� " + o2.name);
		System.out.println("\t ��������� ��������� = " + o1.getName().compareTo(o2.getName()));
	return (o1.getName().compareTo(o2.getName()));}
}

class PersonIdComparator implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) {
		int result;
		if (o1.getId() > o2.getId()) result = 1;
		else if (o1.getId() < o2.getId()) result = -1;
		else result = 0;
		System.out.println("������ c id" + o1.id + "  ������������ ����� Comparator �� id c\t �������� c id " + o2.id + "\t � ����������� =" + result);
		return result;	}
}

	//  ��� ����, ����� ������� Person ����� ���� �������� � �����������, ��� ������ ��������� ��������� Comparable<E>
public class t12_Comparable_Comparator  {	
public static void main(String[] args) {
		// ����� ��������� Comparable
	TreeSet <Person> people_list = new TreeSet<Person> ();
	people_list.add(new Person("Bob", 22355));   // ������ ������ ������ ClasCastException ��� ��������������� ������ compareTo()
	people_list.add(new Person("Tom", 32355));
	people_list.add(new Person("Mark", 12355));
	System.out.println(people_list.toString());
	
			//	����� ��������� Comparator �� ���������� �� �����
	/* ��� �������� TreeSet ����� ������������ ���� �� ������ ������������, ������� � �������� ��������� ��������� ����������. 
	 ������ ��� ����������� �� ����, ���������� �� � ������ Person ��������� Comparable, ������ ��������� � ���������� ����� 
	 �������������� ��, ������� ���������� � ������ �����������. 	 */
	PersonNameComparator pcomp = new PersonNameComparator();
	TreeSet<Person> people_list2 = new TreeSet<Person> (pcomp);	// ������ ���������� ����� ����������� ��� �������� ������� TreeSet
	people_list2.add(new Person("Bob", 22355));   // ������ ������ ������ ClasCastException ��� ��������������� ������ compareTo()
	people_list2.add(new Person("Tom", 32355));
	people_list2.add(new Person("Mark", 12355));
	System.out.println(people_list2.toString());
		
			//	����� ��������� Comparator �� ���������� �� ��������
	PersonIdComparator pcomp2 = new PersonIdComparator();
	TreeSet<Person> people_list3 = new TreeSet<Person> (pcomp2);	
	people_list3.add(new Person("Bob", 22355));  
	people_list3.add(new Person("Tom", 32355));
	people_list3.add(new Person("Mark", 12355));
	System.out.println(people_list3.toString());
	
		//	����� ��������� Comparator �� ���������� ����� �� ����� � �� ��������
// ��������� ����������� ���������� ����������� ����� �� ��������� thenComparing, ������� ��������� ������������ ������� 
// ������������ ��� ���������� ������
	Comparator<Person> pcomp3 = new PersonNameComparator().thenComparing(new PersonIdComparator());
	TreeSet<Person> people_list4 = new TreeSet<Person> (pcomp3);	
	people_list4.add(new Person("Bob", 22355));  
	people_list4.add(new Person("Tom", 32355));
	people_list4.add(new Person("Mark", 12355));
	System.out.println(people_list4.toString());
		}
}
