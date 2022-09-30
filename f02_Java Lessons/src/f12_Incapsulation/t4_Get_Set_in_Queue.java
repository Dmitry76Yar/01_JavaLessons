package f12_Incapsulation;
// Массив с дуракозащитой. Массив объявляется как закрытый член класса, а доступ к нему осуществляется с помощью
// специально предназначенных для этой цели методов SET и GET, которые проверяют нет ли выхода за пределы массива

class Queue {
    private int Queue1[];
    private int length;
    int set_number = 0; int get_number = 0;
    
    Queue (int length1) {  // Конструктор задает
        Queue1 = new int[length1+1];
        length = length1;}        
    
    void set (int val) {
        if (set_number != length) 
            {Queue1[set_number] = val; 
            System.out.println("Элемент с индексом  " + set_number + "  =  " + val + "  внесен в очередь");}
        else {System.out.println("Очередь заполненна" + set_number); return;}
        set_number++;}
            
    void get() {
        if (get_number <set_number) System.out.println("Элемент с индексом  " + get_number + "  =  " + Queue1[get_number]);
        else {System.out.println("Очередь пустая"); return;}
        get_number++;}
   }                
    
class t4_Get_Set_in_Queue {
     public static void main(String[] args) {
        Queue Queue1 = new Queue(6);  // Создание объекта через конструктор  - создается массив заданной длины
        
          // Добавление элементов в очередь через метод SET
        Queue1.set(13);     Queue1.set(14);     Queue1.set(2);      Queue1.set(8);
        Queue1.set(-20);    //Queue1.set(48);     Queue1.set(383);    Queue1.set(32);
        System.out.println();
         
        for (int i=0; i<4; i++)    Queue1.get();
        Queue1.get();      Queue1.get();       Queue1.get();       Queue1.get();    
        System.out.println();
        
        Queue1.set(48);
        Queue1.get();      Queue1.get();
        System.out.println();
        
        Queue1.set(444);
        Queue1.get();      Queue1.get();
        System.out.println();
        
            }
   } 
   