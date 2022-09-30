package f08_Class;
// Метод 1 возвращает растояние, которое авто может проехать на полном баке
// Метод 2 возвращает необходимое кол-во литров бензина для прохождения заданного растояния

class Vehicle {
    double burn_up;
    int passengers;
    int fuelcap;
    
    double distance_na_back(){
    return (double)(fuelcap*burn_up);}
    
    double fuel_needed (double distance){
    return (double)(distance/burn_up);}
}
    
class Mehtod_in_Class{
public static void main (String[] args) {
      Vehicle car1 = new Vehicle();
      car1.burn_up = 10.1; car1.passengers = 4; car1.fuelcap = 40;
      
      Vehicle car2 = new Vehicle();
      car2.burn_up = 5.1; car2.passengers = 3; car2.fuelcap = 40;
      
      System.out.println ("Car1 проедет на полном баке расстояние =   " + car1.distance_na_back());
      System.out.println ("Car2 проедет на полном баке расстояние =   " + car2.distance_na_back());
      double distance = 100.5;
      System.out.println ("Для прохождения Car1 дистанции = " + distance + "км  требуется  " + car1.fuel_needed(distance) + " л");
      System.out.println ("Для прохождения Car1 дистанции = " + distance + "км  требуется  " + car2.fuel_needed(distance) + " л");
}
}
 