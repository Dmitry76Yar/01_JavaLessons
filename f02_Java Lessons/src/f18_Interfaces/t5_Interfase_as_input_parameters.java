package f18_Interfaces;
/*Интерфейсы как параметры и результаты методов
Также как и в случае с классами, интерфейсы могут использоваться в качестве типа параметров метода или в качестве возвращаемого типа
Метод inform() в качестве параметра принимает объект интерфейса Building, поэтому в этот метод мы можем передать как объект House, так
и объект Garage.*/

public class t5_Interfase_as_input_parameters {
	public static void main(String[] args) {
		Building house1 = new House (12,4);
		Building garage1 = new Garage (120, 10);
		inform(house1);			// Передача в метод inform объекта интерфейса Building, где вызывается метод интерфейса print
		inform(garage1);		//, который переопределяется в зависимости от класса-наследника интерфейса
	}
	
static void inform (Building a) { 
	a.print(); }
}

interface Building {
	void print();}

class House implements Building {
	int Width; 
	int Floors; 
	House (int Width, int Floors) {
		this.Width = Width;
		this.Floors = Floors;}
	public void print() {
		System.out.println("Width = " + Width + ",     Floors = " + Floors);}
}

class Garage implements Building  {
	int Square; 
	int Length; 
	Garage (int Square, int Length) {
		this.Square = Square;
		this.Length = Length;}
	public void print() {
		System.out.println("Square = " + Square + ",     Length = " + Length);}
}
	