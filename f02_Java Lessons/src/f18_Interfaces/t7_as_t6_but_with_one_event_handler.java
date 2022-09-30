package f18_Interfaces;

public class t7_as_t6_but_with_one_event_handler {
	public static void main(String[] args) {
		// Определение метода execute интерфейса делается сразу в конструкторе объекта класса PushButton
		
		PushButton printButton = new PushButton(new CommonEventHandler() {
			public void execute() {
				System.out.println("Печать начата"); }
		});
		
		PushButton TvButton = new PushButton(new CommonEventHandler() {
			public void execute() {
				System.out.println("Телевизор включен"); }
		});
		
		printButton.click();
		TvButton.click();
		TvButton.click();
	}
}

interface CommonEventHandler {
	void execute();}	

class PushButton {
	CommonEventHandler action; 
	PushButton (CommonEventHandler action) {
		this.action = action;}
	void click() {
		action.execute();}
}