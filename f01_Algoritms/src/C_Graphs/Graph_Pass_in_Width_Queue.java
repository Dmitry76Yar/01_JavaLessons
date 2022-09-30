package C_Graphs;
	
		// Граф с обходом в ширину
import java.io.*;

		// Класс очередь
	class MyQueue {
		private int head;	
		private int tail;
		private int size;
		private int [] array;
		private int count;		
		public MyQueue(int size) {
			this.size = size;
			array  = new int [size];
			head = 0;
			tail = -1;
			count = 0;
		}
		public void insert (int v) {			// Заносит вершину в очередь (в массив)
			if (tail == size - 1) tail = -1;	// Если заносим, например, 11-элемент в очередь из 10 элементов, то он встанет на 1-ую позицию
			array[++tail] = v;
			count++;
		}
		public int remove () {					// Возвращает все элементы, начиная с 0-го
			if (head == size) head = 0;			// После возврата count++  и в след. раз возвращает уже 1-ый элемент и так далее
			count--;							// Когда доходит до самого последнего элемента в очереди, возвращается снова к нулевому элементу
			return array[head++];
		}
		public boolean isEmpty() {	 			// Проверяет пустая ли очередь
			return count == 0;
		}
	}

			/* Класс Vertex, представляющий отдельную вершину графа: Пока в нашей структуре мы будем хранить только метку вершины. 
	Но в реальной задаче вершины графы могут описывать объекты реального мира, например, города или элементы на электронной схеме, 
	так что они вполне могут содержать другие, необходимые для решения задачи, данные. 	 */
	class Vertex1 {
		public String name;
		public boolean isVisited;
		public Vertex1(String name) {
		    this.name = name;
		    isVisited = false;
		}
	}

		/* Kласс Graph для представления самого графа. Он будет содержать массив vertexArray для удобного доступа к вершинам графа и
	матрицу смежности размерности N*N(где N — количество вершин) для представления связей между вершинами в графе. При создании
	графа матрица смежности заполняется нулями:			 */
	class Graph1 { 
		private Vertex1[] vertexList;				// массив для хранения списка вершин
		private int[][] matrix;					// матрица смежности - показывает наличие связей (ребер) между вершинами	
		private int count;							// текущее количество вершин
		private MyQueue queue;	
		public Graph1(int n)	 {
			vertexList = new Vertex1[n];
		  matrix = new int[n][n];
		  queue = new MyQueue(n);
		  count = 0;
		}
			// Mетод для добавления новой вершины в граф:
		public void insertVertex(String key)	 {
		   vertexList[count++] = new Vertex1(key);
		}
			// Mетод для добавления нового ребра (связи между вершинами):
		public void insertEdge(int begin, int end, int val)	    {		// val - если 1, то есть обратная связь из 2-ой вершины в 1-ую
		  matrix[begin][end] = 1;
		  matrix[end][begin] = val;
		}
			//Метод получения смежной непосещенной вершины
		private int getUnvisitedVertex(int vertex)    {
		  for(int i = 0; i < count; i++)
		      if(matrix[vertex][i] == 1 && vertexList[i].isVisited == false)
		          return i;
		  return -1;
		}	
			//Метод реализации обхода в ширину
		public void passInWidth(int index)	  {				// На входе индекс начальной вершины
			System.out.println(vertexList[index].name);		// Печать названия вершины
			vertexList[index].isVisited = true;				// Отмечаем, что вершина уже посещена
			queue.insert(index);							// Заносит вершину в очередь
			int vertex;
			while(!queue.isEmpty()) {						
				int temp = queue.remove();		
				while ((vertex = getUnvisitedVertex(temp)) != -1) {
					System.out.println(vertexList[vertex].name);		// Печать названия вершины
					vertexList[vertex].isVisited = true;				// Отмечаем, что вершина уже посещена
					queue.insert(vertex);
				}
			}
				// Для сброса все к исходному состоянию, чтобы воспользоваться стэком повторно
			for (int i = 0; i<count; i++) {
				vertexList[i].isVisited = false;
			}
		}
	}
	
public class Graph_Pass_in_Width_Queue {
public static void main(String[] args) throws IOException {
	Graph1 graph = new Graph1(10);
	
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
    
    graph.passInWidth(0);
}
}
