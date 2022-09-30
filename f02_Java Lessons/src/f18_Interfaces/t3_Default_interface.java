package f18_Interfaces;

/* ����� �� JDK 8 ��� ���������� ���������� �� ������ ���� ����������� ����������� ��� ��� ������ � ������. 
� ��� ��������� ��� ��������� ������ ����������� ������� ��� ���������� ����������. � JDK 8 ���� ��������� ����� ����������������
��� ������ �� ���������. � ������ ���������� ����� ����������� ������� ����� ����� �� ���������� �� ���������, ������� ������������, 
���� �����, ����������� ������ ���������, �� ��������� �����. ��������, �������� ����� �� ��������� � ���������� Printable:   */

public class t3_Default_interface {
	public static void main(String[] args) {
		Moto moto1 = new Moto(200); 
		moto1.inform();		// ����� ������, ����������������� � ������
		moto1.print();		// ����� Default ������ ����������
		System.out.println(moto1.calculator(100,200));		// � ����������� ����� ������������ �������
		Vehicle.notice();
	}

}

class Moto implements Vehicle { 
	private int Max_speed;
	Moto (int Max_speed) {
		this.Max_speed = Max_speed;}
	int getMaxSpeed () {
		return Max_speed;}
	public void inform() {
		System.out.println("����� ����������������� ������ ������   ������������ �������� = " + Max_speed);
	}
}
	
interface Vehicle {
	void inform();
	
	default void print () {
		System.out.println("����� ������ ���������� �� ���������");}
	
	default int calculator (int a, int b) {
		System.out.println("����� ������ ���������� �� ��������� ��� �������� ");
		return (a+b);} 
	
	static void notice() {
		System.out.println("����� ������������ ������ ����������");}
}