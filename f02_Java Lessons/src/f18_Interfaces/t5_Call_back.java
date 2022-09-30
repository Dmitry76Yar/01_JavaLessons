package f18_Interfaces;

public class t5_Call_back {
    public static void main(String[] args) {
	        Button button = new Button(new ButtonClickHandler());
/* � ������������ ��������� ������ ������ ButtonClickHandler, ������ ����� ��������� ��������� EventHandler
   �� ���������� � ����������� ������ Button, ��� ���������� ����� ������ handler ������������� ���� ���������� ������
   � ����� ��������� ������ button ������ Button, �������
   	    ����� � �������� ���������� button.handler - ������ ������ ButtonClickHandler = ������ ���������� EventHandler   */
	        button.handler.execute();  //  - ������� ����� ��� button.handler ������� ����� execute ������ ButtonClickHandler
	        
// ���� ������� ��� button ����� click ������ Button, �� ��������� ����� execute ��� button.handler
	        button.click();  }
}
	 
class ButtonClickHandler implements EventHandler{
    public void execute() {
	        System.out.println("������ ������!");  }
	}
	 
	interface EventHandler{    
		void execute(); 	}
	 
class Button {
    EventHandler handler;				// ������������� ���������� ������ Button = ������ �� ������ handler ���������� EventHandler
   	Button(EventHandler action){		// ���������� handler ������� �� ������������
	        this.handler=action;}		// ����� ����� ����� ��������� ������ ���������� EventHandler
	public void click(){
    handler.execute();					// ����� click �������� ����� execute ���������� EventHandler
	    }
}
