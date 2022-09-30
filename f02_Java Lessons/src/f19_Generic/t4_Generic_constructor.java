package f19_Generic;
// Конструкторы как и методы также могут быть обобщенными. В этом случае перед конструктором также указываются в угловых
// скобках универсальные параметры:

public class t4_Generic_constructor {
public static void main(String[] args) {

	Account4 acc1 = new Account4("cid2373", 5000);
    Account4 acc2 = new Account4(53757, 4000);
    System.out.println(acc1.getId());
    System.out.println(acc2.getId());
}
}

class Account4 {
private String id;
private int sum;
	<T> Account4(T id, int sum){
		this.id = id.toString();
		this.sum = sum; }
public String getId() { return id; }
public int getSum() { return sum; }
public void setSum(int sum) { this.sum = sum; }
}
	
