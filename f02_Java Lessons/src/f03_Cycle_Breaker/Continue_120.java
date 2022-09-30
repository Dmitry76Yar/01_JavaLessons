package f03_Cycle_Breaker;
// Оператор continue осуществляет переход к следующему шагу цикла, пропуская оставшийся невыполненным код. 
// Пример ниже выводит только нечетные числа
// Для нечетных чисел операция печати в коде ниже команды Continue пропускается и идет возврат к циклу For

class Continue_120 {
    public static void main (String args []) {
        for(int i=1; i<=10; i++) {
            if (i%2 == 1) continue; 
            System.out.println(i);}
            
// Continue c меткой
// В примере ниже по сути Continue = Break, при k=5 идет выход из 2-го if и возврат к первому For1 
outerloop:
    for (int j=1; j<10; j++) {
    System.out.print("\nBнeшний цикл: проход " + j + "\t");
        for (int k = 1; k < 10; k++) {
            if(k == 5) continue outerloop; 
            System.out.print("Внутренний цикл: проход " + k + "\t");}
    }
              
        }
    }
                        
    