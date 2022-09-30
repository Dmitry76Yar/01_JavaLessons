package f22_Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Phone2{
	private String name;
	private int price;
	public Phone2(String name, int price){
        this.name=name;
        this.price=price;
    }
	public int getPrice () {
		return price;}
	public String getName () {
		return name;}
}
public class t05_Stream_to_Map {
public static void main(String[] args) {
	ArrayList<Phone2> phoneList = new ArrayList<>();
	phoneList.add(new Phone2("Motorola", 1000));
	phoneList.add(new Phone2("LG", 6000));
	phoneList.add(new Phone2("Samsung", 8000));
	
		// Лямбда-выражение p->p.getName() получает значение для ключа элемента, а t->t.getPrice() - извлекает значение элемента.
	Map<String, Integer> phones = phoneList.stream().collect(Collectors.toMap(p->p.getName(), t->t.getPrice()));

	}
}


        
  