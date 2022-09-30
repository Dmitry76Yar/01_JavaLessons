package f15_Nasledov_Constructors;
/* Наследование класса не отменяет ограничений, налагаемых на доступ к закрытым членам класса. 
Так, если переменные экземпляра width и height в надклассе TwoDShape объявить как закрытые, это предотвратит возможность доступа к ним из подкласса Triangle. 

Для обращения к закрытым членам надкласса в программах на Java обычно используют специальные методы доступа GET и SET.*/

// Надкласс TwoDShape, описывающий двумерные объекты
class TwoDShape4 {
    private double width;
    private double height;
    
    void showDim() {
        System.out.println("Шиpинa и высота - " + width + " и " + height);}
        
    double get_width() {
        return width;}
        
    double get_height() {
        return height;}
        
    void set_width (double setwidth) {
        width = setwidth;}
        
    void set_height (double setheight) {
        height = setheight;}
}
// Подкласс Triangle, описывающий треугольник
class Triangle4 extends TwoDShape4 {
    String style;            /*  из надкласса TwoDShape также приходят переменные width и height */
    
    double area() {         /*  Собственный метод класса Triangle по расчету площади */
    return (get_width()*get_height())/2;} 
    
    void showStyle() {      /*  Собственный метод класса Triangle по отображению стиля */
    System.out.println("Tpeyгoльник " + style);}
}

class t2_Nasledov_class_with_incapsulation {
public static void main(String args[]) {
    Triangle4 tl = new Triangle4();
    tl.set_width(4.0);     tl.set_height(4.0);     tl.style  = "закрашенный";
       
System.out.println("инфopмaция о tl: ");
    tl.showStyle();
    tl.showDim ();
    System.out.println("Плoщaдь - " + tl.area());
    System.out.println();
}
}
