package f00_Bitwise_Opertions;

// Сам написал    Не работает для отрицательных чисел

public class t0_Perevod_int_Any_Sistemu_Chislen {
public static void main(String[] args){
	int N = 6;					// Число цифр в числе
	int K = 3;					// Система счисления

	int chislo_start = (int)Math.pow(K, N-1);
	int chislo_end = (int)(Math.pow(K, N) - 1);
	
    int count = 0;
    int countNum = 0;
    int allFigures = 0;

    for (int chislo = chislo_start; chislo<=chislo_end; chislo++) {
    	 int val = chislo;
    	 count = 0;
  	     StringBuilder sbr = new StringBuilder();
  	     while (val != 0) {
	    	 sbr.append(val%K);
	    	 val = (int)val/K;
	     }
  	     sbr.reverse();
  	   System.out.println("Число = " + chislo + "   в " + K + "-чной системе счисления равно " + N + "-значному числу  " + sbr.toString());
    }

     }
 }
