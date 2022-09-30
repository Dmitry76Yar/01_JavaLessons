package f18_Interfaces;

public class t2_Convers_types {
	public static void main(String[] args) {
		
		// Так как класс Journal реализует интерфейс Literature1, то переменная типа Literature1 может хранить ссылку на объект типа Journal:
	Literature1 journal = new Journal1 ("2020", "Marks");
	journal.print();
	
		/*  Не существует переменной Year в интерфейсе, поэтому невозможно обратиться к переменной journal.year
			Необходимо явное преобразование объекта интерфейса Literature1  к объекту класса Journal1 */
	String year = ((Journal1)journal).Year;
	System.out.println(year);
	
	/*  Не существует метода getAuthor() в интерфейсе, поэтому невозможно обратиться к нему для объекта - journal.getAuthor()
	Необходимо явное преобразование объекта интерфейса Literature1  к объекту класса Journal1 */
	String author = ((Journal1)journal).getAuthor();
	System.out.println(author);
	}
}

interface Literature1 {
	void print(); }

class Journal1 implements Literature1 {
		String Year; 
		String Author; 
	String getAuthor(){
		return Author;}
	Journal1 (String Year, String Author) {
		this.Year = Year; 
		this.Author = Author;}
	public void print () {
		System.out.printf("%s (%s) \n", Year, Author);
	}
}

class Book1 implements Literature1 {
	String Name; 
	String Author; 
Book1(String Name, String Author) {
	this.Name = Name; 
	this.Author = Author;}
public void print () {
	System.out.printf("%s (%s) \n", Name, Author);
}
}

