package f15_Nasledov_Constructors;
/*  ДиНАМиЧЕСКАЯ ДиСПЕТЧЕРиЗАЦиЯ МЕТОДОВ   (Полиморфизм в переопределяемых методах)
    Механизм переопределения методов лежит в основе одного из наиболее эффективных языковых средств Java - динамической 
диспетчеризации методов, обеспечивающей возможность поиска подходящей версии переопределенного метода во время выполнения 
программы (а не во время ее компиляции).
    Вспомним очень важный принцип: ссылочная переменная суперкласса может ссылаться на объект подкласса.
В Java этот принцип используется для вызова переопределяемых методов во время выполнения. Если вызов переопределенного метода
осуществляется с использованием ссылки на суперкласс, то исполняющая система Java выбирает нужную версию метода на основании 
типа объекта, на который эта ссылка указывает в момент вызова. 
    Ссылкам на различные типы объектов будут соответствовать вызовы различных версий переопределенного метода. 
    Другими словами, во время выполнения версия переопределенного метода выбирается в зависимости от типа обьекта ссылки 
(а не типа ссылочной переменной). Следовательно, если суперкласс содержит метод, переопределенный в подклассе, будет 
вызываться метод, соответствующий тому объекту, на который указывает ссылочная переменная суперкласса.  */
    
class SuperClass {
      void show() { System.out.println("show() в SuperClass");}
}      
class SubClass1 extends SuperClass {
      void show() { System.out.println("show() в SubClass1");}
}      
class SubClass2 extends SuperClass {
      void show()  {System.out.println("show() в SubClass2");}
}      
class t14_Polimorphism_in_Methods {
public static void main(String args[]) {
    SuperClass SuperOb = new SuperClass();
    SubClass1 SubOb1 = new SubClass1();
    SubClass2 SubOb2 = new SubClass2(); 
        System.out.println("Вызов метода show() переопределяется в зависимости от класса ");
    SuperOb.show();      SubOb1.show();         SubOb2.show();      System.out.println();
    
    SuperClass SuperRef;        // Объявление переменной SuperRef, 
    SuperRef = SuperOb;         // Присвоение переменной SuperRef ссылки на объект суперкласса SuperOb
    System.out.print("Вызов метода show() для объекта суперкласса вызывает \t ");
    SuperRef.show();    
    
    /* Затем переменной supRef в методе main () поочередно присваиваются ссылки на объекты разного типа, и далее эти ссылки
используются для вызова метода show() . Как следует из результата выполнения данной программы, вызываемая версия метода 
show() определяется типом объекта, на который указывает переменная supRef в момент вызова, а не типом самой переменной.*/
    
    SuperRef = SubOb1;   // Присвоение ссылки на объект суперкласса    ссылки на объект подкласса SubOb1   
    System.out.print("Вызов метода show() для объекта суперкласса после присвоения ему ссылки на объект подкласса SubOb1 вызывает \t");
    SuperRef.show();    
    
    SuperRef = SubOb2;   // Присвоение ссылки на объект суперкласса    ссылки на объект подкласса SubOb2   
    System.out.print("Вызов метода show() для объекта суперкласса после присвоения ему ссылки на объект подкласса SubOb2 вызывает \t");
    SuperRef.show();    
    
}}