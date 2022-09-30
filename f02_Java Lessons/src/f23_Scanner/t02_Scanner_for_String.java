/* Scanner имеет еще ряд методов, которые позволяют получить введенные пользователем значения:
next(): считывает введенную строку до первого пробела		nextLine(): считывает всю введенную строку	 */

package f23_Scanner;
import java.util.Scanner;

public class t02_Scanner_for_String {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
    System.out.print("Input name: ");
    	String name = in.nextLine();
    	System.out.print("Input age: ");
    int age = in.nextInt();
    System.out.print("Input height: ");
    	float height = in.nextFloat();
    	System.out.printf("Name: %s  Age: %d  Height: %.2f \n", name, age, height);
    in.close();
	

	}
}
