package t23_Files_Path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*  ������� �������
���������� Java ������������� ����� File (� ������ java.io) ��� ������� � �������� ��������. ���� ����� ������������ ����/������� �
�������� ������� � ��������� ��������� ����� ��������, ��� �������� �� ������������� �����/��������, ��������� �������, � �������� 
�����/��������. ��� �� �����, ��������� ����� ������������� ��������� I/O API.
I/O (input/output, ����-����� ) � �������������� ����� ������������ ���������� � � ����������� �/��� �����������. 
������� ������ ����������� ������ I/O API:
������ File �� ������� ����������������. �������� �� ���� ������ copy ��� ����������� �����/��������.
� ������ File ���������� ����� �������, ������� ���������� Boolean-��������. � ������ ������, ������������ false, � �� ��������� 
����������, ��� ���������� ����������� � ����������� ������.
����� File �� ������������� ������� ��������� ���������� ������.
����� File ������������ �����/�������� ������������ (�������� � ����������������);
����� File ������������� ������ � ������������� ������ ��������� ������, ������� �������� ������������.
��� ����������� ���� �������, � Java 4 ������ NIO (New IO). NIO (Non-blocking I/O, New I/O) � ��������� ���������� �����������
����������� ��� ����� Java, ��������������� ��� ���������� ���������������������� �������� �����-������.
�������� ����������� NIO:
- ������ � ���������: NIO ������������ ��������� ���� �������. ����� �������� ����������� �������� ����� ������� ������ �������� �������
(��������, ������������ � ������ ����� � ���������� ������), ��� ��������� ���������� ������ � ����� ������� ���������. ������ ��
����������� � ������� Java ������������� ��� ����� �����������, ��� ��������, ������� ��������� ������� ������� ����� ��� �������� 
������, � �����, ������� �������� ������������ ��� ����������.
- ������: � Java 4 ���� ������� ����������� ��� ���� �������-������ ���������� (����� Boolean). �������� ����������� ����� Buffer,
������� ������������� ����� ��������, ��� clear, flip, mark � �.�. ��� ��������� ������������� ������ ��� ��������� � ��������� ������
- ���������: � Java 4 ��������� ��������� (java.nio.charset), ������ � �������� ��� ����������� ���� � �������� Unicode.

� Java 7 ��� ����� ����� java.nio.file ��� ������ ��������� � ��������� ���������� ������, ������� ������� � ��������� � ������ �
�������� �������� ����� ���������� ��� ������, ����� ��� Path, Paths, and Files. */

/* 		����� Files (����� � Java 7, ����� java.nio.file) ����� ������������ ��� ���������� ��������� �������� � ������� � ����������
 Files �������� ��������� �������, ��� ��������, ��� ��� final-����� � private-������������� � �������� ������ ����������� ������. 
 � ���� ������ ��������� ��������� ������� ��� ���������� ��������� ��������. 
		���� ��� ������� ������ ����, � ������� ����������, ��������� �� ��� ���� �� ���� ����. 
��������� ������ ��������� ��� � ������� ������ isSameFile () �� ������ Files:
		������
 - 01_isSameFile () ��������� ��������� �� ��� ���� �� ���� ����
 - 02_isDirectory() - ���������, ����� �� �� ���� � ������ ��� ����������� (������)
 - 03_ exists() - ��������� ������������� ������ ��� �����
 - 04_isReadable() ��� �������� ����������� ������
 - 05_isWriteable() ��� �������� ����������� ������
 - 06_isExecutable() ��� �������� ����������� ���������� ������:
*/

public class t05_Files {
public static void main(String[] args) throws IOException {
		// 01_isSameFile () ��������� ��������� �� ��� ���� �� ���� ����
	// �.�. ��� ������������ �����, � �� ����, �� ������������� ���������������� ����� �����������, ����� ������ java.nio.file.NoSuchFileException.
Path path1 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt"); 
Path path2 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt"); 
Path path3 = Paths.get(".\\Copy1.txt");		// ������������� ����
Path path4 = Paths.get("Copy1.txt");		// ������ ���� ������������� ���� � ������ (������� ������������)
Path path5 = Paths.get("CopyIn.txt");
System.out.println("01_isSameFile()_�������� ���� ��� �������������� path3- " + path3.toRealPath(LinkOption.NOFOLLOW_LINKS));
System.out.println("01_isSameFile()_�������� ���� ��� �������������� path4- " + path4.toRealPath(LinkOption.NOFOLLOW_LINKS));
System.out.println("01_isSameFile()_ ��� ���������� ���������� �����-  "    + Files.isSameFile(path1, path2)); 
System.out.println("01_isSameFile()_ ��� ������ ����������� � �������������� �����-  "    + Files.isSameFile(path1, path3));
System.out.println("01_isSameFile()_ ��� ������ ����������� � �������������� ����� -  " + Files.isSameFile(path3, path5) + "\n");
	
		// 02_isDirectory() - ���������, ����� �� �� ���� � ������ ��� ����������� (������)
	// �������� ��� ��� ������������, ��� � �� ������������ �����/�����. ��� �������������� ����� ������ false
Path path6 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\");
Path path7 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\1.txt");
System.out.println("02_isDirectory()_������ ��� ������������� ����� ��� path3- " + Files.isDirectory(path1, LinkOption.NOFOLLOW_LINKS));
System.out.println("02_isDirectory()_������ ��� ������������ ����� ��� path6- " + Files.isDirectory(path6, LinkOption.NOFOLLOW_LINKS));
System.out.println("02_isDirectory()_������ ��� ��������������� ����� ��� path7- " + Files.isDirectory(path7, LinkOption.NOFOLLOW_LINKS) + "\n");

		// 03_ exists() - ��������� ������������� ������ ��� �����
Path path8 = Paths.get("C:\\");
System.out.println("03_ exists()_��� ��������� �������� � ������ - " + Files.exists(path8, LinkOption.NOFOLLOW_LINKS));
System.out.println("03_ exists()_������ ��� ������������� ����� ��� path3- " + Files.exists(path1, LinkOption.NOFOLLOW_LINKS));
System.out.println("03_ exists()_������ ��� ������������ ����� ��� path6- " + Files.exists(path6, LinkOption.NOFOLLOW_LINKS));
System.out.println("03_ exists()_������ ��� ��������������� ����� ��� path7- " + Files.exists(path7, LinkOption.NOFOLLOW_LINKS) + "\n");

		// 04_isReadable() ��� �������� ����������� ������ ������ � �����
			// ��� �������������� ������ � ����� ������ false
System.out.println("04_isReadable()_����� �� ������ ������������ ���� ��� path3- " + Files.isReadable(path3));
System.out.println("04_isReadable()_����� �� ������ �������������� ���� ��� path7- " + Files.isReadable(path7));
System.out.println("04_isReadable()_����� �� ������ ������������ ����� ��� path- " + Files.isReadable(path6)+ "\n");

		// 05_isWriteable() ��� �������� ����������� ������ ������ ������ � �����
			// ��� �������������� ������ � ����� ������ false
System.out.println("05_isWriteable()_����� �� �������� ������������ ���� ��� path3- " + Files.isWritable(path3));
System.out.println("05_isWriteable()_����� �� �������� �������������� ���� ��� path7- " + Files.isWritable(path7));
System.out.println("05_isWriteable()_����� �� �������� ������������ ����� ��� path- " + Files.isWritable(path6)+ "\n");
	
		// 06_isExecutable() ��� �������� ����������� ���������� ������
			// ��� �������������� ������ � ����� ������ false
System.out.println("06_isExecutable()_����� �� ��������� ������������ ���� ��� path3- " + Files.isExecutable(path3));
System.out.println("06_isExecutable()_����� �� ��������� �������������� ���� ��� path7- " + Files.isExecutable(path7));
System.out.println("06_isExecutable()_����� �� ��������� ������������ ����� ��� path- " + Files.isExecutable(path6)+ "\n");

		//06_1_isHidden() ��� �������� ����� �� ����		������ ��� ������������ ������ � �����
System.out.println("06_1_isHidden() - ����� �� ���� ������������ ����? ��� path1- " + Files.isHidden(path1));
System.out.println("06_1_isHidden()_- ������ �� ��� ������������ ����� ��� path- " + Files.isHidden(path6)+ "\n");
//System.out.println("06_1_isHidden()_- ����� �� ���� �������������� ���� ��� path7- " + Files.isHidden(path7));	

		//07_getLastModifiedTime() - ������ ����� ��������� ����������� ����� ��� �����   	������ ��� ������������ ������ � �����
System.out.println("07_getLastModifiedTime()_������ ��� ������������� ����� ��� path1- " + Files.getLastModifiedTime(path1, LinkOption.NOFOLLOW_LINKS));
System.out.println("07_getLastModifiedTime()_������ ��� ������������ ����� ��� path6- " + Files.getLastModifiedTime(path6, LinkOption.NOFOLLOW_LINKS) + "\n");
//System.out.println("07_getLastModifiedTime()_������ ��� ��������������� ����� ��� path7- " + Files.getLastModifiedTime(path7, LinkOption.NOFOLLOW_LINKS) + "\n");

		//08_getFileStore() - ������ �������� ���������� (��������� ����) ������������ ����� ��� ����� 		������ ��� ������������ ������ � �����
System.out.println("08_getFileStore()_������ ��� ������������� ����� ��� path1- " + Files.getFileStore(path1));
System.out.println("08_getFileStore()_������ ��� ������������ ����� ��� path6- " + Files.getFileStore(path6)  + "\n");
//System.out.println("08_getFileStore()_������ ��� ��������������� ����� ��� path7- " + Files.getFileStore(path7) + "\n");

		// 09_getOwner - ������ ��� ������������ (User name Windows)         ������ ��� ������������ ������ � �����
System.out.println("09_getOwner()������ User name ��� ������������� ����� ��� path1- " + Files.getOwner(path1, LinkOption.NOFOLLOW_LINKS));
System.out.println("09_getOwner()_������ ��� ������������ ����� ��� path6- " + Files.getOwner(path6, LinkOption.NOFOLLOW_LINKS)  + "\n");
//System.out.println("09_getOwner()_������ ��� ��������������� ����� ��� path7- " + Files.getOwner(path7, LinkOption.NOFOLLOW_LINKS) + "\n");

		//10_size()  - ������ ������ �����        ������ ��� ������������ ������ � �����
System.out.println("10_size()  - ������ ������ ����� ��� ������������� ����� ��� path1- " + Files.size(path1));
System.out.println("10_size()  - ������ ��� ������������ ����� ��� path6- " + Files.size(path6)  + "\n");
//System.out.println("10_size()  - ������ ������ ����� ��� ��������������� ����� ��� path7- " + Files.size(path7) + "\n");


			
		/* 10_����� getAttribute() ��������� �������� �������� (��������) �����. ����� ��������� ���������� ����� ����������:
	������ � ������ Path; ������ � ��� ��������; ����� �� ���� �� ���������� �������� LinkOption (��� enum)  */
System.out.println("10_����� getAttribute() ��������� �������� �������� (��������) �����");
Path path9 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt");
try { 
    Object object = Files.getAttribute(path9, "creationTime"); 
    System.out.println("Creation time: " + object); 
    
    //����� ������ ������ �������� 
    object = Files.getAttribute(path9, "lastModifiedTime", LinkOption.NOFOLLOW_LINKS); 
    System.out.println("Last modified time: " + object);
    
    object = Files.getAttribute(path9, "lastModifiedTime"); 
    System.out.println("Last modified time: " + object); 

    object = Files.getAttribute(path9, "size"); 
    System.out.println("Size: " + object); 

    object = Files.getAttribute(path9, "isDirectory"); 
    System.out.println("isDirectory: " + object + "\n"); 
} catch (IOException e) { 
    e.printStackTrace();  }

	/* 11_Files.create()  - �������� ����� � �����
  ���� ������ ��� ��� ��������� �������������� � ��������� ��������, �� �����  ���������� java.nio.file.FileAlreadyExistsException. */
System.out.println("11_Files.create()  - �������� ����� � ����� \n");
Path path10 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\2.txt");
// System.out.println("11_Files.create()  �������� �����, ����� ��� ������ ����� - " + Files.createFile(path10));
// System.out.println("12_Files.create()  �������� �����, ����� ����� ���� ��� ���� - " + Files.createFile(path10));

	/* 12_Files.copy()_����������� ������ � ��������� (�����) 
Path copy(Path source, Path target, CopyOption. . . options)
������ �������� � ���� � ��������� �����, ������ � ���� � �����, ����� ����� ������ ��������� �����������,� ����� � �� ������, ��� ����: 
������� ��������, ��� ��� ����������� ���������� �� ����� ������������ ������������ � ��� ����� � ����������. */

System.out.println("12_Files.copy()_����������� ������ � ��������� (�����)");  /*
System.out.println("���� ��� path9- " + path9.toRealPath(LinkOption.NOFOLLOW_LINKS));
Path pathDestination = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\CopyOfCopy1.txt");
	try {
		Files.copy(path9, pathDestination);
		System.out.println("Sourse file was copied successfully");}
	catch (IOException e) {
		e.printStackTrace();}  */

/* ���� ������ ��� ��� ��������� �������������� � ��������� ��������, �� �����  ���������� java.nio.file.FileAlreadyExistsException.
  ��� ������� � ���, ��� ������� ���� ��� ����������. ��� ��������� ����� ������� ����� �������, ����� � ������ ��� ������������� ��
  ���������������. ��� ����� ���� ������� Files.copy(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING) */
	
	System.out.println("12_1_Files.copy() � �����������");
	System.out.println("���� ��� path9- " + path9.toRealPath(LinkOption.NOFOLLOW_LINKS));
	Path pathDestination1 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1OfCopy1.txt");
		try {
			Files.copy(path9, pathDestination1, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Sourse file was copied successfully \n");}
		catch (IOException e) {
			e.printStackTrace();}
		
		//13_������ ����������� ����� ������ �� ���� �� ����������
	// ������ ���� t06_Files_directory_with_files.java

		/* 14_move() - ����������� ����� � ����� 
  ����� ��� ����������� ����� ����� ����� �� ����� ��� �����������: Path move(Path source, Path target, CopyOption. . . options)
  ��� �������� ����, ��� ����������� ���������� ������������ � ��� ����� � ���������� �� ������������, 
  �� ��� ����������� ����������, � ������ ���������� ������, ������������ � �� �� ����������. */
	System.out.println("14_move() - ����������� ����� � �����");
	Path pathSource = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1OfCopy1.txt");
	Path pathDestination2 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Copy1OfCopy1.txt");
	try {
		Files.move(pathSource, pathDestination2, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("14_move() - Source file copied successfully \n"); 	}
	catch (IOException e) { 
        e.printStackTrace();   }	
	
		// 15_delete() - �������� ������ � �����
/* ��������� ��������, ������� ���������� ������� ������������ ������ Files.delete():
 - � ������ �������� ��������, ����������, ����� �� ��� ������, ����� ���������� (java.nio.file.DirectoryNotEmptyException)
 - ���� �������� � ������ ����� ���������� ������, �� ����� ������� ������, � �� ������� ����.
 - ��� ������� ������ ����������, ����� ���� �����������, ����� ����� �������� ���������� (java.nio.file.NoSuchFileException). 
���� ���������� ������������ ������ ������, �� ����� ������� ����� deleteIfExists(), ������� ������� ���� � ������ ��� �������������  � �� ������� �������� ���������� ��� ��� ����������.*/
	System.out.println("15_delete() - �������� ������ � �����");
	Path path11 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Copy1OfCopy1.txt");
	try { 
        Files.delete(path11); 
        System.out.println("15_delete() - File deleted successfully \n"); 
    } catch (IOException e) { 
        e.printStackTrace();  }
	
		// 16_deleteIfExists(path)- �������� ������ � �����, ���� ��� ����������
	System.out.println("16_deleteIfExists(path)- �������� ������ � �����, ���� ��� ����������");
	System.out.println("�������� ��������������� �����");
	Files.deleteIfExists(path11);
	System.out.println("16_deleteIfExists(path) - ����� �� ������� ���������� � ������ ���������� ����� \n");
	
		
	
	
	
	}

}
