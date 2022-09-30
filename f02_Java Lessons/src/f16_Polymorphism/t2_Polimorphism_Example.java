package f16_Polymorphism;
/*  Полиморфизм в переопределяемых методах
    Большое значение полиморфизма в ОО программах обусловлено тем, что это позволяет объявить в суперклассе методы,
общие для всех ero подклассов, а в самих подклассах - определить конкретные реализации всех этих методов или некоторых из них. 
    Переопределение методов - один из способов для реализации принципа полиморфизма "один интерфейс - множество методов".
    Залогом успешного применения полиморфизма является, в частности, понимание тоrо, что суперклассы и подклассы образуют 
иерархию по степени увеличения специализации. При продуманной организации суперкласса он предоставляет своему подклассу
все элементы, которыми тот может пользоваться непосредственно. В нем также определяются те методы, которые должны быть 
по-своему реализованы в производных классах. Таким образом, подклассы получают достаточную свободу в определении собственных
методов, реализуя в то же время согласованный интерфейс. Сочетая наследование с переопределением методов, в суперклассе можно 
определить общую форму методов для использования во всех ero подклассах.
переопределения
    В приведенных ранее примерах в каждом классе, наследующем класс TwoDShape, определялся метод area (). 
Теперь мы знаем, что в этом случае имеет смысл включить метод area () в состав класса TwoDShape, позволить каждому ero 
подклассу переопределить этот метод и, в частности, реализовать вычисление площади в зависимости от конкретного
типа геометрической фигуры.
  */
    
class TwoDShape {
    private double width;
    private double height; 
    private String name;
        // Параметризованный конструктор 
    TwoDShape (double width, double height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;}
        
        // Конструктор по умолчанию
    TwoDShape () {
        width = height = 0.0;   name = "none"; }
        
        // Конструктор для создания одного объекта на основе другого
    TwoDShape (TwoDShape Ob) {
        width = Ob.width;
        height = Ob.height; 
        name =  Ob.name; } 
        
        
    double get_width ()              {return width;}
    double get_height ()             {return height;}
    String get_name ()               {return name;}
    void set_width (double a)           {width = a;}
    void set_height (double b)          {height =b;}
    void set_name (String c)         {name = c;}
    
    double area () {
        System.out.print("Meтoд area() должен быть переопределен \t");
        return 0.0;}
}      
class Triangle extends TwoDShape {
      String style;
      // Конструктор по умолчанию
      Triangle () { 
        super();    
        style = "none";}
        
      // Параметризованный конструктор
       Triangle (double width, double height, String name, String style) { 
          super(width, height, name);   
          this.style = style;}
      
      // Конструктор для создания одного объекта на основе другого
        Triangle (Triangle Ob, String style) { 
          super (Ob);               // передать объект конструктору класса TwoDShape
          style = Ob.style; }
          
       // Переопределение метода area() для класса Triangle
       double area () {
          return get_width()*get_height()/2;}
}
class Rectangle extends TwoDShape {      //Подкласс для представления прямоугольников,
       // Конструктор по умолчанию
       Rectangle() {
        super();}
        
        // Параметризованный конструктор
        Rectangle (double width, double height) {
            super(width, height, "Прямоугольник");}
            
        // Конструктор для создания одного объекта на основе другого
        Rectangle (Rectangle Ob) {
            super (Ob);}
        
        boolean isSquare() {
          if (get_width() == get_height()) return true;
          else return false;}  
          
        // Переопределение метода area() для класса Rectangle
        double area() {
          return get_width()*get_height();}
}      
class t2_Polimorphism_Example {
public static void main(String args[]) {
    TwoDShape shapes[] = new TwoDShape[5];
    
    shapes[0] = new Triangle(8.0, 12.0, "треугольник", "контурный");
    System.out.print (shapes[0].get_name() + "\t" + shapes[0].get_width() + "\t" + shapes[0].get_height() + "\t" );   //
    System.out.println ("Площадь равна   " + shapes[0].area());
    
    shapes[1] = new Rectangle(4.0, 7.0);
    System.out.print (shapes[1].get_name() + "\t" + shapes[1].get_width() + "\t" + shapes[1].get_height() + "\t");
    System.out.println ("Площадь равна   " + shapes[1].area());
    
    /* Важно, что т.к. объект shapes[1], хоть и ссылается на объект типа Rectangle, принадлежит типу суперкласса, поэтому
он будет иметь переменные только суперкласса и строка ниже выдаст ошибку, т.к.переменная style приналежит классу Rectangle
     System.out.print ("shapes[1].get_height()                     */
       
    shapes[2] = new TwoDShape(9.0, 5.0, "Фигура");
    System.out.print (shapes[2].get_name() + "\t" + shapes[2].get_width() + "\t" + shapes[2].get_height() + "\t");
    System.out.println ("Площадь равна   " + shapes[2].area());
 
 /* Обратите внимание на то, что в методе main () геометрические фигуры объявляются как массив объектов типа TwoDShape. 
Но на самом деле элементами массива являются ссылки на объекты Triangle, Rectangle и TwoDShape. 
Это вполне допустимо. Ведь, как пояснялось ранее, ссылочная переменная суперкласса может ссылаться на объект его подкласса.
    Пример наглядно демонстрирует возможности как наследования классов, так и переопределения методов. 
    Тип объекта, на который указывает ссылочная переменная суперкласса, определяется во время выполнения, что гарантирует 
правильный выбор версии переопределенного метода. Если объект является производным от класса TwoDShape, то для вычисления 
его площади достаточно вызвать метод area (). интерфейс для выполнения данной операции оказывается общим и не зависит от того,
с какой именно геометрической фигурой приходится иметь дело. */   
}} 