package f15_Nasledov_Constructors;
/*  ПЕРЕОПРЕДЕЛЕНиЕ МЕТОДОВ 
В иерархии классов часто присутствуют методы с одинаковой сигнатурой и одинаковым возвращаемым значением,
как в суперклассе, так и в подклассе. В этом случае говорят, что метод суперкласса переопределяется в подклассе. 
Если переопределяемый метод вызывается из подкласса, то он всегда будет ссылаться на версию метода, определенную в подклассе. 
Если переопределяемый метод вызывается из надкласса, то он всегда будет ссылаться на версию метода, определенную в надклассе.
    В примере ниже, когда метод show() вызывается для объекта подкласса Truck, выбирается версия метода из класса Vehicle.
Таким образом, версия метода show() в классе Truck переопределяет версию одноименного метода, объявленную в классе Vehicle.

    Если требуется обратиться к исходной версии переопределяемого метода, т.е. той, которая определена в суперклассе, 
следует воспользоваться ключевым словом super. 
Например, в примере ниже класс Train  метод show () с кодом super,show() вызывает то же метод, определенная в суперклассе. */

// Надкласс TwoDShape, описывающий двумерные объекты
class Vehicle1 {
    int passengers;
    int fuel_stock;
    double burnup;
        
        /*  Констуктор надкласса  */
    Vehicle1 (int passengers, int fuel_stock, double burnup){
        this.passengers = passengers;
        this.fuel_stock = fuel_stock;
        this.burnup = burnup;}
     
    void Show(){
    System.out.println("Данные объекта суперкласса:\t passengers = " + passengers + ",\t fuel_stock = " + fuel_stock + ", \t burnup = " + burnup); }
}        
            
    /*  Класс по описанию характеристик грузовика */
class Truck1 extends Vehicle1 {
    int cargocap;   // грузоподъемность
    
    /*  Констуктор подкласса по описанию характеристик грузовика */
    Truck1(int p2, int f2, double b2, int cargocap) {
        super(p2,f2,b2);
        this.cargocap = cargocap;}
        
     void Show(){
     System.out.println("Данные объекта подкласса:\t passengers = " + passengers + ",\t fuel_stock = " + fuel_stock + ", \t burnup = " + burnup +", \t cargocap = " + cargocap);  }
    } 

/*  Класс по описанию характеристик мотоцикла */
class Byke1 extends Vehicle1 {
    int max_speed;   
    
    /*  Констуктор подкласса по описанию характеристик мотоцикла */
    Byke1(int p2, int f2, double b2, int max_speed) {
        super(p2,f2,b2);
        this.max_speed = max_speed;}
        
     void Show(){
         super.Show();
        System.out.println("Дополнительно из конструктора мотоцикла. Макс.скорость = " + max_speed);  }
    } 
  
class t12_Pereopredelenie_of_methods {
public static void main(String args[]) {
    Vehicle1 Auto1 = new Vehicle1(4, 50, 8.0); 
    Auto1.Show();
    
    Truck1 Truck1 = new Truck1(6, 100, 23.0, 2500);
    Truck1.Show();
    
    Byke1 Byke1 = new Byke1 (2, 10, 5, 200);
    Byke1.Show();
     }
}
