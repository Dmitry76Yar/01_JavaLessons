package f02_Math;
/*

*/

import java.util.Scanner; 
import java.util.Random;

public class Random_Range {
   public static void main(String[] args) {
	int n = 0;  // Число участников
	int temp;
	int a = 0;
	
	Scanner sc = new Scanner(System.in);
    System.out.println ("Введите число участников N");
    if (sc.hasNextInt() == true)   {
                    temp = sc.nextInt(); 
                    if ((temp>=1)&(temp<=1000)) n = temp;
                    else System.out.println("Число не в том диапазоне");
                }
                else System.out.println("Число не целое"); 
				
	Random random = new Random();
    for (int i = 1; i<=n; i++) {
		temp = random.nextInt(1000);
		if ((temp >= 100) & (temp<= 1000)) a = temp;
		else i = i-1;
		System.out.println(a);}
   }
}