package Combinatorika.Perestanovka;

import java.util.ArrayList;

// Выводит все комбинации перестановки, но без повторений.  Например, для aaaa будет только один вариант - aaaa
//															Для aaab будет - aaab aaba  abaa baaa

public class t02_Perest_bez_Povtor_alg {
	
	static ArrayList<String> arr = new ArrayList<String>();
	
    // Функция для печати всех различных перестановки str
    static void printDistinctPermutn(String str, String ans)   {
    		// Если строка пуста
        if (str.length() == 0) {
            System.out.print(ans + " ");
            arr.add(ans);
            return;	        }

        	// Создаем логический массив размером 26, который  сохраняет false по умолчанию и делает true
        	// в позиции, в которой находится алфавит  используемый
        boolean alpha[] = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
        		// i-й символ строки
        	char ch = str.charAt(i);
	            // Остальная часть строки после исключения i-й символ
	        String ros = str.substring(0, i) + str.substring(i + 1);
	            // Если персонаж не использовался тогда произойдет рекурсивный вызов.
	            // Иначе рекурсивного не будет вызов
	        if (alpha[ch - 'a'] == false)
	        printDistinctPermutn(ros, ans + ch);
	        alpha[ch - 'a'] = true;
        }
    }

    public static void main(String[] args) {
        String s = "soorrtt";		// 7!/1!*2!*2!*2! = 5040/(2*2*2)
        printDistinctPermutn(s, "");
        System.out.println();
        System.out.println(arr.size());
    }
}