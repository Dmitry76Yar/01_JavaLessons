package f18_Interfaces;

public class t2_Convers_types {
	public static void main(String[] args) {
		
		// ��� ��� ����� Journal ��������� ��������� Literature1, �� ���������� ���� Literature1 ����� ������� ������ �� ������ ���� Journal:
	Literature1 journal = new Journal1 ("2020", "Marks");
	journal.print();
	
		/*  �� ���������� ���������� Year � ����������, ������� ���������� ���������� � ���������� journal.year
			���������� ����� �������������� ������� ���������� Literature1  � ������� ������ Journal1 */
	String year = ((Journal1)journal).Year;
	System.out.println(year);
	
	/*  �� ���������� ������ getAuthor() � ����������, ������� ���������� ���������� � ���� ��� ������� - journal.getAuthor()
	���������� ����� �������������� ������� ���������� Literature1  � ������� ������ Journal1 */
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

