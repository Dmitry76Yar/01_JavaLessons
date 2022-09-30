package f00_Basic;

class t1_Short_operations{
    public static void main (String[] args){
        int a,b,c,d,e,f;
        a = b = f = 0;
        c = 2; d = 20; e = 19;
        System.out.println(" знак += означает увеличение переменной на число справа    a= " + (a+=10));
        System.out.println(" знак -= означает уменьшение переменной на число справа    b= " + (b-=10));
        System.out.println(" знак *= означает умножением переменной на число справа    c= " + (c*=10));
        System.out.println(" знак /= означает деление переменной на число справа       d= " + (d/=4));
        System.out.println(" знак %= означает возврат остатка от деления переменной на число справа    e = " + (e%=10));
		
		// Определение целое ли число    1-ый вариант
		double g = 2.5;
		double h; 
		h = (g*10)%10; 
		System.out.println(" Число h= " + h);
		if (h==0) 	System.out.println(" Число g является целым");
		else 		System.out.println(" Число g неявляется целым");
		
		// Определение целое ли число    2-ой вариант
		g = 2.5;
		double diff = g - (int)g;
		System.out.println(" Число diff = " + diff);
		if (diff ==0) 	System.out.println(" Число g является целым");
		else 		System.out.println(" Число g неявляется целым");
		
        
    }
}