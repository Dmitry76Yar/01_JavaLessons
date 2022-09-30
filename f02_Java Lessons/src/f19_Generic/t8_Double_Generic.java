package f19_Generic;
/* Обобщенные типы в качестве ограничений
Здесь двойной Generic - для класса Transaction1 T переменная должна быть только объектом класса Account6
Второй - Generic тип для переменной id класса Account6 */ 

public class t8_Double_Generic {
public static void main(String[] args) {
		Account7 <String> from = new Account7 <String> ("Ivanov", 5000);
		Account7 <String> to = new Account7 <String> ("Petrov", 0);
		Transaction2 <Account7<String>> Perevod = new Transaction2<Account7<String>> (from, to, 6000);   
		Perevod.execute();
	}
	}

	class Transaction2 <T extends Account7<String>> {    //  <T extends Account6>  - указывает, что на входе только объекты класса Account6 
												 // !!!! Важно, что если указать просто <T>, то нельзя будет вызвать методы класса Account6
		private T from;							 // Вместо класса Account6 указываем generic T
		private T to; 
		int sum_perevoda;
		public Transaction2(T from, T to, int sum_perevoda) {
			this.from = from;
			this.to = to;
			this.sum_perevoda = sum_perevoda;} 
		void execute() {
			if (sum_perevoda < from.getSum()) {
				System.out.print("На счету " + from.getId() + " было " + from.getSum() + "\t");
				System.out.println("На счету " + to.getId() + " было " + to.getSum());
				from.setSum(from.getSum() -sum_perevoda );
				to.setSum(to.getSum() + sum_perevoda);
				System.out.print("На счету " + from.getId() + " стало " + from.getSum()  + "\t");
				System.out.println("На счету " + to.getId() + " стало " + to.getSum());}
			if (sum_perevoda > from.getSum()) System.out.println("На счету " + from.getId() + " сумма " + from.getSum() + ", что меньше перевода равного  " + sum_perevoda);
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
	 