package C_Graphs;

import java.util.ArrayList;

class StackClass <T> {
	private ArrayList<T> list = new ArrayList<T>();
	
		// Добавить элемент на вершину стека (на первую позицию)
	public void push (T item) {
		list.add(0, item);}
		
		// Удаляет элемент из вершины стека (с первой позиции) 
	public T pop () {
		return list.remove(0);}			// Удаляет первый элемент (с 0-вым индексом)
	
		// Проверка является ли стек пустым
	public boolean isEmpty() {
		return list.isEmpty();}
}

class Tree2 {
	int value; 
	Tree2 left;
	Tree2 right;
	public Tree2(int value, Tree2 left, Tree2 right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class TreeCreation_and_DeepObhod_via_Stack {
	
	// Метод суммирование элементов обходом в глубину через стек 
		public static int sumDeep (Tree2 root) {		// root - корневой узел, с которого начинается обход дерева
			StackClass<Tree2> stack = new StackClass();
			stack.push(root);
			int sum = 0;
			while (stack.isEmpty() == false) {
				Tree2 node = stack.pop();
				System.out.println("Node.value = " + node.value);
				sum = sum + node.value;
				if (node.right != null) stack.push(node.right);
				if (node.left != null) stack.push(node.left);
			}
			return sum;
		}
	
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
	Tree2 root  =
			new Tree2(20,
			new	Tree2 (7, 					// Левая часть корневого элемента
					     new Tree2 (4,
							           null, 
							           new Tree2(6, null, null)), 
					     new Tree2 (9, null, null)),	           
			new	Tree2 (35, 
					     new Tree2 (31, 
					    		        new Tree2 (28, null, null),
					    		        null),
					     new Tree2 (40, 
					    		 		new Tree2(38, null, null),
					    		 		new Tree2 (52, null, null)))
			);
	System.out.println(sumDeep(root));
	
				/* Создание дерева другим способом
			      20
			  /       \
			 7         35
			/ \       /  \
			4  9    31   40
			 \	   /     / \
			  6   28    38  52
									*/
	Tree2 left1 = new Tree2(6, null, null);
	Tree2 left2 = new Tree2(9, null, null);
	Tree2 left3 = new Tree2(4, null, left1);
	Tree2 left4 = new Tree2(7, left3, left2);
	Tree2 right1 = new Tree2(28, null, null);
	Tree2 right2 = new Tree2(38, null, null);
	Tree2 right3 = new Tree2(52, null, null);
	Tree2 right4 = new Tree2(31, right1, null);
	Tree2 right5 = new Tree2(40, right2, right3);
	Tree2 right6 = new Tree2(35, right4, right5);
	Tree2 root1 = new Tree2(20, left4, right6);
	
//	System.out.println("Сумма при вызове метода для корневого элемента  = "  + sumDeep(root1));
//	System.out.println("Сумма при вызове метода для нижнего элемента 6  = "  + sumDeep(left1));
//	System.out.println("Сумма при вызове метода для элемента 7 из середины  = "  + sumDeep(left4));
	
	}
}
