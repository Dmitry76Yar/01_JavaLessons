package f18_Interfaces;

public class t6_Call_Back_for_2_actions {
	public static void main(String[] args) {
		EnterButton printButton = new EnterButton(new PrAction());
		EnterButton tvButton = new EnterButton(new TvAction());
		
			// Каждый раз передавая объекты разного класса одного интерфейса будет вызывать разное действие
		printButton.click();
		tvButton.click();
		tvButton.click();
	}
}

interface InterfaceAction {
void execute();}	

class TvAction implements InterfaceAction{
public void execute() {
	System.out.println("Телевизор включен"); 
	} 	
}

class PrAction implements InterfaceAction {
	public void execute() {
		System.out.println("Принтер начал печать");
	}
}
		
class EnterButton {
InterfaceAction action; 
EnterButton (InterfaceAction action) {
	this.action = action;}
void click() {
	action.execute();}
}