package f18_Interfaces;

/* Ранее до JDK 8 при реализации интерфейса мы должны были обязательно реализовать все его методы в классе. 
А сам интерфейс мог содержать только определения методов без конкретной реализации. В JDK 8 была добавлена такая функциональность
как методы по умолчанию. И теперь интерфейсы кроме определения методов могут иметь их реализацию по умолчанию, которая используется, 
если класс, реализующий данный интерфейс, не реализует метод. Например, создадим метод по умолчанию в интерфейсе Printable:   */

public class t3_Default_interface {
	public static void main(String[] args) {
		Moto moto1 = new Moto(200); 
		moto1.inform();		// Вызов метода, переопределенного в классе
		moto1.print();		// Вызов Default метода интерфейса
		System.out.println(moto1.calculator(100,200));		// В интерфейсах можно осуществлять расчеты
		Vehicle.notice();
	}

}

class Moto implements Vehicle { 
	private int Max_speed;
	Moto (int Max_speed) {
		this.Max_speed = Max_speed;}
	int getMaxSpeed () {
		return Max_speed;}
	public void inform() {
		System.out.println("Вызов переопределенного метода класса   Максимальная скорость = " + Max_speed);
	}
}
	
interface Vehicle {
	void inform();
	
	default void print () {
		System.out.println("Вызов метода интерфейса по умолчанию");}
	
	default int calculator (int a, int b) {
		System.out.println("Вызов метода интерфейса по умолчанию для расчетов ");
		return (a+b);} 
	
	static void notice() {
		System.out.println("Вызов статического метода интерфейса");}
}