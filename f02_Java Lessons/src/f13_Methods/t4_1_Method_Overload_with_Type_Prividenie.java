package f13_Methods;
// Автоматическое преобразование типов может влиять на выбор перегружаемого метода.

class Overload{  
   void method_a(int b) {
   System.out.println("Integer метод был инициализораван");}
   
   void method_a(double d) {
   System.out.println("Double метод был инициализораван");}
   
   void method_b(byte e) {
   System.out.println("Byte метод был инициализораван");}
   
   void method_b(double g) {
   System.out.println("Double метод был инициализораван");}
}
   
  class t4_1_Method_Overload_with_Type_Prividenie {
      public static void main (String[] args){
      Overload b1 = new Overload();
      System.out.println("\tByte, Short переменные приводятся к Integer методу");
      System.out.println("\tFloat переменные приводятся к Double методу");
      int k = 1;        System.out.print("Int переменная - \t\t");     b1.method_a(k);
      byte l = 2;       System.out.print("Byte переменная - \t\t");     b1.method_a(l);
      short m = 3;      System.out.print("Short переменная - \t");     b1.method_a(m);
      double n = 4.3;   System.out.print("Double переменная - \t");        b1.method_a(n);
      float o = 6;      System.out.print("Float переменная - \t");        b1.method_a(o);
      System.out.println();
     
      System.out.println("\tОбратное привидение Int в Byte не работает. Как видно ниже byte переменная инициализирует Double метод");  
      k = 1;        System.out.print("Int переменная - \t\t");     b1.method_b(k);
      m = 3;        System.out.print("Short переменная - \t");     b1.method_b(m);
      l=2;          System.out.print("Byte переменная - \t\t");     b1.method_b(l);
      
      }
  }