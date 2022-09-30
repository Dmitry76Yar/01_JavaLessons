package f01_Operators_Cycles_Sort;
// Тернарный оператор 
class t2_Ternar_operator {
public static void main (String args []) {
   int absval; 
   int val =-5; 
   
   // Вычисление абсолютного значения числа val через тернарный оператор
   absval = (val <0) ? -val : val;
   System.out.println("Абсолютное значение числа val =  " + absval);
   
   // Оператор if-else ниже делает тоже самое
   if (val<0) absval = -val; else absval = val;
   System.out.println("Абсолютное значение числа val =  " + absval);
   
   // Тернарный оператор для boolean задач
   // Цикл ниже ограничивает деление на ноль.   Переменной a присваивается true или false, по ее значению работает цикл if
       boolean a = true;
   for (int i = -6; i<5; i++) {
        if (a = (i!=0) ? true : false) System.out.print(i + "\t") ; else System.out.print("Деление на ноль запрещено \t");}
         
    
    }
}