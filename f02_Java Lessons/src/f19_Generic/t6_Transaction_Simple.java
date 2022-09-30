package f19_Generic;

/* ������� ����� �� ������ ������������ ������� ��� GENERIC
���������� �� �������� ����������� - ������ from, ������� ������������ �������� - ������ to ������ Account5
������� ����� - ��� ������ ������ Transaction, ��� ����������� �������� ������� from � to, � ����� ����� �������� */ 

public class t6_Transaction_Simple {
public static void main(String[] args) {
	Account5 from = new Account5 ("Ivanov", 5000);
	Account5 to = new Account5 ("Petrov", 0);
	Transaction Perevod = new Transaction (from, to, 6000);
	Perevod.execute();
}
}

class Transaction {
	Account5 from;
	Account5 to; 
	int sum_perevoda;
	public Transaction(Account5 from, Account5 to, int sum_perevoda) {
		this.from = from;
		this.to = to;
		this.sum_perevoda = sum_perevoda;} 
	void execute() {
		if (sum_perevoda < from.getSum()) {
			System.out.print("�� ����� " + from.getId() + " ���� " + from.getSum() + "\t");
			System.out.println("�� ����� " + to.getId() + " ���� " + to.getSum());
			from.setSum(from.getSum() -sum_perevoda );
			to.setSum(to.getSum() + sum_perevoda);
			System.out.print("�� ����� " + from.getId() + " ����� " + from.getSum()  + "\t");
			System.out.println("�� ����� " + to.getId() + " ����� " + to.getSum());}
		if (sum_perevoda > from.getSum()) System.out.println("�� ����� " + from.getId() + " ����� " + from.getSum() + ", ��� ������ �������� �������  " + sum_perevoda);
		}
	}
	
class Account5 {
	private String id;
	private int sum;
	public Account5(String id, int sum) {
		this.id = id;
		this.sum = sum; 	}
	public int getSum() {return sum; 	}
	public void setSum(int sum) {this.sum = sum; 	}
	public String getId() {return id; }
}
 