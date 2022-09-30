package f12_Incapsulation;
// Массив с дуракозащитой. Массив объявляется как закрытый член класса, а доступ к нему осуществляется с помощью
// специально предназначенных для этой цели методов SET и GET, которые проверяют нет ли выхода за пределы массива

class Array {
    private int Massive[];
    private int length;
    
    public Array(int length1) {
        Massive = new int[length1];  // При вызове конструктора создается массив заданной длины
        length = length1;}        
    
    void get (int index) {
        if ((index>=0) & (index<Massive.length)) System.out.println("\t\t" + Massive[index] + " ");
        else System.out.println("Такого элемента не существует");}
        
    boolean set(int index, int val) {
        if ((index>=0) & (index<Massive.length)) {Massive[index] = val; return true;}
        else return false;}
}
    
class t3_Get_Set_in_Massive {
     public static void main(String[] args) {
        Array Object1 = new Array(3);  // Создание объекта через конструктор  - создается массив заданной длины
        
          // Добавление элементов в массив через метод SET
        for (int i=-2; i<5; i++)    {
            Object1.set(i, i*10);
            if (Object1.set(i, i*10) == true)  System.out.println("\tЗначение " + i*10 + " внесено в массив под индексом " + i);
            else System.out.println("Элемента под таким индексом = " + i+ " не существует");}
        
        System.out.println();
        for (int i=-2; i<5; i++)    Object1.get(i);
               
                
            }
   } 
   