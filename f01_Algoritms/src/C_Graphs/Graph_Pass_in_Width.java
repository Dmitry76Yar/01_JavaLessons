package C_Graphs;
// ОТЛИЧИЕ ОТ "Graph_Pass_in_Width_Queue" в том, что очередь из коллекции JAVA
// ОБХОД В ШИРИНУ

/*	Cуть в том, что у нас есть некоторая текущая вершина, с которой мы все смежные, непройденные вершины, заносим в очередь и 
  выбираем следующий элемент (который хранится первым в очереди), чтобы его сделать текущим…
  	Если разбить данный алгоритм на этапы, можно выделить следующие правила:
- Посетить следующую, ранее не посещенную вершину, смежную с текущей вершиной, пометить её заранее и занести в очередь.
- Если выполнение правила #1 невозможно — извлечь вершину из очереди и сделать её текущей вершиной.
 -Если правило #1 и #2 невозможно, обход закончен, а все вершины пройдены (если граф у нас связный).
 	Класс графа практически идентичен аналогичному классу из алгоритма поиска в глубину, за исключением метода, обрабатывающего
 алгоритм и замены внутреннего стека на очередь:
  
 */

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
				
		/* Класс Vertex, представляющий отдельную вершину графа: Пока в нашей структуре мы будем хранить только метку вершины. 
	Но в реальной задаче вершины графы могут описывать объекты реального мира, например, города или элементы на электронной схеме, 
	так что они вполне могут содержать другие, необходимые для решения задачи, данные. 	 */
class Vertex2 {
	  private String label;  			// метка А например
	  public boolean wasVisited;

	  public Vertex2(final String label) {
	     this.label = label;
	     wasVisited = false; }

	  public String getLabel() {
	     return this.label;  }

	  public boolean isWasVisited() {
	     return this.wasVisited; }

	  public void setWasVisited(final boolean wasVisited) {
	     this.wasVisited = wasVisited; }
	}
		/* Kласс Graph для представления самого графа. Он будет содержать массив vertexArray для удобного доступа к вершинам графа и
	матрицу смежности размерности N*N(где N — количество вершин) для представления связей между вершинами в графе. При создании
	графа матрица смежности заполняется нулями:	*/
 class Graph2 {
	  private Vertex2 vertexList[]; 		//массив вершин
	  private int adjMat[][]; 			// матрица смежности
	  private int nVerts; 				// текущее количество вершин
	  private Queue<Integer> queue;

	  public Graph2(int MAX_VERTS) {
	     vertexList = new Vertex2[MAX_VERTS];
	     adjMat = new int[MAX_VERTS][MAX_VERTS];
	     nVerts = 0;
	     for (int j = 0; j < MAX_VERTS; j++) {
	        for (int k = 0; k < MAX_VERTS; k++) {  // заполнение матрицы смежности нулями
	           adjMat[j][k] = 0; }
	     }
	     queue = new PriorityQueue<>();
	  }
	     
	     		// Mетод добавления новой вершины в граф:
	     public void addVertex(String lab) {
	         vertexList[nVerts++] = new Vertex2(lab);  }
	     
	     		// Mетод добавления нового ребра (связи между вершинами):
	      public void addEdge(int start, int end, int val) {		// val - если 1, то есть обратная связь из 2-ой вершины в 1-ую
	         adjMat[start][end] = 1;
	         adjMat[end][start] = val;  }
	      	
	      		// Mетод печати метки/имени вершины
	      public void displayVertex(int v) {
	         System.out.print(vertexList[v].getLabel() +  " -> ");	}
	      
	      		/* Метод получения смежной непосещенной вершины
	      На входе индекс (поряд.номер) вершины в списке = соответствует индексу строки этой вершины в матрице смежности
	      Проходит по этой строке матрицы смежности и находит номера столбцов с "1" в ячейке при условии, что вершина с этим
	      найденным индексом J не помечена, как посещенная	*/
    	  private int getAdjUnvisitedVertex(int v) {
    	     for (int j = 0; j < nVerts; j++) {
    	        if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
    	           return j;   }		//возвращает первую найденную вершину
    	     }
    	     return -1;
    	  }

    	  		/* Mетод обхода графа в ШИРИНУ
    	    / - B - E
    	   А  - C
    	    \ - D - F - G 
    	    
    	    */
    	  
	      public void pass_in_width(int index) { 
	    	     vertexList[index].setWasVisited(true);			// Начинаем с 0-ой вершины в списке вершин  (вершина А)
	    	     displayVertex(index);							// Помечаем ее, как посещенную и добавляем в очередь
	    	     queue.add(index);
	    	     int v2;									

	    	     while (!queue.isEmpty()) {				// Пока очередь не будет пустой
	    	        int v = queue.remove();				// Извлекаем индекс вершины в очереди. В начале это будет 0.

	    	        while((v2 = getAdjUnvisitedVertex(v))!=-1) { // Определяем индекс v2 для соседней вершины с вершиной с инд.v
	    	           vertexList[v2].wasVisited =true;          // Для точки А сначала определится вершина В, помечаем ее как посещенную
	    	           displayVertex(v2);						
	    	           queue.add(v2);			// и добавляем в очередь.   Очередь примет вид {0,1}		
	    	        }
	    	     }
	    	     /*  На примере выше:
	     - извлекается, но НЕ удаляется из очереди головной элемент очереди. В начале только одна вершина "А" с индексом 0 
	     - для 0-вой вершины в списке вершин "А" опред-ся соседняя вершина В (1-ая в списке вершин)
	     - вершина "В" помечается, как посещенная и заносится в очередь ее индекс (1).   Очередь примет вид {0,1}
		     - для вершины "А" опред-ся соседняя непосещенная вершина  - вершина С (3-ая в списке вершин)
	         - вершина "С" помечается, как посещенная и заносится в очередь ее индекс (2).   Очередь примет вид {0,1,2}
         - для вершины "А"  опред-ся соседняя непосещенная вершина  - вершина D (3-ая в списке вершин)
	     - вершина "D" помечается, как посещенная и заносится в очередь ее индекс (3).   Очередь примет вид {0,1,2,3}
	     	 - для вершины "А" нет непосещенных соседних вершин, метод getAdjUnvisitedVertex возвращает "-1", выход из цикла while
		     - идет переод на строку "int v = queue.remove()" , где головной элемент очереди удаляется. 
		     - очередь примет вид {1,2,3}
		     - снова попадаем во внутренний цикл while, где для вершины "В" опред-ся соседняя непосещенная вершина  - вершина Е
		     - вершина "Е" помечается, как посещенная и заносится в очередь ее индекс (3).   Очередь примет вид {1,2,3,4}
		 - для вершины "В" нет непосещенных соседних вершин, метод getAdjUnvisitedVertex возвращает "-1", выход из цикла while
		     - идет переод на строку "int v = queue.remove()" , где головной элемент очереди удаляется. 
		     - очередь примет вид {2,3,4}
		     - снова попадаем во внутренний цикл while, где для вершины "В" опред-ся соседняя непосещенная вершина  - вершина Е
		      где извлекается, но НЕ удаляется из очереди головной элемент очереди. В начале только одна вершина "А" с индексом 0
	     и так далее	    	      */

	    	     for (int j = 0; j < nVerts; j++) {  // сброс флагов
	    	        vertexList[j].wasVisited = false;  }
	    	  }
}
			
public class Graph_Pass_in_Width {	
public static void main(String[] args) throws IOException {
	Graph2 graph = new Graph2(10);
    
    graph.addVertex("A");		// 0
    graph.addVertex("B");		// 1
    graph.addVertex("C");		// 2
    graph.addVertex("D");		// 3
    graph.addVertex("E");		// 4
    graph.addVertex("F");		// 5
    graph.addVertex("G");		// 6
    graph.addVertex("H");		// 7
    graph.addVertex("I");		// 8
    graph.addVertex("J");		// 9
    	/*			  /-> C -> H -> I -> J 
    	 * 		A -> B -> D
    	 		\-> E -> F	
    	 		G (вершина без связи)	
    	 */
    graph.addEdge(0, 1, 1);		// AB
    graph.addEdge(1, 2, 1);		// BC
    graph.addEdge(1, 3, 1);		// BD
    graph.addEdge(0, 4, 1);		// AE
    graph.addEdge(4, 5, 1);		// EF
    graph.addEdge(2, 7, 1);		// CH
    graph.addEdge(7, 8, 1);		// HI
    graph.addEdge(8, 9, 1);		// IJ
    
    graph.pass_in_width(6);
	
}
}
