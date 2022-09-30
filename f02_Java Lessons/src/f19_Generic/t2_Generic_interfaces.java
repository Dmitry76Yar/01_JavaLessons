package f19_Generic;
// ����������, ��� � ������, ����� ����� ���� �����������. �������� ���������� ��������� Accountable � ���������� ��� � ���������:

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
		// ��� ���������� ��������� ���������� ���� ��� ���������.
class Account2 implements Accountable <String> {  /* ������ ���������, ����� ��� ���������� ��� �������������� ��������� ���������� ��������
													���������� ���, ��� ��������, � ������ ������ ��� ��� String. ����� �����, ����������� 
													���������, ������ �������� � ����� ����.  */
	private String id;
	private int sum;
	Account2(String id, int sum) {
		this.id = id;
		this.sum = sum;	}
	public int getSum() { return sum; }
	public String getId() {	return id;}
	public void setSum(int sum) {this.sum = sum;} 
}

class Account3<T> implements Accountable<T> {		/* ������ ��������� ������������ ����������� ����������� ������, 
											������� ����� ���������� ��� �� ������������� ��������:  */
	private T id;
	private int sum;
	Account3(T id, int sum) {
		this.id = id;
		this.sum = sum;}
	public int getSum() { return sum;}
	public void setSum(int sum) { this.sum = sum;}
	public T getId() {return id;}
}

