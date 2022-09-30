package f17_Class_Object;
/*  Глубокое клонирование требуется в том случае, если одним из параметров объекта является объект другого класса.
Например, ниже объект driver1 класса Driver является одним из параметров объекта Car класса Vehicle
*/

class Vehicle8 implements Cloneable{
	int max_speed;
	String name;
	Driver driver;
		Vehicle8(int max_speed, String name, Driver driver) {
		this.max_speed = max_speed;
		this.name = name;
		this.driver = driver;}
		
	/* Переопределение метода Clone, т.к. он является private в классе Object;
Кроме того нужно привести тип возвращаемой копии объекта в Vehicle, поэтому нужно сделать привидение (Vehicle)
Тогда можно просто написать Vehicle Car2 = Car1.clone(); */
	@Override
	public Vehicle8 clone () {
		try{
			Vehicle8 newCar = (Vehicle8)super.clone();
			Driver newDriver = (Driver)this.driver.clone();
			newCar.driver = newDriver;
			return newCar;}
		catch (CloneNotSupportedException ex) {
			throw new InternalError();}
	}
}
class Driver implements Cloneable {
	int age; 
	String name;
	
	Driver(int age, String name) {
		this.age = age;
		this.name = name;}
	
	@Override
	public Driver clone () {
		try{
			return (Driver)super.clone();}
		catch (CloneNotSupportedException ex) {
			throw new InternalError();}
	}
}
		
class t5_deep_clone {
public static void main (String[] args){
	
		// Вызов переопределенного в классе Vehicle метода clone() класса Object в его default исполнении,
	System.out.println("Вызов переопределенного в классе Vehicle метода clone() с глубоким копированием");
	Vehicle8 Car1 = new Vehicle8(120, "Skoda", new Driver(18, "Ivan")); 
	Vehicle8 Car2; 
	Car2 = Car1.clone();
	System.out.println("Car1.max_speed = " + Car1.max_speed + "\t Car1.name = " + Car1.name + "\t Car1.driver.name = " + Car1.driver.name + " \t Car1.driver.age = " + Car1.driver.age);
	System.out.println("Car2.max_speed = " + Car2.max_speed + "\t Car2.name = " + Car2.name + "\t Car2.driver.name = " + Car2.driver.name + " \t Car2.driver.age = " + Car2.driver.age);
	System.out.println("");
		 }
}
   
   