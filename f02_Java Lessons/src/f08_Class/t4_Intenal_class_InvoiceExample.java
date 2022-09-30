package f08_Class;
import java.util.ArrayList;
// Пример по созданию счета-фактуры, где описание товара (описание, количество, цена за штуку) происходит во внутренем классе Items 

class Invoice { 
	class Item {
		private String description;
		private int quantity;
		private double unitPrice;
		public Item(String description, int quantity, double unitPrice) {
			this.description = description;
			this.quantity = quantity;
			this.unitPrice = unitPrice;		}
				// Метод расчета стоимости одного товара 
		public double price() {
		return (quantity*unitPrice);}
	}
		// Создание списка всех купленных товаров 
	private ArrayList <Item> itemsList = new ArrayList <Item> ();
	public void addItem (Item item) {
		itemsList.add(item);}
}

public class t4_Intenal_class_InvoiceExample {
public static void main(String[] args) {
		// Создание объекта счет-фактуры
	Invoice myInvoice = new Invoice();
		// Добавление в этот счет покупаемых товаров
	Invoice.Item item1 = new Invoice.Item(null, 0, 0);
	//Invoice.Item item1 = new Invoice.Item("Hammer", 2, 1600.50);
	//	myInvoice.addItem(item1);
	//Invoice.Item item2 = new Invoice.Item("Lobsik", 1, 3400.00);	
	//	myInvoice.addItem(item2);
		
}
}
