package Greedy_algoritm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*		Жадный алгоритм — это подход, при котором на каждом этапе принимаются локально оптимальные решения и допускается, что
конечное решение также окажется оптимальным. “Оптимальное” решение — то, которое предлагает наиболее очевидную и немедленную выгоду
на определенном шаге/этапе.  
	Чтобы рассмотреть данный алгоритм, выберем довольно распространенную задачу — о рюкзаке.
	Давайте на секунду представим, что вы вор. Вы вломились ночью в магазин с рюкзаком, и перед вами некоторое множество товаров, 
которые вы можете украсть. Но при этом вместимость рюкзака ограничена — не более 30 условных единиц. В тоже время вы хотите унести 
набор товаров максимальной стоимости, которые только влезут в рюкзак. 
	Как вы определите, что положить?
	Итак, жадный алгоритм для задачи о рюкзаке состоит в следующих шагах (считаем, что все предметы помещаются в рюкзак):
Выбрать максимально дорогой предмет из еще не затронутых.
Если он помещается в рюкзак, положить его туда, если нет — пропускаем.
Все предметы перебрали? Если нет — возвращаемся к 1 пункту, если да — бежим из магазина, так как наша цель тут выполнена.
	Жадный алгоритм  на каждом шагу делает локально оптимальный выбор в расчете на то, что итоговое решение также будет оптимальным. 
	Это не всегда оправдано, но для многих задач жадные алгоритмы действительно дают оптимум.
Временная сложность данного алгоритма — O(N), довольно неплохо, не так ли?	*/

	//  Kласс предмета Item: три поля — name, weight, cost — для задания характеристик предмета.
	// Также, как вы можете видеть, тут реализован интерфейс Comparable таким образом, чтобы мы могли сортировать наши Item по цене.

class Item implements Comparable<Item> {
	   private String name;
	   private int weight;
	   private int cost;

	   public Item(String name, int weight, int cost) {
	       this.name = name;
	       this.weight = weight;
	       this.cost = cost;	  }

	   public String getName() {
	       return name;  }

	   public int getWeight() {
	       return weight; }

	   public int getCost() {
	       return cost;	 }

	   @Override
	   public int compareTo(Item o) {
	       return this.cost > o.cost ? -1 : 1;
	   }
	}

		// Kласс нашего рюкзака — Bag:
	// maxWeight — вместимость нашего рюкзака, которая задаётся при создании объекта;
	// items — объекты находящиеся в рюкзаке;
	// currentWeight, currentCost — текущий вес и стоимость всех вещей в рюкзаке, которые мы увеличиваем при добавлении нового 
	// предмета в методе addItem.

class Bag {
	   private final int maxWeight;
	   private List<Item> items;
	   private int currentWeight;
	   private int currentCost;

	   public Bag(int maxWeight) {
	       this.maxWeight = maxWeight;
	       items = new ArrayList<>();
	       currentCost = 0;	}

	   public int getMaxWeight() {
	       return maxWeight; }

	   public int getCurrentCost() {
	       return currentCost; }

	   public int getCurrentWeight() {
	       return currentWeight;  }

	   public void addItem(Item item) {
	       items.add(item);
	       currentWeight += item.getWeight();
	       currentCost += item.getCost();  }
	}

public class Greedy_algoritm {
	
		/* Mы начинаем проходить по отсортированному по стоимости списку элементов и складывать их в сумку, если позволяет 
	вместимость. Если же не позволяет, элемент будет пропущен и продолжится проход по остальным элементам до конца списка.
	Запустив main, мы получим вывод в консоль: Вес рюкзака составляет - 29, общая стоимость вещей в рюкзаке - 3700
	Собственно, это и есть пример жадного алгоритма: на каждом шагу выбирается локально-оптимальное решение, а в итоге вы получаете
	глобально-оптимальное решение. В нашем случае льно-оптимальное решение вариант — это наиболее дорогой предмет среди оставшихся.
	Но является ли это лучшим решением? Вам не кажется, что можно немного модернизировать наше решение
	*/
	public static void fillBackpack(Bag bag, List<Item> items) {
		   for (Item item : items) {
		       if(bag.getMaxWeight() > bag.getCurrentWeight() + item.getWeight()) {
		            bag.addItem(item);
		            System.out.println("Добавлен " + item.getName());
		       }
		   }
		}
	
	/* Модернизированный метод
	Тут мы в первую очередь вычисляем соотношение веса и цены для каждого предмета. Так сказать, сколько стоит одна единица 
	данного предмета. И уже по этим значениям мы сортируем наши предметы и добавляем в нашу сумкy	 */
	
	public static void effectiveFillBackpack(Bag bag, List<Item> items) {
		   Map<Double, Item> sortByRatio = new TreeMap(Collections.reverseOrder());
		   for (Item item : items) {
		       sortByRatio.put((double)item.getCost() / item.getWeight(), item);	}
		   System.out.println(sortByRatio);

		   for (Map.Entry<Double, Item> entry : sortByRatio.entrySet()) {
		       if(bag.getMaxWeight() > bag.getCurrentWeight() + entry.getValue().getWeight()) {
		           bag.addItem(entry.getValue());	}
		   }
	 }

	
public static void main(String[] args) {
			//Для начала мы создаем список элементов, сортируем его. Создаем объект сумки с вместимость 30 единиц. 
	 List<Item> items = new ArrayList<>();
     items.add(new Item("гитара",7, 800));
     items.add(new Item("утюг",6, 500));
     items.add(new Item("чайник",3, 300));
     items.add(new Item("лампа",4, 500));
     items.add(new Item("телевизор",15, 2000));
     items.add(new Item("ваза",2, 450));
     items.add(new Item("миксер",1, 400));
     items.add(new Item("блендер",3, 200));
     Collections.sort(items);

     Bag firstBag = new Bag(30);
     fillBackpack(firstBag, items);
     System.out.println("Вес рюкзака состaвляет - " + firstBag.getCurrentWeight() +	 ", общая стоимость вещей в рюкзаке - " +
     firstBag.getCurrentCost());
	
     Bag secondBag = new Bag(30);
     effectiveFillBackpack(secondBag, items);
     System.out.println("Вес рюкзака составляет - " + secondBag.getCurrentWeight() +  ", общая стоимость вещей в рюкзаке - " + 
     secondBag.getCurrentCost());
	}

}
