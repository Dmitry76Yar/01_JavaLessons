package f18_Interfaces;

public class t5_Call_back {
    public static void main(String[] args) {
	        Button button = new Button(new ButtonClickHandler());
/* В конструкторе создается объект класса ButtonClickHandler, данный класс наследует интерфейс EventHandler
   Он передается в конструктор класса Button, где переменной этого класса handler присваивается этот переданный объект
   В итоге создается объект button класса Button, который
   	    имеет в качестве переменной button.handler - объект класса ButtonClickHandler = объект интерфейса EventHandler   */
	        button.handler.execute();  //  - поэтому можно для button.handler вызвать метод execute класса ButtonClickHandler
	        
// Если вызвать для button метод click класса Button, то вызовется метод execute для button.handler
	        button.click();  }
}
	 
class ButtonClickHandler implements EventHandler{
    public void execute() {
	        System.out.println("Кнопка нажата!");  }
	}
	 
	interface EventHandler{    
		void execute(); 	}
	 
class Button {
    EventHandler handler;				// Инициализация переменной класса Button = ссылка на объект handler интерфейса EventHandler
   	Button(EventHandler action){		// Присвоение handler объекта из конструктора
	        this.handler=action;}		// После этого имеем созданный объект интерфейса EventHandler
	public void click(){
    handler.execute();					// Метод click вызывает метод execute интерфейса EventHandler
	    }
}
