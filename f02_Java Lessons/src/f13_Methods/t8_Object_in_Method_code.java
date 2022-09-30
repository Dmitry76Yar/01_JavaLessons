package f13_Methods;
// ПЕРЕДАЧА ОБЪЕКТОВ В КОД МЕТОДА  - использование объектов в качестве переменных, переданных методу
// Метод сравнивает равен ли параллелепипед Object2 параллелепипеду Object1
// Метод SameBlock () возвращает логическое значение true только в том случае, если все три размера обоих параллелепипедов совпадают.

class Figure{
   int a;   int b;  int c;  int volume;
   // Конструктоp
        Figure(int a1, int b1, int c1) {
        a = a1;     b = b1;     c = c1;
        volume = a1*b1*c1;}
 
// Вернуть логическое значение true, если параллелепипеды равны
// Здесь Object.a - это данные для Object1 в обращении к методу в основном коде Object2.SameBlock(Object1)
// Соответсвенно параметр "а" берется для объекта для которого вызывается метод - т.е. для Object2.
    boolean SameBlock (Figure Object){
       if ((Object.a == a) & (Object.b == b) & (Object.c == c)) return true;
       else return false;
        }
} 
class t8_Object_in_Method_code {
     public static void main(String[] args) {
        Figure Object1 = new Figure(2,3,4);
        Figure Object2 = new Figure(2,3,4);
        Figure Object3 = new Figure(4,5,6);
        if (Object2.SameBlock(Object1) == true)      System.out.println("Параллепипеды равны");  else  System.out.println("Параллепипеды различны");   
        if (Object3.SameBlock(Object1) == true)      System.out.println("Параллепипеды равны");  else  System.out.println("Параллепипеды различны");   
                
            }
   } 
   