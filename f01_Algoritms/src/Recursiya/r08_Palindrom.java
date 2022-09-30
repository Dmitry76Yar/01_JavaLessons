package Recursiya;

/* Палиндром
Дано слово, состоящее только из строчных латинских букв. Проверьте, является ли это слово палиндромом. Выведите YES или NO.
При решении этой задачи нельзя пользоваться циклами, в решениях на питоне нельзя использовать срезы с шагом, отличным от 1. */

public class r08_Palindrom {
	
	public static boolean recursion(String str, int k) {
		if (k >= str.length()/2) return true;
		else { 
			if (str.charAt(k) != str.charAt(str.length()-1-k)) {
				System.out.println("Symbol str[" + k + "] differs from symbol str[" + (str.length()-1-k) + "]");
				return false;
			}
			else {
				System.out.println("Symbol str[" + k + "] is equal to symbol str[" + (str.length()-1-k) + "]");
				return recursion(str, k+1);
			}
			
		}
	}

public static void main(String[] args) {
    	String str = "ABCCBA";
    	if (recursion(str, 0) == true) System.out.println("This word is PALENOM");
    	else System.out.println("No PALENOM");
    }
}



