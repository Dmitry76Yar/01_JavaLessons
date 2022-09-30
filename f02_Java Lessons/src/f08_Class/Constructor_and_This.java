package f08_Class;
class Car
 {int passengers;
  int Max_speed;
  int Wheels;
     Car (int passengers, int Wheels, int Max_speed) {   // Начало конструктора
     this.passengers = passengers;          // Команда this важна, если именна переменных конструктора совпадают с 
     this.Wheels = Wheels;                  // именами класса. В противном случае, могут быть ошибки
     this.Max_speed = Max_speed;
        }                                                // Конструктор завершен
           double distance (double interval){            // Начало метода по расчету пути класса Car
           double distance = interval*Max_speed;
           return distance;}                            // Завершение метода по расчету пути
  }
  class Constructor_and_This {
     public static void main (String[] args){
         Car Car1 = new Car(3, 4, 150);   // Через конструктор сразу при инициилизации идет присваивания значений переменных объекта
         Car Car2 = new Car(4, 3, 180);
         double interval = 0.3;
         double distance_Car1 = Car1.distance(interval);
         double distance_Car2 = Car2.distance(interval);
     System.out.println ("Автомобиль Car2 пройдет за " + interval + " ч" + " расстояние в " + distance_Car2 + " км");
     System.out.println ("Автомобиль Car1 пройдет за " + interval + " ч" + " расстояние в " + distance_Car1 + " км");
     }
 }
         
     