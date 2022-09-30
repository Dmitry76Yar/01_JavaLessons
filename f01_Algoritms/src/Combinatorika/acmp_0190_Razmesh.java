	package Combinatorika;
/*По размещению!	(Время: 1 сек. Память: 16 Мб Сложность: 56%)
	Перестановкой из N элементов называется упорядоченный набор из N различных чисел от 1 до N.
	Размещением порядка K называют подмножество элементов некоторой перестановки порядка N. Например, (1, 3) – размещение порядка
2 для перестановки (1, 2, 3) порядка 3.
	Требуется по заданному размещению определить его позицию в лексикографическом порядке всех возможных размещений, образованных
из всевозможных перестановок порядка N.
	Например, лексикографическая последовательность всевозможных размещений для K=2 и N=3 выглядит следующим образом:
(1,2), (1,3), (2,1), (2,3), (3,1), (3,2)
	Таким образом, перемещение (2,3) имеет номер 4 в этой последовательности.
	Входные данные
В первой строке входного файла INPUT.TXT находятся числа N и K (1 ≤ K ≤ N ≤ 12). Во второй строке записаны K чисел из диапазона
от 1 до N - размещение.
	Выходные данные
В выходной файл OUTPUT.TXT выведите единственное число - номер данного размещения.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	3 2
	3 2				6
2	6 4
	1 3 2 5			14*/

import java.util.*;
import java.io.*;

public class acmp_0190_Razmesh{
	
	public static int factor (int N) {
		int res = N;
		if (N==0) res = 1;
		else 
			for (int i = N-1; i>0; i--) res = res*i;
		return res;
	}
	
	public static int razmesh (int N, int R) {
		// Кол-во вариантов  = n!/(n-r)!
		int res = factor(N)/factor(N-R);
		System.out.print("N = " + N + "   R = " + R + "  res = " + res + " \t");
		return res;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int K = sc.nextInt();	
	ArrayList<Integer> posled = new ArrayList<Integer>();
	while (sc.hasNextInt()) posled.add(sc.nextInt());
	System.out.println("N = " + N + " ,  K = " + K);
	System.out.println("posled = " + posled);
	
	//	N= 6; K = 4       Последовательность = 1 3 2 5
	// 1234 1235 1236 1243 1245 1246 1253 1254 1256 1263 1264 1265 
	// 1324 1325 1326 1342 1345 1346 1352 1354 1356 1362 1364 1365
	// Итого для 1-го ряда = 12*5 = 60
	// Всего кол-во комбинаций 60*6 = 360
	// Кол-во размещений = 6!/(6-4)! =  720/2 = 360
	// Первая цифра в последовательности = 1, значит все цифры до 1-го ряда нужно учесть все комбинации
	// Количество в 1-ом ряду = 360/N = 60  
	// Тогда учитываем 60*0 = 0
	
	//	Без цифры 1  Значит N= 5; K = 3
	// 234 235 236 243 245 246 253 254 256 263 264 265 
	// Итого для 1-го ряда = 12
	// 12 в ряду   То есть всего 12*5 = 60
	// Кол-во размещений = 5!/(5-3)! =  120/2 = 60
	// Вторая цифра в последовательности = 3, значит все цифры до 3-го ряда нужно учесть все комбинации
	// Но так как цифра 1 уже вышла, то 1-ый ряд не нужно учитывать
	// Количество в 1-ом ряду = 60/(N) = 60/5 = 12
	// Тогда учитываем 12*(2 - 1 - кол-во вышедших цифр меньше текущего = 1) =  12
	
	//	Без цифры 1 и 3  Значит N= 4; K = 2
	// 24 25 26 42 45 46 52 54 56 62 64 65 
	// Всего - 12
	// Кол-во размещений = 4!/(4-2)! =  24/2 = 12
	// Третья цифра в последовательности = 2, значит все цифры до 2-го ряда нужно учесть все комбинации
	// Но так как цифра 1 уже вышла, то 1-ый ряд не нужно учитывать
	// Количество в 1-ом ряду = 12/(N) = 12/4 = 3
	// Тогда учитываем 3*(2 - 1 - кол-во вышедших цифр меньше текущего = 1) =  0
	
	//	Без цифры 1, 3 и 2  Значит N= 3; K = 1
	// 4 5 6 
	// Всего - 3
	// Кол-во размещений = 3!/(3-1)! =  6/2 = 3
	// Четвертая цифра в последовательности = 5, значит все цифры до 5-го ряда нужно учесть все комбинации
	// Но так как цифры 1, 2, 3 уже вышла, то 1-ый ряд, 2-ой ряд и 3-ий ряд не нужно учитывать
	// Количество в 1-ом ряду = 3/(3) = 3/3 = 1
	// Тогда учитываем 1*(5 - 1 - кол-во вышедших цифр меньше текущего = 3) =  0
	
	long result = 0;
	ArrayList<Integer> usedNumbers = new ArrayList<Integer>();
	for (int i = 0; i<posled.size(); i++) {
		int currentNumber = posled.get(i);
		 // Уменьшаем число, если предыдущие цифры в последовательности были меньше
		 // Это для учета того, чтобы исключить ряд, начинающийся с вышедших чисел 
		 // Считаем кол-во предыдущих чисел, меньших текущего числа
		int count = 0;
		for (int j =0; j<usedNumbers.size(); j++) 
			if (usedNumbers.get(j) < currentNumber) count ++;
		currentNumber = currentNumber - count -1;
		int y = razmesh(N, K)/N;
		result = result + currentNumber*y;
		N--;
		K--;
		usedNumbers.add(posled.get(i));	
		System.out.println("currentNumber = " + currentNumber + " \tresult = " + result);
	}

	System.out.println("RESULT = " + (result+1));
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    o.print(result+1);
    o.flush();
    o.close();
    }
}