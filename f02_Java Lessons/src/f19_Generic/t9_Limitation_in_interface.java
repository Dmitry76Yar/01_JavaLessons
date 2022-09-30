package f19_Generic;
/* Интерфейсы в качестве оганичений
В качестве ограничений могут выступать также интерфейсы. В этом случае передаваемый на место универсального параметра тип должен 
реализовать данный интерфейс:  */

public class t9_Limitation_in_interface {
public static void main(String[] args) {
	Account8 from = new Account8("Ivanov", 3000);
	Account8 to = new Account8("Petrov", 1000);
	Transaction3 <Account8> tran1 = new Transaction3 <Account8> (from, to, 600);
	System.out.printf("До перевода Account %s:  %d  \t Account %s: %d ", from.getId(), from.getSum(),to.getId(), to.getSum());
	System.out.println();
	tran1.execute();
	System.out.printf("После перевода Account %s: %d \t Account %s: %d", from.getId(), from.getSum(),to.getId(), to.getSum());
}
}

interface Accountable2 {
	String getId();
	int getSum(); 
	void setSum(int Sum); 	}

class Account8 implements Accountable2{
	String id; 
	int sum;
	public Account8(String id, int sum) {
		this.id = id;
		this.sum = sum; 	}
	public int getSum() { return sum; }
	public void setSum(int sum) { this.sum = sum; }
	public String getId() { return id; 	}
}

class Transaction3 <T extends Accountable2> {
	private T from; 
	private T to; 
	private int perevod;
	Transaction3(T from, T to, int perevod) {
		this.from = from;
		this.to = to;
		this.perevod = perevod; 	}
	public void execute () {
		if (from.getSum() < perevod)  System.out.println("Сумма недостостаточна для перевода");
		else {
			from.setSum(from.getSum() - perevod);
			to.setSum(to.getSum() + perevod);
			}}
}
