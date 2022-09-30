package f21_COLLECTIONS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*���������� ��������� ����������� � ������� Collections.sort(Collection) ��� ���������� ��������. ���� ����� ������������ ��� ���, 
 ��� ��������� ��������� Comparable . ���� ��������� ���������� ����� compare , ������� ��������� �������� ��������� ��������� �
 ���������� -1, ���� ������� ������, ��� ������������ �������, 0, ���� �� ����� � 1, ���� �� ������. ����� �������� �������� �����
 Integer.
 ���� ��� ����������� ��-�������, �� ������ ���������� ���� ����������� ���������� �� ������ ���������� Comparator. 
 ���� ������ ����������� � ���, ��� �� ����� ���������� ����� ������ �� ������ �������� ��� ���� ���������� ���������. 
 ��������, ���� � ��� ���� ������� ���� Person � ��������� income � dateOfBirth, �� ������ ���������� ��������� ���������� ����������� 
 � ������������� ������� � ������������ � ������ �������������. */


public class t13_Collections_Sort_List {
public static void main(String[] args) {
	ArrayList<String> strArray = new ArrayList<String>();
	strArray.add("Tom");		strArray.add("Kristina");		strArray.add("Misha");		strArray.add("Liza");
			
			// 1_sort(list) ��������� ������ �� default ��������� (�������� ������ ��� Sting, Integer..)
	System.out.println("1_sort(list)_������� list �� default ������ - \t\t" + strArray);
	Collections.sort(strArray);
	System.out.println("1_sort(list)_������� list ����� default ������ - \t\t" + strArray + "\n");
	
			// 2_sort(list, Comparator) ��������� ������ �� ��������� ������������� ��������� 
	strArray.add("Anna");		strArray.add("Barbara");
	System.out.println("2_sort(list, Comparator)_������� list �� ������ � �������� Comparator - \t\t" + strArray);
	Comparator<String> lenComp = new LengthComparator();
	Collections.sort(strArray, lenComp);
	System.out.println("2_sort(list, Comparator)_������� list ����� ������ � �������� Comparator - \t\t" + strArray + "\n");
	
			// 3_sort(list, Comparator) � ������������ ����� � ���� ���������
	System.out.println("3_�������� ������� Comparator ����� � ���� ���������");
	System.out.println("3_sort(list, Comparator)_����� � ���� ���������,    list �� ������  - \t\t" + strArray);
	Collections.sort(strArray, new Comparator<String>() {
		@Override												// ��������� �� ������ �����
		public int compare(String o1, String o2) {
			if (o1.charAt(1) > o2.charAt(1)) return 1; 
			else if (o1.charAt(1) < o2.charAt(1)) return -1; 
			else return 0; }		
	});
	System.out.println("3__sort(list, Comparator)_����� � ���� ���������,    list ����� ������  - \t" + strArray + "\n");
	
			
	} 
}

class LengthComparator implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		if (o1.length() > o2.length())		return 1;
		else if (o1.length() < o2.length())	return -1;
		else return 0;}
}