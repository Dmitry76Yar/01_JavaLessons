package f24_Threads;

/* 		 Определение момента завершения потока
Нередко требуется знать, когда завершится поток. 
В классе Thread предусмотрены два средства, позволяющие определить, завершился ли поток.
Метод final boolean isAlive() - возвращает значение true, если поток, для которого он вызывается, все
еще выполняется. В противном случае он возвращает значение false.  

Метод final void join() throws InterruptedException - ожидает завершения потока, для которого он был вызван. Выбор его имени
был обусловлен тем, что вызывающий поток ожидает, когда указанный поток присоединится (англ. "join") к нему. Имеется и другой 
вариант метода join (), позволяющий указать максимальное время ожидания момента завершения потока.  	

В приведенном ниже примере программы наличие метода join () гарантирует, что основной поток завершит работу последним */

class MyThread6 implements Runnable {
	Thread thrd;
	
	public MyThread6(String name) {
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

public class t05_Method_JOIN {
public static void main(String[] args) {
	System.out.println("Запуск main");
		/* Следует иметь в виду, что потоки в данном примере запускаются на выполнение в том порядке, в каком они были созданы.
		  Но так происходит не всегда. Исполняющая система Java сама планирует выполнение потоков. 		 */
	MyThread5 mythrd1 = new MyThread5("Thread #1");
	MyThread5 mythrd2 = new MyThread5("Thread #2");
	MyThread5 mythrd3 = new MyThread5("Thread #3");
		
	/* Метод final void join() throws InterruptedException - ожидает завершения потока, для которого он был вызван. Выбор его имени
	был обусловлен тем, что вызывающий поток ожидает, когда указанный поток присоединится (англ. "join") к нему. Имеется и другой 
	вариант метода join (), позволяющий указать максимальное время ожидания момента завершения потока.  	*/
	
	try {
		mythrd1.thrd.join();			// Ожидание до тех пор, пока указанный метод не завершится
		System.out.println("Child #1 - присоединен");
		mythrd2.thrd.join();			// Ожидание до тех пор, пока указанный метод не завершится
		System.out.println("Child #2 - присоединен");
		mythrd3.thrd.join();			// Ожидание до тех пор, пока указанный метод не завершится
		System.out.println("Child #3 - присоединен");	
	}
		catch (InterruptedException e) { e.printStackTrace(); 	}
		System.out.print("Пpepывaниe основного потока");
		
			// В итоге всо операции в main начинаются только после завершения работы других потоков
		for (int i = 0; i <50; i++)  {
			try { Thread.sleep(100); }
			catch (InterruptedException e) { e.printStackTrace(); 	}
			System.out.print(".");}
		
	System.out.println("Зaвepшeниe основного потока");
		// Как видите, после того как вызываемый метод join () возвращает управление, выполнение потока прекращается.
	
	}
}
