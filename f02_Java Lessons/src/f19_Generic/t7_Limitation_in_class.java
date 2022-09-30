package f19_Generic;
/* Перевод денег от одного пользователя другому C GENERIC  - то же самое, что t6_Limitation, но с Generic
Универсальный параметр у обобщений по умолчанию может представлять любой тип. 
Когда необходимо, чтобы параметр соответствовал только некоторому ограниченному набору типов, применяются ограничения.
В данном случае для параметра T в Transaction1 ограничением является класс Account. То есть на место параметра T мы можем передать либо класс 
Account, либо один из его классов-наследников.

Информация об аккаунте отправителя - объект from, аккаунт принимающего человека - объект to класса Account5
Перевод денег - это объект класса Transaction, где переменными являются объекты from и to, а также сумма перевода */ 

public class t7_Limitation_in_class {
public static void main(String[] args) {
		Account6 from = new Account6 ("Ivanov", 5000);
		Account6 to = new Account6 ("Petrov", 0);
		Transaction1 <Account6> Perevod = new Transaction1<Account6> (from, to, 6000);   
		// Здесь двойной Generic - для класса Transaction1 T переменная должна быть только объектом класса Account6
		// Второй - Generic тип для переменной if класса Account6 
		Perevod.execute();
	}
	}

	class Transaction1 <T extends Account6> {    //  <T extends Account6>  - указывает, что на входе только объекты класса Account6 
												 // !!!! Важно, что если указать просто <T>, то нельзя будет вызвать методы класса Account6
		private T from;							 // Вместо класса Account6 указываем generic T
		private T to; 
		int sum_perevoda;
		public Transaction1(T from, T to, int sum_perevoda) {
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
	 