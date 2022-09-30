package f22_In_Out_Streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class t05_Copy_txt_file {
public static void main(String[] args) {
	
	FileInputStream fis = null;
	FileOutputStream fos = null;
	int i = 0;
	
	try {
		fis = new FileInputStream("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\CopyFrom.txt");
		fos = new FileOutputStream("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\CopyIn1.txt");
	} catch (FileNotFoundException e) {
		System.out.println("������ �������� ������");
		e.printStackTrace(); }
	
	try {
		while (fis.available() >0) {			// ���� �������� ������������� �����
			i = fis.read();						// ������������ ������ �����
			if (i!=-1) fos.write((char)(i));}}
	catch (Exception e) {
		e.getStackTrace();
		System.out.println("������ ������ - ������"); }
	
	finally {
		try {
			if(fis != null) fis.close();}
		catch (Exception e) {
			e.getStackTrace();  System.out.println("O����a ��� �������� Input �����"); } 	
		try {
			if(fos != null) fos.close(); }
		catch (Exception e) {
			e.getStackTrace();  System.out.println("O����a ��� �������� Output �����"); } 	}
	
	System.out.println("Main �������� �������");	
	}
}
