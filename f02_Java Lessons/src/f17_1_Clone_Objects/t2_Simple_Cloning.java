package f17_1_Clone_Objects;
/* Для реализации клонирования класс Person должен применить интерфейс Cloneable, который определяет метод clone. 
 Реализация этого метода просто возвращает вызов метода clone для родительского класса - то есть класса Object с преобразованием к типу 
 Кроме того, на случай если класс не поддерживает клонирование, метод должен выбрасывать исключение CloneNotSupportedException, что
 определяется с помощью оператора throws.   */

public class t2_Simple_Cloning {
public static void main (String[] args){
			// Нет проблем с копированием простых объектов
	Book book1 = new Book("Tolstoy", "War and Piece");
	book1.display("book1");
	try {
		Book book2 = book1.clone();
		book2.display("book2");
		System.out.println("\t После изменения переменной объекта book 2 - для объекта book1 ничего не изменилось");
		book2.setAuthor("Mendeleev"); 
		book1.display("book1");
		book2.display("book2");}
	catch (CloneNotSupportedException ex) {System.out.println("Clonable not implemented"); 	}
	
		/* Есть проблемы с клонированием сложных объектов (переменные которых представляют собой также объекты)
Хотя переменные jour1 и jour2 (клон) указывают на разные объекты в памяти, но эти объекты при этом будут указывают на один объект Name name*/
	
	Journal jour1 = new Journal("Dmitry", "Kulikov", "Science");	System.out.println();
	jour1.display("jour1");
	try {
		Journal jour2 = jour1.clone();
		jour2.display("jour2");
		System.out.println("\t После изменения переменной объекта jour2 - для объекта jour1 также произошли измнения");
		jour2.setName("Alexander", "Isaev");
		jour2.display("jour2");
		jour1.display("jour1");
		}
	catch (CloneNotSupportedException ex) {System.out.println("Clonable not implemented"); 	}

}}

class Book implements Cloneable{
	private String name; 
		public String getName() { return name; 	}
		public void setName(String name) { 	this.name = name; }
	private String author;
		public String getAuthor() { return author; 	}
		public void setAuthor(String author) { this.author = author; }

	public Book(String name, String author) {
		this.name = name;
		this.author = author; 	}
	void display(String a) {System.out.printf( a + ":  name = %s, \t author = %s \n", name, author); 	}
		
	public Book clone() throws CloneNotSupportedException{
	return (Book) super.clone();} }

class Journal implements Cloneable {
	private Name name; 
	public String getName() { return name.getFirstName() + name.getSurName();}
	public void setName(String FirstName, String SurName) {
		name.setFirstName(FirstName);
		name.setSurName(SurName); }
	
	private String style;
	public String getStyle() { return style; 	}
	public void setStyle(String style) {this.style = style; }
	
	public Journal(String firstName, String surName, String style) {
		this.style = style;
		this.name = new Name(firstName, surName); } 
	void display(String a) {System.out.printf(a + ": firstName = %s, \t surName = %s \t author = %s \n", name.getFirstName(), name.getSurName(), style);}
	
	public Journal clone() throws CloneNotSupportedException{
		return (Journal) super.clone();}
}

class Name {
	private String FirstName; 
	private String SurName;
	public String getFirstName() { return FirstName;	}
	public void setFirstName(String firstName) { FirstName = firstName; 	}
	public String getSurName() { return SurName; 	}
	public void setSurName(String surName) { SurName = surName; }
	public Name(String firstName, String surName) {
		FirstName = firstName;
		SurName = surName; 	} 
}
 