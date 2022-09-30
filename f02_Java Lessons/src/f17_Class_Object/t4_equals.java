package f17_Class_Object;
/*  Метод equals()
Метод equals() обозначает отношение эквивалентности объектов. Эквивалентным называется отношение, которое является симметричным, транзитивным и рефлексивным.
	
Соглашение между equals и hashCode в Java
Если два объекта равны по методу equals(), то у них всегда одинаковый hashCode. 
Но у двух разных объектов hashCode могут быть одинаковыми, а могут и отличаться.

	При default исполнении метода equals() он делает то же самое, что и операция If (Ob a == Ob b), а именно сравнивает ссылки, но не содержимое ссылок (объекты)
Cравнение ссылок даст true только в том случае, если ссылки ссылаются на один и тот же объект (например, если создается ссылка Ob2 = Ob1). 
Это видно, если взглянуть исходный код метода equals класса Object:
	public boolean equals(Object obj) {
		return (this == obj);
		
	Поэтому нужно переопределять метода equals() в созданном классе, чтобы он проверял равенство значений параметров/полей объектов. 
Например, в классе String уже переопределен equals таким образом, что возвращается true, если содержимое двух сравниваемых объектов одинаковое.
А в классе-обертке Integer метод equal уже переопределен для выполнения численного сравнения.
	Java предлагает следующие правила для переопределения этих методов:
 - Метод рефлексивен - при сравнении ненулевого объекта с самим собой будет true    x.equals(x) = true 
 - Метод симметричен - при сравнении ненулевых объектов x и y:  если x.equals(y) = true, то и y.equals(x) = true.
 - Метод транзитивен - при сравнении ненулевых объектов x, y и z, если x.equals(y) = true и y.equals(z) = true, то и x.equals(z) = true.
 - Метод непротиворечив (консистентен): для любых ненулевых ссылочных значений x и y множественные вызовы x.equals(y) последовательно возвращают true или 
последовательно возвращают false при условии, что никакая информация, используемая в сравнениях equals на объектах, не изменяется.
 - Сравнение null: объект должны быть проверен на null. Если объект равен null, то метод должен вернуть false, а не NullPointerException.
 - Синтаксис метода должен оставаться прежним, т.е. public boolean equals(Object obj), т.е. на входе объект типа Object. 
Не нужно перегружать метод  public boolean equals(Person obj) с использование на входе объект своего класса (напр. Person). Эту ошибку сложно обнаружить 
 - ВСЕГДА нужно переопределять также и метод hashCode(). 
При переопределении hashCode() удостоверьтесь в использовании всех полей, что были использованы в методе equals().
	Почему так важно переопределять метод hashCode()?
При вычислении hashCode для объектов класса Object по умолчанию используется RNG алгоритм, в основе которого лежит генератор случайных чисел. 
Получается, что при каждом создании объекта класса мы будем получать разные хеш-коды. Мало того, перезапуская программу, мы будем получать абсолютно разные
значения, поскольку это просто случайное число.
Но, как мы помним, должно выполняться правило: “если у двух объектов одного и того же класса содержимое одинаковое, то и хеш-коды должны быть одинаковые ”. 
Поэтому, при создании пользовательского класса, принято переопределять методы hashCode() и equals() таким образом, что бы учитывались поля объекта.
	
*/

class Vehicle4 {
	int max_speed;
	String name;
		Vehicle4(int max_speed, String name) {
		this.max_speed = max_speed;
		this.name = name;}
}
class Plane4 {
	int max_speed;
	String name;
		Plane4(int max_speed, String name) {
		this.max_speed = max_speed;
		this.name = name;}
}		
	// Класс в котором equals() переопределен для сравнения только поля name
class Vehicle5 {
	int max_speed;
	String name;
		Vehicle5(int max_speed, String name) {
		this.max_speed = max_speed;
		this.name = name;}
		
/* @Override указывает, что далее мы собираемся переопределять метод базового класса.
   При этом, если в базовом классе не окажется метода с аналогичной сигнатурой, то мы получим предупреждение компилятора о том, что хотя мы и собирались
что-то переопределить, по факту этого не произошло. На этом действие аннотации заканчивается
   Таким образом, аннотация никак не влияет на сам факт переопределения метода - при совпадении сигнатур с методом базового класса он и так будет переопределен, 
независимо от наличия, либо отсутствия этой аннотации. 
   В случае отсутствия данной аннотации и не совпадении сигнатур (в результате ошибки) с методом, который мы собирались переопределять - случится страшное - 
очень трудноуловимая ошибка, когда вы думаете, что должно бы переопределяться, а по факту имеете отдельный метод, который скорее всего вообще не выполняется.*/
	
	// Переопределение метода hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 0;
		for (int i=0; i<name.length(); i++) result = result + prime*(int)name.charAt(i);  // Перевод String name в число по выдуманному алгоритму
		result = result* max_speed;
	return result;}
		
	// Переопределение метода equals()
		@Override
	public boolean equals(Object Obj){
	boolean result = false;
		// Проверка ??
	if (this == Obj) result = true;
		/* Проверка, что объект не null и что объекты одного класса с помощью getClass().  Не делайте проверку с помощью instanceof, т.к. такая проверка будет 
возвращать true для подклассов и будет работать правильно только в случае если ваш класс объявлен как immutable.*/
	if ((Obj ==null) && (this.getClass() != Obj.getClass()))  result = false;
		/* Проверка каждого параметра объекта с предварительным приведением объекта на входа к классу объекта, с которым идет сравнение (через 
создания временного объекта Temp равного сравниваемому объекту */
	Vehicle5 Temp = (Vehicle5)Obj;
	if ((name != null)&&(name.equals(Temp.name))) result = true;
	if (max_speed == Temp.max_speed) result = true;
	return result;
	}
}

class t4_equals {
public static void main (String[] args){
	Vehicle4 Car1 = new Vehicle4(120, "Skoda"); 	System.out.println("Код ссылки Car1 =    " + Car1 + "\t hashCode cсылки Car1=   " + Car1.hashCode());
	Vehicle4 Car2 = new Vehicle4(120, "Skoda"); 	System.out.println("Код ссылки Car2 =    " + Car2 + "\t hashCode cсылки Car2=   " + Car2.hashCode());
	Vehicle4 Car3 = new Vehicle4(130, "VW");		System.out.println("Код ссылки Car3 =    " + Car3 + "\t hashCode cсылки Car3=   " + Car3.hashCode());
	Vehicle4 Car4; 	Car4 = Car1;				System.out.println("Код ссылки Car4 =    " + Car4 + "\t hashCode cсылки Car4=   " + Car4.hashCode());
			
			System.out.println("\t\tКак работает if (Ob1 == Ob2) ");
	System.out.println("Операция if (Car1 == Car2) выдает  " + (Car1 == Car2));
	System.out.println("Операция if (Car1 == Car2) выдает  " + (Car1 == Car3));
	System.out.println("Операция if (Car1 == Car4) выдает  " + (Car1 == Car4));
		
			System.out.println("\t\tКак работает Ob1.equals(Ob2) ");
	System.out.println("Метод Car1.equals(Car2) выдает  " + Car1.equals(Car2) + ", т.к. адреса ссылок различаютс");
	System.out.println("Метод Car1.equals(Car3) выдает  " + Car1.equals(Car3) + ", т.к. адреса ссылок различаются, хотя объекты и равны");
	System.out.println("Метод Car1.equals(Car4) выдает  " + Car1.equals(Car4) + ", т.к. ссылки Car1 и Car4 указывают на одит и тот же объект");
		
			System.out.println("\t\t В методе Integer метод equals() переопределен для сравнения именно значений объектов (чисел) ");
	Integer a1 = new Integer(10);
	Integer a2 = new Integer(10);
	System.out.println("Операция (a1 == a2) выдает\t" + (a1 == a2));
	System.out.println("Метод a1.equals(a2) выдает \t" + a1.equals(a2));
	
		System.out.println("\t\tКак работает переопределенный Ob1.equals(Ob2) для класса Vehicle2");
	Vehicle5 Auto1 = new Vehicle5(120, "Skoda"); 	System.out.println("Код ссылки Auto1 =    " + Auto1 + "\t hashCode cсылки Auto1=   " + Auto1.hashCode());
	Vehicle5 Auto2 = new Vehicle5(140, "VW"); 		System.out.println("Код ссылки Auto2 =    " + Auto2 + "\t hashCode cсылки Auto2=   " + Auto2.hashCode());
	Vehicle5 Auto3 = new Vehicle5(120, "Skoda"); 	System.out.println("Код ссылки Auto3 =    " + Auto3 + "\t hashCode cсылки Auto3=   " + Auto3.hashCode());
	System.out.println();
	System.out.println("Операция if (Auto1 == Auto3) выдает  " + (Auto1 == Auto3) + ", т.к. адреса ссылок различаются");
	System.out.println("Метод Auto1.equals(Auto2) выдает  " + Auto1.equals(Auto2) + ", т.к. объекты различаются");
	System.out.println("Метод Auto1.equals(Auto3) выдает  " + Auto1.equals(Auto3) + ", т.к. hashCode и переменные объектов одинаковы");
	
	
	 }
}
   
   