package C_Graphs;
	
	// Граф с обходом в глубину
import java.io.*;
import java.util.Arrays;
				
			// Класс стэк
	class MyStack {
		private int top;			
		private int [] array;
		public MyStack(int size) {
			array  = new int [size];
			System.out.println(Arrays.toString(array));
			top = -1;					// Счетчик элементов в стэке. Изначально д.б. = -1, чтобы первый элемент внеся на 0-вую позицию
		}
		public void push (int v) {		// Заносит вершину в стэк (в массив)
			array[++top] = v;
		}
		public int pop () {				// Возвращает верхнюю вершину и переходит на элемент ниже (по сути удаляет из стэка)
			return array[top--];
		}
		public int peek () {		   // Просто возвращает верхнюю вершину
			return array[top];
		}
		public boolean isEmpty() {	  // Проверяет пустой ли стэк. Если индекс элемента переход в -1, значит прошли 0-вой элемент и стэк пуст
			if (top == -1)  return true;
			else return false;
		}
	}

			/* Класс Vertex, представляющий отдельную вершину графа: Пока в нашей структуре мы будем хранить только метку вершины. 
		Но в реальной задаче вершины графы могут описывать объекты реального мира, например, города или элементы на электронной схеме, 
		так что они вполне могут содержать другие, необходимые для решения задачи, данные. 	 */
	class Vertex{
	    public String name;
	    public boolean isVisited;
        public Vertex(String name) {
            this.name = name;
            isVisited = false;
        }
	}
				/* Kласс Graph для представления самого графа. Он будет содержать массив vertexArray для удобного доступа к вершинам графа и
		  матрицу смежности размерности N*N(где N — количество вершин) для представления связей между вершинами в графе. При создании
		  графа матрица смежности заполняется нулями:			 */
	class Graph { 
		 private Vertex[] vertexList;				// массив для хранения списка вершин
	     private int[][] matrix;					// матрица смежности - показывает наличие связей (ребер) между вершинами	
	     private int count;							// текущее количество вершин
	     private MyStack stack;	
         public Graph(int n)	 {
        	vertexList = new Vertex[n];
	        matrix = new int[n][n];
	        stack = new MyStack(n);
	        count = 0;
         }
         	// Mетод для добавления новой вершины в граф:
        public void insertVertex(String key)	 {
//        	 Vertex v = new Vertex(key);
             vertexList[count++] = new Vertex(key);
		}
			// Mетод для добавления нового ребра (связи между вершинами):
		public void insertEdge(int begin, int end, int val)	    {		// val - если 1, то есть обратная связь из 2-ой вершины в 1-ую
	        matrix[begin][end] = 1;
	        matrix[end][begin] = val;
		}
			/* Mетод обхода графа в глубину
		Как следует из названия, при обходе в глубину мы продвигаемся вглубь графа настолько, насколько это возможно. В этом случае мы не
		стремимся найти всех потомков рассматриваемой вершины, а берем только одного потомка, ищем его потомка и т.д. Только после того, как
		мы дошли до вершины, у которой больше нет потомков, мы возвращаемся на уровень выше. Все это может быть реализовано при помощи стека.
		На каждом этапе поиска мы получаем следующую смежную непосещенную вершину и добавляем ее в стек. Следующим шагом читаем вершину из
		стека и ищем смежные непосещенные вершины уже для нее. Для этого реализуем отдельно метод getUnvisitedVertex():	*/
		
			//Метод получения смежной непосещенной вершины
	    private int getUnvisitedVertex(int vertex)    {
	        for(int i = 0; i < count; i++)
	            if(matrix[vertex][i] == 1 && vertexList[i].isVisited == false)
	                return i;
	        return -1;
	    }	
	    	//Метод реализации обхода в глубину
	    public void passInDeep(int index)	  {				// На входе индекс начальной вершины
	    	System.out.println(vertexList[index].name);		// Печать названия вершины
	    	vertexList[index].isVisited = true;				// Отмечаем, что вершина уже посещена
	    	stack.push(index);								// Заносит вершину в стэк
	    	while(!stack.isEmpty()) {						
	    		int neighboor = getUnvisitedVertex(stack.peek());	// Пока стэк не пустой проверяем есть ли соседние непосещенные вершины
	    							// для вершины с индексом index. Push(index) вносит index в массив (стэк), а peek() возвращает этот index
	    							// int neighboor - для хранения индекса найденной соседней непосещенной вершины
	    							// Если вершина не найдена, то getUnvisitedVertex() возвращает -1
	    		if (neighboor == -1) {			// Вершина не найдена
	    			neighboor = stack.pop();	// тогда pop() удаляет индекс верхнего элемента стэка и возвращает индекс предверхнего индекса
	    		}
	    		else {						 	// Вершина найдена
	    			System.out.println(vertexList[neighboor].name);			// Печать названия вершины
	    	    	vertexList[neighboor].isVisited = true;				// Отмечаем, что вершина уже посещена
	    	    	stack.push(neighboor);								// Заносит вершину в стэк
	    		}
	    	}
	    		// Для сброса все к исходному состоянию, чтобы воспользоваться стэком повторно
	    	for (int i = 0; i<count; i++) {
	    		vertexList[i].isVisited = false;
	    	}
	    }
	}
	
public class Graph_Pass_in_Deep_Steck {	
public static void main(String[] args) throws IOException {
	Graph graph = new Graph(10);
    
    graph.insertVertex("A");		// 0
    graph.insertVertex("B");		// 1
    graph.insertVertex("C");		// 2
    graph.insertVertex("D");		// 3
    graph.insertVertex("E");		// 4
    graph.insertVertex("F");		// 5
    graph.insertVertex("G");		// 6
    graph.insertVertex("H");		// 7
    graph.insertVertex("I");		// 8
    graph.insertVertex("J");		// 9
    	/*			  /-> C -> H -> I -> J 
    	 * 		A -> B -> D
    	 		\-> E -> F	
    	 		G (вершина без связи)	
    	 */
    graph.insertEdge(0, 1, 1);		// AB
    graph.insertEdge(1, 2, 1);		// BC
    graph.insertEdge(1, 3, 1);		// BD
    graph.insertEdge(0, 4, 1);		// AE
    graph.insertEdge(4, 5, 1);		// EF
    graph.insertEdge(2, 7, 1);		// CH
    graph.insertEdge(7, 8, 1);		// HI
    graph.insertEdge(8, 9, 1);		// IJ
    
    graph.passInDeep(0);
	
}
}
