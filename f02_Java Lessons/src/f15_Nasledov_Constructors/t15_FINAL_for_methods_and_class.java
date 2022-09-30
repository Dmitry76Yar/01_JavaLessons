package f15_Nasledov_Constructors;
/*  Ключевое слово FINAL
    Служит для предотвращения переопределения методов суперкласса из подкласса
    иногда механизмы наследования классов и переопределения методов  может стать помехой. Например, создается класс, 
в котором инкапсулированы средства управления некоторым устройством. Данный класс может предоставлять пользователю возможность
инициализировать устройство с использованием конфиденциальной коммерческой информации. В этом случае пользователи данноrо 
класса не должны иметь возможность переопределять метод, ответственный за инициализацию устройства.  
  
    Ключевое слово FINAL для предотвращения наследования классов
    Предотвратить наследование класса можно, указав в определении класса ключевое слово final. 
    В этом случае считается, что данное ключевое слово применяется ко всем методам класса. Очевидно, что не имеет 
никакого смысла применять ключевое слово final к абстрактным классам. Ведь абстрактный класс не завершен по определению, и
объявленные в нем методы должны быть реализованы в подклассах.  */

class A1 {
    final void method() {
        System.out.println(" Этот метод является FINAL");}
}
class B1 extends A1{
 //   void method() {   // - Ошибка! Этот метод не может быть переопределен
 //       System.out.println(" НЕДОПУСТиМО");}
}
final class C1 { 
    void method() {}
}
// class D1 extends C1 {   // - Ошибка! Этот класс не может быть переопределен
//    void method() {}
//}

class t15_FINAL_for_methods_and_class {
public static void main(String args[]) {
      
    
}}