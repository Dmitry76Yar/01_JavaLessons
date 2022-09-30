package f09_Arrays;
class t1_Massive{
 public static void main (String[] args){
     
     // иницилизация Одномерного массива
   int One[] = new int[3];  
   for (int i=0; i<3; i++) System.out.print("      Массив[" + i + " ] = " + One[i]);
       System.out.println();
       System.out.println (" индексы всех элементов определены сразу после иницилизация массива");
       System.out.println (" значение всех элементов по умолчанию равны нулям");
   
   // Поэлементное присваивание значений
   One[0] = 10;  One[1] = 11; One[2] = 12;    
   for (int i=0; i<3; i++)  System.out.print("      Массив[" + i + " ] = " + One[i]);   System.out.println();
   
    // иницилизация массива и сразу присваивание элементом значений
 int One1[] = {101,102,103};      
   for (int i=0; i<3; i++)  System.out.print("      Массив[" + i + " ] = " + One1[i]); System.out.println(); System.out.println();
   
   // иницилизация двухмерного массива и сразу присваивание элементом значений
   // Двумерный массив, по существу, представляет собой ряд одномерных массивов.
   int Table[][] = new int[10][20];
   
      // иницилизация трехмерного массива и сразу присваивание элементом значений
 int Dual2[][] = {               
    {2,3,4}, {4,9,16}, {8,27,64}};
      for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++)    System.out.print("   Dual2[" + i + " ]" + "[" + j + " ]= "  + Dual2[i][j]);
       System.out.println();}
   System.out.println();
   
   // Нерегулярные массивы
// Например, в приведенном ниже фрагменте кода память выделяется только под первый размер двумерного массива tаblе.
// Дальнейшее выделение памяти, соответствующей второму измерению, осуществляется вручную .
    int Tаblе1[][] = new int[3][];
    Table[0] = new int[4];   // Длина 1-ой строки массива
    Table[1] = new int[4];   // Длина 2-ой строки массива
    Table[2] = new int[4];
    Table[3] = new int[2];

   int Uneven[][] = {                 // иницилизация непрямоугольного массива и сразу присваивание элементом значений
    {2,3,4,100}, {4,9,16}, {8,27,64}};  // в одной из строк 5 элементов, в других по 4 эелемента
      for (int i=0; i<3; i++) {
      for (int j=0; j<3; j++)    System.out.print("   Uneven[" + i + " ]" + "[" + j + " ]= "  + Uneven[i][j]);
       System.out.println();}
   System.out.println("Не знаю, как вывести значения элементов вне прямоугольника."); 
   System.out.println("Вручную вот так    Uneven[0][3] = " + Uneven[0][3]); System.out.println();
   
    int Dual3[][] = new int[5][3];    // Массив 5х3 выводящий квадрат, куб... элементов первого ряда 
    for (int i=0; i<5; i++) {
     for (int j=0; j<3; j++) {    
        if (i==0)  
            if (j==0) Dual3[i][j] = 1;
            else Dual3[i][j] = Dual3[i][j-1]+1;
        else Dual3[i][j] = Dual3[i-1][j]*Dual3[0][j];
       System.out.print("   Dual3[" + i + " ]" + "[" + j + " ]= "  + Dual3[i][j]);}
       System.out.println();}
   System.out.println();
   
   int Dual4[][] = new int[5][3];    // Тоже самое, но с использованием While
    int i=0; int j=0;
    while (i<5) {
        j=0;
       while (j<3) { 
        if (i==0)  
            if (j==0) Dual4[i][j] = 1;
            else Dual4[i][j] = Dual4[i][j-1]+1;
        else Dual4[i][j] = Dual4[i-1][j]*Dual4[0][j];
       System.out.print("   Dual4[" + i + " ]" + "[" + j + " ]= "  + Dual4[i][j]);
       j++;}
       i++; System.out.println();}
   System.out.println();
   
      }
}