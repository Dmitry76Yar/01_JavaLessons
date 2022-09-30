package f00_Bitwise_Opertions;

// Статический метода перевода из десятичной в двоичную систему (сам написал). На входе десятичное число
class Perevod1 {  
    public static void perevod(int val1){ 
           // Статический метод может быть вызван без создания объекта, а через класс - Perevod.perevod(int val1)
    int k;
        for(k = 65536; k > 0; k = k/2) {
            if (val1/k >=1) {System.out.print("1 "); val1 = val1 - k;}
            else System.out.print("0 ");}   System.out.println();
   }   }
// Статический метод перевода из двоичной системы в десятичную(cам написал). На входе число в строковом выражении
class Obr_Perevod1 {  
    public static void obr_perevod(String fig){ 
    int result = 0; int r;
    for (int i = 0; i<fig.length(); i++)  {
        if (fig.charAt(i) == '1') r =1; else continue;
        for (int j = 1; j<(fig.length()-i); j++)  r = r*2;
        result = result + r;}
        System.out.println("Двоичное число = " + fig + " в десятичной системе = " + result); System.out.println();
   }   }
            
class t2_OR_operator {
    public static void main (String args []) {
   
    Obr_Perevod1.obr_perevod("01111111111011111");
 
 // Поразрядная операция OR выполняет действия, противоположные поразрядной операции AND, и служит для установки отдельных битов.
 // Любой бит, значение которого равно единице хотя бы в одном из двух операндов, в результирующем значении будет l. 

    int x = 123; int y = 124;   
    System.out.print("\t\t Число = " + x + " в двоичной системе - \t");
        Perevod1.perevod(x);  
    System.out.print("\t\t Число = " + y + " в двоичной системе - \t");
        Perevod1.perevod(y); 
    int z = x|y; 
    System.out.print("Число после операции x|y = " + z + " в двоичной системе - \t");
        Perevod1.perevod(z); System.out.println("Любой бит, значение которого равно единице хотя бы в одном из двух операндов, в результирующем значении будет l");    
    System.out.println();
    
 // Операция & используется для перевода прописного символа в заглавный.
 // Коды строчных букв английского алфавита отличаются от прописных букв на величину 32.
 // Поэтому для преобразования прописных букв в строчные достаточно поставит единицу в шестом бите в кодах их символов.
 // В двоичном представлении значения 32 установлен только шестой бит 
    System.out.print("\tСимвол = " + "A" + "  имеет код ASCII = " + (int)('A') +" в двоичной системе - \t");
        Perevod1.perevod('A'); 
    System.out.print("\tСимвол = " + "a" + "  имеет код ASCII = " + (int)('a') +" в двоичной системе - \t");
        Perevod1.perevod('a'); 
    System.out.print("\t Число = 32 в двоичной системе - \t\t\t");
        Perevod1.perevod(32);    
    System.out.print("Символ A после A|32 =  " + (char)('A'|32) + "   в двоичной системе - \t\t");
    Perevod1.perevod('A'|32); System.out.println();
    
               }
    }