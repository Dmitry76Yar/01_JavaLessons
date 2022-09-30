package f15_Nasledov_Constructors;
/* 
Первое применение super - это вызов конструктора суперкласса из конструктора подкласса для необходимых переменных.
При этом конструкторы суперкласса и подкласса должны совпадать по кол-ву и типу переменных. В пр.случае не будет вызова конструктора суперкласса
Второе применение super - это вызов метода суперкласса из метода подкласса.
Это делается, если мы хотим, чтобы метод выполнился по алгоритму, прописанному в суперклассе + можно дополнить его.
Так метод show подкласса Circle в примере ниже через super.show() вызывает метод show суперкласса и дополняет его */

class TwoDShape3 {
    private int width;
    private int height;
    String name;
    
    TwoDShape3 (int width, int height, String name) {
        this.width = width; 
        this.height = height; 
        this.name = name;}
           
  void show () {
    System.out.print("name = " + name + "\t width = " + width + " \t height = " + height + "\t");}
  
   double area () {
       System.out.println("Метод нужно переопределить");
       return 0.0;}
}
class Circle3 extends TwoDShape3 {
    int radius; 
    Circle3 (int width, int height, String name, int radius) {
        super (width, height, name);
        this.radius = radius;}
    
    void show() {
        super.show();
        System.out.print ("Дополнительно radius = " + radius);}
        
    double area () {
        System.out.print ("\t Area = " + (radius*radius*3.14));
        return (radius*radius*3.14);}
}      
    
class t14_SUPER_in_methods_and_constructors {
public static void main(String args[]) {
   TwoDShape3 Ob1 = new TwoDShape3 (3, 5, "Какая-то фигура");
   Ob1.show();  Ob1.area();
   
   Circle3 Cir1 = new Circle3 (0,0,"Круг", 5);
   Cir1.show();  Cir1.area();
   
   
}}