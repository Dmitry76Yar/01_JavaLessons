package f14_Perechisleniya_enum;
/* ������������, ��� � ������� ������, ����� ���������� ������������, ���� � ������
������������ Color ���������� ��������� ���� code ��� �������� ���� �����, � � ������� ������ getCode ��� ������������. 
����� ����������� ���������� ��� ���� ��������. ������� ��������, ��� ����������� �� ��������� ���������, �� ���� ����� ����������� private.
����� ������ ����������� ����� ��������� �������. ������� ������� ��������� ������������ � ������� ������������ �� ����� ������ ������ 
������������.  */

public class t5_Peremen_in_enum {
public static void main(String[] args) {
		
	System.out.println(Color.RED.get_code() + "\t" + Color.RED.get_popularity());        
    System.out.println(Color.GREEN.get_code());  
    
    }
}

enum Color {
	RED("FF2222", "popular"), BLUE("FF3333", "unpopular"), GREEN("FF4444", "unpopular");   // �������� �������� ����� ����������� ���������� ����� � ������ ������������
	private String color_code;				// ������������� ���������� �������
	private String popularity;
	Color (String color_code, String popularity) {				// �����������			
		this.color_code = color_code; 	
		this.popularity = popularity;}
	public String get_code () {				
		return color_code;}
	public String get_popularity () {				
		return popularity;}
}
	