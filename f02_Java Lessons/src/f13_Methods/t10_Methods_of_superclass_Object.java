package f13_Methods;
/*  Класс Object   - суперкласс всех остальных классов
    В Java определен специальный класс Object. По умолчанию он считается суперклассом всех остальных классов. Другими словами,
все классы являются подклассами, производными от класса Object.  
    Поэтому все типы и классы могут реализовать те методы, которые определены в классе Object.
    Это означает, что ссылочная переменная типа Object может ссылаться на объект любого класса. Более того, такая переменная
также может ссылаться на массив, поскольку массивы реализованы в виде классов.
    
    В классе Object определены перечисленные ниже методы, доступные в любом объекте:
Метод Object clone()                    Создает новый объект, аналогичный клонируемому объекту
Метод boolean equals (Object объект)    Определяет равнозначность объектов
Метод void finalize()                   Вызывается перед тем, кок неиспользуемый объект будет удален системой "сборки мусора"
Метод Class<?> getClass()              Определяет класс объекта во время выполнения
Метод int hashCode()                   Возвращает хеш-код, связанный с вызывающим объектом
Метод void notify()                    Возобновляет работу потока, ожидающего уведомления от вызывающего объекта
Метод void notifyAll()                 Возобновляет работу всех потоков, ожидающих уведомления от вызывающего объекта
Метод String toString()                Возвращает символьную строку, описывающую объект
Метод void wait ()                      Ожидает исполнения другого потока
    void wait (long миллисекунды)
    void wait (long миллисекунды,
    void wait (int наносекунды)     
    
Методы getClass(), notify(), notifyAll() и wait() объявлены как final, а остальные можно переопределять в подклассах. 
Некоторые из этих методов будут описаны далее. Два из них - equals () и toString () - заслуживают особого внимания.
Метод toString() возвращает символьную строку, содержащую описание того объекта, которому принадлежит этот метод. Он
автоматически вызывается в том случае, если объект передается методу println () в качестве параметра. Во многих классах этот
метод переопределяется. В этом случае описание специально подбирается для конкретных типов объектов, которые в них создаются. */
    
class Person {
  private String name;
      public Person(String name){
         this.name=name;  }
} 
class t10_Methods_of_superclass_Object {
public static void main(String args[]) {
    
    /* Демонстрация метода equals()
Метод equals() сравнивает два объекта. Если объекты равнозначны, то он возвращает логическое значение true, иначе -  false. */
    Person tom = new Person("Tom");       Person bob = new Person("Bob");   Person tom2 = new Person("Tom");
    System.out.println(tom.equals(bob)); // false
    System.out.println(tom.equals(tom2)); // true
    
    /* Демонстрация метода getClass()     */
    System.out.println(tom.getClass());
    
    /* Демонстрация метода toString()     */
    System.out.println(tom.toString());
    
}}