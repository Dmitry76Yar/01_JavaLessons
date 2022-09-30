package f22_Stream;

import java.util.*;
import java.util.stream.Collectors;

class Phone3{
	private String name;
	private int price;
	private String company;
	public Phone3(String name, String company, int price){
        this.name=name;
        this.company = company;
        this.price=price;
    }
	public int getPrice () {
		return price;}
	public String getName () {
		return name;}
	public String getCompany () {
		return company;	}
}
public class t06_Grouping {
public static void main(String[] args) {
	ArrayList<Phone3> phoneList = new ArrayList<>();
	phoneList.add(new Phone3("Pixel 2", "Google", 500));
	phoneList.add(new Phone3("iPhone 8", "Apple",450));
	phoneList.add(new Phone3("Galaxy S9", "Samsung", 440));
	phoneList.add(new Phone3("Galaxy S8", "Samsung", 340));
	
		// Связка метод collect() и метод Collectors.groupingBy() позволяет группировать данные по какому-нибудь признаку
		// Пример, ниже сохраняет все телефоны в MAP в зависимости от производителя
		// Key - Название компании     Value  - название телефона	
	
		// Сохранение без фильтрации
	Map<String, Integer> phones = phoneList.stream().
			collect(Collectors.toMap(p->p.getName(), t->t.getPrice()));
	
		// Сохранение с фильтрацией по компании
	Map<String, List<Phone3>> phonesByCompany = phoneList.stream().
			collect(Collectors.groupingBy(Phone3::getCompany));
	
	for(Map.Entry<String, List<Phone3>> item : phonesByCompany.entrySet()){
        System.out.print(item.getKey() + " :   ");
        for(Phone3 phone : item.getValue())   System.out.print(phone.getName() + " \t");
        System.out.println();
    } 
	System.out.println();
	
		// Метод Collectors.partitioningBy имеет похожее действие, только он делит элементы на группы по принципу, 
		// соответствует ли элемент определенному условию
		// Пример сохранения в МАР телефонов производителя Apple
	Map<Boolean, List<Phone3>> phonesByCompany2 = phoneList.stream().
			collect(Collectors.partitioningBy(p->p.getCompany()=="Apple"));
	System.out.println("Этот телефон фирмы Apple");
    for(Map.Entry<Boolean, List<Phone3>> item : phonesByCompany2.entrySet()){
    	System.out.print(item.getKey() +  " : ");
    	for(Phone3 phone : item.getValue())   System.out.print(phone.getName() + "  \t");
    	System.out.println();
    }	System.out.println();
    
    	// Метод Collectors.counting применяется в Collectors.groupingBy() для вычисления количества элементов в каждой группе:
    Map<String, Long> phonesByCompany3 = phoneList.stream().
    		collect(Collectors.groupingBy(Phone3::getCompany, Collectors.counting()));
    System.out.println("Количество телефонов для каждого производителя");
    for(Map.Entry<String, Long> item : phonesByCompany3.entrySet()){
      	    System.out.print(item.getKey() + " - " + item.getValue() + "\t");
    } System.out.println();
    
    	// Метод Collectors.summing применяется для подсчета суммы.   summingInt(), summingLong(), summingDouble(). 
		// Пример подсчета стоимости всех смартфонов по компаниям:
    Map<String, Integer> phonesByCompany4 = phoneList.stream().
    		collect(Collectors.groupingBy(Phone3::getCompany, Collectors.summingInt(Phone3::getPrice)));
    System.out.println("Стоимость всех смартфонов по компаниям");       
    for(Map.Entry<String, Integer> item : phonesByCompany4.entrySet()){
         System.out.print(item.getKey() + " - " + item.getValue() + "\t");
    }	System.out.println();
    
    	// Методы maxBy и minBy применяются для подсчета минимального и максимального значения в каждой группе.
    // В качестве параметра эти методы принимают функцию компаратора, которая нужна для сравнения значений. 
    // Например, найдем для каждой компании телефон с минимальной ценой
    Map<String, Optional<Phone3>> phonesByCompany5 = phoneList.stream().
    		collect(Collectors.groupingBy(Phone3::getCompany, Collectors.minBy(Comparator.comparing(Phone3::getPrice))));
    System.out.println("Для каждой компании телефон с минимальной ценой");
    for(Map.Entry<String, Optional<Phone3>> item : phonesByCompany5.entrySet()){
        System.out.print(item.getKey() + " - " + item.getValue().get().getName() + "\t");
    }		System.out.println();
    
    	/* Методы summarizingInt() / summarizingLong() / summarizingDouble() позволяют объединить в набор значения соответствующих типов
     Метод Collectors.summarizingInt(Phone::getPrice)) создает набор, в который помещаются цены для всех телефонов каждой
     из групп. Данный набор инкапсулируется в объекте IntSummaryStatistics. 
     У этих объектов есть ряд методов, который позволяют выполнить различные атомарные операции над набором:
		getAverage(): возвращает среднее значение
		getCount(): возвращает количество элементов в наборе
		getMax(): возвращает максимальное значение
		getMin(): возвращает минимальное значение
		getSum(): возвращает сумму элементов
		accept(): добавляет в набор новый элемент 
		Пример, получаем среднюю цену смартфонов для каждой группы. */
    Map<String, IntSummaryStatistics> priceSummary = phoneList.stream().
    		collect(Collectors.groupingBy(Phone3::getCompany, Collectors.summarizingInt(Phone3::getPrice)));
    System.out.println("Cредняя цена смартфонов для каждой группы");
    for(Map.Entry<String, IntSummaryStatistics> item : priceSummary.entrySet()){
       	    System.out.print(item.getKey() + " - " + item.getValue().getAverage() + "\t");
    }   System.out.println();
    
    System.out.println("Количество телефонов каждого производителя");
    for(Map.Entry<String, IntSummaryStatistics> item : priceSummary.entrySet()){
       	    System.out.print(item.getKey() + " - " + item.getValue().getCount() + "\t");
    }	System.out.println();
    
    System.out.println("Максимальная стоимость телефонов каждого производителя");
    for(Map.Entry<String, IntSummaryStatistics> item : priceSummary.entrySet()){
       	    System.out.print(item.getKey() + " - " + item.getValue().getMax() + "\t");
    }	System.out.println();
    
    	// Метод mapping позволяет дополнительно обработать данные и задать функцию отображения объектов из потока
    	// на какой-нибудь другой тип данных. 
    Map<String, List<String>> phonesByCompany6 = phoneList.stream().
    		collect(Collectors.groupingBy(Phone3::getCompany,Collectors.mapping(Phone3::getName, Collectors.toList())));
    System.out.println("Подборка телефонов по производителю, сохранение названий телефонов в List");        
    for(Map.Entry<String, List<String>> item : phonesByCompany6.entrySet()){
        System.out.print(item.getKey() + " :");
        System.out.print(item.getValue());
        System.out.println();
    }	System.out.println();
    
    
    
    
    
    
	


	}
}


        
  