package f24_Threads;

/* 		 Определение момента завершения потока
	Нередко требуется знать, когда завершится поток. 
	В классе Thread предусмотрены два средства, позволяющие определить, завершился ли поток.
	Метод final boolean isAlive() - возвращает значение true, если поток, для которого он вызывается, все
еще выполняется. В противном случае он возвращает значение false.  
	Метод final void join() throws InterruptedException - ожидает завершения потока, для которого он был вызван. Выбор его имени
был обусловлен тем, что вызывающий поток ожидает, когда указанный поток присоединится (англ. "join") к нему. Имеется и другой 
вариант метода join (), позволяющий указать максимальное время ожидания момента завершения потока.
	*/

class MyThread5 implements Runnable {
	Thread thrd;
	
	public MyThread5(String name) {
		thrd = new Thread(this, name);
		thrd.start(); 	}
	
	@Override
	public void run() {
		System.out.println(thrd.getName() + " - запуск");
		for (int i = 0; i <10; i++) {
			try { Thread.sleep(400); 
				System.out.println(thrd.getName() + ",  " + i);}
			catch (InterruptedException e) {
				e.printStackTrace(); } 	
		}
		System.out.println(thrd.getName() + " - окончен");
	}
}

public class t04_Method_isAlive {
public static void main(String[] args) {
	System.out.println("Запуск main");
		/* Следует иметь в виду, что потоки в данном примере запускаются на выполнение в том порядке, в каком они были созданы.
		  Но так происходит не всегда. Исполняющая система Java сама планирует выполнение потоков. 		 */
	MyThread5 mythrd1 = new MyThread5("Thread #1");
	MyThread5 mythrd2 = new MyThread5("Thread #2");
	MyThread5 mythrd3 = new MyThread5("Thread #3");
	do {
		try { Thread.sleep(100); }
		catch (InterruptedException e) { e.printStackTrace(); 	}
		System.out.print(".");}
			// В данном случае ожидание завершения порожденного потока организовано с помощью метода isAlive ().
	while (mythrd1.thrd.isAlive() || mythrd2.thrd.isAlive() || mythrd3.thrd.isAlive());
		
	System.out.println("Окончание main");
	}
}
