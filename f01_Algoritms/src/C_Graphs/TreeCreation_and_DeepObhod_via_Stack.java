package C_Graphs;

import java.util.ArrayList;

class StackClass <T> {
	private ArrayList<T> list = new ArrayList<T>();
	
		// �������� ������� �� ������� ����� (�� ������ �������)
	public void push (T item) {
		list.add(0, item);}
		
		// ������� ������� �� ������� ����� (� ������ �������) 
	public T pop () {
		return list.remove(0);}			// ������� ������ ������� (� 0-��� ��������)
	
		// �������� �������� �� ���� ������
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
	
	// ����� ������������ ��������� ������� � ������� ����� ���� 
		public static int sumDeep (Tree2 root) {		// root - �������� ����, � �������� ���������� ����� ������
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
		/* �������� ������
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
			new	Tree2 (7, 					// ����� ����� ��������� ��������
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
	
				/* �������� ������ ������ ��������
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
	
//	System.out.println("����� ��� ������ ������ ��� ��������� ��������  = "  + sumDeep(root1));
//	System.out.println("����� ��� ������ ������ ��� ������� �������� 6  = "  + sumDeep(left1));
//	System.out.println("����� ��� ������ ������ ��� �������� 7 �� ��������  = "  + sumDeep(left4));
	
	}
}
