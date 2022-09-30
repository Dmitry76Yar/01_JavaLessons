package f13_Methods;
// Перегружаемые методы - использование одного и того же метода для входных данных разного типа
// Компилятор сам понимает какой из вариантов метода использовать, ориентируясь по кол-ву и типу параметров
class Basket{  
   // Оплата наличными - метод pay срабатывает по алгоритму ниже в случае, если на входе только один аргумент double
   // Создание метода pay 
   void pay(double money) {
   System.out.println("Оплачено наличными на сумму:  " + money);}
   
    // Оплата кредитной картой - метод pay срабатывает, если на входе 2 аргумента - строковый и double
   void pay(String CardNumber, double money1) {
   System.out.println("Оплачено картой с номером " + CardNumber + "  на сумму " + money1);}
   
     // Оплата чеком - метод pay срабатывает, если на входе 3 аргумента - 2 строковых и double
   void pay(String AccountNumber, String Name, double money2) {
   System.out.println("Оплачено чеком со счета  " + AccountNumber + "  на имя  " + Name + "  на сумму " + money2);}
          }
          
  class t4_Method_Overload {
      public static void main (String[] args){
      Basket b1 = new Basket();
      System.out.print("Происходит инициализация метода в зависимости от параметра метода");
      System.out.print("Вызов с 1-м параметром double: \t\t\t  ");                    b1.pay(1200.0);
      System.out.print("Вызов с 2-мя параметрами double и String: \t\t:   ");         b1.pay("83637kr", 1400.0);
      System.out.print("Вызов с 3-мя параметрами double,  String и String: \t:");     b1.pay("36637jkr", "Ivanov", 1200.0);
      }
  }