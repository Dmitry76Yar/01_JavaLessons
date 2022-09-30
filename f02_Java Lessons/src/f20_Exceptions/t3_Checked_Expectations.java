package f20_Exceptions;
/* Все остальные классы, образованные от класса Exception, называются проверяемыми исключениями (checked exceptions).
Некоторые из классов проверяемых исключений: 
	CloneNotSupportedException: класс, для объекта которого вызывается клонирование, не реализует интерфейс Cloneable
	InterruptedException: поток прерван другим потоком
	ClassNotFoundException: невозможно найти класс
Подобные исключения обрабатываются с помощью конструкции try..catch. Либо можно передать обработку методу, который будет вызывать 
данный метод, указав исключения после оператора throws */

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

