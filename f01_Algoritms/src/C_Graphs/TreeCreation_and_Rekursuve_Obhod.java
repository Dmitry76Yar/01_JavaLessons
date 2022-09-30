package C_Graphs;

class Tree {
	int value; 
	Tree left;
	Tree right;
	public Tree(int value, Tree left, Tree right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
		// Рекурсивный метод вычисления суммы всех элементов
		// является рекурсивным методом обхода в глубину, поэтому медленнее, чем обход через стек или очередь
	public int sumAllElements() {
		int sum = value;
		if (left != null)  sum = sum + left.sumAllElements();
		if (right != null)  sum = sum + right.sumAllElements();
//		System.out.println("Current sum = " + sum);
		return sum;
	}
}

public class TreeCreation_and_Rekursuve_Obhod {
public static void main(String[] args) {
		/* Создание дерева
		             20
		 		 /       \
		        7         35
		 	   / \       /  \
		 	  4   9     31   40
			 	\	   /     / \
			     6    28    38  52
		 								*/
	Tree root  =
			new Tree(20,
			new	Tree (7, 					// Левая часть корневого элемента
					     new Tree (4,
							           null, 
							           new Tree(6, null, null)), 
					     new Tree (9, null, null)),	           
			new	Tree (35, 
					     new Tree (31, 
					    		        new Tree (28, null, null),
					    		        null),
					     new Tree (40, 
					    		 		new Tree (38, null, null),
					    		 		new Tree (52, null, null)))
			);
	System.out.println(root.sumAllElements());
	
				/* Создание дерева другим способом
			      20
			  /       \
			 7         35
			/ \       /  \
			4  9    31   40
			 \	   /     / \
			  6   28    38  52
									*/
	Tree left1 = new Tree(6, null, null);
	Tree left2 = new Tree(9, null, null);
	Tree left3 = new Tree(4, null, left1);
	Tree left4 = new Tree(7, left3, left2);
	Tree right1 = new Tree(28, null, null);
	Tree right2 = new Tree(38, null, null);
	Tree right3 = new Tree(52, null, null);
	Tree right4 = new Tree(31, right1, null);
	Tree right5 = new Tree(40, right2, right3);
	Tree right6 = new Tree(35, right4, right5);
	Tree root1 = new Tree(20, left4, right6);
	
	System.out.println("Сумма при вызове метода для корневого элемента  = "  + root1.sumAllElements());
	System.out.println("Сумма при вызове метода для нижнего элемента 6  = "  + left1.sumAllElements());
	System.out.println("Сумма при вызове метода для элемента 7 из середины  = "  + left4.sumAllElements());
	
	}
}
