/*  роме отдельных примитивов и классов есть также тип enum = перечислени€. ќбъ€вление перечислений происходит с помощью оператора enum.
«атем идет список элементов через зап€тую.   
ѕеречисление фактически представл€ют собой новый тип, поэтому можно определить переменную данного типа и использовать ее   */
package f14_Perechisleniya_enum;

public class t1_Perechisleniya {
public static void main(String[] args) {
	Book b1 = new Book("War and Piece", "L.Tolstoy", Type.Belletre);
	Book b2 = new Book("DDDDDD", "GGGGGGG", Type.Sciene);
	System.out.printf("Book %s by author %s has a type %s", b1.name, b1.author, b1.bookType);	System.out.println();
	System.out.printf("Book %s by author %s has a type %s", b2.name, b2.author, b2.bookType);
	}
}

class Book {
	String name;
	Type bookType;
	String author;
	Book (String name, String author, Type type) {
		this.name = name;
		bookType = type;
		this.author = author; }  }

enum Type {
	Sciene,
	Belletre,
	Phantasy,
	Science_fiction }


