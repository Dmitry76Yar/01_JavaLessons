package f22_Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Phone implements Comparable<Phone>{
	private String name;
	private PhoneType type;
	private int price;
	public enum PhoneType {SMARTPHONE, BOTTON};
	public Phone(String name, PhoneType type, int price){
        this.name=name;
        this.type = type;
        this.price=price;
    }
	public int getPrice () {
		return price;}
	public String getName () {
		return name;}
	public String getType () {
		return type.toString();}
	@Override
		//	В данной реализации compareTo идет сравнение через встроенного механизма сравнения для строк (name)
	public int compareTo(Phone o) {
		return name.compareTo(o.getName().toUpperCase());
	}
}
public class t04_Stream_for_Class_Example {
public static void main(String[] args) {
	ArrayList<Phone> phoneList = new ArrayList<>();
	phoneList.add(new Phone("Motorola", Phone.PhoneType.BOTTON, 1000));
	phoneList.add(new Phone("LG", Phone.PhoneType.SMARTPHONE, 6000));
	phoneList.add(new Phone("Samsung", Phone.PhoneType.SMARTPHONE, 8000));
	phoneList.add(new Phone("Samsung", Phone.PhoneType.SMARTPHONE, 8000));
	
		// Отфильтруем набор телефонов по цене
	phoneList.stream().filter(p->p.getPrice()<7000).forEach(p->System.out.print(p.getName() + "\t"));  System.out.println();
	
	 	// COLLECT чтобы получить данные не в виде потока, а в виде обычной коллекции, например, ArrayList или HashSet.
	 	// toList(): преобразование к типу List
	 	// toSet(): преобразование к типу Set
	 	// toMap(): преобразование к типу Map
		// 1-ый способ
	 List<Phone> filteredPhoneList = phoneList.stream().filter(p->p.getPrice()<7000).collect(Collectors.toList());
	 	// 2-ой способ   - Выражение ArrayList::new представляет функцию создания коллекции.
	 ArrayList<Phone> filteredPhoneList2 = phoneList.stream().filter(p->p.getPrice()<7000).
			 collect(Collectors.toCollection(ArrayList::new));
	 System.out.print("Список до фильтрации   "); 
	 phoneList.stream().forEach(p->System.out.print(p.getName() + "\t"));  System.out.println();
	 System.out.print("Список после фильтрации   ");
	 filteredPhoneList.stream().forEach(p->System.out.print(p.getName() + "\t"));  System.out.println();
	 
	 // toSet(): преобразование к типу Set
	 // Выражение HashSet::new представляет функцию создания коллекции. 
	 HashSet<Phone> filteredPhonesHashSet = phoneList.stream().filter(p->p.getPrice()<7000).
			 collect(Collectors.toCollection(HashSet::new));
	 

		// Метод <R> Stream<R> MAP (Function<? super T, ? extends R> mapper) возвращает поток с преобразованием объектов от одного типа T к другому типу R
		// Выполним преобразование от типа Phone к типу String, помещая в поток только названия телефонов
	phoneList.stream().map(p-> p.getName()).forEach(s->System.out.print(s + "\t"));			System.out.println();
		// Сохранение результата в массив 
	System.out.println(Arrays.toString(phoneList.stream().map(p-> p.getName()).toArray()));
		// Выполним преобразование от типа Phone к типу String, помещая в поток только названия телефонов + цены
	phoneList.stream().map(p-> "название: " + p.getName() + ", цена: " + p.getPrice() + "\t").forEach(s->System.out.print(s + "\t"));		System.out.println();
	
		// Метод <R> Stream<R> FLATMAP(Function<? super T, ? extends Stream<? extends R>> mapper) используется, когда из одного элемента нужно получить несколько.
		// Например, если мы хотим установить для каждого телефона цену со скидкой и цену без скидки. 
		// То есть из одного объекта Phone нам надо получить два объекта с информацией, например, в виде строки. 
	phoneList.stream().flatMap(p->Stream.of(
			String.format("название: %s  цена без скидки: %d", p.getName(), p.getPrice()),
			String.format("название: %s  цена со скидкой: %d", p.getName(), p.getPrice() - (int)(p.getPrice()*0.1))
			)).forEach(s->System.out.print(s + "\t"));
	
		// Метод Object[] toArray(): возвращает массив из элементов потока.
	Object[] phoneArray = phoneList.stream().toArray();
	
		// Метод Stream distinct() возвaщает из исходного потока новый поток, не содержащий повторяющихя элементов
		// НЕ РАБОТАЕТ ДЛЯ ГЛУБОКОГО СРАВНЕНИЯ объектов
	phoneList.stream().distinct().forEach(p->System.out.print(p.getName() + "\t")); 		System.out.println();
	
		// Метод skip(long n)  возвращает новый поток, в котором пропущены первые n элементов.
		// Метод limit(long n) возвращает модифицированный поток, в котором не более n элементов.
		// Удобно использовать в паре для выбора определенных номеров объектов - ниже выбор 2 и 3-го объектов
	phoneList.stream().skip(1).limit(2).forEach(s->System.out.print(s.getName() + "\t"));  System.out.println();
	
		//  СОРТИРОВКА 
		//Cортировка по названию 
	System.out.println("Cортировка по названию через интерфейс Comparable");
	phoneList.stream().sorted().forEach(s->System.out.print(s.getName() + "\t"));  System.out.println();
	
	System.out.println("Cортировка по названию через PhoneComparatorh");
	phoneList.stream().sorted(new PhoneComparator())
    .forEach(p->System.out.printf("%s (%s) - %d \t", 
            p.getName(), p.getType(), p.getPrice())); 
	System.out.println();
    
	System.out.println("Cортировка по цене через PhoneComparatorPrice");
	phoneList.stream().sorted(new PhoneComparatorPrice())
    .forEach(p->System.out.printf("%s (%s) - %d \t", 
            p.getName(), p.getType(), p.getPrice())); 
	System.out.println();
	
		// Метод Optional<T> min (Comparator<? super T> comparator): возвращает минимальный элемент из потока. 
		// Метод Optional<T> max (Comparator<? super T> comparator): возвращает минимальный элемент из потока.	
		// Оба метода возвращают элемент потока (минимальный или максимальный), обернутый в объект Optional.
		// Для сравнения элементов применяется компаратор comparator.
	 System.out.println("Поиск MIN и MAX по цене через PhoneComparatorPrice");
	 Phone min = phoneList.stream().min(new PhoneComparatorPrice()).get();
     Phone max =phoneList.stream().max(new PhoneComparatorPrice()).get();
     System.out.printf("MIN Name: %s Price: %d \n", min.getName(), min.getPrice());
     System.out.printf("MAX Name: %s Price: %d \n", max.getName(), max.getPrice());
	
     System.out.println("\"Поиск MIN и MAX по названию через интерфейс Comparable");
     Phone min1 = phoneList.stream().min(Phone::compareTo).get();
     Phone max1 =phoneList.stream().max(Phone::compareTo).get();
     System.out.printf("MIN Name: %s Price: %d \n", min1.getName(), min1.getPrice());
     System.out.printf("MAX Name: %s Price: %d \n", max1.getName(), max1.getPrice());
     
	     // Метод  U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
	     // выполняет терминальные операции сведения, возвращая некоторое значение - результат операции.
	     // identity - используется, как первый элемент в сведении
	  	 // Ниже расчитываем результат сложения стоимостей всех телефонов      identity = 0
	  int sum = phoneList.stream().reduce(0, 
	       (x,y)-> {
	               return x + y.getPrice();
	        }, 
	        (x, y)->x+y);
	  System.out.println(" Результат сложения стоимостей всех телефонов = " + sum); 
	  
		// Может reduce может использоваться, когда нужно свести числа ,удовлетворяющие определенному условию
	   // Ниже расчитываем результат сложения стоимостей всех телефонов, цена которых меньше 6500      identity = 0
	int sum1 = phoneList.stream().reduce(0, 
	        (x,y)-> {
	                if(y.getPrice()<6500)
	                    return x + y.getPrice();
	                else
	                    return x + 0;
	        }, 
	        (x, y)->x+y);
	     
	System.out.println(" Результат сложения стоимостей всех телефонов с ценой ниже 6500  = " + sum1); 
	
	
	}
}

class PhoneComparator implements Comparator<Phone>{
    public int compare(Phone a, Phone b){
        return a.getName().toUpperCase().compareTo(b.getName().toUpperCase());
    }
}
class PhoneComparatorPrice implements Comparator<Phone>{
    public int compare(Phone a, Phone b){
    	int result;
		if (a.getPrice() > b.getPrice()) result = 1;
		else if (a.getPrice() < b.getPrice()) result = -1;
		else result = 0;
        return result;
    }
}


        
  