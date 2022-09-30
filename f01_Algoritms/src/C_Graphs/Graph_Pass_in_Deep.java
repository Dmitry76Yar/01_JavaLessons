package C_Graphs;
// ОТЛИЧИЕ ОТ "Graph_Pass_in_Deep_Stack" в том, что стэк из коллекции JAVA
// ОБХОД В ГЛУБИНУ

/*	Это один из наиболее распространенных методов обхода графа.
Данная стратегия поиска в глубину состоит в том, чтобы идти «вглубь» графа насколько это возможно, а достигнув тупика, 
возвращаться к ближайшей вершине, у которой есть смежные ранее не посещенные вершины.
	Этот алгоритм хранит в стеке информацию о том, куда следует вернуться при достижении “тупика”.
	Правила обхода в глубину:
- Посетить смежную, ранее не посещенную вершину, пометить её и занести в стек.
- Перейти на данную вершину.
- Повторить этап 1. Если выполнение пункта 1 невозможно, вернуться к предыдущей вершины и попытаться повторить правило 1. 
Если это невозможно — вернуться к вершине до нее, и так далее, пока не найдем вершину, с которой можно продолжить обход.
	Продолжать до тех пор, пока все вершины не окажутся в стеке.
 */

import java.io.*;
import java.util.Stack;
				
		/* Класс Vertex, представляющий отдельную вершину графа: Пока в нашей структуре мы будем хранить только метку вершины. 
	Но в реальной задаче вершины графы могут описывать объекты реального мира, например, города или элементы на электронной схеме, 
	так что они вполне могут содержать другие, необходимые для решения задачи, данные. 	 */
class Vertex3 {
	  private String label;  			// метка А например
	  public boolean wasVisited;

	  public Vertex3(final String label) {
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
 class Graph3 {
	  private Vertex3 vertexList[]; 		//массив вершин
	  private int adjMat[][]; 				// матрица смежности
	  private int nVerts; 					// текущее количество вершин
	  private Stack<Integer> stack;

	  public Graph3(int MAX_VERTS) {
	     vertexList = new Vertex3[MAX_VERTS];
	     adjMat = new int[MAX_VERTS][MAX_VERTS];
	     nVerts = 0;
	     for (int j = 0; j < MAX_VERTS; j++) {
	        for (int k = 0; k < MAX_VERTS; k++) {  // заполнение матрицы смежности нулями
	           adjMat[j][k] = 0; }
	     }
	     stack = new Stack<>();
	  }
	     
	     		// Mетод добавления новой вершины в граф:
	     public void addVertex(String lab) {
	         vertexList[nVerts++] = new Vertex3(lab);  }
	     
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
    	  		/* Mетод обхода графа в ГЛУБИНУ
    	    / - B - E
    	   А  - C
    	    \ - D - F - G	    	    */
    	  
    	  public void pass_in_deep(int start_index) { 
    		     vertexList[start_index].setWasVisited(true); 	// Начинаем с 0-ой вершины в списке вершин  (вершина А)
    		     displayVertex(start_index);					// Помечаем ее, как посещенную и добавляем в стэк
    		     stack.push(start_index);	

    		     while (!stack.empty()) {							// Пока cтэк не будет пустой
    		        int v = getAdjUnvisitedVertex(stack.peek()); 	// Извлекаем индекс вершины из стэка. В начале это будет 0.
    		        if (v == -1) { 									// если непройденных смежных вершин нету элемент извлекается из стека
    		           stack.pop();   }
    		        else {
    		           vertexList[v].setWasVisited(true);			// Для точки А сначала определится вершина В, помечаем ее как посещенную
    		           displayVertex(v);
    		           stack.push(v);    }							// и добавляем в стэк.   Стэк примет вид {0,1}
    		     }

    		     for (int j = 0; j < nVerts; j++) {  // сброс флагов
    		        vertexList[j].wasVisited = false;	   }
    	  }
    	  
	    	     /*  На примере выше:
	     - в "stack.peek()" в строке "int v = getAdjUnvisitedVertex(stack.peek())" 
	       извлекается, но НЕ удаляется из стэка головной элемент стэка. В начале только одна вершина "А" с индексом 0 
	     - для 0-вой вершины в списке вершин "А" опред-ся соседняя вершина В (1-ая в списке вершин)
	     - вершина "В" помечается, как посещенная и заносится в стэк ее индекс (1).   Стэк примет вид {0,1}
	     	 - извлекается, но НЕ удаляется из стэка головной элемент стэка - вершина с индексом "1" - "В".
		     - для вершины "В" опред-ся соседняя непосещенная вершина  - вершина Е (4-ая в списке вершин)
	         - вершина "Е" помечается, как посещенная и заносится в очередь ее индекс (4).   Очередь примет вид {0,1,4}
	     - извлекается, но НЕ удаляется из стэка головной элемент стэка - вершина с индексом "4" - "Е".  
	     - для вершины "Е" нет непосещенных соседних вершин, метод getAdjUnvisitedVertex возвращает "-1", выход из цикла while  
	     - идет переход на строку  "stack.pop()", где головной элемент стэка удаляется.
	     - стэк примет вид {0,1}
		 	- снова извлекается, но НЕ удаляется из стэка головной элемент стэка - вершина с индексом "1" - "В".
		 	- для вершины "В" нет непосещенных соседних вершин, метод getAdjUnvisitedVertex возвращает "-1", выход из цикла while  
	     	- идет переход на строку  "stack.pop()", где головной элемент стэка удаляется.
	     	- стэк примет вид {0}
	     - извлекается, но НЕ удаляется из стэка головной элемент стэка - вершина с индексом "0" - "А".  
	     - для 0-вой вершины в списке вершин "А" опред-ся соседняя вершина С (2-ая в списке вершин)
	     - вершина "С" помечается, как посещенная и заносится в стэк ее индекс (2).   Стэк примет вид {0,2}
	       и так далее	    	      */
}
			
public class Graph_Pass_in_Deep {	
public static void main(String[] args) throws IOException {
	Graph3 graph = new Graph3(10);
    
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
    
    graph.pass_in_deep(0);;
	
}
}