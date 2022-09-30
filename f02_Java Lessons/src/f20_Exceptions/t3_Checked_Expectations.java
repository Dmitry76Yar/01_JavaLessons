package f20_Exceptions;
/* ��� ��������� ������, ������������ �� ������ Exception, ���������� ������������ ������������ (checked exceptions).
��������� �� ������� ����������� ����������: 
	CloneNotSupportedException: �����, ��� ������� �������� ���������� ������������, �� ��������� ��������� Cloneable
	InterruptedException: ����� ������� ������ �������
	ClassNotFoundException: ���������� ����� �����
�������� ���������� �������������� � ������� ����������� try..catch. ���� ����� �������� ��������� ������, ������� ����� �������� 
������ �����, ������ ���������� ����� ��������� throws */

public class t3_Checked_Expectations {
public static void main(String[] args) {
	Person a = new Person ("Bob");
	try  { 
		Person b = a.clone();
		System.out.println(b.getName());}
	catch (CloneNotSupportedException ex) {
		System.out.println("Clonable not implemented"); 	}
	}
}

class Person // implements Cloneable 
	{
	private String name;
	public String getName() { return name; 	}
	Person (String name) {
		this.name = name;}
		
	public Person clone() throws CloneNotSupportedException {
	    Person p = (Person) super.clone();
	    return p;}
}

