package f02_Math.Perebor;
 /* ��� � ����������� pdf �����
���������. � ��� ������� n ��������� ������������ �������, ���������� ����� �����. 
���������� �� ���� ��������� ������������ ������ �� m ��������� � ������ ������, ��� m �� ��������� n, 
�����, ��� ��� �������� � ������ ������ �������� � ����� ��� ������ ����������� �������� �������� � ��� 
���������. ��� ������ � ���������� ����������� �� n ��������� �� m    */

import static java.lang.System.out;
import java.util.Arrays;

class t1_Sochetaniya {
	private static final int N = 5;  // �� ��������� � N ������� �������� ��������� �� � ���������� ��� �������
    private static final int M = 3;  
    
    private static int[] generateCombinations(int[] arr) {
		//System.out.println("ENTER");
        if (arr == null)  {   // ��� 1-�� ��������� �� ����� ������ ������. ���� ���������� ��� {1,2,3..M}
            arr = new int[M];
            for (int i = 0; i < M; i++)
                arr[i] = i + 1;
            return arr;
        }
/* ��� ���������� �������� ���� ��������� ��� �������� � (N - M + i + 1), ��� true ���� ���������� ����� �������� �� �������. 
������ ���� for ��� ���������� �������� ������ fals�, ������� ���������� return � ����� �� ������� ����� for � main ���,  ����
����� ���������� �� ������ � ����� ����� ������ generateCombinations(int[] arr) (�� �� ���������� �������� � ����� for).
� ����� ����� ����� {1,2,4} � {1,2,5}.
   ����� ���������� ���������� �������� ������������� �������� = 5, ������� (N - M + i + 1) ���������� False � ���� ������� �� 
������������� �������. �� ������������ � (N - M + i + 1) � ��� True ������������� �� �������, � ����� ���� ������� �� ������ ����,
��� (�������������� + 1) = ���������� �������� ������������� �������� �� ������� ������, ��� ������������� �������. 
� ����� ����� ����� {1,3,4}
   ���� ����� ����� ������ � ������� � ������� ����� � �������� ����� i = 2. ��� ��� ��������� ������� (i = 2) ������ �� ����� � 
����� ����� 4, �.�. �� ������ ��������� ���� ��� ���������� �� ������� � ������ �����. ����� ����� {1,3,5}
  �� ����� ��������� ������� = 5, � ������ �������  (N - M + i + 1) = False. � ���������� ��������� � �������������� ��������.
��� ��� �� ����� 3 � �������������� ��� �� ������ ������ ��������� 4 ���� ��� ���������. ����� ����� {1,4,5}
  ����� ��������� � 1-�� �������� � �.�. 
 */
        
        for (int i = M - 1; i >= 0; i--) {
			// System.out.println(" i = " + i);
			if (arr[i] < N - M + i + 1)
            {
                arr[i]++;
                for (int j = i; j < M - 1; j++) {
					// System.out.println("hh");
				arr[j + 1] = arr[j] + 1; }
                return arr;
		}}
        return null;
		
    }
    public static void main(String args[])
    {
        int[] arr = null;
        while ((arr = generateCombinations(arr)) != null)  out.println(Arrays.toString(arr));
           }
}