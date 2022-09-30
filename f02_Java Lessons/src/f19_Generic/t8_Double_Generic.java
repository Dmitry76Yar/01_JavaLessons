package f19_Generic;
/* ���������� ���� � �������� �����������
����� ������� Generic - ��� ������ Transaction1 T ���������� ������ ���� ������ �������� ������ Account6
������ - Generic ��� ��� ���������� id ������ Account6 */ 

public class t8_Double_Generic {
public static void main(String[] args) {
		Account7 <String> from = new Account7 <String> ("Ivanov", 5000);
		Account7 <String> to = new Account7 <String> ("Petrov", 0);
		Transaction2 <Account7<String>> Perevod = new Transaction2<Account7<String>> (from, to, 6000);   
		Perevod.execute();
	}
	}

	class Transaction2 <T extends Account7<String>> {    //  <T extends Account6>  - ���������, ��� �� ����� ������ ������� ������ Account6 
												 // !!!! �����, ��� ���� ������� ������ <T>, �� ������ ����� ������� ������ ������ Account6
		private T from;							 // ������ ������ Account6 ��������� generic T
		private T to; 
		int sum_perevoda;
		public Transaction2(T from, T to, int sum_perevoda) {
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
		
	class Account7 <R>{
		private R id;
		private int sum;
		public Account7(R id, int sum) {
			this.id = id;
			this.sum = sum; 	}
		public int getSum() {return sum; 	}
		public void setSum(int sum) {this.sum = sum; 	}
		public R getId() {return id; }
	}
	 