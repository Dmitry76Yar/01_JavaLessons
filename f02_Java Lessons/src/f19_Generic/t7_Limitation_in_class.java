package f19_Generic;
/* ������� ����� �� ������ ������������ ������� C GENERIC  - �� �� �����, ��� t6_Limitation, �� � Generic
������������� �������� � ��������� �� ��������� ����� ������������ ����� ���. 
����� ����������, ����� �������� �������������� ������ ���������� ������������� ������ �����, ����������� �����������.
� ������ ������ ��� ��������� T � Transaction1 ������������ �������� ����� Account. �� ���� �� ����� ��������� T �� ����� �������� ���� ����� 
Account, ���� ���� �� ��� �������-�����������.

���������� �� �������� ����������� - ������ from, ������� ������������ �������� - ������ to ������ Account5
������� ����� - ��� ������ ������ Transaction, ��� ����������� �������� ������� from � to, � ����� ����� �������� */ 

public class t7_Limitation_in_class {
public static void main(String[] args) {
		Account6 from = new Account6 ("Ivanov", 5000);
		Account6 to = new Account6 ("Petrov", 0);
		Transaction1 <Account6> Perevod = new Transaction1<Account6> (from, to, 6000);   
		// ����� ������� Generic - ��� ������ Transaction1 T ���������� ������ ���� ������ �������� ������ Account6
		// ������ - Generic ��� ��� ���������� if ������ Account6 
		Perevod.execute();
	}
	}

	class Transaction1 <T extends Account6> {    //  <T extends Account6>  - ���������, ��� �� ����� ������ ������� ������ Account6 
												 // !!!! �����, ��� ���� ������� ������ <T>, �� ������ ����� ������� ������ ������ Account6
		private T from;							 // ������ ������ Account6 ��������� generic T
		private T to; 
		int sum_perevoda;
		public Transaction1(T from, T to, int sum_perevoda) {
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
		
	class Account6 {
		private String id;
		private int sum;
		public Account6(String id, int sum) {
			this.id = id;
			this.sum = sum; 	}
		public int getSum() {return sum; 	}
		public void setSum(int sum) {this.sum = sum; 	}
		public String getId() {return id; }
	}
	 