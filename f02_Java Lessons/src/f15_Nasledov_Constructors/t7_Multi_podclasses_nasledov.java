package f15_Nasledov_Constructors;
/*   Java позволяет строить иерархии, состоящие из любого количества уровней наследования.
Так, если имеются три класса, А, B и C, то класс C может наследовать все характеристики класса В, а тот, в свою очередь, 
может наследовать все характеристики класса А.
Kаждый подкласс наследует характерные особенности всех своих суперклассов - класс C наследует все члены классов B и А.
В этой программе подкласс Triangle выступает в роли суперкласса для класса ColorTriangle. 
Класс ColorTriangle наследует все свойства классов Triangle и TwoDShape, а также содержит поле color, определяющее цвет  

Bызов super () всегда означает обращение к конструктору ближайшего суперкласса. 
�?ными словами, вызов super() в классе ColorTriangle означает вызов конструктора класса Triangle,
а в классе Triangle - вызов конструктора класса TwoDShape.*/

// Надкласс TwoDShape, описывающий двумерные объекты
class TwoDShape8 {
    private double width;
    private double height;
    
     /*  Констуктор надкласса c двумя входящими параметрами*/
    TwoDShape8 (double width, double height){
        this.width = width;
        this.height = height;}
        
    void showDim() {System.out.println("Шиpинa и высота - " + width + " и " + height);}
        
    double get_width() {return width;}
    double get_height() {return height;}
    void set_width (double setwidth) {width = setwidth;}
    void set_height (double setheight) {height = setheight;}
}
// Подкласс Triangle, описывающий треугольник
class Triangle8 extends TwoDShape8 {
    String style;            
        /*  Констуктор подкласса */
    Triangle8 (double w, double h, String style) {
        super(w, h);                                 
        this.style = style;}
     
    void showStyle() {      
    System.out.println("Tpeyгoльник " + style);}
}

// ПодПодкласс Color_Triangle, описывающий цветной треугольник
class Color_Triangle8 extends Triangle8 {
    String color;            
        /*  Констуктор ПодПодкласса */
    Color_Triangle8 (double w, double h, String style, String color) {
        super(w, h, style);                                 
        this.color = color;}
     
    void showColor() {      
    System.out.println("Цвет " + color);}
}   

class t7_Multi_podclasses_nasledov {
public static void main(String args[]) {
    
TwoDShape8 t1 = new TwoDShape8(3.0, 3.0);    
System.out.println("инфopмaция об объекте TwoDShape: ");
    t1.showDim();             System.out.println();
    
Triangle8 t2 = new Triangle8(4.0, 4.0, "прямоугольный");
    System.out.println("инфopмaция о треугольнике : ");
    t2.showStyle();
    t2.showDim ();          System.out.println();    
    
Color_Triangle8 t3 = new Color_Triangle8(5.0, 6.0, "равнобедренный", "красный");
    System.out.println("инфopмaция о цветном треугольнике : ");
    t3.showStyle();
    t3.showDim();
    t3.showColor();
    System.out.println();
    
    
    
}
}
