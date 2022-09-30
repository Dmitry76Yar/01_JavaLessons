package Recursiya;

// T: Без двух нулей
// Даны числа a и b. Определите, сколько существует последовательностей из a нулей и b единиц, в которых никакие два нуля не стоят
//рядом.

public class r18_Dvoichn_chisla_bez_2_nuley2 {
	
    public static int recursion(int a, int b, String str, int counter, int zerosInRaw, int a_zero, int b_ones) {
    	// counter - счетчик глубины рекурсии 
    	// store[] - массив для хранения чисел
    	// k - количество чисел в сочетании
    	int result = 0;
    	if (counter == (a+b)) {
    		System.out.print(" str = " + str + " a_zero =  " + a_zero + " ,b_ones = " + b_ones + " , zerosinRaw = " + zerosInRaw);
    		if (zerosInRaw>=2) {
    			System.out.println("  , res = 0");
    			return 0;
    		}
    		else {
    			if ((a_zero == a) && (b_ones == b)) {
	    			System.out.println("  , OK, res = 1");
	    			return 1;}
    			else {
    				System.out.println("  , 2 zeroes in raw, but wrong numbers of zeroes and ones");
	    			return 0;
    			}
    		}
    	}
    	else {
//    		System.out.println(" str = " + str + "  zerosInRaw = " + zerosInRaw +  "   , allZeros " + allZeros);
	   		for (int i = 0; i<2; i++) {
	   			if (i==0) {
	   				if (zerosInRaw >=2) result = result + recursion(a,b, str + "0", counter+1, zerosInRaw, a_zero+1, b_ones);
	   				else result = result + recursion(a,b, str + "0", counter+1, zerosInRaw+1, a_zero+1, b_ones);
	   			}
	   			else {
	   				if (zerosInRaw >=2) result = result + recursion(a,b, str + "1", counter + 1, zerosInRaw, a_zero, b_ones+1);
	   				else result = result + recursion(a,b, str + "1", counter + 1, 0, a_zero, b_ones+1);
	   			}
	   		}
	   		return result;
    	}
    }
    
    public static void main(String[] args) {
    	int a = 2;
    	int b = 2;
    	System.out.println("Количество чисел c " + a + " нулями и " + b + " единицами, а также без 2-х нулей подряд = " + recursion(a, b, "", 0, 0, 0, 0));
    }
}