package f15_Nasledov_Constructors;
/*  ПЕРЕОПРЕДЕЛЕНиЕ МЕТОДОВ 
В иерархии классов часто присутствуют методы с одинаковой сигнатурой и одинаковым возвращаемым значением,
как в суперклассе, так и в подклассе. В этом случае говорят, что метод суперкласса переопределяется в подклассе. 
Если переопределяемый метод вызывается из подкласса, то он всегда будет ссылаться на версию метода, определенную в подклассе. 
Если переопределяемый метод вызывается из надкласса, то он всегда будет ссылаться на версию метода, определенную в надклассе.   */

// Надкласс TwoDShape, описывающий двумерные объекты
class Vehicle {
    int passengers;
    int fuel_stock;
    double burnup;
        
        /*  Констуктор надкласса  */
    Vehicle (int passengers, int fuel_stock, double burnup){
        this.passengers = passengers;
        this.fuel_stock = fuel_stock;
        this.burnup = burnup;}
     
    void Show(){
    System.out.println("Данные объекта суперкласса:\t passengers = " + passengers + ",\t fuel_stock = " + fuel_stock + ", \t burnup = " + burnup); }
}        
            
    /*  Класс по описанию характеристик грузовика */
class Truck extends Vehicle {
    int cargocap;   // грузоподъемность
    
    /*  Констуктор подкласса по описанию характеристик грузовика */
    Truck(int p2, int f2, double b2, int cargocap) {
        super(p2,f2,b2);
        this.cargocap = cargocap;}
        
     void Show(){
     System.out.println("Данные объекта подкласса:\t passengers = " + passengers + ",\t fuel_stock = " + fuel_stock + ", \t burnup = " + burnup +", \t cargocap = " + cargocap);  }
    } 

class t11_Pereopredelenie_methods {
public static void main(String args[]) {
    Vehicle Auto1 = new Vehicle(4, 50, 8.0); 
    Auto1.Show();
    
    Truck Truck1 = new Truck(6, 100, 23.0, 2500);
    Truck1.Show();
     }
}
