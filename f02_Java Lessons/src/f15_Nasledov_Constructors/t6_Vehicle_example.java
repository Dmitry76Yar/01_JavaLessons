package f15_Nasledov_Constructors;
/*   Надкласс Vehicle инкапсулирует данные о транспортных средствах и, в частности, сведения о количестве пассажиров, 
объеме топливного бака и расходе топлива.      Надкласс Truck добавляет переменную грузоподъемность. 
В этом проекте переменные экземпляра объявляются в классе Vehicle как закрытые (private), а для обращения к
ним используются специальные методы доступа.   */

// Надкласс TwoDShape, описывающий двумерные объекты
class Vehicle4 {
    private int passengers;
    private int fuel_stock;
    private double burnup;
    
     /*  Методы SET и GET для чтения и записи Private переменных  */     
    void set_passengers(int p)       {this.passengers = p;}
    void set_fuel_stock(int f)       {this.fuel_stock = f;}
    void set_burnup(double b)        {this.burnup = b;}
    int get_passengers()         {return this.passengers;}   
    int get_fuel_stock()         {return this.fuel_stock;}
    double get_burnup()         {return this.burnup;}
        
        /*  Констуктор надкласса  */
    Vehicle4 (int passengers, int fuel_stock, double burnup){
        set_passengers (passengers);
        set_fuel_stock (fuel_stock);
        set_burnup (burnup);}
        
        /*  Расчет топлива для прохождения заданной дистанции в км  */
    double distance (int interval) {
    return  (interval*get_burnup())/100;}
    }
  /*  Класс по описанию характеристик грузовика */
class Truck4 extends Vehicle4 {
    int cargocap;   // грузоподъемность
    /*  Констуктор подкласса по описанию характеристик грузовика */
    Truck4(int p2, int f2, double b2, int cargocap) {
        super(p2,f2,b2);
        this.cargocap = cargocap;}
}

class t6_Vehicle_example {
public static void main(String args[]) {
    Vehicle4 Auto1 = new Vehicle4(4, 50, 8.0); 
    System.out.println("Характеристики АВТО1: " + Auto1.get_passengers() + "\t" + Auto1.get_fuel_stock() + "\t" + Auto1.get_burnup());
    System.out.println("На 200 км израсходуется топлива = " + Auto1.distance(200) + "\n");
    
    Truck4 Truck1 = new Truck4(4, 100, 23.0, 2500);
    System.out.println("Характеристики TRUCK1: " + Truck1.get_passengers() + "\t" + Truck1.get_fuel_stock() + "\t" + Truck1.get_burnup() + "\t" + Truck1.cargocap);
    System.out.println("На 200 км израсходуется топлива = " + Truck1.distance(200));
    
}
}
