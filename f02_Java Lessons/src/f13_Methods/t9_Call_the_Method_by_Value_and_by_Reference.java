package f13_Methods;
// Если методу передается простой тип, например int или double, то он передается по значению (by Value).
// В этом случае в параметр метода копируется значение аргумента. В теле метода значение перменной может меняться, но 
// за пределами метода переменная не изменяется

// Если методу передается ссылка (например, на объект), то при этом параметру метода передается не значение аргумента, а ссылка
// на него. Это означает, что изменения, вносимые в параметр/объект будут меняться как в методе, так и вне метода

// Класс Test и метод Method для демонстрации передачи по значению
class Test{
   public void Method (int a1, int b1, char c){
   a1 = 1; b1 = 101; c = 'r';}
}
// Класс Test2 и метод Method2 для демонстрации передачи по ссылке
class Test2 {
    int a3;     int b3;
        Test2 (int a3, int b3) {   // - конструктор
        this.a3 = a3;    this.b3 = b3;}
        
    // Метод получает на входе объект
    void Method2 (Test2 Obj){
        Obj.a3 = 1; Obj.b3 = 101;}
        
}       
class t9_Call_the_Method_by_Value_and_by_Reference {
     public static void main(String[] args) {
// Демонстрация передачи по значению
        Test Object = new Test();
        int a = 15;        int b = 13;  char c = 't';
        System.out.println("Значение переменных до вызова метода   а = " + a + "      b=  " + b + "      char c = " + c);
        Object.Method(a,b,c);
        System.out.println("Значение переменных после вызова метода   а = " + a + "    b=  " + b + "      char c = " + c +"   - значение переменнных не изменились");

// Демонстрация передачи по ссылке
        Test2 Object2 = new Test2 (15,13);
        System.out.println("Значение переменных до вызова метода   Object2.a3 = " + Object2.a3 + " \t Object2.b3=  " + Object2.b3);
        Object2.Method2(Object2);
        System.out.println("Значение переменных после вызова метода   Object2.a3 = " + Object2.a3 + " \t Object2.b3=  " + Object2.b3);
        
             
            }
   } 
   