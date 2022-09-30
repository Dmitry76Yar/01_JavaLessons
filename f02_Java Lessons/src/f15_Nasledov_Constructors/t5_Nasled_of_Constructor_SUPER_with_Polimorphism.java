package f15_Nasledov_Constructors;
/*   Вызов super () позволяет вызвать любую форму конструктора, определенную в суперклассе 
Для выполнения выбирается тот вариант конструктора, который соответствует  указанным аргументам. 
Ниже в качестве примера приведены расширенные версии  классов TwoDShape и Triangle, которые содержат конструкторы по умолчанию и конструкторы,
принимающие один и более аргументов.  */

// Надкласс TwoDShape, описывающий двумерные объекты
class TwoDShape7 {
    private double width;
    private double height;
    
     /*  Констуктор надкласса c двумя входящими параметрами*/
    TwoDShape7 (double width1, double height1){
        width = width1;
        height = height1;}
        
        /*  Констуктор надкласса по умолчанию*/
    TwoDShape7 (){
        width = height = 0;}
        
         /*  Констуктор надкласса с одинаковыми значениями переменных экземпляра width и height   */
    TwoDShape7 (double x){
        width = height = x;}
        
    void showDim() {System.out.println("Шиpинa и высота - " + width + " и " + height);}
        
    double get_width() {return width;}
    double get_height() {return height;}
    void set_width (double setwidth) {width = setwidth;}
    void set_height (double setheight) {height = setheight;}
}
// Подкласс Triangle, описывающий треугольник
class Triangle7 extends TwoDShape7 {
    String style;            
    
    /*  Констуктор подкласса по умолчанию, вызывающший конструктор суперкласса по умолчанию  + присвоение нулевого значения переменной style*/
    Triangle7 () {
        super();                                  // вызвать конструктор суперкласса по умолчанию
        style = "none";}
        
    /*  Констуктор подкласса, вызывающший конструктор суперкласса c двумя входящими параметрами  */
    Triangle7 (double width2, double height2, String s) {
        super(width2, height2);     // вызвать конструктор суперкласса c двумя входящими параметрами
        style = s;}
    
     /*  Констуктор подкласса, вызывающший конструктор суперкласса c одинаковыми значениями переменных экземпляра width и height */
    Triangle7 (double x1, String s) {
        super(x1);     // вызвать конструктор суперкласса c одинаковыми значениями переменных экземпляра width и height
        style = s;}
        
        
    double area() {         /*  Собственный метод класса Triangle по расчету площади */
    return (get_width()*get_height())/2;} 
    
    void showStyle() {      /*  Собственный метод класса Triangle по отображению стиля */
    System.out.println("Tpeyгoльник " + style);}
}

class t5_Nasled_of_Constructor_SUPER_with_Polimorphism {
public static void main(String args[]) {
    
Triangle7 tl = new Triangle7();    
System.out.println("инфopмaция об объекте с параметрами по умолчанию: ");
    tl.showStyle();
    tl.showDim ();
    System.out.println();
    
Triangle7 t2 = new Triangle7(4.0, 4.0, "красный");
    System.out.println("инфopмaция об объекте с 2-мя входящими параметрами из конструктора класса и 1-м параметром, входящим из конструктора подкласса : ");
    t2.showStyle();
    t2.showDim ();
    System.out.println();
    
Triangle7 t3 = new Triangle7(5.0, "синий");
    System.out.println("инфopмaция об объекте сc одинаковыми значениями переменных экземпляра width и height из из конструктора класса и пи 1-м параметром, входящим из конструктора подкласса : ");
    t3.showStyle();
    t3.showDim ();
    System.out.println();
    
    
    
}
}
