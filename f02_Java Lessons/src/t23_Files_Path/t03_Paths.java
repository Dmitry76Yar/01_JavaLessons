package t23_Files_Path;
/* ¬место единого класса File по€вились целых 3 класса: Paths, Path и Files. Ќу а если быть точным, Path Ч это интерфейс, а не класс.
 	 Paths
Paths Ч это совсем простой класс с единственным статическим методом get(). ≈го создали исключительно дл€ того, чтобы из переданной
строки или URI получить объект типа Path.
ƒругой функциональности у него нет.

Ќ≈ –≈ ќћ≈Ќƒј”≈“—я использовать данный класс и его метод, т.к. он будет скоро устаревшим
¬место Paths.get необходимо использовать Path.of 

 */
import java.nio.file.Path;
import java.nio.file.Paths;

public class t03_Paths {
public static void main(String[] args) {

	Path testFilePath = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\src\\f22_In_Out_Streams\\FileIn.txt");
	System.out.println(testFilePath);

	}
}
