package f03_Cycle_Breaker;
/* Коrда в теле метода (неважно в цикле или в коде до или после цикла) стоит return, то при его достижении 
 компилятор прекращает выполнение метода, т.е. все что стоит после return не будет выполнено
 в консоли появится ошибка "unreachable statement"
     При замене return на break, мы выйдем из цикла и выполним все что стоит за ним
     
Поэтому для циклов НЕ используют break */

class Return {
   public static void main (String args []) {
   int num = 30;
    for (int i= 1; ; i++)
        {if (i*i > num) break;
        System.out.println(i*i);}
        
        System.out.println("Строка выведится в случае break, и не выведится - при return");
        
    }
}   