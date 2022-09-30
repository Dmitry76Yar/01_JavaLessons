package f18_Interfaces;
/*���������� ��� ��������� � ���������� �������
����� ��� � � ������ � ��������, ���������� ����� �������������� � �������� ���� ���������� ������ ��� � �������� ������������� ����
����� inform() � �������� ��������� ��������� ������ ���������� Building, ������� � ���� ����� �� ����� �������� ��� ������ House, ���
� ������ Garage.*/

public class t5_Interfase_as_input_parameters {
	public static void main(String[] args) {
		Building house1 = new House (12,4);
		Building garage1 = new Garage (120, 10);
		inform(house1);			// �������� � ����� inform ������� ���������� Building, ��� ���������� ����� ���������� print
		inform(garage1);		//, ������� ���������������� � ����������� �� ������-���������� ����������
	}
	
static void inform (Building a) { 
	a.print(); }
}

interface Building {
	void print();}

class House implements Building {
	int Width; 
	int Floors; 
	House (int Width, int Floors) {
		this.Width = Width;
		this.Floors = Floors;}
	public void print() {
		System.out.println("Width = " + Width + ",     Floors = " + Floors);}
}

class Garage implements Building  {
	int Square; 
	int Length; 
	Garage (int Square, int Length) {
		this.Square = Square;
		this.Length = Length;}
	public void print() {
		System.out.println("Square = " + Square + ",     Length = " + Length);}
}
	