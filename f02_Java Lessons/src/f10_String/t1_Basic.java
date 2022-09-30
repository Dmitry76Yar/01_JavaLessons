package f10_String;

public class t1_Basic {
        // В Java строки - это объекты
 public static void main (String [] args) {
        // Варианты создания строковых объектов
    String s1 = new String("Строки");
    String s0 = s1;
    String s2 = "java";
    String s3 = "эффективны";
    System.out.print (" s0=s1=  " + s0);  System.out.print (" \t s1= " + s1);  
    System.out.print ("\t s2= " + s2);  System.out.print(" \t s3= " + s3); System.out.println();
    System.out.println ("Длина строки s3= " + s3.length());
    
    String temp = ""; 
    String temp1 = "";
    String temp2 = "";
   
   int n = 4;
    String Words[] = {"111"};
        
    // Вставить букву а во все положения, чтобы получить из 111 число из 4-х цифр
         for (int i=0; i<Words.length; i++) 
             if (Words[i].length() == n-1)  {
                for (int j=0; j<=Words[i].length();j++) {
                    temp1 ="";
                    temp2 = "";
                    for (int k=0; k<j; k++ )  
                        temp1 = temp1 + "" + Words[i].charAt(k);
                    for (int k=j; k<Words[i].length(); k++) 
                        temp2 = temp2 + Words[i].charAt(k);
                    temp = temp1 + "0" + temp2;
                    System.out.println(temp); 
                }
             }
    
    String h = "dfdf";
    String h1 = "";
    h1= h;
    System.out.println ("h1 = " + h1);
          
    }
}