package f15_Nasledov_Constructors;
/*   Java является строго типизированным языком программирования. Это означает, что переменная,
 ссылающаяся на объект класса одного типа, как правило, не может ссылаться на объект класса другого типа. 
    Однако существует одно важное исключение из этого: ссылке на объект суперкласса может быть присвоена 
ссылка на объект любого подкласса, производного от данного суперкласса. 
    Один из самых важных моментов для присваивания ссылок на объекты подкласса = ссылок  на объекты суперкласса наступает,
когда конструкторы вызываются в иерархии классов. Часто в конструктор передается в качестве параметра объект своего класса - 
благодаря этому в классе может быть сконструирована копия объекта. 
    Этой особенностью можно воспользоваться в подклассах, производных от такого класса. 
    В качестве примера рассмотрим описанные ниже версии классов TwoDShape и Triangle. В оба класса добавлены
конструкторы, принимающие объект своего класса в качестве параметра.   */

class TwoDShape {
    private double width;
    private double height;
    
     /*  Констуктор надкласса c двумя входящими параметрами*/
    TwoDShape (double width1, double height1){
        width = width1;
        height = height1;}
        
    /*  Констуктор надкласса, принимающий объект этого же класса  */
    TwoDShape (TwoDShape Ob){
        width = Ob.width;
        height = Ob.height;}
       
  void showDim() {System.out.println("Шиpинa и высота - " + width + " и " + height);}
        
    double get_width() {return width;}
    double get_height() {return height;}
    void set_width (double setwidth) {width = setwidth;}
    void set_height (double setheight) {height = setheight;}
}
// Подкласс Triangle, описывающий треугольник
class Triangle extends TwoDShape {
    String style;            
    /*  Констуктор подкласса по умолчанию, вызывающший конструктор суперкласса по умолчанию  + присвоение нулевого значения переменной style*/
    Triangle (double a, double b, String s) {
        super(a,b);                                  
        style = s;}
        
      /*  Констуктор подкласса, принимающий объект этого же класса  
      В качестве параметра конструктору передается объект Triangle, который затем с помощью вызова super () 
передается конструктору TwoDShape. */
    Triangle (Triangle Ob1) {
        super(Ob1);
        style = Ob1.style;}
        
    void showStyle() {      /*  Собственный метод класса Triangle по отображению стиля */
    System.out.println("Tpeyгoльник " + style);}
}

class t10_Constructor_Copy_of_Object {
public static void main(String args[]) {
    System.out.println("Данные созданного объекта t1 суперкласса TwoDShape:");
    TwoDShape t1 = new TwoDShape(3.0, 5.0);
    t1.showDim();          System.out.println();

/* Объект t2 конструируется на основе объекта tl, и поэтому они идентичны.  */ 
    System.out.println("Данные объекта t2 суперкласса TwoDShape, скопированного с t1:");
    TwoDShape t2 = new TwoDShape(t1);
    t2.showDim ();          System.out.println();
    
Triangle t3 = new Triangle(4.0, 4.0, "красный");
    System.out.println("Данные созданного объекта t3 подкласса TwoDShape:");
    t3.showStyle();
    t3.showDim ();
    System.out.println();
 
/* Объект t4 подкласса конструируется на основе объекта t3, и поэтому они идентичны.  */ 
Triangle t4 = new Triangle(t3);
    System.out.println("Данные созданного объекта t4 подкласса TwoDShape, , скопированного с t3: ");
    t4.showStyle();
    t4.showDim ();
    System.out.println();    
    
    }
}
