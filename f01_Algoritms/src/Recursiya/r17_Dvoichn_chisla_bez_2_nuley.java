package Recursiya;

// T: Без двух нулей
//  Определите, сколько существует последовательностей из k нулей и единиц, в которых никакие два нуля не стоят рядом.

public class r17_Dvoichn_chisla_bez_2_nuley {
	
    public static int recursion(int k, String str, int counter, int allZeros, int zerosInRaw) {
    	// counter - счетчик глубины рекурсии 
    	// store[] - массив для хранения чисел
    	// k - количество чисел в сочетании
    	int result = 0;
    	if (counter == k) {
    		System.out.print(" str = " + str + "  , allZeros = " + allZeros + "  , zerosinRaw = " + zerosInRaw);
    		if (zerosInRaw>=2) {
    			System.out.println("  , res = 0");
    			return 0;
    		}
    		else {
    			System.out.println("  , res = 1");
    			return 1;
    		}
    	}
    	else {
//    		System.out.println(" str = " + str + "  zerosInRaw = " + zerosInRaw +  "   , allZeros " + allZeros);
	   		for (int i = 0; i<2; i++) {
	   			if (i==0) {
	   				if (zerosInRaw >=2) result = result + recursion(k, str + "0", counter+1, allZeros+1, zerosInRaw);
	   				else result = result + recursion(k, str + "0", counter+1, allZeros+1, zerosInRaw+1);
	   			}
	   			else {
	   				if (zerosInRaw >=2) result = result + recursion(k, str + "1", counter + 1, allZeros, zerosInRaw);
	   				else result = result + recursion(k, str + "1", counter + 1, allZeros, 0);
	   			}
	   		}
	   		return result;
    	}
    }
    
    public static void main(String[] args) {
    	int k = 4;
    	System.out.println("Количество чисел без 2-х нулей подряд = " + recursion(k, "", 0, 0,0));
    }
}