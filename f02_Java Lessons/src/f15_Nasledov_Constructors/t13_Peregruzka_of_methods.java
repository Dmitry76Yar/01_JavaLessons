package f15_Nasledov_Constructors;
/*  ПЕРЕГРУЗКА МЕТОДА
    В том случае, если в иерархии классов присутствуют методы с одинаковой сигнатурой и одинаковым возвращаемым значением,
метод суперкласса переопределяется в подклассе - происходит переопределение метода.
    Если сигнатуры переопределяемого и переопределяющего методов не совпадают - происходит  обычная перегрузка методов
        В примере ниже:
    Метод show() в подклассе Truck изменен на show(String msg), т.к. input данные подкласса и суперкласса различаются,
то метод show() перегружается.
    Метод show() в подклассе Byke изменен c void show() на String show(), поэтому метод перегружается  */
    
// Надкласс TwoDShape, описывающий двумерные объекты
class Vehicle2 {
    int passengers;
    int fuel_stock;
    double burnup;
        
        /*  Констуктор надкласса  */
    Vehicle2 (int passengers, int fuel_stock, double burnup){
        this.passengers = passengers;
        this.fuel_stock = fuel_stock;
        this.burnup = burnup;}
     
    void Show(){
    System.out.println("Данные объекта суперкласса:\t passengers = " + passengers + ",\t fuel_stock = " + fuel_stock + ", \t burnup = " + burnup + "\n"); }
}        
    /*  Класс по описанию характеристик грузовика */
class Truck2 extends Vehicle2 {
    int cargocap;   // грузоподъемность
    
    /*  Констуктор подкласса по описанию характеристик грузовика */
    Truck2(int p2, int f2, double b2, int cargocap) {
        super(p2,f2,b2);
        this.cargocap = cargocap;}
        
     void Show(String msg){
     System.out.println("Данные объекта подкласса:\t passengers = " + passengers + ",\t fuel_stock = " + fuel_stock + ", \t burnup = " + burnup +", \t cargocap = " + cargocap);  
     System.out.println(msg + "\n");  }
    } 

/*  Класс по описанию характеристик мотоцикла */
class Byke2 extends Vehicle2 {
    int max_speed;   
    
    /*  Констуктор подкласса по описанию характеристик мотоцикла */
    Byke2(int p2, int f2, double b2, int max_speed) {
        super(p2,f2,b2);
        this.max_speed = max_speed;}
        
     String Show(int l){
      System.out.println("Данные объекта подкласса:\t passengers = " + passengers + ",\t fuel_stock = " + fuel_stock + ", \t burnup = " + burnup +", \t max_speed = " + max_speed);     
     return ("Произошла перегрузка метода, т.к. метод изменился с void на String");}
} 
class t13_Peregruzka_of_methods {
public static void main(String args[]) {
    Vehicle2 Auto1 = new Vehicle2(4, 50, 8.0); 
    Auto1.Show();
    
    Truck2 Truck1 = new Truck2(6, 100, 23.0, 2500);
    Truck1.Show("Произошла перегрузка метода, т.к. input данные в метод отличается от суперкласса");
    
    Byke2 Byke1 = new Byke2 (2, 10, 5, 200);
    System.out.print(Byke1.Show(1));
     }
}
