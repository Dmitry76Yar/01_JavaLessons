package f00_Basic;
// Короткие логические операции AND и OR отличаются от стандартных тем, что итоговое условие не будет выполнено при 
// невыполнение первого условия и второе условие будет проигнорировано компилятором

class t3_AND_and_DOUBLE_AND {
    public static void main (String[] args){
    int d = 8; //делимое
    int t = 2;  // делитель
    if (t!=0 && (d%t) ==0)   // Оба условия соблюдаются - идет выполнение печати
        System.out.println("Число d делится на t без остатка и частное равно  " + d/t + '\n');  
    
    t = 0; 
    if (t!=0 && (d%t) ==0)  // 1-ое условие не соблюдается, поэтому ко 2-ому компилятор даже не переходит, 
                            // Печати не происходит
        System.out.println("Число d делится на t без остатка и частное равно  " + d/t);  
        
    // Для сравнения ниже операция с некоротким AND - выдаст ошибку, т.к. 2-ое условие d%t приводит к делению на ноль
    // if (t!=0 & (d%t) ==0)  
        // System.out.println("Число d делится на t без остатка и частное равно  " + d/t);  
     
    // При коротком AND увеличие переменной во втором условии осуществляется, при коротком - не осуществляется
    int i = 1;
    if (false && (i++<5)) System.out.println("Строка не будет напечаната, т.к. 1-ое условие False");
    System.out.println ("Переменная i не изменилась и равна "  + i + ", т.к. до ее увеличения компилятор не дошел" + '\n');
    
    i = 1;
    if (false & (i++<5)) System.out.println("Строка не будет напечаната, т.к. 1-ое условие False");
    System.out.println ("Переменная i изменилась и равна "  + i + " ,т.к. до компилятор проверил и 2-ое условие с увеличением" + '\n');
    
    }
}       