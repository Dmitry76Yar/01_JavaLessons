package f08_Class;
/*Вкласс можно вложить в области действия блока. В итоге получается локальный класс, недоступный за пределами блока. 
В следующем примере программы мы преобразуем класс ShowBits, созданный в упражнении 5.3, таким образом,
чтобы он стал локальным.*/
 
public class t5_Class_in_main_code{
   public static void main(String[] args) {
    class Show_bits{
        int numbits;
        
        Show_bits (int n) {
            numbits = n;}
            
        void show (long val){
            long mask = 1;
            // Сдиг влево для установки единицы в нужной позиции
            mask <<= numbits - 1;
            
            int spacer = 0;
            for (; mask != 0; mask >>>= 1) {
                if( (val & mask) != 0) System.out.print("1");
                else System.out.print("0");
                spacer++;
                if ( (spacer % 8) == 0) {
                    System.out.print(" ");
                    spacer = 0;}
            }   
           System.out.println();
        }
    }
for (byte b = 0; b < 10; b++) {
    Show_bits byteval = new Show_bits(8);
    System.out.print(b + " в двоичном представлении: ");
    byteval.show(b); 
         }
   }
}
   
   