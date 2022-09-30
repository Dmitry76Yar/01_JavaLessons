package f15_Nasledov_Constructors;
/*В иерархии классов допускается, чтобы как суперклассы, так и подклассы имели собственные конструкторы.

Вопрос: какой именно конструктор отвечает за создание объекта подкласса - конструктор суперкласса, конструктор подкласса или же оба одновременно? 
На этот вопрос можно ответить так: конструктор суперкласса используется для построения родительской части объекта, а конструктор подкласса - для остальной его части.

В этом случае на помощь приходит ключевое слово super, которое может применяться в двух общих формах. 
Вызов конструктора super () всегда должен быть первым оператором в теле конструктора подкласса.
В конструкторе Triangle присутствует вызов конструктора super () с параметрами w и h. 
В результате управление получает конструктор TwoDShape ( ) , инициализирующий переменные width и height этими значениями. 
Теперь класс Triangle не должен самостоятельно инициализировать элементы суперкласса.
Ему остается инициализировать только собственную переменную экземпляра style.   */

// Надкласс TwoDShape, описывающий двумерные объекты
class TwoDShape6 {
    private double width;
    private double height;
    
     /*  Констуктор надкласса*/
    TwoDShape6 (double width1, double height1){
        width = width1;
        height = height1;}
        
    void showDim() {System.out.println("Шиpинa и высота - " + width + " и " + height);}
        
    double get_width() {return width;}
    double get_height() {return height;}
    void set_width (double setwidth) {width = setwidth;}
    void set_height (double setheight) {height = setheight;}
}
// Подкласс Triangle, описывающий треугольник
class Triangle6 extends TwoDShape6 {
    String style;            
    
    /*  Констуктор подкласса с дополнительным переменным подкласса (style)   */
    Triangle6 (double width2, double height2, String s) {
        super(width2, height2);            // вызвать конструктор суперкласса
        style = s;}
        
    double area() {         /*  Собственный метод класса Triangle по расчету площади */
    return (get_width()*get_height())/2;} 
    
    void showStyle() {      /*  Собственный метод класса Triangle по отображению стиля */
    System.out.println("Tpeyгoльник " + style);}
}

class t4_Nasled_of_Constructor_SUPER {
public static void main(String args[]) {
    Triangle6 tl = new Triangle6(4.0, 4.0, "закрашенный");
         
System.out.println("инфopмaция о tl: ");
    tl.showStyle();
    tl.showDim ();
    System.out.println("Плoщaдь - " + tl.area());
    System.out.println();
}
}

