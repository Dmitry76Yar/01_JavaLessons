package C_Graphs;

import java.util.ArrayList;
import java.util.List;

/*    Алгоритм Дейкстры
Как говорилось ранее, графы могут быть направленными (одностороння связь) и взвешенными (с указанием расстояния каждого ребра)
Взвешенные, направленные графы часто встречаются и в реальной жизни: например, карта городов, где города — вершины, пути между ними —
дороги, дороги могут иметь одностороннее движение — направление графа.
	Допустим, вы занимаетесь грузоперевозками и нужно составить кратчайший путь между двумя отдаленными городами.
	Одной из  распространённых задач, связанной со взвешенными графами, является задача выбора кратчайшего пути между двумя вершинами.
	Для решения данной задачи мы и используем алгоритм Дейкстры.
	Хотелось бы сразу отметить, что выполнив алгоритм Дейкстры мы узнаем кратчайшие пути ко всем вершинам от заданной начальной. 
	Какие же этапы имеет данный алгоритм? 
	Этапы алгоритма Дейкстры:
Этап 1: поиск узла, переход к которому будет составлять наименьшую стоимость. Вы стоите в самом начале и думаете, куда направиться: 
		к узлу А или к узлу В. Сколько времени понадобится, чтобы добраться до каждого из этих узлов?
Этап 2: вычисление, сколько времени нужно, чтобы добраться до всех ещё не затронутых алгоритмом соседей В при переходе по ребру из В.
 		Если же это новое время окажется меньше старого, путь через ребро B и станет новым кратчайшим путём для этой вершины.
Этап 3: помечаем вершину B как пройденную.
Этап 4: перейти к этапу 1.
Цикл этих этапов мы будем повторять до тех пор, пока все вершины не будут пройдены.
	Давайте рассмотрим следующий взвешенный направленный граф:
	
	 /-3->--B--6-->\ 
	/               \
	А--5->--C---4->--E-6->\
	\       >              \
	 \       3              \
	  \-7->--D---3->--F-4->--G
	  
	  Итак, с помощью вышеприведенного алгоритма мы определим кратчайший путь от A до G:
1. Для вершины A есть три возможных пути: к B с весом 3, к С с весом 5 и к D с весом 7. 
Согласно первому пункту алгоритма выбираем узел с наименьшей стоимостью перехода — то есть к B.
2. Так как единственной непройденной вершиной-соседом для B будет вершина Е, мы проверяем, каков будет путь при прохождении через эту
вершину. 3(AB) + 6(BE) = 9.
	Таким образом, мы отмечаем что текущий кратчайший путь до AE = 9.
3.Так как наша работа с вершиной B уже закончена, переходим к выбору следующей вершины с минимальным весом ребра до неё.
С вершин A и B это могут быть вершины D(7), C(5), E(6).
	Наименьший вес ребра имеет С, поэтому к этой вершине и перейдем.
4. Далее, как и раньше, выясняем кратчайший путь к соседним вершинам при проходе через С:
AD = 5(AC) + 3(CD) = 8, но так как предыдущий кратчайший путь AC = 7, то есть меньше, чем этот через С, мы так и оставляем
кратчайший путь AD = 7, без изменений.
CE = 5(AC) + 4(CE) = 9, этот новый кратчайший путь равен прежнему поэтому мы оставляем его без изменения тоже.
5. Из ближайших доступных вершин, E и D, выбираем вершину с наименьшим весом ребра, то есть D(3).
6. Выясняем кратчайший путь до его соседа — F.
	AF = 7(AD) + 3(DF) = 10
7. Из ближайших доступных вершин E и F, выбираем вершину с наименьшим весом ребра к ней, то есть F(3).
8. Выясняем кратчайший путь до его соседа — G.
AG = 7(AD) + 3(DF) + 4(FG) = 14
Собственно, вот мы и нашли путь от A до G.
Но чтобы убедиться в том, что он кратчайший, мы должны прогнать наши этапы и для вершины E.
9. Так как у вершины G нет соседних вершин, к которым вел бы направленный путь, у нас остаётся только вершина E: выбираем ее.
10. Выясняем кратчайший путь до соседа — G.
AG = 3(AB) + 6(BE) + 6(EG) = 15, этот путь длиннее прежнего кратчайшего AG(14), поэтому данный путь мы оставляем без изменений.
	Так как вершин, ведущих от G, нет, прогонять этапы для данной вершины не имеет смысла. Поэтому работу алгоритма можно считать 
законченной.
	Как я и говорил ранее, помимо выяснения кратчайшего пути для AG, мы получили кратчайшие пути до всех вершин от 
вершины A (AB, AC, AD, AE, AF).
 */
		// Класс вершины фактически идентичен классу вершины из поиска в глубину и ширину.
class Vertex4 {
	   private char label;
	   private boolean isInTree;

	   public Vertex4(char label) {
	       this.label = label;
	       this.isInTree = false; }

	   public char getLabel() {
	       return label; }

	   public void setLabel(char label) {
	       this.label = label;  }

	   public boolean isInTree() {
	       return isInTree;  }

	   public void setInTree(boolean inTree) {
	       isInTree = inTree;  }
	}

			// Класс Path для отображения кратчайшего пути	
class Path { 					// объект данного класса содержащий расстояние и предыдущие и пройденные вершины
	   private int distance; 					// текущая дистанция от начальной вершины
	   private List<Integer> parentVertices; 	// текущий родитель вершины

	   public Path(int distance) {
	       this.distance = distance;
	       this.parentVertices = new ArrayList<>();  }

	   public int getDistance() {
	       return distance;  }

	   public void setDistance(int distance) {
	       this.distance = distance;  }

	   public List<Integer> getParentVertices() {
	       return parentVertices;  }

	   public void setParentVertices(List<Integer> parentVertices) {
	       this.parentVertices = parentVertices;  }
	}

			// Класс в котором, собственно, и происходит кратчайший обход графа.
class Graph4 {
	   private final int INFINITY = 100000000; 		// это число у нас будет служить в качестве "бесконечности"
	   private Vertex4 vertexList[]; 				// список вершин
	   private int relationMatrix[][]; 				// матрица связей вершин
	   private int countOfVertices;					// текущее количество вершин
	   private int countOfVertexInTree; 			// количество рассмотренных вершин в дереве
	   private List<Path> shortestPaths; 			// список данных кратчайших путей
	   private int currentVertex; 					// текущая вершина
	   private int startToCurrent; 					// расстояние до currentVertex

	   public Graph4(int MAX_VERTS) {
	       vertexList = new Vertex4[MAX_VERTS]; 			// матрица смежности
	       relationMatrix = new int[MAX_VERTS][MAX_VERTS];
	       countOfVertices = 0;								// текущее количество вершин = 0
	       countOfVertexInTree = 0;							// количество рассмотренных вершин в дереве = 0
	       for (int i = 0; i < MAX_VERTS; i++) {			 
	           for (int k = 0; k < MAX_VERTS; k++) { 		// матрица смежности заполняется бесконечными расстояниями
	               relationMatrix[i][k] = INFINITY; 		// задания значений по умолчанию
	               shortestPaths = new ArrayList<>(); } 	// задается пустым
	       }
	   }

	   public void addVertex(char lab) {						// Метод задания новых вершин
	       vertexList[countOfVertices++] = new Vertex4(lab);}

	   public void addEdge(int start, int end, int weight) {	// Метод задания ребер между вершинами, с весом между ними
	       relationMatrix[start][end] = weight;  }

	   		// Метод выбора кратчайшего пути
	   public void path() { 							
	       int startTree = 0; 							//  Задание данных для стартовой вершины - стартуем с вершины 0
	       vertexList[startTree].setInTree(true); 	    // включение в состав дерева первого элемента
	       countOfVertexInTree = 1;

	       for (int i = 0; i < countOfVertices; i++) {		// заполнение коротких путей для вершин смежных с стартовой
	           int tempDist = relationMatrix[startTree][i];
	           Path path = new Path(tempDist);
	           path.getParentVertices().add(0);				// первым родительским элементом, будет всегда стартовая вершина
	           shortestPaths.add(path);
	       }
	       		// пока все вершины не окажутся в дереве
	       while (countOfVertexInTree < countOfVertices) { 	// выполняем, пока количество вершин в дереве не сравняется с общим количеством вершин
	           int indexMin = getMin();			//получаем индекс вершины с наименшей дистанцией, из вершин еще не входящих в дерево
	           int minDist = shortestPaths.get(indexMin).getDistance();// минимальная дистанция вершины, из тек которые ещё не в дереве

	           if (minDist == INFINITY) {
	               System.out.println("В графе пристувствуют недостижимые вершины");
	               break;// в случае если остались непройденными только недостижимые вершины, мы выходим из цикла
	           } else {
	               currentVertex = indexMin; // переводим указатель currentVert к текущей вершине
	               startToCurrent = shortestPaths.get(indexMin).getDistance();// задаем дистанцию к текущей вершине
	           }

	           vertexList[currentVertex].setInTree(true);  //включение текущей вершины в дерево
	           countOfVertexInTree++; // увеличиваем счетчик вершин в дереве
	           updateShortestPaths(); // обновление списка кратчайших путей
	       }

	       displayPaths(); // выводим в консоль результаты
	   }

	   public void clean() { // очиска дерева
	       countOfVertexInTree = 0;
	       for (int i = 0; i < countOfVertices; i++) {
	           vertexList[i].setInTree(false);
	       }
	   }

	   private int getMin() {
	       int minDist = INFINITY; // за точку старта взята "бесконечная" длина
	       int indexMin = 0;
	       for (int i = 1; i < countOfVertices; i++) {// для каждой вершины
	           if (!vertexList[i].isInTree() && shortestPaths.get(i).getDistance() < minDist) { // если вершина ещё не ве дереве и её растояние меньше старого минимума
	               minDist = shortestPaths.get(i).getDistance(); // задаётся новый минимум
	               indexMin = i; // обновление индекса вершины содержащую минимаьную дистанцию
	           }
	       }
	       return indexMin; //возвращает индекс вершины с наименшей дистанцией, из вершин еще не входящих в дерево
	   }

	   private void updateShortestPaths() {
	       int vertexIndex = 1; // стартовая вершина пропускается
	       while (vertexIndex < countOfVertices) { // перебор столбцов

	           if (vertexList[vertexIndex].isInTree()) { // если вершина column уже включена в дерево, она пропускается
	               vertexIndex++;
	               continue;
	           }
	           // вычисление расстояния для одного элемента sPath
	           // получение ребра от currentVert к column
	           int currentToFringe = relationMatrix[currentVertex][vertexIndex];
	           // суммирование всех расстояний
	           int startToFringe = startToCurrent + currentToFringe;
	           // определение расстояния текущего элемента vertexIndex
	           int shortPathDistance = shortestPaths.get(vertexIndex).getDistance();

	           // сравнение расстояния через currentVertex с текущим расстоянием в вершине с индексом vertexIndex
	           if (startToFringe < shortPathDistance) {// если меньше, то у вершины под индексом vertexIndex будет задан новый кратчайший путь
	               List<Integer> newParents = new ArrayList<>(shortestPaths.get(currentVertex).getParentVertices());//создаём копию списка родителей вершины currentVert
	               newParents.add(currentVertex);// задаём в него и currentVertex как предыдущий
	               shortestPaths.get(vertexIndex).setParentVertices(newParents); // соохраняем новый маршут
	               shortestPaths.get(vertexIndex).setDistance(startToFringe); // соохраняем новую дистанцию
	           }
	           vertexIndex++;
	       }
	   }

	   private void displayPaths() { // метод для вывода кратчайших путей на экран
	       for (int i = 0; i < countOfVertices; i++) {
	           System.out.print(vertexList[i].getLabel() + " = ");
	           if (shortestPaths.get(i).getDistance() == INFINITY) {
	               System.out.println("0");
	           } else {
	               String result = shortestPaths.get(i).getDistance() + " (";
	               List<Integer> parents = shortestPaths.get(i).getParentVertices();
	               for (int j = 0; j < parents.size(); j++) {
	                   result += vertexList[parents.get(j)].getLabel() + " -> ";
	               }
	               System.out.println(result + vertexList[i].getLabel() + ")");
	           }
	       }
	   }
	}

public class Path_Algoritm_Deisktri {
public static void main(String[] args) {
	 Graph4 graph = new Graph4(7);
     graph.addVertex('A');
     graph.addVertex('B');
     graph.addVertex('C');
     graph.addVertex('D');
     graph.addVertex('E');
     graph.addVertex('F');
     graph.addVertex('G');

     graph.addEdge(0, 1, 3);
     graph.addEdge(0, 2, 5);
     graph.addEdge(0, 3, 7);
     graph.addEdge(1, 4, 6);
     graph.addEdge(2, 4, 4);
     graph.addEdge(2, 3, 3);
     graph.addEdge(3, 5, 3);
     graph.addEdge(4, 6, 6);
     graph.addEdge(5, 6, 4);

     System.out.println("Элементы имеют кратчайшие пути из точки A: ");
     graph.path();
     graph.clean();

	}

}
