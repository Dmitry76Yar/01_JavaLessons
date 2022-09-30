package f01_Operators_Cycles_Sort;
class t4_For_Without_Body{
    public static void main(String[] args){
        
    int j; int result;
    for (j= 0, result = 0; j<=6; result +=j, j++);  // Расчет сквозной суммы чисел от 0 до 6
       System.out.println("Сумма чисел от 0 до 6 равен " + result); 
        
    int sum =0; 
    int i=0;
    int factorial = 1;
    
    for (; i<6; sum = sum+i, factorial = factorial*i) i++;
        System.out.println("Сумма чисел от 0 до 6 равен " + sum); 
    System.out.println("Факториал чисел от 0 до 6 равен " + factorial);    
    
           }
}
