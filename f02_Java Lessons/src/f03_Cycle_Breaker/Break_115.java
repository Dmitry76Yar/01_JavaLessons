package f03_Cycle_Breaker;
// Коrда в теле цикла встречается оператор break, цикл завершается, а выполнение программы 
// возобновляется с оператора, следующего после этоrо цикла.

class Break_115 {
    public static void main (String args []) 
    throws java.io.IOException {
        
   // Программа выдает квадрат переменной i пока квадрат не превысит 30
  // Бесконечный цикл for с выходом из него при совпадении условия и выполнения Break
    int num = 30;
    for (int i= 1; ; i++)
        {if (i*i > num) break;
        System.out.println(i*i);}
        
    // игра на угадывание букв с заменой цикла While на бесконечный цикл For c Break
    char A; char ignore; char Target; A = ignore = Target = 'k';
    for (;;) {
         System.out.println("Введите латинскую букву");
         A = (char)System.in.read();
        do{
            ignore = (char)System.in.read();}
            while (ignore != '\n');
        if (A == Target) 
            {System.out.println("Правильно"); break;}
         }
         
    // Если оператор break применяется посреди набора вложенных циклов, то он прерывает выполнение только 
    // самого внутреннего цикла.
    // Программа по печати счетчикуов двух циклов
    for (int i = 1; i<=5; i++) {
        System.out.print("  " + i+ "  " + "\t"); 
        for (int j = 0; ; j++) {
            System.out.print("  " + j+ "  "); 
            if (j== 5) break;}   // Break обрывает только цикл For c переменной j и возвращает в первый цикл For
        System.out.println ();
    }        
    }
}   