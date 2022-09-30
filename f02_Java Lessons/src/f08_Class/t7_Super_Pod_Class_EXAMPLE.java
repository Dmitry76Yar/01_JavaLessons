package f08_Class;
import java.util.ArrayList;

class Employee2 {						// Суперкласс по определению любого работника
	private String name;				/* - Имя работника в String  */
	private double salary;				/* - Оклад работника в Double  */
	private Employee2 boss;				/* - Босс работника, как объект класса Employee */
	
		public String getName() {return name;	}			public void setName(String name) {this.name = name;	}
		public double getSalary() {return salary;}			public void setSalary(double salary) {this.salary = salary;	}
		public Employee2 getBoss() {return boss; }			public void setBoss(Employee2 boss) { this.boss = boss; }
		
	public Employee2(String name, double salary) {
		this.name = name;
		this.salary = salary;	
		Employee2 boss = null;}
			
	public double raiseSalary (int byPercent) {    // Метод по расчету увеличения зарплаты на byPercent%
		salary = salary*(100 + byPercent)/100; 
		return salary;}
	
	public void show () {
		System.out.printf("Specialist:\tИмя - %s,\tОклад -   %.2f,\tИмя руководителя - %s \n", getName(), getSalary(), getBoss().getName());}
}

class Manager extends Employee2 {	// Подкласс по определению руководителя, отличие - имеет также премию в зарплате
	private double bonus;
		public void setBonus(double bonus) { this.bonus = bonus; }
	
	public Manager(String name, double salary, double bonus) {
		super(name, salary);		// Вызов конструктора суперкласса. Должен стоять на первом месте
		this.bonus = bonus;}
	
	@Override		
		/* Переопределение метода getSalary() для менеджера (добавление премии в зарплату)
	 	   Методу надкласса недоступны private переменные суперкласса, поэтому вызываем метод getSalary() через кл.слово SUPER
	 	   Слово SUPER - является прямой директивой на использование метода суперкласса */
	public double getSalary() {return (super.getSalary() + bonus);}    

	@Override
	// Переопределение метода raiseSalary для менеджера (добавление премии в зарплату)
	public double raiseSalary (int byPercent) {    
		double x = 0;
		x = getSalary();
		x = getSalary()*(100 + byPercent)/100;
		super.setSalary(x-bonus);
		return x;}
	
	/*  Переопределение метода с setBoss(Employee boss) на setBoss(Manager boss) НЕВОЗМОЖНО, т.к. типы параметра метода должен совпадать
	    Если мы уберем аннотацию "@Override", то метод создастся, но это будет дубликат метода и это может привести к ошибкам
	    Вот почему важно писать аннотацию "@Override" - компилятор сразу выдаст ошибку невозможности переопределения
	  @Override
	public void setBoss(Manager boss) { this.boss = boss; }  */ 
	
	@Override
	/* РАЗРЕШАЕТСЯ переопределение метода Employee getBoss() с изменением типа возвращаемой переменной на Manager getBoss()  
	Метод переопределяется, т.к. руководитель босса - также руководитель   */
	public Manager getBoss() {return (Manager) super.getBoss(); }
}
public class t7_Super_Pod_Class_EXAMPLE {
public static void main(String args[]) {
	Employee2 purchaseSpecialist = new Employee2 ("Anna Khodikina", 40000.00); 
	Manager purchaseManager = new Manager ("Elena Leonova", 60000.00, 20000.00);
	Manager financeDirector = new Manager ("Lubov Kachalova", 100000, 30000);
	
	purchaseSpecialist.setBoss(purchaseManager);
	purchaseManager.setBoss(financeDirector);
	financeDirector.setBoss(new Manager ("Нет прямого руководителя", 0.00, 0.00));
	
	purchaseSpecialist.show();
	purchaseManager.show();
	financeDirector.show();

	/* Процесс динамического поиска метода 
	   Разрешается присваивать объект подкласса, переменной-ссылке, которая относится к суперклассу
	   Ниже идет присваивание объекта суперкласса purchaseManager ссылке подкласса  Employee2
	   Это удобный инструмент обращения метода единого для под- и суперкласса СРАЗУ ко всем объектам (и к Employee2, и к Manager)
	   При этом для объекта класса Manager вызывается метод именно его класса (хотя ссылка и принадлежит суперклассу) - это процесс динамического поиска метода   */

	ArrayList <Employee2> employesList= new ArrayList <Employee2>();
employesList.add(purchaseSpecialist);
employesList.add(purchaseManager);
employesList.add(financeDirector);

for (Employee2 x : employesList) x.raiseSalary(10);
System.out.println("\t\t После роста зарплаты");
for (Employee2 x : employesList)	x.show(); 

	/* Приведение типов 
	   Есть один недостаток такого подхода (вызова метода уникального для подкласса через ссылку суперкласса) - не получится вызвать 
	   метод подкласса, который отсутствует в суперклассе */

	//Метод setBonus() вызывается для объекта подкласса Manager через ссылку подкласса purchaseManager
purchaseManager.setBonus(30000);   

	// НО метод setBonus() невозможнo вызвать для объекта подкласса Manager через ссылку суперкласса Employee2, т.к. в нем нет этого метода
// employesList.get(1).setBonus(30000)      

	// Для этого сначала проверяют через instanceof принадлежит ли ссылка необъодимому классу и если нет то делают присваивание, как ниже  
for (Employee2 x : employesList) {
if (x instanceof Manager) {
	Manager temp = (Manager)employesList.get(1);
	temp.setBonus(35000);
	System.out.printf("\t Объекту с именем " + x.getName() + "задан бонус 35000 \n");
	}
else System.out.println("\t Объект " + x.getName() + " принадлежит к классу отличному от Manager и не содержит метод setBonus() ");
}

 
}
}
