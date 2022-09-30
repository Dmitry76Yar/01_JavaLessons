package f19_Generic;

public class t10_Nasledov_classov_generic {
public static void main(String[] args) {
	
	DepositAccount <Integer> dep1 = new DepositAccount <Integer> (20, "Ivanov"); 
	System.out.printf("ѕри введении в качестве id типа integer:  id = %d, name = %s \n", dep1.getId(), dep1.getName());
	DepositAccount <String> dep2 = new DepositAccount <String> ("Null", "Petrov"); 
	System.out.printf("ѕри введение в качестве if типа String:  id= %s, name  = %s \n", dep2.getId(), dep2.getName());
	
	CreditAccount <Integer, String> credit1 = new CreditAccount <Integer, String>  (20, "Sidorov", 5500);
	/* class CreditAccount <T,S> extends Account9 <T>     - значит дл€ <T> присвоен Integer дл€ <S> - String,  		
	 <T> задан дл€ id, <S> задан дл€ name	 		конструктор CreditAccount(T id, S name, int sum) */
	System.out.printf("ƒанные дл€ credit1: id = %d, \t name = %s, \t sum = %d\n", credit1.getId(), credit1.getName(), credit1.getSum());
	
	SaveAccount sav1 = new SaveAccount(20344, 10000) ;
	System.out.printf("ƒанные дл€ sav1: id = %d, \t sum = %d\n", sav1.getId(), sav1.getSum());
	
	MoneyAccount <Integer> mon1 = new MoneyAccount <Integer> ("Smirnov", 10434543);
	System.out.printf("ƒанные дл€ mon1: name = %s, \t id = %d\n", mon1.getId(), mon1.getId());
}}

class Account9 <T>{		
	private T id; 
	T getId() {return id;}
	Account9(T id) { 
		this.id = id; 	}}

class Account10 {
	private String name;
	Account10(String name) {
		this.name = name; } } 

	// ѕри наследовании от суперкласса с Generic класс-наследник должен передавать данные о типе в конструкции базового класса:
class DepositAccount <T> extends Account9<T> {
	private String name;
	public String getName() { return name;}
	DepositAccount(T id, String name) {	// ¬ конструкторе DepositAccount идет обращение к конструктору базового класса
		super(id);
		this.name = name;} }

	//  ласс-наследник может добавл€ть и использовать также свои обобщенные типы (Generic)
class CreditAccount <T,S> extends Account9 <T> {	
	private S name; 
	private int sum;
	public S getName() {return name; }
	public int getSum() { return sum; }
	public void setSum(int sum) { this.sum = sum;}
	CreditAccount(T id, S name, int sum) {
		super(id);
		this.name = name;
		this.sum = sum; } }

	//  ласс наследник  может сразу при создании определ€ть тип обобщенной переменной суперкласса
class SaveAccount extends Account9 <Integer>  {	 // - здесь переменной суперкласса  id сразу задаетс€ тип Integer
	int sum;
	public int getSum() { return sum; 	}
 	public void setSum(int sum) { this.sum = sum; 	}
	SaveAccount(Integer id, int sum) {
		super(id);
		this.sum = sum;} }

	/* —уперкласс не содержит обобщений, а класс-наследник определ€ет свои собственные обобщеннные переменные*/
class MoneyAccount <T> extends Account10 {
	private T id;
	public T getId() { 	return id; 	}
	MoneyAccount(String name, T id) {
		super(name); 
		this.id = id;}
}



