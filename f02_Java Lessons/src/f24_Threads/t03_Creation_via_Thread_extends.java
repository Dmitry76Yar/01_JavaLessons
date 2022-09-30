package f24_Threads;
/*		Расширение класса Тhread
Реализация интерфейса Runnable в примерах t01 и t02  - это лишь ОДИН ИЗ способов получения экземпляров потоковых объектов. 
Другой способ состоит в создании подкласса, производного от класса Thread. В этом проекте будет продемонстрировано, каким образом
расширение класса Thread позволяет реализовать такие же функциональные возможности, как и рассмотренная в t01 и t02
	Подкласс, производный от класса Thread, должен переопределить метод run () , который является точкой входа в новый поток. 
Для того чтобы начать исполнение нового потока, следует вызвать метод start (). Можно также переопределить и друтие методы 
из класса Thread, но делать это не обязательно. Поэтапное описание процесса создания программы приведено ниже.  */

/*	Зачем нужны два способа создания порожденных потоков (расширение класса Thread и реализация интерфейса Runnable)?
 ОТВЕТ. В классе Thread имеется несколько методов, которые можно переопределить в порожденном классе. Из них обязательному 
 переопределению подлежит только метод run () . Этот же метод, безусловно, должен быть определен и при реализации интерфейса
 Runnable. 
 	Некоторые программисты считают, что создавать подкласс, порожденный от класса Thread, следует только в том случае, если
требуется дополнить его новыми функциями. Так, если переопределять любые другие методы из класса Thread не нужно, то можно
ограничиться только реализацией интерфейса Runnable. Кроме того, реализация интерфейса Runnable позволяет создаваемому потоку 
наследовать класс, отличающийся от Thread.  */

			// Теперь класс MyThread3 наследует класс Thread, но не implements Runnable
class MyThread3 extends Thread {
	String name;
				// Создать новый поток		 
	public MyThread3(String name) {
			/* Здесь в конструктор класса MyThread3 передается имя потока,
	далее сразу же в конструкторе создается объект класса Thread и в его конструктор типа Thread(Runnable threadOb, String имя)
	передается объект класса MyThread2 и имя потока из вызова конструктора  */
			/* Присвоить имя потоку
	Ключевое слово super используется для вызова следующего варианта конструктора Thread: Thread { String имя) */
		super(name);		 
		start();}			// Запустить поток
	
			// Точка входа в поток
	public void run() {
			// Получить имя потока можно, используя метод getName (), определенный в классе Thread.
		System.out.println(getName() + " - запуск");
		try {
			for(int count = 0; count < 10; count++) {
				Thread.sleep(400);
				System.out.println("B " + getName() + ", счетчик: " + count);} 		}
		catch(InterruptedException ехс) {
			System.out.println(getName() + " - прерван");}
		System.out.println(getName() + " - завершение");
	}
}

public class t03_Creation_via_Thread_extends{
public static void main(String[] args) {
	System.out.println("Зaпycк основного потока");
		// При создании объекта класса MyThread, в его конструкторе сразу создается объект класса Thread - потоk
	// и данный поток сразу же запускается через строку thrd.start() в конструкторе
	MyThread3 mt = new MyThread3("Child #1");
	
	/* Т.к. в методе sleep () может быть сгенерировано исключение InterruptedException, то его нужно вызывать в блоке try.
 Имеется и другой вариант метода sleep (), позволяющий точнее указывать 	 */
	/* В методе main () определен цикл for, который повторяется 50 раз с задержкой 100 мс на каждом шаге цикла.
  ОБА ПОТОКА ПРОДОЛЖАЮТ ВЫПОЛНЯТЬСЯ, разделяя ресурсы ЦП в однопроцессорной системе до тех пор, пока циклы в них не завершатся */
	
	for(int i = 0; i<50; i++) {
		System.out.print(".");
		try {
			Thread.sleep(100);}
		catch(InterruptedException ехс) {
			System.out.println("Пpepывaниe основного потока");}
	}
		System.out.println("Зaвepшeниe основного потока");
		
	/*  Различий во временных характеристиках обоих потоков в примере хватает для того, чтобы основной поток в методе main () 
завершился последним, но на практике этого, как правило, оказывается недостаточно. В Java предоставляются более совершенные 
способы, позволяющие организовать ожидание завершения потока.
	ВОПРОС. Почему основной поток рекомендуется завершать последним?
ОТВЕТ. В основном потоке удобно выполнять действия по подготовке к завершению программы, например закрывать файлы. Именно
поэтому основной поток желательно завершать последним. К счастью, организовать ожидание в основном потоке завершения 
порожденных потоков совсем не сложно
	 */

	}
}