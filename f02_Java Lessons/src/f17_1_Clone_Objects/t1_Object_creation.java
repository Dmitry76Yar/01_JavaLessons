package f17_1_Clone_Objects;
/* При работе с объектами надо учитывать, что они все - ссылочные типы, то есть указывают на какой-то объект, расположенный в памяти.
Здесь создаем два объекта Vehicle и один присваиваем другому. 
При изменении только объекта car3 вместе с ним изменяется и объект car2, т.к.после присвоения они указывают на одну и ту же область в памяти,
 где собственно данные об объекте Vehicle и его полях и хранятся. */

class t1_Object_creation{
public static void main (String[] args){
    Vehicle car1 = new Vehicle("Lada", 169, 4);
    Vehicle car2 = new Vehicle("Ford", 180, 4);
    System.out.printf("Name %s, \t max_speed %d, \t passengers %d \n", car2.name, car2.max_speed, car2.passengers);
    
    Vehicle car3;
    car3 = car2; 
    System.out.printf("Name %s, \t max_speed %d, \t passengers %d \n", car3.name, car3.max_speed, car3.passengers);
    
    car3.max_speed = 250;
    System.out.println("\t После изменения объекта car3 меняется и объект car2");
    System.out.printf("Name %s, \t max_speed %d, \t passengers %d \n", car2.name, car2.max_speed, car2.passengers);
    System.out.printf("Name %s, \t max_speed %d, \t passengers %d", car3.name, car3.max_speed, car3.passengers);
      
}     }
 
class Vehicle {
    String name;
    int max_speed;
    int passengers;
	Vehicle(String name, int max_speed, int passengers) {
		this.name = name;
		this.max_speed = max_speed;
		this.passengers = passengers;} }