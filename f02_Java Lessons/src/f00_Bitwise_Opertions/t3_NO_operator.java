package f00_Bitwise_Opertions;

class t0_Perevod_v_dvoichn1 {
public static void perevod (int chislo) {
 // Происходит сравнение каждого бита со степенными производными двойки (т.е. только один бит равен 1)
    System.out.print("Число = " + chislo + " в двоичной системе - \t");
    for (int m = 65536; m>0; m=m/2)
        if ((chislo&m) != 0) System.out.print("1 "); else System.out.print("0 "); System.out.println();
                  }
    }
            
class t3_NO_operator {
    public static void main (String args []) {
  // Унарная поразрядная операция НЕ (или дополнения до l) изменяет на обратное состояние всех битов операнда.
     
    byte b = -34; int y = 124;   
    t0_Perevod_v_dvoichn.perevod(b); 
    
Perevod1.perevod(y);    
    System.out.print("\t\t Число = " + y + " в двоичной системе - \t");
        Perevod1.perevod(y); 
    byte z = (byte)~b; 
    System.out.print("Число после операции ~x = " + z + " в двоичной системе - \t");
        Perevod1.perevod(z);
    
    
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