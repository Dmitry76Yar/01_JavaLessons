package f11_Acess_Types;
/* Статический блок
иногда для подготовки к созданию объектов в классе должны быть выполнены некоторые инициализирующие действия. 
Например, нужно сначала задать значения некоторых статических переменных перед тем, как воспользоваться статическими методами класса.
Для этого испол-ся статические блоки. Статический блок выполняется при первой загрузке класса, еще до того, как класс будет использован*/

class StaticBlock {
    static double a;
    static double b;
    
        static {                // - статический блок
        System.out.println("Внутри блока");
        a = Math.sqrt(2.0); System.out.println("Переменная a посчитана в статичeском блоке  и = " + a);
        b = Math.sqrt(4.0); System.out.println();}
    
    StaticBlock(String msg) {
        System.out.println(msg);}
}
        
public class t3_Static_block {
   public static void main(String[] args) {
       StaticBlock b1 = new StaticBlock ("Внутри конструктора");
       System.out.println("Переменная a = " + StaticBlock.a);
       System.out.println("Переменная b = " + b1.b);
    }
}
        
        
  