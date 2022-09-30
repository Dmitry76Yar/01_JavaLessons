package Recursiya;

// Рекурсивно вычисляет сумму элементов массива

import java.io.*;

public class r01_Summa_element_massiva	{
	
	static int recurs (int a[], int k) {
		if (k==0) return 0;
		return recurs(a, k-1) + a[k];
	}
	
public static void main(String[] args) throws IOException {
	
	int a[] = {1,2,3,4,5,6,7,8,9,10};
	System.out.println(recurs(a, 9));

}
}




