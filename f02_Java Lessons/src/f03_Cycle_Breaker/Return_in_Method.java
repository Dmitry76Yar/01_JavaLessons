package f03_Cycle_Breaker;
// Коrда в теле метода стоит return, то при его достижении компилятор прекращает выполнение метода, т.е. 
// все что стоит после return не будет выполнено.

// В этом примере идет добавеление 15 символов в массив размером 12 элементов (с неиспользуемым нулевым элементом).
// При достижении максимального кол-ва элементов (12) в условии if происходит пропуск кода, приведенного ниже цикла if,
// а значит не происходит putloc++ (т.е. перехода к следующему элементу  - Массив[13]) 
// Если убрать Return, то код ниже будет испольняться и putloc станет равным 13, мы перейдем к Массив[13] - ошибка выхода из границ массива

 

class Queue1 {
    char q[] = new char[13];               // массив для хранения элементов очереди (здесь символы))
    int putloc, getloc = 0;     
    
    // Метод put (), помещающий элемент в очередь:
void put(char ch) {
    if(putloc == q.length-1) {                  
     System.out.print("putloc = " + putloc + " \t "); 
     System.out.print("Q[putloc] = " + q[putloc]);  
     System.out.println(" \t- Очередь заполнена");
    return; }
    //Если убрать Return, то код ниже будет испольняться и putloc станет равным 14, мы перейдем к Массив[14] - ошибка выхода из границ массива
    putloc++;        
    q[putloc] = ch;
    System.out.print("putloc = " + putloc + " \t ");  System.out.println("Q[putloc] = " + q[putloc]);  
    }   
}

class Return_in_Method {
    public static void main(String args[]) {
    Queue1 bigQ = new Queue1();   // Создает массив для хранения символов с размером 101 элемент
    // Внесение 15 символов алфавита в очередь (массив)
    System.out.println(); System.out.println("  \n        Внесение 15 символов алфавита в очередь, показано увеличение индекса вставки, 2 символа сверх очереди");
    for(int i = 0; i < 15; i++)
        bigQ.put ((char)('A' + i));
  }
}    
       
