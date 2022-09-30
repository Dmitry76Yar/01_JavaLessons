package Recursiya;

/* P: Заданная сумма цифр
Даны натуральные числа k и sum. Определите, сколько существует k-значных натуральных чисел, сумма цифр которых равна sum. Запись
натурального числа не может начинаться с цифры 0.
В этой задаче можно использовать цикл для перебора всех цифр, стоящих на какой-либо позиции. 	*/

public class r14_MultyCycle2 {
	
    public static int recursion(int counter, int sum, int k, int sumNeeded) {
    	// counter - счетчик глубины рекурсии 
    	// store[] - массив для хранения чисел
    	// k - количество чисел в сочетании
    	
    	if (counter == k) {
    		if (sum == sumNeeded) return 1;
    		else return 0;
    	}
    	
    	int i_min = 0;
    	if (counter == 0) i_min = 1;
    	int res = 0;
    	for (int i = i_min; i<=9; i++) {
    		res = res + recursion(counter+1, sum+i, k, sumNeeded);
    	}
    	return res;
    }
    
public static void main(String[] args) {
	System.out.println(recursion(0,0,3,10));
    }
}