package f14_Perechisleniya_enum;
// C���������� ����� values()  ������ ���� �������� ������������ � ��� �������, � ������� �� ���� ����������������

public class t3_Metod_Values_for_enum {
	public static void main(String[] args) {
		
			// ����� values() ���������� ������ ���� �������� ������������:
		Type1[] types = Type1.values();
        for (Type1 s : types) {System.out.println(s); }     
        
        	// ����� valuesOf() "���������" � ���������� temp1 ������ Type1 ���������� ���������  ��� ������� ����������, ���� �� �����
        Type1 temp1 = Type1.valueOf("SCIENCE");
        System.out.println("\n" + temp1);
        
        try { Type1.valueOf("SCIENC__E"); 	} 
        catch (Exception e) {
			System.out.println("�� ���������� ������ ������������");}
	}
}

enum Type1
{   SCIENCE,
    BELLETRE,
    PHANTASY,
    SCIENCE_FICTION
}