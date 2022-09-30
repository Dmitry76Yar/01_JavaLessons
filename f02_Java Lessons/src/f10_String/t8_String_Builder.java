/*   ������� String �������� �������������, ������� ��� ��������, ������� �������� ������, ���������� �������� � �������� ����� ������, 
��� ����������� �� ������������������ ����������. ��� ������� ���� ��������, ����� ������ �� �������� ��������� � �������� ����������
 � Java ���� ��������� ������ StringBuffer � StringBuilder. �� ���� ��� ���������� ����������� ������.  
     ��� ������ ������, ����������� ��������, ��� ����� ���������� ������������, ���� � �� �� ������, ������� ��������� ������������. 
������������ �� �������� ������� � ���, ��� ����� StringBuffer ������������������ � ����������������. �� ���� ����� StringBuffer �������
������������ � ������������� �����������, ��� ������ ������� ������ ����� �������� � ��������� �������. ���� �� ���� � ������������� 
����������� �� ����, �� ����� ������������ ����� StringBuilder, ������� �� ����������������, �� ��� ���� �������� �������, ��� StringBuffer 
� ������������ �����������.  */

package f10_String;

public class t8_String_Builder {
public static void main(String[] args) {
	String str = "Java";
		
		// �������� ������� StringBuilder 
	StringBuilder strA = new StringBuilder();   // ����������� StringBuffer(int capacity) - ����������� 16 ���� ��� ��������
	StringBuilder strB = new StringBuilder(30);   // ����������� StringBuffer(int capacity) - ����������� �������� ����� ���� ��� ��������
	StringBuilder strC = new StringBuilder(str);  // ����������� StringBuffer(String str) - ������ ������ str � ���� ����������� 16 ���� ��� ��������
	StringBuilder strD = new StringBuilder("������������� ��� ������������� �������" );
		//StringBuilder strE = new StringBuilder('a','b','c','d');      // ����������� StringBuffer(CharSequence chars) 	- ������ ��������������� �������� + 16 ���� ��� ��������
	  	
		// ������ � �������
	System.out.println(strC.toString()); // ��� ������ ����� ��������� � String
	System.out.println(strD.toString()); 
		
		// � ������� ������ capacity() �� ����� �������� ���������� ��������, ��� ������� ��������������� ������. 
	System.out.println("Capacity strC= " + strC.capacity()); 
	System.out.println("Capacity strC = " + strC.length());   // ���-�� �������� � ������ �� �����
		
		// C ������� ������ ensureCapacity() �������� ����������� ������� ������ ��������
	strC.ensureCapacity(40);
	System.out.println("Capacity strC= " + strC.capacity()); 
		
		// ����� charAt() �������� ������ �� ������������� �������:
	char c = strC.charAt(0); 
	System.out.println(c);

		//����� setCharAt() ������������� ������ �� ������������� �������:	
	strC.setCharAt(0, 'j');
	System.out.println(strC.toString()); 	
		
		//����� getChars(int Begin, int End, char dst[], int Begin) �������� ����� �������� ����� ������������� ���������:
	int StartIndex = 0;
	int EndIndex = 3;
	char[] Array = new char[EndIndex - StartIndex];
	strC.getChars(StartIndex, EndIndex, Array, 0);
	System.out.println(Array);
		
		// ����� append() ��������� ��������� � ����� StringBuilder
	char d = '_';		strC.append(d);   	System.out.println(strC.toString());    // ���������� �������
						strC.append(Array);	System.out.println(strC.toString());	// ���������� ������� ��������
						strC.append(2);		System.out.println(strC.toString());	// ���������� ����� Int
						strC.append(3.0);	System.out.println(strC.toString());	// ���������� ����� Double
						strC.append("_is_cool");	System.out.println(strC.toString());	// ���������� ������

		// ����� delete(int start, int end) ������� ��� ������� � ������������� ������� �� ������������ �������, 
	strC.delete(4,10);
	System.out.println("����� �������� \t" + strC.toString());
						
		// ����� deleteCharAt() ������� ���� ������ �� ������������� �������:
	strC.deleteCharAt(5);	strC.deleteCharAt(4);
	System.out.println("����� �������� ������� \t" + strC.toString());

		// ����� insert() ��������� ������ ��� ������ �� ������������� ������� � StringBuilder:
	strC.insert(0, 'J');	System.out.println(strC.toString());	// ���������� ������� �� �������� �������
	strC.insert(1, "1234_"); System.out.println(strC.toString());	// ���������� ������ � 1 �������

		// ����� substring() �������� ������ � ������������� ������� �� �����, ���� �� ������������� �������:
	// �������� ������ � ��������� � ������ ������
	String str1 = strC.substring(6); 	System.out.println("��������� � 6-�� ������� \t" + str1);	// �������� � 6 ������� � �� �����
	String str2 = strC.substring(6, 9);	System.out.println("��������� 6-9 \t" + str2);	// �������� � 6 ������� � �� 9
						
		// ��� ������ ��������� ����� ������������� ��������� � StringBuilder �� ������ ��������� ����������� ����� replace():
	strC.replace(0, 6, "!!!!!!!!!!!!");	 	System.out.println(strC.toString());	

		// ����� reverse() ������ ������� � StringBuffer �� ��������:
	strC.reverse(); 	System.out.println(strC.toString());
	strC.reverse(); 	System.out.println(strC.toString());				
						
	}
}