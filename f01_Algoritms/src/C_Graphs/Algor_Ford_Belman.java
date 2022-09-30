package C_Graphs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class Algor_Ford_Belman	{
	
	public static class edge {
	        int startVert;
	        int finshVert;
	        public edge(int startVert, int finshVert) {
	            this.startVert = startVert;
	            this.finshVert = finshVert; }
	 
	        public String toString() {
	            return this.startVert + " " + this.finshVert;}
	 }
	 
	 public static class VertixT {
	        int name;				// Имя вершины (порядковый номер, например, А,В,С ... или 1,2,3...)
	        int dist;				// Значение миним.дистанции от стартовой вершины до этой вершины
	        String path;			// Минимальный маршрут от стартовой вершины до этой вершины
	 
	        public VertixT(int name, int dist, String path) {
	            this.name = name;
	            this.dist = dist;
	            this.path = path;}
	 
	  public String toString() {
	  	   return  "      "+ this.name + " \t\t" + this.dist + "  \t\t   " +  this.path + ""; 
	   }
	 }
	 		// Метод создает матрицу ребер, которые существуют в графе 
	 public static edge[] getEdges(int N_Edges, int[][] graph) {
		    edge[] rv = new edge[N_Edges];
		    int i = 0;
		    for (int u = 1; u < graph.length; u++) {
		    	for (int v = 1; v < graph[u].length; v++) {
		            rv[i] = new edge(u, v);
		            if (graph[u][v] != 0) i++;
		            if (i == N_Edges) break;
		        }
		    	if (i == N_Edges) break;
		    }
//		    for (int i1 = 0; i1 < rv.length; i1++) {
//		    	System.out.println("[" + rv[i1].startVert + "][ " + rv[i1].finshVert + "]") ;  }
		    return rv;
		}

		public static void bellmanford(int startVert, int N_vertix, int N_edges, int[][] graph) {
		    /* Map — это структура данных, которая содержит набор пар “ключ-значение”.
		    We use hashmap to store every vertex:  key - name of vertix, value - object VertixT  */
		    
			HashMap<Integer, VertixT> vertixMap = new HashMap<>();
		    
			/* Инициализируем все вершины кроме стартовой с бесконечным минимальным расстоянием dist и пустым минимальным путем path, 
		       т.к. путь до них пока не ясен
		       Стартовую вершину инициализируем с dist = 0 и path = номер/имя стартовой вершины   */
			for (int i = 1; i < graph.length; i++) {	
				if (i == startVert) vertixMap.put(i, new VertixT(i, 0, Integer.toString(i)));
				else vertixMap.put(i, new VertixT(i, Integer.MAX_VALUE, ""));
			}

					// Внешний цикл с количеством иттераций = N_Vertix -1 
		    for (int var = 1; var <= N_vertix - 1; var++) {
		        	/* Внутренний цикл - это перебор всех ребер графа, их список возвращается из метода getEdges() 
		        	   Порядок ребер рандомный, чаще делают по алфавиту, как и здесь*/
		    	System.out.println("Иттерация " + var);
		    	
		        for (edge e : getEdges(N_edges, graph)) {
		            VertixT u = vertixMap.get(e.startVert);
		            VertixT v = vertixMap.get(e.finshVert);

		            System.out.print("Ребро[" + u.name + "][" + v.name + "]=" + graph[u.name][v.name] + 
		            		        ",  vert(" + u.name + ")= " + u.dist + ",  vert(" + v.name + ")= " + v.dist);
		            
		            if (v.dist > u.dist + graph[u.name][v.name]) {
		                v.dist = u.dist + graph[u.name][v.name];
		                v.path = u.path + "->" + Integer.toString(v.name);
		                System.out.println("   v[" + v.name + "]>u[" + u.name + "]+ребро[" + u.name + "][" + v.name + "] " + 
		                "  Теперь вершина " + v.name + " равна "  + v.dist + " и путь до нее  "  + v.path);
		            }
		            else System.out.println("   v[" + v.name + "]<u[" + u.name + "]+ребро[" + u.name + "][" + v.name + "] " + 
		            		"  Вершина " + v.name + " не меняется и равна "  + v.dist + " и путь до нее  "  + v.path);
		        }
		        System.out.println();
		    }
		    
		    for (int i : vertixMap.keySet())    System.out.println(vertixMap.get(i));

		    /* One more loop in the random set of edges to detect if there is any negative cycle or not     
		     If the we still are able to find shorted distance this simply means that there is a negative cycle
		     for sure and hence we return from the function as shortest distance for every vertex from source can
		     not be found for such graph as we can get even shorter distance by looping once again in that  negative cycle.  */
		    for (edge e : getEdges(N_edges, graph)) {
		        VertixT u = vertixMap.get(e.startVert);
		        VertixT v = vertixMap.get(e.finshVert);
		        if (v.dist > u.dist + graph[u.name][v.name]) {
		            System.out.println("Negative Cycle Detected");
		            return;
		        }
		    }
		}
	 
public static void main(String[] args) throws IOException {
    int N_Vertix = 5;
    int startVertix = 1;
    int[][] graph = new int[N_Vertix + 1][N_Vertix + 1];
    /*	   5
          /  \
        (5)   (-6)
        /       \
       1---(2)---2
       | \       |
      (1) \     (1)
       |   (5)  |
       |       \ |
       3---(3)---4
*/
    int N_Edges = 7;
    graph[1][2] = 2;
    graph[1][5] = 5;
    graph[1][3] = 1;
    graph[2][4] = 1;
    graph[3][4] = 3;
    graph[4][1] = 5;		// Если сделать -5, то будет отрицательный цикл
    graph[5][2] = -6;
    
    System.out.println("Граф на входе");
    for (int i = 1; i < graph.length; i++) {
   	   for (int j = 1; j < graph.length; j++)  	System.out.print(graph[i][j] + " \t");
   	   System.out.println();}
    
    bellmanford(startVertix, N_Vertix, N_Edges, graph);
}
}
