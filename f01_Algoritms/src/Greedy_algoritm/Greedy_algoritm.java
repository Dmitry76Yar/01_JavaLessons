package Greedy_algoritm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*		������ �������� � ��� ������, ��� ������� �� ������ ����� ����������� �������� ����������� ������� � �����������, ���
�������� ������� ����� �������� �����������. ������������ ������� � ��, ������� ���������� �������� ��������� � ����������� ������
�� ������������ ����/�����.  
	����� ����������� ������ ��������, ������� �������� ���������������� ������ � � �������.
	������� �� ������� ����������, ��� �� ���. �� ��������� ����� � ������� � ��������, � ����� ���� ��������� ��������� �������, 
������� �� ������ �������. �� ��� ���� ����������� ������� ���������� � �� ����� 30 �������� ������. � ���� ����� �� ������ ������ 
����� ������� ������������ ���������, ������� ������ ������ � ������. 
	��� �� ����������, ��� ��������?
	����, ������ �������� ��� ������ � ������� ������� � ��������� ����� (�������, ��� ��� �������� ���������� � ������):
������� ����������� ������� ������� �� ��� �� ����������.
���� �� ���������� � ������, �������� ��� ����, ���� ��� � ����������.
��� �������� ���������? ���� ��� � ������������ � 1 ������, ���� �� � ����� �� ��������, ��� ��� ���� ���� ��� ���������.
	������ ��������  �� ������ ���� ������ �������� ����������� ����� � ������� �� ��, ��� �������� ������� ����� ����� �����������. 
	��� �� ������ ���������, �� ��� ������ ����� ������ ��������� ������������� ���� �������.
��������� ��������� ������� ��������� � O(N), �������� �������, �� ��� ��?	*/

	//  K���� �������� Item: ��� ���� � name, weight, cost � ��� ������� ������������� ��������.
	// �����, ��� �� ������ ������, ��� ���������� ��������� Comparable ����� �������, ����� �� ����� ����������� ���� Item �� ����.

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

		// K���� ������ ������� � Bag:
	// maxWeight � ����������� ������ �������, ������� ������� ��� �������� �������;
	// items � ������� ����������� � �������;
	// currentWeight, currentCost � ������� ��� � ��������� ���� ����� � �������, ������� �� ����������� ��� ���������� ������ 
	// �������� � ������ addItem.

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
	
		/* M� �������� ��������� �� ���������������� �� ��������� ������ ��������� � ���������� �� � �����, ���� ��������� 
	�����������. ���� �� �� ���������, ������� ����� �������� � ����������� ������ �� ��������� ��������� �� ����� ������.
	�������� main, �� ������� ����� � �������: ��� ������� ���������� - 29, ����� ��������� ����� � ������� - 3700
	����������, ��� � ���� ������ ������� ���������: �� ������ ���� ���������� ��������-����������� �������, � � ����� �� ���������
	���������-����������� �������. � ����� ������ ����-����������� ������� ������� � ��� �������� ������� ������� ����� ����������.
	�� �������� �� ��� ������ ��������? ��� �� �������, ��� ����� ������� ��������������� ���� �������
	*/
	public static void fillBackpack(Bag bag, List<Item> items) {
		   for (Item item : items) {
		       if(bag.getMaxWeight() > bag.getCurrentWeight() + item.getWeight()) {
		            bag.addItem(item);
		            System.out.println("�������� " + item.getName());
		       }
		   }
		}
	
	/* ����������������� �����
	��� �� � ������ ������� ��������� ����������� ���� � ���� ��� ������� ��������. ��� �������, ������� ����� ���� ������� 
	������� ��������. � ��� �� ���� ��������� �� ��������� ���� �������� � ��������� � ���� ����y	 */
	
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
			//��� ������ �� ������� ������ ���������, ��������� ���. ������� ������ ����� � ����������� 30 ������. 
	 List<Item> items = new ArrayList<>();
     items.add(new Item("������",7, 800));
     items.add(new Item("����",6, 500));
     items.add(new Item("������",3, 300));
     items.add(new Item("�����",4, 500));
     items.add(new Item("���������",15, 2000));
     items.add(new Item("����",2, 450));
     items.add(new Item("������",1, 400));
     items.add(new Item("�������",3, 200));
     Collections.sort(items);

     Bag firstBag = new Bag(30);
     fillBackpack(firstBag, items);
     System.out.println("��� ������� ����a����� - " + firstBag.getCurrentWeight() +	 ", ����� ��������� ����� � ������� - " +
     firstBag.getCurrentCost());
	
     Bag secondBag = new Bag(30);
     effectiveFillBackpack(secondBag, items);
     System.out.println("��� ������� ���������� - " + secondBag.getCurrentWeight() +  ", ����� ��������� ����� � ������� - " + 
     secondBag.getCurrentCost());
	}

}
