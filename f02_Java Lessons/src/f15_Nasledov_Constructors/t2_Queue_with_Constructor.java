package f15_Nasledov_Constructors;
// Массив с дуракозащитой. Массив объявляется как закрытый член класса, а доступ к нему осуществляется с помощью
// специально предназначенных для этой цели методов SET и GET, которые проверяют нет ли выхода за пределы массива

class Queue {
    private char q[];                           // массив для хранения элементов очереди
    private int set_number; 
    private int get_number;     // индексы для вставки и извлечения элементов очереди
    
    // Конструктор пустой очереди заданного размера
    Queue (int size) {  
        q = new char[size + 1];
        set_number = 0; get_number = 0;} 
    
    // Конструктор по созданию копии очереди
    Queue(Queue ob) {
        set_number = ob.set_number;
        get_number = ob.get_number;
        q = new char[ob.q.length];
                                    // Копировать элементы очереди
        for (int i = (get_number+1); i<=set_number; i++)   q[i] = ob.q[i];}
        
    // Конструктор очереди на основе массива исходных значений
    Queue(char a[]) {
        q = new char[a.length+1];
        set_number = 0; int get_number = 0;
        for (int i=0; i<a.length; i++)  set(a[i]);}
                   
    // Метод для записи элемента в очередь   
    void set (char val) {
        if (set_number == q.length-1) 
            {System.out.println("Очередь заполненна" + set_number); 
            return;}
        set_number++;
        q[set_number] = val;
        System.out.println("Элемент с индексом  " + set_number + "  =  " + val + "  внесен в очередь");}
    
 // Метод для чтения элементов из очереди
    char get() {
        if (get_number == set_number) 
            {System.out.println("Очередь пустая"); 
            return (char)0;}
        get_number++;
        System.out.println("Элемент с индексом  " + get_number + "  =  " + q[get_number]);
        return q[get_number];
       }
   }                
    
class t2_Queue_with_Constructor {
     public static void main(String[] args) {
        
        // Создание очереди через конструктор заданной длины
        Queue q1 = new Queue(10);  
        
        // Создание очереди через конструктор с изначальным внесением элементов из массива элементов
        char name[] = {'T','o','m'};
        Queue q2 = new Queue(name);  
        
        // Поместить ряд символов в очередь ql 
        for(int i=0; i < 10; i++) 
            q1.set((char)('A' + i));
            
        
        // Создать одну очередь на основе другой
        Queue q3 = new Queue(q1); 
        
        char ch;
        // Показать очередь q1  
        System.out.println("Coдepжимoe ql: ");
        for (int i=0; i<10; i++) {
            ch = q1.get();}         System.out.println();
     
       // Показать очередь q2  
        System.out.println("Coдepжимoe q2: ");
        for (int i=0; i<10; i++) {
            ch = q2.get(); }        System.out.println();
            
         // Показать очередь q3  
        System.out.println("Coдepжимoe q3: ");
        for (int i=0; i<10; i++) {
            ch = q3.get();}          System.out.println();
        
            }
   } 
   