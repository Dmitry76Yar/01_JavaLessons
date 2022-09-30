package f00_Basic;
/*   Булевские операции выполняются над булевскими переменными и их результатом также является значение типа boolean.
 В Java определены следующие булевские операции:  */

class t2_Boolean_short_operations {
public static void main(String args[]) {
    boolean a = true; 
    boolean b = true; 
    boolean c = false;
    boolean d;
 
/*    Oтрицание "!" – замена false на true, или наоборот */
    if (!c == true ) System.out.println("C не равно TRUE ");
    if (c != true ) System.out.println("C не равно TRUE ");
    if (a == true ) System.out.println("A  равно TRUE ");  System.out.println();
    
/*    Oперация "&" – результат равен true, только, если оба операнда равны true, иначе результат – false; */
    if ((a == true ) & (b == true)) System.out.println("A и B равно TRUE ");
    if ((a == true ) && (b == true)) System.out.println("A и B равно TRUE "); System.out.println();
    
/*    Oперация "|" – результат равен true, только, если хотя бы один из операндов равен true, иначе результат – false. */
    if ((a == true ) | (c == true)) System.out.println("A или C равно TRUE ");
    if ((a != true ) | (b != true)) System.out.println("A или B не равны TRUE ");   System.out.println();
    
/*    Oперация исключающее "^" – результат равен true, только, если операнды не равны друг другу, иначе результат – false. */
    if (a ^ c ) System.out.println("A и B не равны ");
    
}
}
