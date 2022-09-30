package f15_Nasledov_Constructors;
// Перегружаемый конструктор - 
class Car{
    int passengers;
    int wheels;
    int maxspeed;
         // Конструктор с заранее определенными значениями параметров
         Car(){
         this(4,4,150);}  // Команда this вызывает другой конструктор, передающий значения пареметров конструктору Car
                          // Это сделано, чтобы для избежания длинного кода по присваиванию значений каждому параметру
         
         // Конструктор с параметрами (их определение происходит уже при выполнении основного кода)
         Car (int passengers, int wheels, int maxspeed){
             this.passengers = passengers;
             this.wheels = wheels;
             this.maxspeed = maxspeed;}  
             
          // Расчет расстояния проходимого за интервал времени  
           double distance (int interval){  // Метод использующий int параметр пути на входе
           double distance = interval*maxspeed;
           return distance;}     
                            
           double distance(double interval){   // Метод использующий double параметр пути на входе
           double distance = interval*maxspeed*2;
           return distance;}
           // В зависимости от типа параметра interval компилятор выбирает  из 2-х методов выше 
          }

class t1_Overloading_constructor{
    public static void main(String[] args){
        Car Car1 = new Car();   // Этот объект будет работать с конструктором с заранее определенными значениями параметров
        Car Car2 = new Car(3,3,180); // Этот объект будет работать с конструктором без заранее определ. значений параметров
        System.out.println ("Car1:  passengers= " + Car1.passengers + "   wheels = " + Car1.wheels + "   maxspeed = " + Car1.maxspeed);
        System.out.println ("Car2:  passengers= " + Car2.passengers + "   wheels = " + Car2.wheels + "   maxspeed = " + Car2.maxspeed);
        int interval = 1;
        double distance_Car1 = Car1.distance(interval);
        System.out.println ("Car1:  за время " + interval + "  машина пройдет  " + distance_Car1);
              
   }
}