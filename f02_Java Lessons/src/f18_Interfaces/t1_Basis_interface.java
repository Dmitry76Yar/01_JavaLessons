package f18_Interfaces;

public class t1_Basis_interface {
	public static void main(String[] args) {
		Book book1 = new Book ("Gone with Wind", "Tolstoy");
		Journal journal1 = new Journal ("2020", "Marks");
		book1.print();
		journal1.print();
		
/* Класс Book и класс Journal связаны тем, что они реализуют интерфейс Literature. Поэтому мы динамически в программе 
 можем создавать объекты Literature как экземпляры обоих классов  */
		Literature book2 = new Book("Java. Complete Reference", "H. Shildt");
		Literature journal2 = new Book("1999", "Foreign Policy");
		book2.print();
		journal2.print();
		
// Еще более интересный метод создания объектов объектов либо Book, либо Journal по вводу соответствующей цифры в методе CreationObject
		Literature book3 = CreationObject(0);
		book3.print();

}
		// Метод создания объектов либо Book, либо Journal по вводу соответствующей цифры (0 или 1)
	static Literature CreationObject (int a) {
		if (a==0) return new Book("dd", "dd"); 
		else if (a==1) return new Journal("ddd", "sss");
		else return null;}
}

interface Literature {
	void print(); }

class Book implements Literature {
		String Name; 
		String Author; 
	Book(String Name, String Author) {
		this.Name = Name; 
		this.Author = Author;}
	public void print () {
		System.out.printf("%s (%s) \n", Name, Author);
	}
}

class Journal implements Literature {
		String Year; 
		String Author; 
	Journal (String Year, String Author) {
		this.Year = Year; 
		this.Author = Author;}
	public void print () {
		System.out.printf("%s (%s) \n", Year, Author);
		
	}
}

