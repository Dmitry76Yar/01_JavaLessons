package t23_Files_Path;

import java.io.File;
import java.io.IOException;

/* 		����� File
� ������� �� ����������� ������� �����/������, ����� File �������� �� � ��������, � �������� ��������������� � �������.
������ ����� ��������� �������� ���������� � �����: ����� �������, ����� � ���� ��������, ���� � ��������. � ����� ������������ 
��������� �� ��������� ������������.
	�������
������� - ��� ������ ������ File, ������� �������� ������ ������ ������ � ���������. ����� �������� ������� ������ File, ��������� 
���������, ��� ����� isDirectory() ������ �������� true. � ����� �� ������ �������� ����� list().
��� �������� �������� ����� ������������ ����� mkdir(), ������� ������ true � �������� ������. ���� ��������� ���� ��� ���������� 
��� ������� ������ ������� ��-�� ���������� ������� ���� � ����, �� �������� false.
����� mkdirs() ������ ��� �������, ��� � ���� ��� ���������.

		�� � Java 7 ��������� ����� ������ �������� ������ � ������� � ����������.
��� ��������� ��-�� ����, ��� � ������ File ��� ��� �����������. ��������, � ��� �� ���� ������ copy(), ������� �������� �� 
����������� ���� �� ������ ����� � ������ (�������� ��, ���� ����������� �������).
	����� ����, � ������ File ���� ���������� ����� �������, ������� ���������� boolean-��������. ��� ������ ����� ����� ���������� false, � �� ����������� ����������, ��� ������ ����������� ������ � ������������ �� ������ ����� ��������� �����.
	������ ������� ������ File ��������� ����� 3 ������: Paths, Path � Files. �� � ���� ���� ������, Path � ��� ���������, � �� �����.
 

��� �������� �������� ������ File ����� ������������ ���� �� ��������� �������������:
File(File dir, String name) � ����������� ������ ������ File (�������) � ��� �����
File(String path) � ����������� ���� � ����� ��� �������� ����� �����
File(String dirPath, String name) � ����������� ���� � ����� � ��� �����
File(URI uri) � ����������� ������� URI, ����������� ����
  
  		������������:
 - File(File parent, String child) - ����������� ������� ������ File (�������) � ��� �����
 - File(String pathname) - ����������� ���� � ����� ��� �������� ����� �����
 - File(String parent, String child) - ����������� ���� � ����� � ��� �����
 - File(URI uri) - ����������� ������� URI, ����������� ����
 		������
 	����� File ����� �������������� ��� �������� �������� ��� ������ ���������. ����� ����� ������ �������� ������ (������, ���� 
 ���������� ���������, ����� ������/������), ���������� � ������ ���� (���� ��� �������) ��������� ������ File, ������� ����.
 - public String getName() - ���������� ��� ����� ��� ��������, �� ���������� ������������ ����� ����.
 - public String getParent() -���������� ��������� ���� �������� ������������ ����, ��� null, ���� ���� �� ��������� ������������ �������.
 - public File getParentFile() - ���������� ����������� ���� �������� ������������ ����, ��� null, ���� ���� �� ��������� ������������ �������.
 - public String getPath() - ����������� ����������� ���� � ������.
 - public boolean isAbsolute() - �������, �������� �� ����������� ���� ����������. ���������� true, ���� ����������� ���� �������� ����������, ����� false.
 - public String getAbsolutePath() - ���������� ������� ���������� ����.
 - public boolean canRead() - ���������, ����� �� ���������� ��������� ����, �� ���������� ������������ ����� ����. ���������� true ����� � ������ �����, ����� ����, ��������� � ����������� ����, ���������� � ����� ���� �������� �����������; � ��������� ������ false.
 - public boolean canWrite() - ���������, ����� �� ���������� �������� ����, �� ���������� ������������ ����� ����. ���������� true ����� � ������ �����, ����� �������� ������� ���������� �������� ����, �� ���������� ������������ ����� ����, � ���������� ��������� ���������� � ����; � ��������� ������ false.
 - public boolean exists() - ���������, ���������� �� ���� ��� �������, �� ���������� ������������ ����� ����. ���������� true ����� � ������ �����, ����� ���������� ���� ��� �������, �� ���������� ������������ ����� ����; � ��������� ������ false.
 - public boolean isDirectory() - ���������, �������� �� ����, �� ���������� ������������ ����� ����, ���������. ���������� true ����� � ������ �����, ����� ����, ������������ ���� ����������� ������, ���������� � �������� ���������; � ��������� ������ false.
 - public boolean isFile() - ���������, �������� �� ����, �� ���������� ������������ ����� ����, ���������� ������. ���� �������� 
 			����������, ���� �� �� �������� ��������� �, ����� ����, ������������� ������ ��������� ���������. ����� ���� ���
 			��������, ��������� ����������� Java, �������������� �������� ���������� ������. ���������� true ����� � ������ �����, 
 			����� ����, ������������ ���� ����������� ������ ������, ���������� � �������� ���������� ������; � ��������� ������ false.
 - public long lastModified() - ���������� ����� ���������� ��������� �����, �� ���������� ������������ ����� ����. ���������� ������� ��������, �������������� ����� ���������� ��������� �����, ���������� � ������������� � ����� (00:00:00 GMT, 1 ������ 1970 �.) ��� 0L, ���� ���� �� ���������� ��� ��������� ������ �����-������.
 - public long length() - ���������� ����� �����, ������������� ���� ����������� ������ ����. ������������ �������� �� �������, ���� ���� ��������� �� �������.
 - public boolean createNewFile() throws IOException - �������� ������� ����� ������ ����, ��������� ���� ����������� ������ ����, 
 			����� � ������ �����, ����� ���� � ���� ������ ��� �� ����������. ���������� true, ���� ��������� ���� �� ���������� � 
 			��� ������� ������; false, ���� ����������� ���� ��� ����������.
 - public boolean delete() - ������� ���� ��� �������, �� ���������� ������������ ����� ����. ���� ��� ��� ���� ���������� �������, 
 			������� ������ ���� ������, ����� ��� ����� ���� �������. ���������� true ����� � ������ �����, ����� ���� ��� �������
 			������� �������; � ��������� ������ false.
 - public void deleteOnExit() - ������, ����� ���� ��� �������, ������������ ������ ����������� ������ ������, ���� ������� ���
  			���������� ������ ����������� ������.
 - public String[] list() - ���������� ������ �����, ���������� ����� � �������� � ��������, ������������ ���� ����������� ������ ����.
 - public String[] list(FilenameFilter filter) - ���������� ������ �����, ���������� ����� � �������� � ��������, ������������ ���� 
 			����������� ������ ������ ����, ������� ������������� ���������� �������.
 - public File[] listFiles() - ���������� ������ ����������� �����, ������������ ����� � ��������, ������������ ���� ����������� ������ ����.
 - public File[] listFiles(FileFilter filter) - ���������� ������ ����������� �����, ������������ ����� � �������� � ��������, 
 			������������ ���� ����������� ������ ������ ����, ������� ������������� ���������� �������.
 - public boolean mkdir() - ������� ������� � ������ ����� ������������ ����. ���������� true ����� � ������ �����, ����� ������� ��� ������, � ��������� ������ false.
 - public boolean mkdirs() - ������� ������� � ������ ����� ������������ ����, ������� ����� �����������, �� �������������� 
 			������������ ��������. ���������� true ����� � ������ �����, ����� ������� ��� ������ ������ �� ����� ������������ ������������� ����������, � ��������� ������ false.
 - public boolean renameTo(File dest) - ��������������� ����, ������������ ���� ����������� ������ ������. ���������� true ����� � ������ �����, ����� �������������� ��������� �������, � ��������� ������ false.
 - public boolean setLastModified(long time) - ������������� ��������� ������������ ����� ����� ��� �������� � ������ ����� ������������ ����. ���������� true ����� � ������ �����, ����� �������� ��������� �������, � ��������� ������ false.
 - public boolean setReadOnly() - �������� ���� ��� ������� � ������ ����� ������������ ����, ����� ��������� ������ �������� ������.
  		���������� true ����� � ������ �����, ����� �������� ��������� �������, � ��������� ������ false.
 - public static File createTempFile(String prefix, String suffix, File directory) throws IOException - ������� ����� ������ ���� � 
 		��������� ��������, ��������� ��������� prefix � suffix, ����� ������������� ��� ���. ���������� ����������� ����, 
 		������������ ����� ��������� ������ ����.
 - public static File createTempFile(String prefix, String suffix) throws IOException - ������� ������ ���� � �������� ���������
  		������ �� ���������, ��������� ������ prefix � suffix, ����� ������������� ��� ���. ����� ����� ������ ������������ ������ 
  		createTempFile(prefix, suffix, null). ���������� ����������� ��� ����, ������������ ����� ��������� ������ ����.
 - public int compareTo(File pathname) - ���������� ����������������� ��� ����������� ����. ���������� ����, ���� �������� ����� 
 		����� ������������ ����, �������� ������ ����, ���� ��� ����������� ��� ���� ����������������� ������ ��������� ��� ��������
 		������ ����, ���� ���� ����������� ���� ����������������� ������ ���������.
 - public int compareTo(Object o) - ���������� ���� ����������� ���� � ������ ��������. ���������� ����, ���� �������� ����� ����� 
 		������������ ����, �������� ������ ����, ���� ��� ����������� ��� ���� ����������������� ������ ��������� ��� �������� ������ ����, ���� ���� ����������� ���� ����������������� ������ ���������.
- public boolean equals(Object obj) - ��������� ���� ����������� ���� �� ��������� � ������ ��������. ���������� true ����� � ������
 	�����, ����� �������� �� �������� ������� � ������������ ����� ����������� ����, ������� ���������� ��� �� ���� ��� �������, ���
 	� ���� ����������� ����.
- public String toString() - ���������� ��������� ���� ����� ������������ ����. ��� ������ ������, ������������ ������� getPath().
 */

public class t01_File_class_Obsolete{
public static void main(String[] args) throws IOException {
	 /* 01_File(String pathname) - ����������� ������� ����� ��������� �����, �������������� ��������� ������ pathname �
		����������� ����. 					*/
	System.out.println("01_File(String pathname) - !!! ����������� �� ������� ���� �� �����, � ������� ������ ������ ��� ���������� ������ \n");
	File file1 = new File("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\src\\f22_In_Out_Streams\\T16_Files\\Data1.txt");
	File file2 = new File("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\src\\f22_In_Out_Streams\\T16_Files\\Data2.txt");
	file2.createNewFile();
	
	// 02_public String getName() - ���������� ��� ����� ��� ��������, �� ���������� ������������ ����� ����.
	System.out.println("02_String getName() - ��� ������� file ��� �������� ����� �� ����� - ������ String �������� ����� ��"
			+ " ���������� � ����������� ������������ ���� - " + file1.getName() );				//��������� - Data1.txt
	System.out.println("02_String getName() - ��� ������� file2 � ��������� ������ �� ����� - ������ String �������� ����� ��"
			+ " ���������� � ����������� ������������ ���� - " + file2.getName() + "\n");		//��������� - Data2.txt

		/* 03_public String getParent() - ���������� ��������� ���� �������� ������������ ����, ��� null, ���� ���� �� ��������� 
	������������ �������.   */
	System.out.println("03_String getParent() - ��� ������� file ��� �������� ����� �� ����� - ������ String ���� ��������� �� "
			+ "����� �� ������������ ������������ ���� -  " + file1.getParent());		 	//��������� - C:\Users\dkuli\Documents\My_works\Lessons\src\f22_In_Out_Streams\T16_Files
	System.out.println("03_String getParent() - ��� ������� file2 � ��������� ������ �� ����� - ������ String ���� ��������� �� "
			+ "����� �� ������������ ������������ ���� -  " + file2.getParent() + "\n");		//��������� - C:\Users\dkuli\Documents\My_works\Lessons\src\f22_In_Out_Streams\T16_Files
		
	// 04_public String getAbsolutePath() - ���������� ������� ���������� ����.
	 System.out.println("04_String getAbsolutePath() - ��� ������� file ��� �������� ����� �� ����� - ������ String ���������� ����"
	 		+ " � ������������ ������� file1 - " + 	file1.getAbsolutePath());			// ��������� - C:\Users\dkuli\Documents\My_works\Lessons\src\f22_In_Out_Streams\T16_Files\Data1.txt
	 System.out.println("04_String getAbsolutePath() - ��� ������� file2 � ��������� ������ �� ����� - ������ String ���������� ����"
	 		+ " � ������������ ������� file1 - " + 	file2.getAbsolutePath() + "\n");	// ��������� - C:\Users\dkuli\Documents\My_works\Lessons\src\f22_In_Out_Streams\T16_Files\Data2.txt
	 
	/* 05_ public File getParentFile() - ���������� ����������� ���� �������� ������������ ����, ��� null, ���� ���� �� ���������
	������������ �������. 	 */
	File parentFile = file1.getParentFile();
	System.out.println("05_File getParentFile()- ������ ������ File, ���������� � ������������ ����������� ���� �� ����� �� "
			+ " ������������ ������������ ���� ������� file1   -  " + parentFile.getAbsolutePath() +"\n");
												// ��������� - C:\Users\dkuli\Documents\My_works\Lessons\src\f22_In_Out_Streams\T16_Files
	
		// 06_public String getPath() - ����������� ����������� ���� � ������.
	System.out.println("06_String getPath() - ����������� ����������� ���� File � ������ String -  " + 
			parentFile.getPath() + "\n");		// ��������� - C:\Users\dkuli\Documents\My_works\Lessons\src\f22_In_Out_Streams\T16_Files
	
		/*07_public boolean isAbsolute() - 	�������, �������� �� ����������� ���� ����������. ���������� true, ���� ����������� ����
	  �������� ����������, ����� false.  */
	System.out.println("07_������ true, �.�. parentFile �������� ����������� �����  " + parentFile.isAbsolute());
	System.out.println("07_������ true, �.�. file2 �������� ����������� �����  " + file2.isAbsolute() + "\n");
	
		/* 08_public String[] list() - ���������� ������ �����, ���������� ����� � �������� � ��������, ������������ ���� 
	����������� ������ ����. 	 */
	String str[]; 
//	str = file1.list();				// ������ �� �� ��������
//	System.out.println(str[0]);
//	System.out.println(str.length);
	System.out.println("08_String[] list() ������ ������ ����� ������������ ���� ������� file1 - ");
//	for (String element : str) {System.out.print(element + "\t");}
	System.out.println("\n");
	
	
	boolean bool = file1.canExecute();
	System.out.println(bool);
	
	String a = file1.getAbsolutePath();
	System.out.println(a);
	
//	try {
//		file1.createNewFile(); } 
//	catch (IOException e) { e.printStackTrace(); }
	
		/* ����������� File(File parent, String child) - ����������� ������� ����� ��������� ����� �� ������������� ������������ ���� �
	 � ������ ��������� ����. */
	
	
	
	
	
		/* public boolean mkdir() - ������� ������� � ������ ����� ������������ ����. ���������� true ����� � ������ �����, ����� 
	������� ��� ������, � ��������� ������ false. */
		
	
	
	
//	 - public boolean mkdirs() - ������� ������� � ������ ����� ������������ ����, ������� ����� �����������, �� �������������� 
	
	
	
	
	}

}