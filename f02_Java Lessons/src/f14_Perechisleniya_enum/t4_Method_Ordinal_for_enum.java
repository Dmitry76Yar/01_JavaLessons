package f14_Perechisleniya_enum;
// ����� ordinal() ���������� ���������� ����� ������������ ��������� (��������� ���������� � 0):

public class t4_Method_Ordinal_for_enum {
	public static void main(String[] args) {
		System.out.println(Type2.PHANTASY.ordinal()); 
    }
}

enum Type2
{   SCIENCE,
    BELLETRE,
    PHANTASY,
    SCIENCE_FICTION
}