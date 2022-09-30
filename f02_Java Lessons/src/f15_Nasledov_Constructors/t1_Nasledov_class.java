package f15_Nasledov_Constructors;
/* В Java, чтобы наследовать класс, достаточно включить его имя в объявление другого класса с помощью ключевого слова extends. 
Таким образом, подкласс расширяет суперкласс, дополняя его собственными членами.
Здесь в классе TwoDShape определены свойства обобщенной двумерной фигуры, частными случаями которой могут быть квадрат, треугольник...
Класс Triangle представляет конкретную разновидность класса TwoDShape, в данном случае треугольник. 
Класс Triangle включает в себя все элементы класса TwoDShape (переменные width, height и метод showDim()), а в дополнение к ним - поле style и методы area() и showStyle ). 

Главное преимущество наследования заключается в следующем: создав суперкласс, в котором определены общие для множества объектов свойства, 
вы можете использовать его для создания любого числа более специализированных подклассов. 
Каждый подкласс добавляет собственный набор специфических для него атрибутов в соответствии с конкретной необходимостью.*/

// Класс, описывающий двумерные объекты
class TwoDShape1 {
    double width;
    double height;
    
    void showDim() {
        System.out.println("Шиpинa и высота - " + width + " и " + height);}
}
// Подкласс для представления треугольников, производный от класса TwoDShape
class Triangle1 extends TwoDShape1 {
    String style;            /*  из надкласса TwoDShape также приходят переменные width и height */
    
    double area() {         /*  Собственный метод класса Triangle по расчету площади */
    return width*height/2;} 
    
    void showStyle() {      /*  Собственный метод класса Triangle по отображению стиля */
    System.out.println("Tpeyгoльник " + style);}
}

class t1_Nasledov_class {
public static void main(String args[]) {
    Triangle1 tl = new Triangle1();
    tl.width = 4.0;          tl.height = 4.0;     tl.style = "закрашенный";
  
    
System.out.println("инфopмaция о tl: ");
    tl.showStyle();
    tl.showDim ();
    System.out.println("Плoщaдь - " + tl.area());
    System.out.println();

}
}
