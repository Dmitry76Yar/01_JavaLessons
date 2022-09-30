package f08_Class;

import java.util.Arrays;

/*Вложенный класс не может существовать независимо от класса, в который он вложен. Следовательно, область действия вложенного
класса ограничена его внешним классом. Если вложенный класс объявлен в пределах области действия внешнего класса,
то он становится членом последнего.*/

/* В программе
 Во внешнем классе Outer есть метод, который выводит на печать мин и макс из массива чисел, САМ НЕ СЧиТАЕТ
 Во внутреннем классе Inner метод min и max расчитывают мин и макс массива из их внешенего класса Outer 
 Конечно, для обращения в методам min и max неоходимо создать объект внутреннего класса */
 
class Outer {
    int nums[]; 
    
    Outer (int n[]) {nums = n;}			// Конструктор внешнего класса, добавляет массив
    
    void Analyze () {
        Inner InnerObject = new Inner();
        System.out.println("Минимyм: " + InnerObject.min());
        System.out.println("Maкcимyм: " + InnerObject.max());}

    // Внутренний класс
    class Inner {
        int min () {
        	System.out.println("При вызове метода min внутренний класс имеет доступ к массиву nums из внешнего класса - " + Arrays.toString(nums));
        	int m = nums[0];
        	for(int i = 1; i <nums.length; i++) 
        		if (nums[i] < m)    m = nums[i];
        return m;}
        
        int max() {
        	int m = nums[0];
        	for(int i = 1; i <nums.length; i++) 
        		if (nums[i] > m)    m = nums[i];
        	return m;}
    } // Конец внутреннего класса Inner
} // Конец внешнего класса Outer
     
public class t4_Internal_class{
public static void main(String[] args) {
   int x[] = {3,4,1,7,4,9};
   Outer OuterObject = new Outer(x);
   OuterObject.Analyze();
    }
}  
   