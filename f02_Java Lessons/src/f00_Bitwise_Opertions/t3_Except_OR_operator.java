package f00_Bitwise_Opertions;

// Статический метода перевода из десятичной в двоичную систему (сам написал). На входе десятичное число
class Perevod2 {  
    public static void perevod(int val1){ 
           // Статический метод может быть вызван без создания объекта, а через класс - Perevod.perevod(int val1)
    int k;
        for(k = 256; k > 0; k = k/2) {
            if (val1/k >=1) {System.out.print("1 "); val1 = val1 - k;}
            else System.out.print("0 ");}   System.out.println();
   }   }
// Статический метод перевода из двоичной системы в десятичную(cам написал). На входе число в строковом выражении
class Obr_Perevod2 {  
    public static void obr_perevod(String fig){ 
    int result = 0; int r;
    for (int i = 0; i<fig.length(); i++)  {
        if (fig.charAt(i) == '1') r =1; else continue;
        for (int j = 1; j<(fig.length()-i); j++)  r = r*2;
        result = result + r;}
        System.out.println("Двоичное число = " + fig + " в десятичной системе = " + result); System.out.println();
   }   }
            
class t3_Except_OR_operator {
    public static void main (String args []) {
   
     // Поразрядная операция исключающего OR обнуляет бит, если у двух чисел эти биты совпадают (равны 1 или 0)
     // Поразрядная операция исключающего OR имеет одну интересную особенность, которая позволяет очень просто шифровать сообщения. 
     // Если выполнить данную операцию сначала над некоторыми значениями х и У, а затем над ее результатом и значением У, то мы снова получим значение Х.

    int x = 123; int y = 124;   
    System.out.print("\t\t Число = " + x + " в двоичной системе - \t");
        Perevod2.perevod(x);  
    System.out.print("\t\t Число = " + y + " в двоичной системе - \t");
        Perevod2.perevod(y); 
    int z = x^y; 
    System.out.print("Число после операции x^y = " + z + " в двоичной системе - \t");
        Perevod2.perevod(z);
    int z2 = z^y; 
    System.out.print("Число после операции z^y = " + z2 + " в двоичной системе - \t");
        Perevod2.perevod(z2);
    System.out.println("Значение х снове вернулось к прежнему значению \n");
    
 // использование поразрядной операции исключающего OR для шифрования и дешифрования сообщений
    String message = "this is a test";
    String temp1 = "";
    String temp2 = ""; 
    int key = 25;
    
    for (int i = 0; i<message.length(); i++)  temp1 = temp1 + (char)(message.charAt(i)^key);
       System.out.print("Строка после декодирования: \t");       System.out.println(temp1);
       
    for (int i = 0; i<temp1.length(); i++)    temp2 = temp2 + (char)(temp1.charAt(i)^key);
    System.out.print("Строка после декодирования: \t");       System.out.println(temp2);
     
         
               }
    }