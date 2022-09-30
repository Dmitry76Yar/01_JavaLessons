package f18_Interfaces;
/* Кроме методов в интерфейсах могут быть определены статические константы 
Хотя такие константы также не имеют модификаторов, но по умолчанию они имеют модификатор доступа public static final, 
и поэтому их значение доступно из любого места программы.*/

public class t4_Constants_in_Interface {
	public static void main(String[] args) {
		WaterPipe pipe = new WaterPipe();
		pipe.printState(1);
	}
}

class WaterPipe implements Stateable{
    public void printState(int n){
       if(n == OPEN) System.out.println("Water is opened");
       else if(n ==  CLOSED) System.out.println("Water is closed");
       else  System.out.println("State is invalid");
     }
}

interface Stateable{
    int OPEN = 1;
    int CLOSED = 0;
    void printState(int n);
}