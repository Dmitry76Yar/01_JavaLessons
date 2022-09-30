package f15_Nasledov_Constructors;
/* В иерархии классов допускается, чтобы как суперклассы, так и подклассы имели собственные конструкторы.

Если конструктор определен только в подклассе, то все происходит очень просто: конструируется объект подкласса, а 
родительская часть объекта автоматически создается конструктором суперкласса, используемым по умолчанию. 
В качестве примера  рассмотрим приведенный ниже переработанный вариант класса Triangle, в котором определяется
собственный конструктор, в связи с чем член style этого класса делается закрытым.   */

// Надкласс TwoDShape, описывающий двумерные объекты
class TwoDShape5 {
    private double width;
    private double height;
    
    void showDim() {System.out.println("Шиpинa и высота - " + width + " и " + height);}
        
    double get_width() {return width;}
    double get_height() {return height;}
    void set_width (double setwidth) {width = setwidth;}
    void set_height (double setheight) {height = setheight;}
}
// Подкласс Triangle, описывающий треугольник
class Triangle5 extends TwoDShape5 {
    String style;            
    
    /*  Констуктор подкласса со всеми переменными класса (width и height) и дополнительными переменными подкласса (style)   */
    Triangle5 (double width1, double height1, String s) {
        set_width(width1);
        set_height(height1);
        style = s;}
        
    double area() {         /*  Собственный метод класса Triangle по расчету площади */
    return (get_width()*get_height())/2;} 
    
    void showStyle() {      /*  Собственный метод класса Triangle по отображению стиля */
    System.out.println("Tpeyгoльник " + style);}
}

class t3_Nasled_of_Constructor_only_in_podklass{
public static void main(String args[]) {
    Triangle5 tl = new Triangle5(4.0, 4.0, "закрашенный");
         
System.out.println("инфopмaция о tl: ");
    tl.showStyle();
    tl.showDim ();
    System.out.println("Плoщaдь - " + tl.area());
    System.out.println();
}
}

