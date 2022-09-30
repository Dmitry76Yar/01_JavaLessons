package Search_in_Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// �������� ������ �������� - ���������� ������ �������� ��� -1, ���� ������� �� ������ 

public class Search_in_Array {
	
	static ArrayList<Integer> listFoundElements = new ArrayList<Integer>();
		
		// �������� ��������� ������ �������� � �������		����� ������ - O(N)
	public static int linerSearch (int Arr[], int elementToBeFound) {
		for (int i = 0; i<Arr.length; i++) {
			if (Arr[i] == elementToBeFound) return i;		// ���������� ������ ��������� �������
		}
		return -1;
	}
	
		// �������� ��������� ������ �������� � �������				������ ������ ���� ������������
		// ������ �������� ������� ������ ���������� ����������� ������� (�� ������� ������ ������� ������� �������)
	public static int binarySearch (int Arr[], int startIndex, int endIndex, int elementToBeFound) {
				// ���������� ������������� ������� �� ������� ��������� �������, ���� �� ������, �� ���������� ����� ������ 
				// � ����� �������� ������� � ��� ����� ����������
		if (endIndex >=startIndex) {
			int middleIndex = (startIndex + endIndex)/2;
			System.out.println("startIndex = " + startIndex + "   , endIndex = " + endIndex + "   , middleIndex = " + middleIndex);
			if (Arr[middleIndex] == elementToBeFound) return middleIndex;
			if (Arr[middleIndex] > elementToBeFound) return binarySearch(Arr, startIndex, middleIndex - 1, elementToBeFound);
			else return binarySearch(Arr, middleIndex+1, endIndex, elementToBeFound);
		}
		return -1;
	}
	
	public static ArrayList<Integer> binarySearchAllElements (int Arr[], int startIndex, int endIndex, int elementToBeFound) {
			// ���������� ������������� ������� �� ������� ��������� �������, ���� �� ������, �� ���������� ����� ������ 
				// � ����� �������� ������� � ��� ����� ����������
		if (endIndex >=startIndex) {
			int middleIndex = (startIndex + endIndex)/2;
			System.out.println("startIndex = " + startIndex + "   , endIndex = " + endIndex + "   , middleIndex = " + middleIndex);
			if (Arr[middleIndex] == elementToBeFound) 	listFoundElements.add(middleIndex);
			if (Arr[middleIndex] > elementToBeFound)  binarySearchAllElements(Arr, startIndex, middleIndex - 1, elementToBeFound);
			else  binarySearchAllElements(Arr, middleIndex+1, endIndex, elementToBeFound);
		}
		return listFoundElements;
	}
	
public static void main(String[] args) {
	int[] testArr = new int[]{6,3,8,2, 6,9,4,11,1, 57, 57, 75};
	System.out.println("�������� �����:   " + linerSearch(testArr, 57));
	
	Arrays.sort(testArr);
	System.out.println("�������� �����:   " + binarySearch(testArr, 0, testArr.length, 57) + "\n");	
	
	ArrayList<Integer> listFoundElements = new ArrayList<Integer>();
	listFoundElements = binarySearchAllElements(testArr, 0, testArr.length, 57);
	System.out.println(listFoundElements);
	}
}
