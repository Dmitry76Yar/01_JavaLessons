package f19_Generic;
// Кроме обобщенных типов можно также создавать обобщенные методы, которые точно также будут использовать универсальные параметры.

public class t3_Generic_methods {
public static void main(String[] args) {
	Printer <Integer> pr1 = new Printer <Integer>(55); 
	pr1.print("Принтер печатает");
	pr1.calculate(333);

	}
}

class Printer <S> {
	S a;
	public Printer(S a) {
		this.a = a;}

	public <T> void print (T items) {    // Обобщенный метод
		System.out.println(items);	}
	
	public S calculate (S a) {
		return a;}
}
	