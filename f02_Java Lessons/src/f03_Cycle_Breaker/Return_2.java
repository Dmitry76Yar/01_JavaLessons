package f03_Cycle_Breaker;
class Return_2 {   
// Return заставляет компилятор пропустить все остальные команды в теле метода за ней
// и вернуться в том место, откуда метод был вызван

    public static void main (String[] args){
       for (int i=0; i<=5; i++) {
        System.out.print ("i=" + i);
        if (i==2) return; // Обрывает выполнение печати ниже при i=2
                          // передает управление в класс main, т.е. по сути обрывает цикл 
        System.out.println ("   Цикл прошел дальше");} 
        System.out.println ("   Выполнение команд в классе main также оборвалось"); 
     }
  }
        
    