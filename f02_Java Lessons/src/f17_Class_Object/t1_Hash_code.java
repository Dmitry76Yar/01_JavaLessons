package f17_Class_Object;
/* Метод hashCode позволяет задать некоторое числовое значение, которое будет соответствовать данному объекту или его хэш-код. 
По данному числу, например, можно сравнивать объекты.
Хэш-код по умолчанию отображает место(адрес) объекта в памяти в виде int значения. Также имеет место быть и метод с аналогичным названием.
Если по-научному, то хеширование— преобразование входного массива данных произвольной длины в выходную битовую строку фиксированной длины. 
Результатом хэширования является хэш-код.
	Хэш-код, скорее, сгенерированный id объекта в виде integer, на который идёт ссылка при поиске/удалении/хранении этого объекта в памяти.
Любой появившейся объект машина "отмечает" для себя особым номером. Это как в гардеробе- гардеробщик принимает одежду, вешает её на свободную вешалку и
отдаёт специальный номерок, чтобы одежда не затерялась среди других вещей.  номерок- это и есть хэш-код. 

В примере ниже для класса Vehicle метод hashCode() прописан в default исполнении
Для класса Plane метод hashCode() переопределен*/

import java.util.Objects;

class Vehicle {
	int max_speed;
	String name;
	Vehicle() {
		max_speed = 120;
		name = "Ferrari";}
}

class Plane {
	int max_speed;
	String name;
	public Plane(int max_speed, String name) {
		this.max_speed = max_speed;
		this.name = name; 	}

	// Переопредление метода hashCode()
	public int hashCode(){
         return Objects.hash(max_speed, name);       // Учитывает в Integer hashcode обе переменные, в том числе string
    }
}
class t1_Hash_code {
public static void main (String[] args){
	 
    Vehicle Car1 = new Vehicle(); 
	System.out.println("Hash code для Car1\t" + Car1.hashCode());    				// Печать hashCode для объекта Car1
	System.out.println("Hash code для Car1.name\t" + Car1.name.hashCode()); 		// Печать hashCode для String переменной name объекта Car1
	// System.out.println("Hash code для Car1.name\t" + Car1.max_speed.hashCode());	// Печать hashCode для int переменной max_speed объекта Car1 невозможна
	
	Plane Boing = new Plane(1000, "Boing");
	System.out.println("Переопределенный Hash code для Boing\t" + Boing.hashCode());   				 // Печать hashCode для объекта Boing

	
	 }
}
   
   