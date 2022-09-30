package f22_In_Out_Streams;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

class WorkWithFile {
	private String path;			// ����������-���� � �����
	private RandomAccessFile file;	// ��������� ������, ������� �������� �������� � ������ 
	
	public WorkWithFile(String path) {	//����������� �������������� ���� � �����
		this.path = path; 	}

		// ����� ������������� ������� �� ��������� ������
	public long goTo (int num) {
		long pointer = 0;
		try { file = new RandomAccessFile(path, "r"); } 	// �������������� ����� RandomAccessFile, � ��������� �������� ���� � �����
		catch (FileNotFoundException e) {					// � ����������� ������� �������, ��� ���� ��������� ������ ��� ������
			e.printStackTrace();
			System.out.println("���� �� ������"); } 	 
		// ��������� �� num ������	
		try {
			file.seek(num);
				// �������� ������� ��������� ������� � �����
			pointer = file.getFilePointer();}
		catch (IOException e) { System.out.println("������ ������ �����"); }
		try {
			file.close();}
		catch (IOException e) {System.out.println("������ �������� �����"); }
			return pointer;}
	
		// ����� ������ ����� � ������ ��� � ������
	public String read( ) {
		String result = "";
		int b = 0;
		try { file = new RandomAccessFile(path, "r"); } 	// �������������� ����� RandomAccessFile, � ��������� �������� ���� � �����
		catch (FileNotFoundException e) {					// � ����������� ������� �������, ��� ���� ��������� ������ ��� ������
			e.printStackTrace();
			System.out.println("���� �� ������"); }
		try {
			while (b!=-1) {
				b = file.read();
				result = result + (char)b;}}
		catch (IOException e) { System.out.println("������ ������ �����"); }
		try {
			file.close();}
		catch (IOException e) {System.out.println("������ �������� �����"); }
			return result;}
	
		// ����� ������ ����� � ������������� ������� � ������ ��� � ������
	public String readFrom (int numberSymbol) {
		String result = "";
		int b = 0;
		try { file = new RandomAccessFile(path, "r"); } 	
		catch (FileNotFoundException e) {					
			e.printStackTrace();
			System.out.println("���� �� ������"); }
		try {
				// ������ ��������� �� ������ ��� ������
			file.seek(numberSymbol);
			while (b!=-1) {
				b = file.read();
				result = result + (char)b;}}
		catch (IOException e) { System.out.println("������ ������ �����"); }
		try {
			file.close();}
		catch (IOException e) {System.out.println("������ �������� �����"); }
			return result;}

		// ����� ������ � ���� ������
	public void write (String str) {
		try { file = new RandomAccessFile(path, "rw"); } 	// ��������� ���� ��� ������, ��� ����� ��������� ����������� rw (read & write)
		catch (FileNotFoundException e) {					
			e.printStackTrace();
			System.out.println("���� �� ������"); }
			// ���������� ������ ������������ � ����
		try {
			file.write(str.getBytes());}
		catch (IOException e) { System.out.println("������ ������ � ����"); }
		try {
			file.close();}
		catch (IOException e) {System.out.println("������ �������� �����"); }
	}
}
		
public class t21_RandomAccessFile_Exam {
public static void main(String[] args) {
		// ������� ��������� ������ ��� �� �������
	WorkWithFile worker; 
		// �������������� ����� ��������� � ���� ���� � �����
	worker = new WorkWithFile("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Data1");
	
		// ����� ������������ ����� � ����
	worker.write("Give me a break from your take and your take. \n" +
            "Come on and give me a break,\n" +
            "what do you want from me?\n" +
            "Feeding the rich with that son of a bitch.\n" +
            "Well that son of a bitch,\n" +
            "he looks just like me!\n" +
            "Yeah, yeah");
	
		// ��������� �� ��������� ������ � �����
    System.out.println(worker.goTo(100));
    System.out.println("*******");	

    	// ������ ���� ����
    System.out.println(worker.read());
    System.out.println("*******");
    
    	// ������ ���� � ���������� �������
    System.out.println(worker.readFrom(105));
	
	}
}
