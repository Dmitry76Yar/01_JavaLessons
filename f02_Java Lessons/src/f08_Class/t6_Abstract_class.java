/* Зачем нужны абстрактные классы? Допустим, мы делаем программу для обслуживания банковских операций и определяем в ней три класса:
Person, который описывает человека, Employee - описывает банковского служащего, и класс Client - описывает клиента банка.
Очевидно, что классы Employee и Client будут производными от класса Person, так как оба класса имеют некоторые общие поля и методы. 
И так как все объекты будут представлять либо сотрудника, либо клиента банка, то напрямую мы от класса Person создавать объекты не 
будем. Поэтому имеет смысл сделать его абстрактным.   */

package f08_Class;

public class t6_Abstract_class {
public static void main(String[] args) {
	Employee Tom = new Employee("Tom", "Sberbank");
	Tom.Print();										System.out.println();
	Client Dina = new Client ("Dina", 84444);
	Dina.Print();
	}
}

abstract class Person {
	String name; 
	String getName() {return name;}
	public Person (String name) {
		this.name = name;}
	public void Print() {}
	}
class Employee extends Person {
	private String bank; 
	public Employee (String name, String bank) {
		super(name);  			// Вызов констукторы суперкласса 
		this.bank = bank;	}  
	public void Print() {
		System.out.printf("Name: %s \t  Bank: %s \t", super.getName(), bank);}
	}
class Client extends Person {
	private int id;
	public Client (String name, int id) {
		super(name); 
		this.id = id;}
	public void Print() {
		System.out.printf("Name: %s \t  Bank: %d \t", super.getName(), id);}
	}
