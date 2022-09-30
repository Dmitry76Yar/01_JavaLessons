package f01_Operators_Cycles_Sort;
class t5_ForDoubleCondition{
   public static void main (String[] args){
       int j=3;
   for (int i=1; i<=3; i++) {
   System.out.print ("  i = " + i);
   System.out.println (" ,j = " + j);
   j--;}
   System.out.println ("________double condition__________________");
   
   for (int x=1, y=3; x<=3; x++, y--){
   System.out.println("  x = " + x + " ,y = " + y);}
  
     System.out.println ("________missing condition in brackets______________");  
   for (int n=1; n<10;   ) {
       System.out.print("  n = " + n);
       n = n+2;        }
     
     System.out.println (); System.out.println ("________for+break______________");  
     int nmax = 25;
     for (int n=0;n<nmax;n++){
          if ((n*n)>nmax)break;
     else System.out.print("    number = " +n + ",SQR =" + (n*n));}
    
    System.out.println ();  System.out.println ();  
    for (int n=0; n<10; n++){
        if (n%2 ==1) System.out.print ("  " + n + "  "); // Стандартное условие для нечетных (без continue)  
        }   

System.out.println ();  System.out.println ("________for+coninue______________");;  
    for (int n=0; n<10; n++){
        if (n%2 ==0) continue; //возвращает к условию цикла
        System.out.print ("  " + n + "  "); // до печати доходят только нечетные числа (без возврата к условию)              
        }         
      } //method
  }//class