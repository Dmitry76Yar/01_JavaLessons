package Recursiya;

/* P: Заданная сумма цифр
Даны натуральные числа k и sum. Определите, сколько существует k-значных натуральных чисел, сумма цифр которых равна sum. Запись
натурального числа не может начинаться с цифры 0.
В этой задаче можно использовать цикл для перебора всех цифр, стоящих на какой-либо позиции. 	*/

public class r14_MultyCycle {
	
	static int result = 0;
	
    public static int recursion(int counter, int sum, int k, int sumNeeded) {
    	// counter - счетчик глубины рекурсии 
    	// store[] - массив для хранения чисел
    	// k - количество чисел в сочетании
    	
    	int i_min = 0;
    	if (counter == 0) i_min = 1;
    	if (counter<k) {
    		for (int i = i_min; i<=9; i++) {
    			System.out.print(i + " -> ");
    			if (recursion(counter+1, sum+i, k, sumNeeded) == sumNeeded) {
    				result++;
    				System.out.println("result = " + result);
    			}
    		}
    		return -100;
    	}
    	else {
    		System.out.println("sum = " + sum);
    		return sum;
    	}
    }
    
public static void main(String[] args) {
	recursion(0,0,3,10);
    System.out.println(result );
    }
}