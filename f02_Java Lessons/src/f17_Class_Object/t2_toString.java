package f17_Class_Object;
/* Метод toString() 
Метод toString служит для получения представления данного объекта в виде строки. 
При попытке вывести строковое представления какого-нибудь объекта, как правило, будет выводиться полное имя класса + hash code

В примере ниже для класса Plane метод toString() прописан в default исполнении - выдает полное имя класса + hash code
Для класса  метод toString() переопределен*/

class Plane1 {
	int max_speed;
	String name;
	public Plane1(int max_speed, String name) {
		this.max_speed = max_speed;
		this.name = name; } }

class Vehicle1 {
	int max_speed;
	String name;
	public Vehicle1(int max_speed, String name) {
		this.max_speed = max_speed;
		this.name = name; } 
	// Переопредление метода toString()	
		public String toString(){
			String temp = getClass() +  " - " + name + " - " + Integer.toString(max_speed);
			return temp;	}  }

class Moto extends Vehicle1 {
	String producer;
	public Moto(int max_speed, String name, String producer) {
		super(max_speed, name);	
		this.producer = producer; 	}
	
	public String toString(){
		return (super.toString() + " - " + producer); 	}
}

class t2_toString {
public static void main (String[] args){
	Plane1 Boing = new Plane1(980, "Boing");
	// Печать toString для объекта Boing
	System.out.println("По умолчанию toString() для объекта Boing выдает название класса + hash code - \t\t" + Boing.toString());    	
	System.out.println("По умолчанию toString() для переменной Boing.name выдает значение переменной \t\t" + Boing.name.toString()); 
		 
    Vehicle1 Car1 = new Vehicle1(120, "Ferrari"); 
	System.out.println("Переопределенный toString() для объекта Car1 выдает собственную реализацию \t\t" + Car1.toString());    			// Печать toString для объекта Car1
		
	Moto Moto1 = new Moto (250, "Kaw1432", "Kawasaki");
	System.out.println("Для мотоцикла - Частично переопределенный из суперкласса + добавлен свой идентификатор \n\t\t\t\t\t\t\t\t" + Moto1.toString());   
	
	}
}
	