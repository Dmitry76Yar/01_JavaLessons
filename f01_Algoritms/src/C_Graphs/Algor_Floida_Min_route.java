package C_Graphs;

import java.io.*;
import java.util.Arrays;

/* САМ НАПИСАЛ	
 * В отличии от алгоритма Дейкстры
      - может работать с отрицательными числами
      - работает дольше, т.к. прорабатывает N3 вариантов, где N - количество вершин
           
  https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%A4%D0%BB%D0%BE%D0%B9%D0%B4%D0%B0_%E2%80%94_%D0%A3%D0%BE%D1%80%D1%88%D0%B5%D0%BB%D0%BB%D0%B0
*/
public class Algor_Floida_Min_route	{
	
	static void addEdge (int start, int finish, int weight, int matrizaSmegn[][]) {
		matrizaSmegn[start-1][finish-1] = weight;
	}
	
public static void main(String[] args) throws IOException {
	int Nvertix = 5;
	int matrizaSmegnosti[][] = new int[Nvertix][Nvertix];
		// Инициализация матрицы числами бесконечности, а диагональ нулями
	for (int i =0; i<Nvertix; i++) {
		for (int j =0; j<Nvertix; j++) 	{
			if (i!=j) matrizaSmegnosti[i][j] = Integer.MAX_VALUE;
			else matrizaSmegnosti[i][j] = 0;
		}
	}
		// Добавление ребер в матрицу смежности
	addEdge(1, 2, 3, matrizaSmegnosti);
	addEdge(2, 1, 3, matrizaSmegnosti);
	addEdge(2, 4, 5, matrizaSmegnosti);
	addEdge(4, 2, 5, matrizaSmegnosti);
	addEdge(4, 5, 4, matrizaSmegnosti);
	addEdge(5, 4, 4, matrizaSmegnosti);
	addEdge(4, 3, 6, matrizaSmegnosti);
	addEdge(3, 4, 6, matrizaSmegnosti);
	addEdge(3, 5, 15, matrizaSmegnosti);
	addEdge(1, 3, 10, matrizaSmegnosti);
	addEdge(3, 1, 10, matrizaSmegnosti);
	for (int i =0; i<Nvertix; i++) System.out.println(Arrays.toString(matrizaSmegnosti[i]));
	
		// Алгоритм Флойда-Уоршелла  
		/* Для каждого к = 0...число вершин  идет сравнение длины числа в матрице смежности в ячейке [i][j]
		 c суммой чисел в ячейках [i][k] + [k][j]
		 Например, для графа 
		 
		 	0 <-----(3)----> 1 <----(5)----> 3 <---(4)----> 4   
		 	|                                |              |
		 	 <---(10)---> 2 <------(6)------>               |
		 	 			  |                                 |
		 	 			  |>-------------(15)-------------->|
		 
		 Сначала имеем просто матрицу смежности. Там где нет связи - бесконечность
		 	[0, 			3, 				10,		 		2147483647,		 2147483647]
			[3, 			0,				2147483647, 	5, 				 2147483647]
			[10, 			2147483647, 	0, 				6, 				 15		   ]
			[2147483647,	5, 				6, 				0, 				 4		   ]
			[2147483647,	2147483647, 	2147483647, 	4, 				 0         ]
			
		 На шаге к = 0 проверяем есть ли ребра, проходящие через вершину 0, это просто перебор всех вариантов [i][j]
		 находим, что m[1][2], которая до этого была равна бесконечности, теперь равна m[1][2] = m[1][0] + m[0][2] = 3 + 10 = 13
		 	          m[2][1], которая до этого была равна бесконечности, теперь равна m[2][1] = m[2][0] + m[0][1] = 10 + 3 = 13
		 Другиех двойных-тройный... ребер, проходящих через вершину 0, нет
		 Переходим к к=1 - аналогично находим
		 */
	
	for (int k =0; k<Nvertix; k++) {
		for (int i =0; i<Nvertix; i++) {
			for (int j =0; j<Nvertix; j++) {
				if (i != j) {
					int temp1 = matrizaSmegnosti[i][k];
					int temp2 = matrizaSmegnosti[k][j];
					int temp3 = 0;
					if ((temp1 == Integer.MAX_VALUE) || (temp2 == Integer.MAX_VALUE)) temp3 = Integer.MAX_VALUE;
					else temp3 = (temp1 + temp2);
//					System.out.println("i = " + i + "   j = "+ j + "   k = " + k + "   temp1 = " + temp1 + "   temp2 = " + temp2 + "   temp3 = " + temp3);
					if (matrizaSmegnosti[i][j] > temp3)  matrizaSmegnosti[i][j] = temp3;}
			}
		}
		System.out.println("k = " + k);
		for (int i =0; i<Nvertix; i++) System.out.println(Arrays.toString(matrizaSmegnosti[i]));
		System.out.println();
	}
	
	}
}
