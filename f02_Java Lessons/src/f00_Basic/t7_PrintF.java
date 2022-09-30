/* Вывод с форматированием
%d: для вывода целых чисел  		%x: для вывода шестнадцатеричных чисел  	%f: для вывода чисел с плавающей точкой
%e: для вывода чисел в экспоненциальной форме, например, 1.3e+01	%c: для вывода одиночного символа
%s: для вывода строковых значений
 */

package f00_Basic;

public class t7_PrintF {
public static void main(String[] args) {
	String name = "Tom";
    int age = 30;
    double height = 1.7;
    System.out.printf("Name: %s  Age: %d  Height: %f \n", name, age, height);
 /* При выводе чисел с плавающей точкой мы можем указать количество знаков после запятой, для этого используем спецификатор на %.2f, где 
.2 указывает, что после запятой будет два знакa    */
    System.out.printf("Name: %s  Age: %d  Height: %.2f \n", name, age, height);

	}
}
