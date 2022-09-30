package f17_1_Clone_Objects;
/* Для реализации клонирования класс Person должен применить интерфейс Cloneable, который определяет метод clone. 
 Реализация этого метода просто возвращает вызов метода clone для родительского класса - то есть класса Object с преобразованием к типу 
 Кроме того, на случай если класс не поддерживает клонирование, метод должен выбрасывать исключение CloneNotSupportedException, что
 определяется с помощью оператора throws.   */

public class t3_Deep_Cloning {
public static void main (String[] args){
			
/* Есть проблемы с простым клонированием сложных объектов (переменные которых представляют собой также объекты)
Хотя переменные jour1 и jour2 (клон) указывают на разные объекты в памяти, но эти объекты при этом будут указывают на один объект Name1 name
И в этом случае нам необходимо выполнить полное копирование. Для этого надо определить метод клонирования и у класса Name1 */
	
	Journal1 jour1 = new Journal1("Dmitry", "Kulikov", "Science");	System.out.println();
	jour1.display("jour1");
	try {
		Journal1 jour2 = jour1.clone();
		jour2.display("jour2");
		System.out.println("\t После изменения переменной объекта jour2 - для объекта jour1 нет изменений");
		jour2.setName("Alexander", "Isaev");
		jour2.display("jour2");
		jour1.display("jour1");
		}
	catch (CloneNotSupportedException ex) {System.out.println("Clonable not implemented"); 	}

}}

class Journal1 implements Cloneable {
	private Name1 name; 
	public String getName() { return name.getFirstName() + name.getSurName();}
	public void setName(String FirstName, String SurName) {
		name.setFirstName(FirstName);
		name.setSurName(SurName); }
	
	private String style;
	public String getStyle() { return style; 	}
	public void setStyle(String style) {this.style = style; }
	
	public Journal1(String firstName, String surName, String style) {
		this.style = style;
		this.name = new Name1(firstName, surName); } 
	void display(String a) {System.out.printf(a + ": firstName = %s, \t surName = %s \t author = %s \n", name.getFirstName(), name.getSurName(), style);}
	
	public Journal1 clone() throws CloneNotSupportedException{		
		Journal1 jour = (Journal1) super.clone();			//  И затем исправим метод clone в классе Book следующим образом:
		jour.name = (Name1)name.clone();
		return jour;	}					
}

class Name1 implements Cloneable {							// Вводим Cloneable интерфейс для класса Name1 
	private String FirstName; 
	public String getFirstName() { return FirstName;	}
	public void setFirstName(String firstName) { FirstName = firstName; 	}
	
	private String SurName;
	public String getSurName() { return SurName; 	}
	public void setSurName(String surName) { SurName = surName; }
	
	public Name1 (String firstName, String surName) {
		FirstName = firstName;
		SurName = surName; 	} 
	public Name1 clone() throws CloneNotSupportedException {   // Определяем метод clone для класса Name1
		return (Name1) super.clone();	}   
}
