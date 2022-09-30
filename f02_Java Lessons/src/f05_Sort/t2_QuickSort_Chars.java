package f05_Sort;
/* Алгоритм быстрой сортировки Чарльза Хоара - на сегодняшний день это самый лучший универсальный алгоритм сортировки.
Принцип разделения. Сначала из массива выбирается один опорный элемент (так называемый компаранд) и массив делится на две части.
Элементы, "меньшие" опорного, помещаются в одну часть массива, а "большие или равные опорному", - в другую часть. 
Затем процесс рекурсивно повторяется для каждой оставшейся части до тех пор, пока массив не окажется отсортированным. 
Допустим, имеется массив, содержащий последовательность символов fedacb, а в качестве опорного выбран символ d. 
На первом проходе массив будет частично упорядочен следующим образом:
    исходные данные fedacb
    проход 1        bcadef
Далее этот процесс повторяется для каждой части: Ьса и def. 
Опорный элемент можно выбрать двумя способами: случайным образом или путем вычисления среднего значения части элементов массива.*/

class QuickSort {
    //Организовать вызов фактического метода быстрой сортировки
    // Отдельный метод qsort нужен, чтобы передавать методу лишь имя массива и не осуществляя первоначальное разделение. 
    static void qsort(char items[]) {
    qs(items, 0, items.length-1);}

    // Рекурсивная версия метода быстрой сортировки символов
    private static void qs(char items[], int left, int right) {
        int i, j;
        char x, y;
        i = left;    // i = left = 0;
        j = right;   // j = right = 6     
        x = items[(left + right)/2];        
       System.out.println("Выбран опорный элемент с  индексом " + ((left + right)/2) + " со значением " + x);
        
            do {
                while((items[i] < x) && (i < right)) i++;
                System.out.println("   Найден элемент левой половины массива с индексом " + i + " =  " + items[i] + "   больший опорного элемента =  " + x);
                    
                while((x <items[j]) && (j >left)) j--;
                System.out.println("   Найден элемент правой половины массива с индексом " + j + " =  " + items[j] + "   меньший опорного элемента =  " + x);  
                     
                if (i <= j){
                    System.out.print("   Происходит смена i= " + i + " и j= " + j + " элементов");
                    y = items [i];
                    items[i] = items[j];
                    items [j] = y;
                    i++; j--; } 
                    System.out.print(" \t\t" ); for(int k = 0; k < items.length; k++) System.out.print(items[k] + " "); System.out.println("\n");
                    System.out.println("   i =  " + i + "  j=  " + j);
            } 
            while (i <= j) ;
            
           if(left < j)  {System.out.println("\t left =" + left + "\t right = j = " + j);  qs(items, left, j);}
           if(i < right) {System.out.println("\t left = i = " + i + "\t right = " + right); qs(items, i, right);}
    }
}
class t2_QuickSort_Chars {
    public static void main(String args[]) {
        char a[] = {'d','x','a','r','b','z','i'};
        int i;
        System.out.print("иcxoдный массив: \t\t\t\t\t ");
        for(i=0; i < a.length; i++)
            System.out.print(a[i] + " "); System.out.println();
// Отсортировать массив
        QuickSort.qsort(a);
        System.out.print("Oтcopтиpoвaнный массив: \t\t\t\t");
        for(i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        }
    }