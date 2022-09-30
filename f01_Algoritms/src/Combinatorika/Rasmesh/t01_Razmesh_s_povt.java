package Combinatorika.Rasmesh;

// Даны 4 буквы abcd. Вывести все возможные комбинации.   В том числе aaaa, aaab.....dddd

public class t01_Razmesh_s_povt {
	   public static void brute( String элементы_размещения, int количество ) {  
	      if (количество<=0){
	           System.out.println ("Пожалуйста заполните поле ввода количества элементов корректно!");
	        }
	      if (элементы_размещения == "") {
	          System.out.println("Пожалуйста заполните поле ввода строки корректно!");
	        }
	      brute( элементы_размещения, количество, new StringBuffer () );
	   }
	   private static void brute (String элементы_размещения, int количество, StringBuffer output) {
	       if (количество <= 0){
	          System.out.println (output);
	        }
	        else{
	            for (int i = 0; i < элементы_размещения.length(); i++) {
	                output.append (элементы_размещения.charAt(i));
	                brute (элементы_размещения, количество - 1, output);
	                output.deleteCharAt (output.length() - 1);
	            }
	       }
	   }
	 
public static void main(String[] args) {
	String str = "abcd";
	brute(str, 4);
	
	
	}
}