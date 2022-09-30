package t23_Files_Path;
/* ������ ������� ������ File ��������� ����� 3 ������: Paths, Path � Files. �� � ���� ���� ������, Path � ��� ���������, � �� �����.
 	 Paths
Paths � ��� ������ ������� ����� � ������������ ����������� ������� get(). ��� ������� ������������� ��� ����, ����� �� ����������
������ ��� URI �������� ������ ���� Path.
������ ���������������� � ���� ���.

�� �������������� ������������ ������ ����� � ��� �����, �.�. �� ����� ����� ����������
������ Paths.get ���������� ������������ Path.of 

 */
import java.nio.file.Path;
import java.nio.file.Paths;

public class t03_Paths {
public static void main(String[] args) {

	Path testFilePath = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\src\\f22_In_Out_Streams\\FileIn.txt");
	System.out.println(testFilePath);

	}
}
