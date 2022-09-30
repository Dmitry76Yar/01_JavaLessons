package f12_Incapsulation;
class Car   // Команда Set задает ограничения на значения параметров Private переменной
 {int passengers;
  private int Max_speed;  
  private int Wheels;                                    // Присваиваем Private для кол-ва колес
                            // Конструктор
     Car (int passengers, int Wheels, int Max_speed) {   
     this.passengers = passengers;          
     this.setWheels(Wheels);                             // Прописываем команду Set в конструкторе для кол-ва колес
     this.Max_speed = Max_speed;                     }   
                           // Метод Get для чтения макс.скорости
     int getMaxspeed() 
     {return this.Max_speed;}   
                          // Метод Get для чтения количества колес
     int getWheels() 
     {return this.Wheels;} 
                          // Метод расчета растояния
     double distance (double interval){            
     double distance = interval*Max_speed;
     return distance;}      
                          // Метод проверки корректности задачи кол-ва колес
     void setWheels(int Wheels) {
     if ((Wheels<1) || (Wheels>24)) {
         System.out.println("Неверно задано количество колес"); 
         return;}
     this.Wheels = Wheels;}
 }    
  class t0_Incaps_for_check_of_constructor_arguments {
  public static void main (String[] args){
         Car Car1 = new Car(3, -4, 150);   // Через конструктор сразу при инициилизации идет присваивания значений переменных объекта
         Car Car2 = new Car(4, 3, 180);
         double interval = 0.3;
         double distance_Car1 = Car1.distance(interval);
         double distance_Car2 = Car2.distance(interval);
     System.out.println ("     Макс.скорость 1-ой машины = " + Car1.getMaxspeed() + " км/ч " );
     // Т.к. кол-во колес 1-ой  машины задано -4, то компилятор автоматически заменит -4 на нулевое значение
     
     System.out.println ("     Кол-во колес 1-ой машины = " + Car1.getWheels() + " " );
     Car1.setWheels(4);  //Зааем
     System.out.println ("      ПОВТОРНО Кол-во колес 1-ой машины = " + Car1.getWheels() + " " );
      }
 }
         
     