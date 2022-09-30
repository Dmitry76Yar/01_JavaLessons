package f21_COLLECTIONS;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/*	 � ��� ������� ������ ���� ��������� HashSet � ������ ��������� �� �����? ���� ������� get() � set() � ��������� ���!
 * 
�������� � ��� ����������� ������ � ���������, ������� �������� ������ ��� �������� ��������� � �� �����������.
�������� �������� � ����� ��������� ����� � ������� ����:
	Iterator<���> it = ���.iterator();   
��� ��� � ��� ��� ����������-���������, ��� � ��� ��� ��������� ���������. iterator() � ��� ����� ���������. 
it � ��� ��� ����������-�������-���������.
	� �������-��������� ���� 3 ������:
- next() - ���������� ��������� ������� ��������� 
- boolean hasNext() - ���������, ���� �� ��� �� ���������� ��������
- void remove()  - ������� ������� ������� ���������
�������� ����� ��������� � ���, ��� � ��� �������������� ��� ���������� ��� ����� ����������, ��� � �������������� ����� for-each.
��, �������� ������ ArrayList ������� ����� �������� � ������� ����� for-each � ��� ������ ����������.
	�����!
� ����� for-each ���� ���� �����: �� �� ����� ��������� ������� ��������.
���� ��� ������� ������ ��� ����������e - ������ ���� 
*/

public class t09_Iterator_and_ForEach {
public static void main(String[] args) {
	HashSet<String> set = new HashSet<String>();
	set.add("������");			set.add("Hello");			set.add("Hola");
	set.add("Bonjour");			set.add("Cialo");			set.add("Namaste");
	
		// �������� ������-�������� � ��������� set, ���� ���� ��� ��������
	Iterator<String> it = set.iterator();
	while (it.hasNext())	{
	   String str = it.next();
	   System.out.print(str + "\t");	} System.out.println();
	   
		   // ���� for-each ��� ArrayList
	ArrayList<String> list = new ArrayList<String>();
	list.add("������");			list.add("Hello");			list.add("Hola");
	list.add("Bonjour");		list.add("Cialo");			list.add("Namaste");
	for (String element : list) System.out.print(element + "\t"); 		System.out.println("\n");
	
		/* � ����� for-each ���� ���� �����: �� �� ����� ��������� ������� ��������. ���� �� �������� ����� ���, �������� ������
	for (String element : list) 
		if (element.equals("Hello"))  list.remove(element); */
	
		//	1-�� ������� ������ ��� ����������� - ������������ ���� for.   �� ���� ������� �� �������� ��� ��������� HashSet � HashMap
	System.out.println("Array ���� �� �����a remove() � ����� for-each\t\t\t"  + list);
	for (int i = 0; i < list.size(); i++) {
	   String str = list.get(i);
	   if (str.equals("Hello"))  {
	      list.remove(str);
	      i--; }}				  // ����� ��������� i, �.�. ����� �������� �������� ���������� 
	System.out.println("Array ���� ����� ������ remove() � ����� for-each\t\t"  + list + "\n");
	   
		// 2-�� ������  - ������������� ������ remove() ���������
	System.out.println("���-������� �� ������ remove() � Iterator \t\t\t"  + set);
	Iterator<String> it1 = set.iterator();
	while (it1.hasNext()) 	{
	   String str = it1.next();
	   if (str.equals("Hello"))
	       it1.remove(); 	}	//	�������� ��������, ��� ����� remove() �� �������� � �������-���������!
	System.out.println("���-������� ����� �����a remove()  � Iterator \t\t\t"  + set  + "\n");
	
		// 3-�� ������ - ������������� ����� ���������
//	����� ������� ����� ��������� � ������������ � ����� for-each ���������-�����, � ������� �������� �� ������������ ��������
	System.out.println("Array ���� �� �����a remove() � ����� for-each ��� ����� \t"  + list);
	ArrayList <String> listCopy = new ArrayList<String>(list);
		for (String str: listCopy) {
			if (str.equals("Hola"))    list.remove(str); }
	System.out.println("Array ���� ����� ������ remove() � ����� for-each ��� ����� \t"  + list + "\n");
	
	
	
	}
}