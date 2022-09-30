package f11_Acess_Types;
// Применение статической переменной

class StaticDemo {
    int x; 
    static int y; 
    // Метод по возврату суммы чисел
        int sum() {
        return (x+y);}
}

class t1_Static_arguments{
public static void main (String args []) {
   StaticDemo ob1 = new StaticDemo();
   StaticDemo ob2 = new StaticDemo();
   ob1.x = 10;  ob2.x = 20;
   System.out.println("Paзyмeeтcя, оb1.х и оb2.х независимы");
   System.out.println(" ob1.x: " + ob1.x + "\t ob2.x: " + ob2.x);    System.out.println();
   
   // Все объекты совместно используют одну общую копию статической переменной
    System.out.println("Cтaтичecкaя переменная у - общая");
    StaticDemo.y = 19;
    System.out.println(" ob1.x: " + ob1.x + "\t ob1.y: " + ob1.y + "\t их сумма =" + ob1.sum());   
    System.out.println(" ob2.x: " + ob2.x + "\t ob2.y: " + ob2.y+ "\t их сумма =" + ob2.sum()); 

//изменения статической переменной в одном объекте оказывают влияние на весь класс
    System.out.println("Если изменить переменную y в одном объекте ob1, то она изменится и во втором ob2");   
    System.out.println("\t Присваиваем новое значение ob1.y = 45");
    ob1.y = 45;
    System.out.println("\t После этого изменения ob2.y тоже изменяется на = " + ob2.y);
      
       
    }
}