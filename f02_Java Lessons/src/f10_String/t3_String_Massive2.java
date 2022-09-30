package f10_String;
class t3_String_Massive{
    public static void main (String [] args) {
    String Str_massive[] = {"This ", "String " , " is" , "text"};
    System.out.println("исходный массив:");
      // Печать массива
    for (String x : Str_massive) System.out.print(x + " "); System.out.println();
    
      // Присвоение нового значения элементам
     Str_massive[2] = "also is ";
     System.out.println("\t После изменения:"); System.out.print("\t");
     for (String x : Str_massive) System.out.print(x + " "); System.out.println();
    
    }
}