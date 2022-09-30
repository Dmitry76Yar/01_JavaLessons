package f17_Class_Object;
/* Метод hashCode может использоваться для быстрого сравнения.
У метода equals есть большой минус – он слишком медленно работает. Допустим, у тебя есть множество(Set) из миллиона элементов, и нам нужно проверить,
содержит ли оно определенный объект или нет. Как это сделать?
Метод hashCode() для каждого объекта возвращает определенное число. Какое именно – это тоже решает разработчик класса, как и в случае с методом equals.
Давай рассмотрим ситуацию на примере:
Представь, что у тебя есть миллион 10-тизначных чисел. Тогда в качестве hashCode для каждого числа можно выбрать остаток от его деления на 100.
Это существенносузит диапазон поиска  для дальнейшего использования метода equals() для финального поиска */

import java.util.Random;

class t1_Hash_code_for_fast_search {
public static void main (String[] args){
	Random random = new Random();
	
	Integer Massive[] = new Integer[500];
	for(int i = 0; i<Massive.length; i++) {
	int a;
    a = random.nextInt(1000000000);
	Massive[i] = new Integer(a); }
	
	Integer a = Massive[120]; 
	System.out.println(a.hashCode());       // hashCode Massive[120] = 523429237
		
	// Поиск по hashCode
	for(int i = 0; i<Massive.length; i++)  
		if (Massive[i].hashCode() == 523429237)  System.out.println("Massive[" + i + " ] имеет hashCode 523429237"); 
	
	if (a.equals(Massive[120])) System.out.println("Элементы экивалентны"); 
	
	 }
}
   