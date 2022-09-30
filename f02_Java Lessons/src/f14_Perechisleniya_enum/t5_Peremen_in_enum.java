package f14_Perechisleniya_enum;
/* Перечисления, как и обычные классы, могут определять конструкторы, поля и методы
Перечисление Color определяет приватное поле code для хранения кода цвета, а с помощью метода getCode оно возвращается. 
Через конструктор передается для него значение. Следует отметить, что конструктор по умолчанию приватный, то есть имеет модификатор private.
Любой другой модификатор будет считаться ошибкой. Поэтому создать константы перечисления с помощью конструктора мы можем только внутри 
перечисления.  */

public class t5_Peremen_in_enum {
public static void main(String[] args) {
		
	System.out.println(Color.RED.get_code() + "\t" + Color.RED.get_popularity());        
    System.out.println(Color.GREEN.get_code());  
    
    }
}

enum Color {
	RED("FF2222", "popular"), BLUE("FF3333", "unpopular"), GREEN("FF4444", "unpopular");   // Создание объектов через конструктор происходит сразу в классе перечисления
	private String color_code;				// Инициализация переменной объекта
	private String popularity;
	Color (String color_code, String popularity) {				// Конструктор			
		this.color_code = color_code; 	
		this.popularity = popularity;}
	public String get_code () {				
		return color_code;}
	public String get_popularity () {				
		return popularity;}
}
	