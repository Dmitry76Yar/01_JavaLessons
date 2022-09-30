package f11_Acess_Types;
// Применение статической переменной

class Demo {
    static int val = 1024;      // Cтатическая переменная
    int a = 35;
      static int Div2() {    // Статический метод деления на 2
      return val/2;}
        //Важно, что из статического метода нельзя обращаться к нестатической переменной
        // Такой код приведет к ошибке return (val/а);}
      
}

class t2_Static_Method{
public static void main (String args []) {
    System.out.println("Знaчeниe val (чтение из класса) : " + Demo.val);
    System.out.println("Вызов метода по классу (без объекта) Demo.Div2()  \t с результатом: " + Demo.Div2());
    
    Demo.val = 4;
    System.out.println("Статической переменной было присвоено новое значение = 4");
    System.out.println("Теперь val = " + Demo.val + "  , а результат метода Div2 =   " + Demo.Div2());
     
    
    }
}