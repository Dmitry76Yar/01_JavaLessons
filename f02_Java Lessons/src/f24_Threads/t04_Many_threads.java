package f24_Threads;

/*  Создание нескольких потоков
В программе можно породить столько потоков, сколько требуется. 
Например, в приведенной ниже программе формируются три порожденных потока.  */

class MyThread4 implements Runnable {
	Thread thrd;
	
	public MyThread4(String name) {
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

public class t04_Many_threads {
public static void main(String[] args) {
	System.out.println("Запуск main");
		/* Следует иметь в виду, что потоки в данном примере запускаются на выполнение в том порядке, в каком они были созданы.
		  Но так происходит не всегда. Исполняющая система Java сама планирует выполнение потоков. 		 */
	MyThread4 mythrd1 = new MyThread4("Thread #1");
	MyThread4 mythrd2 = new MyThread4("Thread #2");
	MyThread4 mythrd3 = new MyThread4("Thread #3");
	for (int i = 0; i <50; i++)  {
		try { Thread.sleep(100); }
		catch (InterruptedException e) { e.printStackTrace(); 	}
		System.out.print(".");}
		
	System.out.println("Окончание main");
	
	
	
	}

}
