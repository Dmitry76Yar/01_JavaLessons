package Recursiya;

/* Проверка числа на простоту
Дано натуральное число n>1. Проверьте, является ли оно простым. Программа должна вывести слово YES, если число простое и NO, если
число составное. Алгоритм должен иметь сложность O(logn).
Указание. Понятно, что задача сама по себе нерекурсивна, т.к. проверка числа n на простоту никак не сводится к проверке на простоту
меньших чисел. Поэтому нужно сделать еще один параметр рекурсии: делитель числа, и именно по этому параметру и делать рекурси */

public class r07_BreakToMnogiteli {
	
	public static boolean recursion(int n, int del) {
		if (n<2) return false;
		else if (n == 2) return true;
		else {
					// Базовый случай
			if (n%del == 0) {
				System.out.println("Найден минимальный делител = " + del);
				return true;
			}	
					// Pекурсивное условие
			else {
				if (del<n/2) {
					System.out.println(del + "  не является делителем");
					return recursion(n, del+1);
				}
				else return false;
			}
		}
	}

public static void main(String[] args) {
    	int n = 49;
    	if (recursion(n, 2) == false) System.out.println("It's prostoe chislo");
    	else System.out.println("It's complex chislo");
    }
}



