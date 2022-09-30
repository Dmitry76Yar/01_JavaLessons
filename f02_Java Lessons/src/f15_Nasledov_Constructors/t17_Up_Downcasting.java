package f15_Nasledov_Constructors;

public class t17_Up_Downcasting {
public static void main (String[] args) {
/* Суперкласс - Person, подкласс - Client */
	
/* Bосходящее преобразование от подкласса к суперклассу - upcasting. Такое преобразование осуществляется автоматически */
      Person Bob = new Client("Bob", "DeutscheBank", 3000);
      Bob.display();

/* Hисходящее преобразование от суперкласса к подклассу - downcasting, автоматически не выполняется.
Hапример, объект Person не всегда является объектом Employee или Client. 
В этом случае нам надо использовать операцию преобразования типов.  */
      Object Sam = new Client("Sam", "Oracle", 123);
      Client Sam1 = (Client)Sam;			// нисходящее преобразование от Object Sam к типу Employee Sam1
      Sam1.display();
      ((Client)Sam).display();   	//  Или можно сразу так. Без формирования второй переменной
      
/* Проверка с помощью instanceof может ли быть проведено преобразование downcasting */      
      Object Mark = new Employee ("Mark", "Microsoft");
      // Client Mark1 = (Client)Mark;   - выдаст ошибку, т.к. переменная Mark хранит объект класса Employee, но не Client
      // Проверка с помощью instanceof
     	if(Mark instanceof Client)   ((Client)Mark).display();
      	else  System.out.println("Conversion is invalid");
     		if(Mark instanceof Employee)   ((Employee)Mark).display();
     		else  System.out.println("Conversion is invalid");
    }
}
		// класс человека
class Person {
    private String name;
    public String getName() { return name; }
    public Person(String name){
        this.name=name; }
    public void display(){
	        System.out.printf("Person %s \n", name); }
}	
		// класс клиента банка
class Client extends Person{
    private int sum; // Переменная для хранения суммы на счете
    private String bank;
    public Client(String name, String bank, int sum) {
        super(name);
        this.bank=bank;
        this.sum=sum; 	    }
    public void display(){
        System.out.printf("Client %s has account in %s \n", super.getName(), bank); }
    public String getBank(){ return bank; }
    public int getSum(){ return sum; }
}
		//служащий некоторой компании 
class Employee extends Person{
	private String company;
	public Employee(String name, String company) {
		super(name);
		this.company = company;  }
 public String getCompany(){ return company; }
 public void display(){
    System.out.printf("Employee %s works in %s \n", super.getName(), company);
 }
}
