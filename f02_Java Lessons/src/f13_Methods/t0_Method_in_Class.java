package f13_Methods;
 // Расчет пути, проходимого машиной за время, с использованием нового метода класса Void
class Car  
  {int Max_speed;
  void distance (double interval){ // Объявляем метод distance, вычисляющий пройденный путь (v).
                                   // Метод на входе берет параметр interval, задающий время
                                   // и на выходе не возвращает никакого значения (void)
      double v = Max_speed * interval;   // v - расчитывает путь
      System.out.println (" рассояние в " + v + " км"); 
   } // Конец метода distance класса Car
   } // Конец класса Car  
   
class t0_Method_in_Class {
    public static void main (String[] args) {
    Car Car1 = new Car(); // Объявляем объект Car1 класса Car
        Car1.Max_speed = 150;
    Car Car2 = new Car(); // Объявляем объект Car2 класса Car
        Car2.Max_speed = 60; 
    double t = 0.5; // переменная t будет являться входными данными interval для метода distance
    System.out.print ("Автомобиль Car1 пройдет за " + t + " ч"); 
    Car1.distance(t); // Вызов метода distance для объекта Car1 класса Car с входной переменной t = interval
                      // Печать растояния происходит из самого метода
    System.out.print ("Автомобиль Car2 пройдет за " + t + " ч"); 
    Car2.distance(0.1); // Вызов метода distance для объекта Car1 класса Car с сразу введеным числом 0.1 = interval
    }
}
    