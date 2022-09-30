package f00_Bitwise_Opertions;

class Showbits {
    int numbits;
// Конструктор класса ShowBits позволяет создавать объекты, отображающие заданное число битов. 
// Например, для создания объекта, отображающего 8  битов  - ShowBits x = new ShowBits(8)
    Showbits(int n){
    numbits = n;}
    
// Для вывода двоичных значений в классе ShowBi ts определен метод show ()
    void show(long val) {
        long mask = 1;
        // По сути преобразовывает число 1 в нужную степень числа 2 (для 8 бит - это 128)
        mask <<= numbits-1;
        int spacer = 0;
        for(; mask != 0; mask >>>= 1) { // Каждый раз делит число mask на 2
            if((val & mask) != 0) System.out.print("1");
            else System.out.print("0");
            spacer++;
            if (( spacer % 8) == 0) {
                System.out.print(" ");
            spacer = 0;}
        }
    }        
}
class t5_ShowBits {  
public static void main (String args []) {
    Showbits b = new Showbits(8);
    Showbits i = new Showbits(32);
    Showbits li = new Showbits(64);
    System.out.println("123 в двоичном представлении: ");
        b.show(123);
    System.out.println("\n\n87987 в двоичном представлении: ");
        i.show(87987);
    System.out.println("\n\n237658768 в двоичном представлении: ");
        li.show(237658768);
// Можно также отобразить младшие разряды любого целого числа
    System.out.println("\n\nМлaдшиe 8 битов числа 87987 в двоичном представлении: ");
        b.show(87987);
    }
}