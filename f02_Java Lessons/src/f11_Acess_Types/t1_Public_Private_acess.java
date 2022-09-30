package f11_Acess_Types;
class Acess{
    public int a; 
    private int b;
    
    void set_a (int a1) {
        a = a1;}
    void set_b(int b1) {
        b = b1;}  
    int get_a (){
        return a;}
    int get_b() {
        return b;}
}     
    
 public class t1_Public_Private_acess {
     public static void main(String[] args) {
        Acess Object1 = new Acess(); 
        //Переменная a может быть присвоена из основного кода, т.к. она является public
        Object1.a = 112;      System.out.println("Переменной a присвоено значение" + Object1.a + " из основного кода, т.к. переменная public");
        
         // Присвоение нового значения переменной а для объекта1 через метод set_a
        Object1.set_a(12);
        System.out.println("Переменной a объекта1 присвоено новое значение  " + Object1.a + "  через set_a ");
         
        // Object1.b = 111;     Переменная b не может быть присвоена из основного кода, т.к. она является private
                
        // Но private переменной b может быть присвоено значение из основного кода через метод set_b
        // Чтение private переменной b также возможно только через метод get_b
        Object1.set_b(1002);
        System.out.println("Переменной b объекта1 присвоено новое значение  " + Object1.get_b() + "  через set_b ");
        
        
            }
   } 
   