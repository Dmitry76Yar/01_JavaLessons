package C_Graphs;

import java.util.ArrayList;
import java.util.List;

/*    �������� ��������
��� ���������� �����, ����� ����� ���� ������������� (������������ �����) � ����������� (� ��������� ���������� ������� �����)
����������, ������������ ����� ����� ����������� � � �������� �����: ��������, ����� �������, ��� ������ � �������, ���� ����� ���� �
������, ������ ����� ����� ������������� �������� � ����������� �����.
	��������, �� ����������� ���������������� � ����� ��������� ���������� ���� ����� ����� ����������� ��������.
	����� ��  ��������������� �����, ��������� �� ����������� �������, �������� ������ ������ ����������� ���� ����� ����� ���������.
	��� ������� ������ ������ �� � ���������� �������� ��������.
	�������� �� ����� ��������, ��� �������� �������� �������� �� ������ ���������� ���� �� ���� �������� �� �������� ���������. 
	����� �� ����� ����� ������ ��������? 
	����� ��������� ��������:
���� 1: ����� ����, ������� � �������� ����� ���������� ���������� ���������. �� ������ � ����� ������ � �������, ���� �����������: 
		� ���� � ��� � ���� �. ������� ������� �����������, ����� ��������� �� ������� �� ���� �����?
���� 2: ����������, ������� ������� �����, ����� ��������� �� ���� ��� �� ���������� ���������� ������� � ��� �������� �� ����� �� �.
 		���� �� ��� ����� ����� �������� ������ �������, ���� ����� ����� B � ������ ����� ���������� ���� ��� ���� �������.
���� 3: �������� ������� B ��� ����������.
���� 4: ������� � ����� 1.
���� ���� ������ �� ����� ��������� �� ��� ���, ���� ��� ������� �� ����� ��������.
	������� ���������� ��������� ���������� ������������ ����:
	
	 /-3->--B--6-->\ 
	/               \
	�--5->--C---4->--E-6->\
	\       >              \
	 \       3              \
	  \-7->--D---3->--F-4->--G
	  
	  ����, � ������� ���������������� ��������� �� ��������� ���������� ���� �� A �� G:
1. ��� ������� A ���� ��� ��������� ����: � B � ����� 3, � � � ����� 5 � � D � ����� 7. 
�������� ������� ������ ��������� �������� ���� � ���������� ���������� �������� � �� ���� � B.
2. ��� ��� ������������ ������������ ��������-������� ��� B ����� ������� �, �� ���������, ����� ����� ���� ��� ����������� ����� ���
�������. 3(AB) + 6(BE) = 9.
	����� �������, �� �������� ��� ������� ���������� ���� �� AE = 9.
3.��� ��� ���� ������ � �������� B ��� ���������, ��������� � ������ ��������� ������� � ����������� ����� ����� �� ��.
� ������ A � B ��� ����� ���� ������� D(7), C(5), E(6).
	���������� ��� ����� ����� �, ������� � ���� ������� � ��������.
4. �����, ��� � ������, �������� ���������� ���� � �������� �������� ��� ������� ����� �:
AD = 5(AC) + 3(CD) = 8, �� ��� ��� ���������� ���������� ���� AC = 7, �� ���� ������, ��� ���� ����� �, �� ��� � ���������
���������� ���� AD = 7, ��� ���������.
CE = 5(AC) + 4(CE) = 9, ���� ����� ���������� ���� ����� �������� ������� �� ��������� ��� ��� ��������� ����.
5. �� ��������� ��������� ������, E � D, �������� ������� � ���������� ����� �����, �� ���� D(3).
6. �������� ���������� ���� �� ��� ������ � F.
	AF = 7(AD) + 3(DF) = 10
7. �� ��������� ��������� ������ E � F, �������� ������� � ���������� ����� ����� � ���, �� ���� F(3).
8. �������� ���������� ���� �� ��� ������ � G.
AG = 7(AD) + 3(DF) + 4(FG) = 14
����������, ��� �� � ����� ���� �� A �� G.
�� ����� ��������� � ���, ��� �� ����������, �� ������ �������� ���� ����� � ��� ������� E.
9. ��� ��� � ������� G ��� �������� ������, � ������� ��� �� ������������ ����, � ��� ������� ������ ������� E: �������� ��.
10. �������� ���������� ���� �� ������ � G.
AG = 3(AB) + 6(BE) + 6(EG) = 15, ���� ���� ������� �������� ����������� AG(14), ������� ������ ���� �� ��������� ��� ���������.
	��� ��� ������, ������� �� G, ���, ��������� ����� ��� ������ ������� �� ����� ������. ������� ������ ��������� ����� ������� 
�����������.
	��� � � ������� �����, ������ ��������� ����������� ���� ��� AG, �� �������� ���������� ���� �� ���� ������ �� 
������� A (AB, AC, AD, AE, AF).
 */
		// ����� ������� ���������� ��������� ������ ������� �� ������ � ������� � ������.
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

			// ����� Path ��� ����������� ����������� ����	
class Path { 					// ������ ������� ������ ���������� ���������� � ���������� � ���������� �������
	   private int distance; 					// ������� ��������� �� ��������� �������
	   private List<Integer> parentVertices; 	// ������� �������� �������

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

			// ����� � �������, ����������, � ���������� ���������� ����� �����.
class Graph4 {
	   private final int INFINITY = 100000000; 		// ��� ����� � ��� ����� ������� � �������� "�������������"
	   private Vertex4 vertexList[]; 				// ������ ������
	   private int relationMatrix[][]; 				// ������� ������ ������
	   private int countOfVertices;					// ������� ���������� ������
	   private int countOfVertexInTree; 			// ���������� ������������� ������ � ������
	   private List<Path> shortestPaths; 			// ������ ������ ���������� �����
	   private int currentVertex; 					// ������� �������
	   private int startToCurrent; 					// ���������� �� currentVertex

	   public Graph4(int MAX_VERTS) {
	       vertexList = new Vertex4[MAX_VERTS]; 			// ������� ���������
	       relationMatrix = new int[MAX_VERTS][MAX_VERTS];
	       countOfVertices = 0;								// ������� ���������� ������ = 0
	       countOfVertexInTree = 0;							// ���������� ������������� ������ � ������ = 0
	       for (int i = 0; i < MAX_VERTS; i++) {			 
	           for (int k = 0; k < MAX_VERTS; k++) { 		// ������� ��������� ����������� ������������ ������������
	               relationMatrix[i][k] = INFINITY; 		// ������� �������� �� ���������
	               shortestPaths = new ArrayList<>(); } 	// �������� ������
	       }
	   }

	   public void addVertex(char lab) {						// ����� ������� ����� ������
	       vertexList[countOfVertices++] = new Vertex4(lab);}

	   public void addEdge(int start, int end, int weight) {	// ����� ������� ����� ����� ���������, � ����� ����� ����
	       relationMatrix[start][end] = weight;  }

	   		// ����� ������ ����������� ����
	   public void path() { 							
	       int startTree = 0; 							//  ������� ������ ��� ��������� ������� - �������� � ������� 0
	       vertexList[startTree].setInTree(true); 	    // ��������� � ������ ������ ������� ��������
	       countOfVertexInTree = 1;

	       for (int i = 0; i < countOfVertices; i++) {		// ���������� �������� ����� ��� ������ ������� � ���������
	           int tempDist = relationMatrix[startTree][i];
	           Path path = new Path(tempDist);
	           path.getParentVertices().add(0);				// ������ ������������ ���������, ����� ������ ��������� �������
	           shortestPaths.add(path);
	       }
	       		// ���� ��� ������� �� �������� � ������
	       while (countOfVertexInTree < countOfVertices) { 	// ���������, ���� ���������� ������ � ������ �� ���������� � ����� ����������� ������
	           int indexMin = getMin();			//�������� ������ ������� � ��������� ����������, �� ������ ��� �� �������� � ������
	           int minDist = shortestPaths.get(indexMin).getDistance();// ����������� ��������� �������, �� ��� ������� ��� �� � ������

	           if (minDist == INFINITY) {
	               System.out.println("� ����� ������������� ������������ �������");
	               break;// � ������ ���� �������� ������������� ������ ������������ �������, �� ������� �� �����
	           } else {
	               currentVertex = indexMin; // ��������� ��������� currentVert � ������� �������
	               startToCurrent = shortestPaths.get(indexMin).getDistance();// ������ ��������� � ������� �������
	           }

	           vertexList[currentVertex].setInTree(true);  //��������� ������� ������� � ������
	           countOfVertexInTree++; // ����������� ������� ������ � ������
	           updateShortestPaths(); // ���������� ������ ���������� �����
	       }

	       displayPaths(); // ������� � ������� ����������
	   }

	   public void clean() { // ������ ������
	       countOfVertexInTree = 0;
	       for (int i = 0; i < countOfVertices; i++) {
	           vertexList[i].setInTree(false);
	       }
	   }

	   private int getMin() {
	       int minDist = INFINITY; // �� ����� ������ ����� "�����������" �����
	       int indexMin = 0;
	       for (int i = 1; i < countOfVertices; i++) {// ��� ������ �������
	           if (!vertexList[i].isInTree() && shortestPaths.get(i).getDistance() < minDist) { // ���� ������� ��� �� �� ������ � � ��������� ������ ������� ��������
	               minDist = shortestPaths.get(i).getDistance(); // ������� ����� �������
	               indexMin = i; // ���������� ������� ������� ���������� ���������� ���������
	           }
	       }
	       return indexMin; //���������� ������ ������� � ��������� ����������, �� ������ ��� �� �������� � ������
	   }

	   private void updateShortestPaths() {
	       int vertexIndex = 1; // ��������� ������� ������������
	       while (vertexIndex < countOfVertices) { // ������� ��������

	           if (vertexList[vertexIndex].isInTree()) { // ���� ������� column ��� �������� � ������, ��� ������������
	               vertexIndex++;
	               continue;
	           }
	           // ���������� ���������� ��� ������ �������� sPath
	           // ��������� ����� �� currentVert � column
	           int currentToFringe = relationMatrix[currentVertex][vertexIndex];
	           // ������������ ���� ����������
	           int startToFringe = startToCurrent + currentToFringe;
	           // ����������� ���������� �������� �������� vertexIndex
	           int shortPathDistance = shortestPaths.get(vertexIndex).getDistance();

	           // ��������� ���������� ����� currentVertex � ������� ����������� � ������� � �������� vertexIndex
	           if (startToFringe < shortPathDistance) {// ���� ������, �� � ������� ��� �������� vertexIndex ����� ����� ����� ���������� ����
	               List<Integer> newParents = new ArrayList<>(shortestPaths.get(currentVertex).getParentVertices());//������ ����� ������ ��������� ������� currentVert
	               newParents.add(currentVertex);// ����� � ���� � currentVertex ��� ����������
	               shortestPaths.get(vertexIndex).setParentVertices(newParents); // ���������� ����� ������
	               shortestPaths.get(vertexIndex).setDistance(startToFringe); // ���������� ����� ���������
	           }
	           vertexIndex++;
	       }
	   }

	   private void displayPaths() { // ����� ��� ������ ���������� ����� �� �����
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

     System.out.println("�������� ����� ���������� ���� �� ����� A: ");
     graph.path();
     graph.clean();

	}

}
