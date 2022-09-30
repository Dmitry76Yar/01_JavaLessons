package f19_Generic;
// Интерфейсы, как и классы, также могут быть обобщенными. Создадим обобщенный интерфейс Accountable и используем его в программе:

public class t2_Generic_interfaces {
public static void main(String[] args) {
	Account2 client1 = new Account2("Account number #5555", 60000);
    System.out.println(client1.getId());
    
    Account3<Integer> client2 = new Account3<Integer>(44555, 5555);
    System.out.println(client2.getId());
    }
}

interface Accountable <T> {
	T getId(); 
	int getSum();
	void setSum(int sum);
}
		// При реализации подобного интерфейса есть две стратегии.
class Account2 implements Accountable <String> {  /* Первая стратегия, когда при реализации для универсального параметра интерфейса задается
													конкретный тип, как например, в данном случае это тип String. Тогда класс, реализующий 
													интерфейс, жестко привязан к этому типу.  */
	private String id;
	private int sum;
	Account2(String id, int sum) {
		this.id = id;
		this.sum = sum;	}
	public int getSum() { return sum; }
	public String getId() {	return id;}
	public void setSum(int sum) {this.sum = sum;} 
}

class Account3<T> implements Accountable<T> {		/* Вторая стратегия представляет определение обобщенного класса, 
											который также использует тот же универсальный параметр:  */
	private T id;
	private int sum;
	Account3(T id, int sum) {
		this.id = id;
		this.sum = sum;}
	public int getSum() { return sum;}
	public void setSum(int sum) { this.sum = sum;}
	public T getId() {return id;}
}

