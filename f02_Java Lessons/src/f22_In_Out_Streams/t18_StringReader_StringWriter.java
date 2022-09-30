package f22_In_Out_Streams;

import java.io.*;

/*		StringReader � StringWriter
 	StringReader - ���������� ����� �����, ��������� ������������ ������ Reader
 	StringWriter - ���������� ����� ������, ��������� ������������ ������ Writer
 ��� ������ � ��� ���������� ���������� ����������� ������� Reader � Writer. � ����������� ������� FileReader � FileWriter.
 ��, � ������� �� ���, ��� �������� �� � ������� � ����� �� �����, � �� ������� (String) ����������� � ������ Java-������.
 	������ ����� ������ ������ ��������� 
StringReader � ���, ����������, ���������� ����� ������� String � Reader. 
� StringWriter � ��� ������, ������� ������������ �� Writer.

���� ������, ��� ������ ���������������� �����-������� ����� ������-������ StringReader � StringWriter
  */

public class t18_StringReader_StringWriter {
	
public static void execute (Reader reader, Writer writer) throws IOException {
		// ������������� ����� 	BufferedReader, ������� � ����������� ������-����� reader
	BufferedReader bfr = new BufferedReader(reader);
		// ������������� ������ line ��� ������ ����� �� ������ BufferedReader bfr 
	String line; 
	while ((line = bfr.readLine()) != null) {
			// ������������� ������ ������ StringBuilder, ����� �������� ����� reverse 
		StringBuilder sbr = new StringBuilder (line);
		String newLine = sbr.reverse().toString();	
			// �������� �� ������ ������, ������������� � StringBuilder, �����������, �������� �� writer
	writer.write(newLine);	}
}
public static void main(String[] args) throws IOException {
	String test = "Hi!\n My name is Richard\n I'm a photographer\n";
		// ������������� ������-����� StringWriter writer ��� ������ ���������� ������ execute 
	StringWriter writer = new StringWriter();
	
		// ����������� ������ test � �������� c�����-������ StringReader 
	StringReader reader = new StringReader(test);
		// ��������� ����� � ������� �������� ��������������� ������ � �������� ��������� writer 
	execute(reader, writer);
	System.out.println(writer.toString());
	}
}
