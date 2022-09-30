package f17_Class_Object;
/*  Метод equals()
Класс Object определяет метод clone(), который создает копию объекта. Если вы хотите, чтобы экземпляр вашего класса можно было клонировать, необходимо
переопределить этот метод и реализовать интерфейс Cloneable. интерфейс Clonable - это интерфейс-маркер, он не содержит ни методов, ни переменных. 
интерфейсы-маркер просто определяют поведение классов.
	Object.clone() выбрасывает исключение CloneNotSupportedException при попытке клонировать объект не реализующий интерфейс Cloneable. 
	Метод clone() в родительском классе Object является protected, поэтому желательно переопределить его как public. Реализация по умолчанию метода 
Object.clone() выполняет неполное/поверхностное (shallow) копирование. Рассмотрим пример:
	
*/
import java.util.Arrays;

class Vehicle6 implements Cloneable{
	int max_speed;
	String name;
		Vehicle6(int max_speed, String name) {
		this.max_speed = max_speed;
		this.name = name;}
		
	/* Переопределение метода Clone, т.к. он является private в классе Object;
Кроме того нужно привести тип возвращаемой копии объекта в Vehicle, поэтому нужно сделать привидение (Vehicle)
Тогда можно просто написать Vehicle Car2 = Car1.clone(); */
	@Override
	public Vehicle6 clone () {
		try{
			return (Vehicle6)super.clone();}
		catch (CloneNotSupportedException ex) {
			throw new InternalError();}
	}
}
class Plane6 {
	int max_speed;
	String name;
		Plane6(int max_speed, String name) {
		this.max_speed = max_speed;
		this.name = name;}	
		
		Plane6() {};			
		
	// Полностью переписанная реализацию метода clone()	
	@Override
	public Plane6 clone () {
		Plane6 New_Plane6 = new Plane6();	
		New_Plane6.max_speed = this.max_speed;
		New_Plane6.name = this.name;
		return New_Plane6;
	}	
}		
class t5_clone {
public static void main (String[] args){
	
		// Вызов переопределенного в классе Vehicle метода clone() класса Object в его default исполнении,
	System.out.println("Вызов переопределенного в классе Vehicle метода clone() класса Object в его default исполнении");
	Vehicle6 Car1 = new Vehicle6(120, "Skoda"); 	
	Vehicle6 Car2 = Car1.clone();
	Vehicle6 Car3 = Car1;
	System.out.println("Car1.name = " + Car1.name + ", Car1.max_speed = " + Car1.max_speed);
	System.out.println("Car2.name = " + Car2.name + ", Car2.max_speed = " + Car2.max_speed);
	System.out.println("Car3.name = " + Car3.name + ", Car3.max_speed = " + Car3.max_speed + "\n");
			Car1.max_speed = 200;
	System.out.println("После Car1.max_speed = 200 меняется переменная Car1 и Car3 (просто ссылка на тот же объект), но не Car2 (отдельный объект)");
	System.out.println("Car1.name = " + Car1.name + ", Car1.max_speed = " + Car1.max_speed);
	System.out.println("Car2.name = " + Car2.name + ", Car2.max_speed = " + Car2.max_speed);
	System.out.println("Car3.name = " + Car3.name + ", Car3.max_speed = " + Car3.max_speed + "\n");
	
		// Для примитивных объектов метод clone работает в его default исполнении (без переопределения)
	int Massive[] = {1,2,3};
	int Massive_Copy[];
	Massive_Copy = Massive.clone();
	System.out.println(Arrays.toString(Massive_Copy) + "\n");
	/*	String st = new String ("Hello");
		String st_copy = (String)st.clone(); 
	    System.out.println(st_copy);  - для String не работает  */
			
	// Вызов метода clone() с полностью переписанной реализацией
	System.out.println("Вызов метода clone() с полностью переписанной реализацией");
	Plane6 Boing = new Plane6(980, "Boing");
	Plane6 Boing_mod;
	Boing_mod = Boing.clone();
	System.out.println("Boing.name = " + Boing.name + ",\t Boing.max_speed = " + Boing.max_speed);
	System.out.println("Boing_mod.name = " + Boing_mod.name + ",\t Boing_mod.max_speed = " + Boing_mod.max_speed);
		 }
}
   
   