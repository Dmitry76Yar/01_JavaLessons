/* ����� � ���������������
%d: ��� ������ ����� �����  		%x: ��� ������ ����������������� �����  	%f: ��� ������ ����� � ��������� ������
%e: ��� ������ ����� � ���������������� �����, ��������, 1.3e+01	%c: ��� ������ ���������� �������
%s: ��� ������ ��������� ��������
 */

package f00_Basic;

public class t7_PrintF {
public static void main(String[] args) {
	String name = "Tom";
    int age = 30;
    double height = 1.7;
    System.out.printf("Name: %s  Age: %d  Height: %f \n", name, age, height);
 /* ��� ������ ����� � ��������� ������ �� ����� ������� ���������� ������ ����� �������, ��� ����� ���������� ������������ �� %.2f, ��� 
.2 ���������, ��� ����� ������� ����� ��� ����a    */
    System.out.printf("Name: %s  Age: %d  Height: %.2f \n", name, age, height);

	}
}
