package f18_Interfaces;

public class t6_Call_Back_for_2_actions {
	public static void main(String[] args) {
		EnterButton printButton = new EnterButton(new PrAction());
		EnterButton tvButton = new EnterButton(new TvAction());
		
			// ������ ��� ��������� ������� ������� ������ ������ ���������� ����� �������� ������ ��������
		printButton.click();
		tvButton.click();
		tvButton.click();
	}
}

interface InterfaceAction {
void execute();}	

class TvAction implements InterfaceAction{
public void execute() {
	System.out.println("��������� �������"); 
	} 	
}

class PrAction implements InterfaceAction {
	public void execute() {
		System.out.println("������� ����� ������");
	}
}
		
class EnterButton {
InterfaceAction action; 
EnterButton (InterfaceAction action) {
	this.action = action;}
void click() {
	action.execute();}
}