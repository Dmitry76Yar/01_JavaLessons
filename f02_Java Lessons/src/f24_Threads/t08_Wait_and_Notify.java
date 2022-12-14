package f24_Threads;
/* Организация взаимодействия потоков с помощью методов notify () , wai t () и notifyAll ()
	В качестве примера рассмотрим следующую ситуацию. Поток т, который выполняется в синхронизированном методе, нуждается в 
доступе к ресурсу R, который временно недоступен. Что делать потоку т? Начать выполнение цикла опросов в ожидании того
момента, когда освободится ресурс R? Но тогда поток т будет связывать объект, препятствуя доступу к нему других потоков. 
Такое решение малопригодно, поскольку оно сводит на нет все преимуrnества программирования в мноrопоточной среде. 
	Будет гораздо лучше, если поток т временно разблокирует объект и позволит другим потокам воспользоваться ero методами.
Когда ресурс R станет доступным, поток т получит об этом уведомление и возобновит свое исполнение. Но для того чтобы такое 
решение можно было реализовать, необходимы средства взаимодействия потоков, с помощью которых один поток моr бы сообщить
другому потоку о том, что он приостановил свое исполнение, а также получить уведомление о том, что ero исполнение может быть 
возобновлено. Для организации подобного взаимодействия потоков в Java предусмотрены методы wait (), notify () и notifyAll ().*/ 

/* Для организации подобного взаимодействия потоков в Java предусмотрены методы wait (), notify () и notifyAll (). 
   Эти методы реализованы в классе Object, поэтому они доступны для любого объекта. Но обратиться к ним можно только из 
синхронизированного контекста. А применяются они следующим образом. Когда поток временно приостанавливает свое исполнение,
он вызывает метод wait () . При этом поток переходит в состояние ожидания и монитор данного объекта освобождается, позволяя 
другим потокам использовать объект. Впоследствии ожидающий поток возобновит свое выполнение, когда другой поток войдет в тот 
же самый монитор и вызовет метод notify () или notifyAll ().
В классе Object определены следующие формы объявления метода wait () .
 - final void wait() throws InterruptedException  - переводит поток в режим ожидания до поступления уведомления
 - final void wait(long миллисекунд) throws InterruptedException - ожидание длится либо до получения уведомления, либо до тех
  пор, пока не истечет указанный промежуток времени.
 - final void wait(long миллисекунд, int наносекунд) throws InterruptedException -  позволяет точнее задавать период времени 
в наносекундах
   Ниже приведены общие формы объявления методов notify () и notifyAll ().
 - final void notify()  - возобновляется выполнение одного ожидающего потока
 - final void notifyAll() -  уведомляет все потоки об освобождении объекта, и тот поток, который имеет наивысший приоритет,
получает доступ к объекту
	Важное замечание - несмотря на то, что метод wait () должен переводить поток в состояние ожидания до тех пор, пока не 
будет вызван метод notify () или notifyAll (), иногда поток выводится из состояния ожидания вследствие так называемой ложной 
активизации. Условия для ложной активизации слишком сложны, чтобы их можно было рассмотреть в данной книге. Достаточно лишь
сказать, что компания Oracle рекомендует учитывать вероятность проявления ложной активизации и помещать вызов метода wait () 
в цикл. В этом цикле должно проверяться условие, по которому поток переводится в состояние ожидания. Именно такой подход
и применяется в приведенном ниже примере.  */

/* 		Пример применения методов wait () и notify ()
Для того, чтобы вам стала понятнее потребность в применении методов wait () и notify () в мноrопоточном программировании, 
рассмотрим пример программы, имитирующей работу часов и выводящей на экран слова "Tick" (Тик) и "Tock" (Так). 
Для этой цели создадим класс TickTock, который будет содержать два метода: tick () и tock (). Метод tick () выводит слово 
"Tick", а метод tock () - слово "Tock". При запуске программы, имитирующей часы, создаются два потока: в одном из них 
вызывается метод tick (), а в другом - метод tock (). В результате взаимодействия двух потоков на экран будет выводиться набор
повторяющихся сообщений "Tick Tock", т.е. после слова "Tick", обозначающего один такт, должно следовать слово "Tock",
обозначающее другой такт часов.   */

class TickTock {
	String state;					// содержит сведения о состоянии часов
	
	synchronized void tick (boolean running) {
		/* Условие if необходимо для завершения работы программы: из main вызывается 5 раз метод с runnung = true и далее
	метод с running = false. При вызове с false вызывается метод notify для того, чтобы ожидающий поток запустился. Если бы 
	не было этого последнего вызова notify(), то ожидающий поток ожидал бы бесконечно и программа бы зависла. 
	В if нет вызова wait(), т.е. не проиходит остановки действующего потока, а происходит только разблокировка ожидающего потока	 */
		if (running != true)  {
			state = "ticked";
			notify(); 
			return;}
		
		/* Основная часть метода заключается в: печати "Tick", вызове ожидающего метода с помощью notify() и остановки текущего
	потока с помощью wait(). В итоге выполнение метода tick () будет приостановлено до тех пор, пока другой поток не вызовет 
	метод notify () для того же самого объекта.
		Как результат, когда вызывается метод tick (), на экран выводится слово "Tick" и другой поток получает возможность
	продолжить свое исполнение, а затем выполнение этого метода приостанавливается.
		Важно, что для избежания ложной активации ожидающего метода (по причинам отличным от вызова его	методом notify())
	в цикл while введена проверка состояние переменной state - пока состояние переменной state не измениться на "tocked"
	будет сохранено ожидание. Изменение на "tocked" означает, что метод был завершен вторым потоком и можно снова вызывать 
	первый 	поток. В противном случае, если по окончании ожидания в переменной state не будет присутствовать значение "tocked", значит,
	имела место ложная активизация, и метод wait () будет вызван снова. */
		System.out.print("Tick  ");  
		state = "ticked";						// Меняет состояние state на ticked, что означает, что метод tick() отработал
		notify(); 								// Посылает уведомление ожидающему потоку для его вызова
		while (state.equals("tocked") != true) {	
			try { wait(); } 				    // Ожидать до завершения работы второго потока
			catch (InterruptedException e) { 
				System.out.println("Пpepывaниe потока");
				e.printStackTrace();	} 
		}
	}
	
	synchronized void tock (boolean running) {
		if (running != true) {
			state  = "tocked";
			notify();
			return;	}
		System.out.println("Tock");
		state = "tocked";
		notify();
		while (state.equals("ticked") != true) {
			try { 	wait(); } 
			catch (InterruptedException e) {
			System.out.println("Пpepывaниe потока");
			e.printStackTrace();	} 
		}
	}		
}

class MyThread9 implements Runnable {
	Thread thrd; 
	TickTock ttOb;
	public MyThread9(String name, TickTock ttOb) {
		thrd = new Thread(this, name);
		this.ttOb = ttOb;
		thrd.start(); }
	
	@Override
	public void run() {
		if (thrd.getName().equals("Tick") == true) {
			for (int i = 0; i<5; i++) ttOb.tick(true);
			ttOb.tick(false); }
		else {
			for (int i = 0; i<5; i++) ttOb.tock(true);
			ttOb.tock(false); }
	}
}

public class t08_Wait_and_Notify {
public static void main(String[] args) {
	TickTock tt = new TickTock();
	
	MyThread9 mt1 = new MyThread9("Tick", tt);
	MyThread9 mt2 = new MyThread9("Tock", tt);
	
	try {
		mt1.thrd.join();
		mt2.thrd.join();}
	catch(InterruptedException ехс) {
	System.out.println("Пpepывaниe основного потока");}
	
	
	}

}


