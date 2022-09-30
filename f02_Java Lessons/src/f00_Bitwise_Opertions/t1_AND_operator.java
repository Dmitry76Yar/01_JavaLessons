package f00_Bitwise_Opertions;

// Статический метода перевода из десятичной в двоичную систему (сам написал). На входе десятичное число
// Не работает для отрицательных чисел
class Perevod {  
    public static void perevod(int val1){ 
           // Статический метод может быть вызван без создания объекта, а через класс - Perevod.perevod(int val1)
    int k;
        for(k = 65536; k > 0; k = k/2) {
            if (val1/k >=1) {System.out.print("1 "); val1 = val1 - k;}
            else System.out.print("0 ");}   System.out.println();
   }   }
// Статический метод перевода из двоичной системы в десятичную(cам написал). На входе число в строковом выражении
class Obr_Perevod {  
    public static void obr_perevod(String fig){ 
    int result = 0; int r;
    for (int i = 0; i<fig.length(); i++)  {
        if (fig.charAt(i) == '1') r =1; else continue;
        for (int j = 1; j<(fig.length()-i); j++)  r = r*2;
        result = result + r;}
        System.out.println("Двоичное число = " + fig + " в десятичной системе = " + result); System.out.println();
   }   }
            
class t1_AND_operator {
    public static void main (String args []) {
   
    Obr_Perevod.obr_perevod("01111111111011111");
        
 // Операция &. Наиболее часто используется как способ сброса единиц в отдельных двоичных разрядах (битов). 
 // Если какой-либо бит в любом из операндов равен 0, то соответствующий бит результата всегда будет нулевым.
    int x = 123; int y = 124;   
    System.out.print("\t\t Число = " + x + " в двоичной системе - \t");
        Perevod.perevod(x);  
    System.out.print("\t\t Число = " + y + " в двоичной системе - \t");
        Perevod.perevod(y); 
    int z = x&y; 
    System.out.print("Число после операции x&y = " + z + " в двоичной системе - \t");
        Perevod.perevod(z); System.out.println("Если какой-либо бит в любом из операндов равен 0, то соответствующий бит результата всегда будет нулевым");    
    System.out.println();
    
 // Операция & используется для перевода заглавного символа в прописной.
 // Коды строчных букв английского алфавита отличаются от прописных букв на величину 32.
 // Поэтому для преобразования строчных букв в прописные достаточно сбросить в нуль шестой бит в кодах их символов.  
    System.out.print("\tСимвол = " + "A" + "  имеет код ASCII = " + (int)('A') +" в двоичной системе - \t");
        Perevod.perevod('A'); 
    System.out.print("\tСимвол = " + "a" + "  имеет код ASCII = " + (int)('a') +" в двоичной системе - \t");
        Perevod.perevod('a'); 
    System.out.print("\t Число = 65503 в двоичной системе - \t\t\t");
        Perevod.perevod(65503);    
    System.out.print("Символ a после a&65503 =  " + (char)('a'&65503) + "   в двоичной системе - \t\t");
    Perevod.perevod('a'&65503); System.out.println();
    
 // Поразрядная операция & используется, если требуется выяснить, установлен или сброшен отдельный бит числа.
    System.out.print("\t Число = 20 в двоичной системе - \t\t");           Perevod.perevod(20);  
    System.out.print("\t Число = 15 в двоичной системе - \t\t");           Perevod.perevod(15);  
    System.out.print("\t Число = 8 в двоичной системе - \t\t");            Perevod.perevod(8); 
    System.out.print("\t Число = (20&8) в двоичной системе - \t");       Perevod.perevod(20&8);  
    System.out.print("\t Число = (15&8) в десятичной системе - \t");   Perevod.perevod(15&8);  
    if ((20&8 ) !=0) System.out.println("\t Четвертый бит в числе 20 установлен "); else System.out.println("\t Четвертый бит  в числе 20 не установлен");
    if ((15&8 ) !=0) System.out.println("\t Четвертый бит в числе 15 установлен "); else System.out.println("\t Четвертый бит  в числе 15 не установлен");
    // Число 8 обнуляет все биты кроме 4-го. Если в анализируемом числе 4-ый бит равен нулю, то
    // все биты результата (w&8 ) будут обнулены и конечное число будет равно нулю в десятичной системе 
    System.out.println();
    
 // По аналогичному принципу работает код ниже по переводу числа в двоичную систему
 // Происходит сравнение каждого бита со степенными производными двойки (т.е. только один бит равен 1)
    System.out.println("Перевод в двоичную систему с использованием &");
    int chislo = 65503;
    for (int m = 65536; m>0; m=m/2)
        if ((chislo&m) != 0) System.out.print("1 "); else System.out.print("0 "); System.out.println();
    // Для сравнения 
    Perevod.perevod(65503);
 
// Внесение результата в строковый массив 
   int q = 0;
   for (int e = 65536; e>0; e=e/2) q++;
   String Massive[] = new String[q];
   chislo = 65503; int f = 0;
   for (int m = 65536; m>0; m=m/2) {
        if ((chislo&m) != 0) Massive[f] = "1 "; else Massive[f] = "0 "; f++;}
    // Печать массива   
   for (int g = 0; g<Massive.length; g++ )   System.out.print(Massive[g] + ""); System.out.println();

               }
    }