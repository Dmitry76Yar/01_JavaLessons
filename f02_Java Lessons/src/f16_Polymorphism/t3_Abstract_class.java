package f16_Polymorphism;
/*  Абстрактные классы
    Часто требуется создать суперкласс, в котором определяется лишь самая общая форма для всех его подклассов, а наполнение 
ее деталями предоставляется каждому из этих подклассов. В таком классе определяется лишь суть методов, которые должны быть
конкретно реализованы в подклассах, а не в самом суперклассе. 
    Подобная ситуация возникает, например, в связи с невозможностью полноценной реализации метода в суперклассе.
Такая ситуация была продемонстрирована в варианте класса TwoDShape из предыдушего примера, где метод area () был 
определен всего лишь как заполнитель. Такой метод ничего не вычисляет и ничего не возвращает.
    Такая ситуация довольно частая. Подобное затруднение разрешается двумя способами:
    1-ый: Просто вывести предупреждающее сообщение из метода суперкласса, что ""Метод должен быть переопределен"
При отладке такой способ может быть действительно полезным, но в практике программирования он обычно не применяется.
На примере класса Triangle. Он был бы неполным, если бы в нем не был переопределен метод area ().
    Требуется какой-то способ, гарантирующий, что в подклассе действительно будут переопределены все необходимые методы. 
Такой способ в Java имеется. Он состоит в использовании абстрактного метода.    
    Абстрактный метод не имеет тела и поэтому не реализуется в суперклассе. Это означает, что он должен быть переопределен 
в подклассе, поскольку его вариант из суперкласса просто непригоден для использования.  
    Спецификатор abstract может применяться только к обычным методам, но не к статическим методам и конструкторам  
    Класс, содержащий один или несколько абстрактных методов, должен быть также объявлен как абстрактный с использованием 
того же спецификатора abstract в объявлении класса. Поскольку абстрактный класс не определяет реализацию полностью, у него 
не может быть объектов. Следовательно, попытка создать объект абстрактного класса с помощью оператора new приведет к ошибке.
    Подкласс, наследующий абстрактный класс, должен реализовать все абстрактные методы суперкласса. В противном случае он 
также должен быть определен как абстрактный. Таким образом, атрибут abstract наследуется до тех пор, пока не будет достигнута
полная реализация класса.*/
    
abstract class TwoDShape1 {          // КЛАСС TwoDShape ОБЪЯВЛЯЕТСЯ АБСТРАКТНЫМ
    private double width;
    private double height; 
    private String name;
    
        // Параметризованный конструктор 
    TwoDShape1 (double width, double height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;}
        
       // Конструктор для создания одного объекта на основе другого
    TwoDShape1 (TwoDShape1 Ob) {
        width = Ob.width;
        height = Ob.height; 
        name =  Ob.name; } 
            
    double get_width ()              {return width;}
    double get_height ()             {return height;}
    String get_name ()               {return name;}
    void set_width (double a)           {width = a;}
    void set_height (double b)          {height =b;}
    void set_name (String c)         {name = c;}
    
    abstract double area ();           // МЕТОД АБСТРАКТНЫЙ
}      
class Triangle1 extends TwoDShape1 {
      String style;
              
      // Параметризованный конструктор
       Triangle1 (double width, double height, String name, String style) { 
          super(width, height, name);   
          this.style = style;}
      
      // Конструктор для создания одного объекта на основе другого
        Triangle1 (Triangle1 Ob, String style) { 
          super (Ob);               // передать объект конструктору класса TwoDShape
          style = Ob.style; }
          
       // Переопределение метода area() для класса Triangle
       double area () {
          return get_width()*get_height()/2;}
}
class Rectangle1 extends TwoDShape1 {      //Подкласс для представления прямоугольников,
         // Параметризованный конструктор
        Rectangle1 (double width, double height) {
            super(width, height, "Прямоугольник");}
            
        // Конструктор для создания одного объекта на основе другого
        Rectangle1 (Rectangle1 Ob) {
            super (Ob);}
        
        boolean isSquare() {
          if (get_width() == get_height()) return true;
          else return false;}  
          
        // Переопределение метода area() для класса Rectangle
        double area() {
          return get_width()*get_height();}
}      
class t3_Abstract_class {
public static void main(String args[]) {
    TwoDShape1 shapes[] = new TwoDShape1[5];
    
    shapes[0] = new Triangle1(8.0, 12.0, "треугольник", "контурный");
    System.out.print (shapes[0].get_name() + "\t" + shapes[0].get_width() + "\t" + shapes[0].get_height() + "\t" );   //
    System.out.println ("Площадь равна   " + shapes[0].area());
    
    shapes[1] = new Rectangle1(4.0, 7.0);
    System.out.print (shapes[1].get_name() + "\t" + shapes[1].get_width() + "\t" + shapes[1].get_height() + "\t");
    System.out.println ("Площадь равна   " + shapes[1].area());
    
   /* shapes[2] = new TwoDShape(9.0, 5.0, "Фигура");  - будет ошибка, т.к. нельзя создавать объектов абстрактного класса */
    
}} 