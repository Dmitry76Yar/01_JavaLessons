package f00_Bitwise_Opertions;

public class t0_Perevod_v_dvoich {
public static void main (String args []) {
   			// Происходит сравнение каждого бита со степенными производными двойки (т.е. только один бит равен 1)
    System.out.println("Перевод в 8-битную двоичную систему с использованием &");
    byte chislo = 61;
    System.out.print("Число = " + chislo + " в двоичной системе - \t");
     for (int m = 128; m>0; m=m/2) {
          if ((chislo&m) != 0) System.out.print("1 "); 
          else System.out.print("0 ");}
     System.out.println();

     System.out.println("Перевод в 16-битную двоичную систему с использованием &");
     short chislo1 = 127; int i =1;
     for (int m1 = 32768; m1>0; m1=m1/2) {
         if ((chislo1&m1) != 0) System.out.print("1"); 
         else System.out.print("0"); 
         if (i==8) System.out.print(" "); i++;} 
         System.out.println(); 
 
     }
 }