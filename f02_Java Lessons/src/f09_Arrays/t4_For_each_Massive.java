package f09_Arrays;
// for-each. В этом цикле происходит последовательное обращение к каждому элементу совокупности объектов (например, массива).

class t4_For_each_Massive{
 public static void main (String[] args){
    int Massive1[] = {1,2,3,4,5};
    int sum = 0;
        // Цикл for-each обрабатывает все элементы массива
    for (int x : Massive1) System.out.print(x + ", ");  
    
        // Цикл for-each для суммирования
    for (int x : Massive1) sum +=x; System.out.print("\n sum = " + sum); 
    
        // Цикл for-each для поиска минимального решения в массиве
    int Massive2[] = {3,1,-10,6,20};             int min = Massive2[0];
    for (int x : Massive2) if (x<min) min = x;   
    System.out.print("\n \tmin = " + min + "\n"); 
    
        // Цикл for-each обрывает обработку элементов при достижении значения = 3
    for (int x : Massive1) {
        System.out.print(x + ", "); if (x==3) break;}                    
    
   // Важно, что итерационная переменная х в цикле for-each обеспечивает только чтение элементов массива, 
   // но ее нельзя использовать для записи значения в какой-либо элемент массива. 
   // Нельзя изменить содержимое массива, присвоив итерационной переменной новое значение.
    for (int x : Massive1) x = 1000; System.out.print("\n"); 
    for (int x : Massive1) System.out.print(x + ", ");  System.out.print("  Массив не изменяется \n");
    
 //  Цикл for-each для обработки двумерного массива
     int Massive[][] = new int[4][3];
     for (int i = 0; i<4; i++) 
        for (int j = 0; j<3; j++)  Massive[i][j] = i+j;  // Внесение данных в  массив
                                    // Цикл for-each для выведения цифр
 // На каждом шаге цикла for из двумерного массива nums извлекается очередной массив, начиная с nums [0].
 // А во внутреннем цикле for перебираются элементы полученного массива и отображаются их значения
       int min1 = Massive[0][0];
       for (int x [] : Massive) {
            for (int y : x)  { System.out.print(y); if (y<min1) min1 = y;}
            System.out.println(); 
            }
            System.out.println("min1 = " + min1); 
            
   // Для сравнения обычный цикл выводит тоже самое
       for (int i = 0; i<4; i++) {
       for (int j = 0; j<3; j++)  {System.out.print(Massive[i][j]);} 
       System.out.println(); }
           
 }
}
