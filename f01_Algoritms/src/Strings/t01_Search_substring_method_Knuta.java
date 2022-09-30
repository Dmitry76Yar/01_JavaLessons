package Strings;

// https://www.youtube.com/watch?v=bBFg9LXdZA4&list=PL5BhKu-LkR_0mDGftRWeaakqGuYE1ToGG&index=13
/* Оптимизированный метод поиска подстроки
 * Для строки ААВААВААААААВААВААВААВВАААВ  ищем кол-во вхождений подстроки ААВААВ, строки могут накладываться
 * ААВААВААААААВААВААВААВВАААВ
 * ААВААВ
 *           ААВААВ
 *              ААВААВ
 *                    ААВААВ
 * Суть в том, что определяется имеет ли разыскиваемая подстрока сама повторения
 * Если нет, то при прохождении анализируемой строки проходим не каждую букву, а сразу делаем шаг на кол-во букв разыскиваемой подстроки
 * Если да, то определеляем сколько символов повторяются и далем шег на это количество букв, для ААВААВ - это 3 символа 
 */

	import java.util.ArrayList;
	import java.util.Arrays;

	public class t01_Search_substring_method_Knuta {
		
			// Метод наивного поиска подстроки (пробегает каждый символ)
		static ArrayList<Integer> searchNaive(String text, String sample) {
	        ArrayList<Integer> foundPositions = new ArrayList<>();
	        for (int i = 0; i < text.length(); i++) {
	            int j = 0;
	            while (j < sample.length() && i + j < text.length() && sample.charAt(j) == text.charAt(i + j)) {
	                j++;	   }
	            if (j == sample.length()) {
	                foundPositions.add(i); }
	        }
	        return foundPositions;
	    }
			
			// Метод определения повторений в подстроке, которая разыскивается
	    static int[] prefixFunction(String sample) {
	        int [] values = new int[sample.length()];
	        for (int i = 1; i < sample.length(); i++) {
	            int j = 0;
	            while (i + j < sample.length() && sample.charAt(j) == sample.charAt(i + j)) {
	                values[i + j] = Math.max(values[i + j], j + 1);
	                j++;    }
	        }
	        return values;
	    }
	    	
	    	// Метод поиска подстроки Кнута-Морриса-Пратта
	    public static ArrayList<Integer> KMPSearch(String text, String sample) {
	        ArrayList<Integer> found = new ArrayList<>();

	        int[] prefixFunc = prefixFunction(sample);

	        int i = 0;
	        int j = 0;

	        while (i < text.length()) {
	            if (sample.charAt(j) == text.charAt(i)) {
	                j++;
	                i++;
	            }
	            if (j == sample.length()) {
	                found.add(i - j);
	                j = prefixFunc[j - 1];
	            } else if (i < text.length() && sample.charAt(j) != text.charAt(i)) {
	                if (j != 0) {
	                    j = prefixFunc[j - 1];
	                } else {
	                    i = i + 1;
	                }
	            }
	        }

	        return found;
	    }
		
		
		public static void main(String[] args) {

	        String text =   "aabaabaaaaaabaabaabaabbaaab";
	        String sample = "aabaab";

	        System.out.println(Arrays.toString(searchNaive(text, sample).toArray()));
	        System.out.println(Arrays.toString(prefixFunction(sample)));
	        System.out.println(Arrays.toString(KMPSearch(text, sample).toArray()));
	    }
	}
