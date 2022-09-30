package f17_Class_Object;
/*   Метод getClass позволяет получить тип данного объекта:     */

class Vehicle3 {
	int max_speed;
	String name;
	Vehicle3() {
		max_speed = 120;
		name = "Ferrari";}
}
class Plane2 {
	int max_speed;
	Plane2() {
		max_speed = 980;}
}
class t3_getClass {
public static void main (String[] args){
	 
    Vehicle3 Car1 = new Vehicle3(); 
	Plane2 Boing  = new Plane2();
	System.out.println("getClass() для объекта Car1 выдает название класса \t\t\t" + Car1.getClass());    			// Печать toString для объекта Car1
	System.out.println("getClass() для переменной Car1.name выдает значение переменной \t" + Boing.getClass()); 	// Печать toString для String переменной name объекта Car1
	
	 }
}
   
   