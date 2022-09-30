package Recursiya;

// T: Без двух нулей
// Даны числа a и b. Определите, сколько существует последовательностей из a нулей и b единиц, в которых никакие два нуля не стоят
//рядом.

public class r20 {
	
    public static int recursion(int N, int zeroTarget, String str, int counter, int zerosCurrent, int onesCurrent) {
    	// counter - счетчик глубины рекурсии 
    	// store[] - массив для хранения чисел
    	// k - количество чисел в сочетании
    	int result = 0;
//    		// Базовый случай
//    	if (zerosCurrent >zeroTarget) return 0;
//    	// Базовый случай
//    	if (onesCurrent >(N-zeroTarget)) return 0;
    		// Базовый случай
    	if (counter == N) {
    		System.out.print(str);
    		if (zerosCurrent == zeroTarget) { System.out.println("   +   "); return 1;}
    		else {System.out.println("   -  "); return 0;}
    	}
    	else {
    		int i_min = 0;
    		if (counter == 0) i_min = 1;
    		for (int i =i_min; i<2; i++) {
    			if (i == 0) result = result + recursion(N, zeroTarget, str + "0", counter+1, zerosCurrent+1, onesCurrent);
    			else result = result + recursion(N, zeroTarget, str + "1", counter+1, zerosCurrent, onesCurrent+1);
    		}
    		return result;
    		
    	}
    }
    
    public static void main(String[] args) {
    	int N = 3    			;		// Количество цифр в двоичном числе
    	int zeroTarget = 3;		// Количество нулей в числе
    	System.out.println(recursion(N, zeroTarget, "", 0, 0, 0));
//    	System.out.println("Количество чисел c " + a + " нулями и " + b + " единицами, а также без 2-х нулей подряд = " + recursion(a, b, "", 0, 0, 0, 0));
    }
}