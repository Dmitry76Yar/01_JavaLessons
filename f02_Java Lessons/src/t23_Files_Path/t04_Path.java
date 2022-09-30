package t23_Files_Path;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

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

/* 		������������� ���������� Path
Java 7 ������������ ����� ���������� ��� ����, � ������ ��������� Path.  
������ ���� �������� ����� ��������� � ������, ������� ���������� ������ ���� �� �����/��������, ��������������� �������� Path; 
Path �������� ������ ��� ���������� ��������� ����, ����������� � ���� � �� ����������.
	Path, �� �������� �����, � ��� �������������� ������ ������ File. �������� � ��� ����������� �����, ��� � File.
��-������, �� ���� ������ ������ ��������� (�����������) ������, � ��������� �� � ����� Files.
��-������, � Path ���� ����������� ������������ �������� �������. � ������ File ������ ���������� �� String, �� boolean, �� File � 
����������� ���� ��������.  ��������, ��� ����� getParent(), ������� ��������� ������������ ���� ��� �������� ����� � ���� ������. 
�� ��� ���� ��� ����� getParentFile(), ������� ��������� �� �� �����, �� � ���� ������� File!
	������� � ���������� Path ����� getParent() � ������ ������ ������ � ������� ���������� ������ ������ Path.
	
	���������� ������ (Symbolic link, �������) � ����������� ���� � �������� �������, ���������� ������ ��������� ������ � ����������. 
��� ������ ���������� ��� ���� � �����, ������� ������ ���� ������ ��� ������� ���������� � ������� �����.
	���������� ���� � ��� ����, ������� ��������� �� ���� � �� �� ����� � �������� �������, ��� ����������� �� ������� ����������.
������ ���� ������ ���������� � ��������� ��������.
	������������� ���� � ��� ���� �� ��������� � �������� �������� ��������.
	
	    ������
 - int	compareTo(Path other) - ���������� ���� ����������� � ����������: 0, ���� ���� �����; ������������� ����� ��������, ����
 ���� � ������� ���������� ����� ����������������� ������ ���� � �������, ���������� � �������� ���������; ������������� ����� 
 �������� � ��������������� ������
 - boolean	endsWith(Path other)  - Tests if this path ends with the given path.
 - boolean	endsWith(String other)  - Tests if this path ends with a Path, constructed by converting the given path string, in exactly 
the manner specified by the endsWith(Path) method.
 - boolean	equals(Object other)  - ���������� ���� � ���������� Boolean
 - Path	getFileName()  - Returns the name of the file or directory denoted by this path as a Path object.
 - FileSystem	getFileSystem()  - Returns the file system that created this object.
 - Path	getName(int index)  - Returns a name element of this path as a Path object.
 - int	getNameCount() - Returns the number of name elements in the path.
 - Path	getParent() - Returns the parent path, or null if this path does not have a parent.
 - Path	getRoot() - Returns the root component of this path as a Path object, or null if this path does not have a root component.
 - int	hashCode() - Computes a hash code for this path.
 - boolean	isAbsolute() - Tells whether or not this path is absolute.
 - Iterator<Path>	iterator() - Returns an iterator over the name elements of this path.
 - Path	normalize() -  ������� �������� ������� (����� ��� � . � � � .. �) �� ������� Path
 - WatchKey	register(WatchService watcher, WatchEvent.Kind<?>... events)  - Registers the file located by this path with a watch
service.
 - WatchKey	register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers)  - Registers the file
located by this path with a watch service.
 - Path	relativize(Path other)  - Constructs a relative path between this path and a given path.
 - Path	resolve(Path other) - Resolve the given path against this path.
 - Path	resolve(String other) - Converts a given path string to a Path and resolves it against this Path in exactly the manner 
specified by the resolve method.
 - Path	resolveSibling(Path other) - Resolves the given path against this path's parent path.
 - Path	resolveSibling(String other) - Converts a given path string to a Path and resolves it against this path's parent path 
in exactly the manner specified by the resolveSibling method.
 - boolean	startsWith(Path other) - Tests if this path starts with the given path.
 - boolean	startsWith(String other) - Tests if this path starts with a Path, constructed by converting the given path string, in 
exactly the manner specified by the startsWith(Path) method.
 - Path	subpath(int beginIndex, int endIndex)  - Returns a relative Path that is a subsequence of the name elements of this path.
 - Path	toAbsolutePath() - ����� toAbsolutePath() ���������� ���������� ���� �� ������� �������������� ����. � ������, ���� ��� 
 ����� ���������� ����, ����� ����� ��� ��
 - File	toFile() - Returns a File object representing this path.
 - Path	toRealPath(LinkOption... options) - Returns the real path of an existing file.
 - String	toString() - Returns the string representation of this path.
 - URI	toUri() - ����� toUri() ���������� URI (���� ������� ����� ���� ������ �� ��������).
 */

public class t04_Path {
public static void main(String[] args) throws IOException {
		/* C������� ������� �� ����������� ����
	Path ����� ����� ������������ ������ get() ������ Paths 
	���������� ���� � ��� ����, ������� ��������� �� ���� � �� �� ����� � �������� �������, ��� ����������� �� ������� ����������. */ 
Path testFilePath = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\src\\Copy1.txt");
		
		// ������ ������� ���� �� ������ � ��� �� ������
Path testFilePath2 = Paths.get("C:\\Users","dkuli", "Documents", "My_works", "Lessons", "src", "Copy1.txt");
		
		// �������� ������� ��� ��������������� �����
Path NonExistingFilePath = Paths.get("C:\\Users","dkuli", "Documents", "My_works", "Lessons", "src", "Copy2.txt");
	
		/* ��������� ����������� ���� �� �������������� ���� � ������������ ���� 
	������������� ���� � ��� ���� �� ��������� � �������� �������� ��������.
	����� normalize() - ������� �������� ������� (����� ��� � . � � � .. �) �� ������� Path*/
Path testRelatingPath = Paths.get(".\\Copy3.txt");
System.out.println("��������� ����������� ���� �� �������������� ���� � ������������ ����");

		/* ����� toAbsolutePath() ���������� ���������� ���� �� ������� �������������� ����. */
System.out.println("00_toAbsolutePath() ��� ������������ ������ ������  " + testRelatingPath.toAbsolutePath()); 

		// ����� normalize() ��������� ������������ ����, ������� ������� ������� �������� ������� (����� ��� � . � � � .. �) �� ������� Path.
System.out.println("00_normalize() ��� ������������ ������ ������  " + testRelatingPath.normalize()); 

		//��������� ������� ������� ������ �� ���������������� �������������� ���� 
Path testRelatingPathNormalized = Paths.get(testRelatingPath.normalize().toString()); 
System.out.println("00_���������� ���� ��� ���������������� ����: "+ testRelatingPathNormalized.toAbsolutePath()); 

		/* ����� toRealPath () ���������� ���������� ���� �� ����������� ���� (��� toAbsolutePath ()) � ����������� ��� (��� 
	normalize()). ����� ����, ���� ��� ��������� ������� ���������, �� �� ����� ���� �������� � ����������� ��������. ������, ���
 	����� ������ ����������, ����� �������� ����/������� ����������� � �������� ������� (��� �� �������� ������������ �������� 
 	��� ������ ������� Path).   */	
Path testRelatingPath2 = Paths.get(".\\Copy1.txt");
System.out.println("00_toRealPath () ��� ������������� �����: "+ testRelatingPath2.toRealPath(LinkOption.NOFOLLOW_LINKS) + "\n"); 

		// 01_Path getFileName() - Returns the name of the file or directory denoted by this path as a Path object.
System.out.println("01_Path getFileName()_���������� ��� ����� :  " + testFilePath.getFileName());
System.out.println("01_Path getFileName()_���������� ��� ����� :  " + testFilePath2.getFileName());
System.out.println("01_Path getFileName()_��� ��������������� ����� ����� ���������� ��� ��� :  " + NonExistingFilePath.getFileName());
System.out.println("01_Path getFileName()_��� ������� � ������������� ������� ���������� ��� ��� :  " + testRelatingPath.getFileName() + "\n");	
	
		// 02_FileSystem	getFileSystem() - Returns the file system that created this object.
	System.out.println("02_FileSystem	getFileSystem()_���������� ��� �������� ������� :  " + testFilePath.getFileSystem() + "\n");
		
		// 02_1_Path getName(int index) - Returns a name element of this path as a Path object.
	System.out.println("02_1_Path getName(int index)_���������� ��� 2-�� �������� ���� :  " + testFilePath.getName(2) + "\n");
	
		// 03_Path	getParent() - 	Returns the parent path, or null if this path does not have a parent.
	System.out.println("03_Path	getParent()_���������� ��� �������� ���� ����� :  " + testFilePath.getParent());
	System.out.println("03_Path	getParent()_��� ��������������� ����� ����� ���������� ��� �������� :  " + NonExistingFilePath.getParent() + "\n");
	
		// 04_Path	getRoot() - Returns the root component of this path as a Path object, or null if this path does not have a root component.
	System.out.println("04_Path	getRoot()_���������� ��� �������� �������� ����� :  " + testFilePath.getRoot()  + "\n" );
	
		// 05_int	getNameCount() - Returns the number of name elements in the path.
	System.out.println("05_int	getNameCount()_���������� ��� �������� �������� ����� :  " + testFilePath.getNameCount()  + "\n" );
		
		//06_Path ForEach_����� ��������� ���� ��������� 
    System.out.println("06_Path ForEach_����� ��������� ���� ���������  "); 
    for (Path element : testFilePath) { 
        System.out.print("\t " + element);} 
    System.out.println("\n");
    
    	//07_Iterator<Path>	iterator() -  Returns an iterator over the name elements of this path.
    System.out.println("07_Iterator<Path>	iterator()_����� ��������� ���� ���������  ");
    Iterator<Path> it = testFilePath.iterator();
    while (it.hasNext())	{
 	   Path element = it.next();
 	   System.out.print(element + "\t");	} System.out.println("\n");
 	   
    	// 08_boolean	endsWith(String other) -  Tests if this path ends with a Path, constructed by converting the given path string, in exactly the manner specified by the endsWith(Path) method.
 System.out.println("08_boolean	endsWith(String other) - ���� ������������� ��  Copy1.txt -   " + testFilePath.endsWith( "Copy1.txt"));
 System.out.println("08_boolean	endsWith(String other) - ���� ������������� ��  src\\Copy1.txt -   " + testFilePath.endsWith( "src\\Copy1.txt"));
 System.out.println("08_boolean	endsWith(String other) - ���� ������������� ��  txt -   " + testFilePath.endsWith( "txt") + "\n" );
 
 		// 09_boolean endsWith(Path other) -  Tests if this path ends with the given path.
 Path CorrectEndFilePath = Paths.get("Copy1.txt");
 Path InCorrectEndFilePath = Paths.get("py1.txt");
 System.out.println("09_boolean endsWith(Path other) - ���� ������������� ��  Copy1.txt -   " + testFilePath.endsWith(CorrectEndFilePath));
 System.out.println("09_boolean endsWith(Path other) - ���� ������������� ��  py1.txt -   " + testFilePath.endsWith(InCorrectEndFilePath) + "\n");
 			
 		//10_boolean startsWith(String other) -  Tests if this path starts with a Path, constructed by converting the given path string, in exactly the manner specified by the startsWith(Path) method.
 System.out.println("10_boolean startsWith(String other) - ���� ���������� ��  C: -   " + testFilePath.endsWith( "C:\\"));
 System.out.println("10_boolean startsWith(String other) - ���� ���������� ��  C: -   " + testFilePath.endsWith( "Users"));
 System.out.println("10_boolean startsWith(String other) - ���� ���������� ��  C: -   " + testFilePath.endsWith( "Users\\dkuli") + "\n");
        
 		// 11_boolean	startsWith(Path other) - Tests if this path starts with the given path.
 
 		//12_Path subpath(int beginIndex, int endIndex) - Returns a relative Path that is a subsequence of the name elements of this path.
 System.out.println("12_Path subpath(int beginIndex, int endIndex) - ���� � 2-�� �� 5-�� �������� -   " + testFilePath.subpath(2, 5) + "\n");
 
 		// 13_URI	toUri() -  ����� toUri() ���������� URI (���� ������� ����� ���� ������ �� ��������).
 System.out.println("13_URI	toUri() - ���� � URI ��������� -   " + testFilePath.toUri() + "\n");
 
 		//14_Path	toAbsolutePath() - Returns a Path object representing the absolute path of this path.
 // ���������� ���� � ��� ����, ������� ��������� �� ���� � �� �� ����� � �������� �������, ��� ����������� �� ������� ����������.
 // ������ ���� ������ ���������� � ��������� ��������.
 System.out.println("14_Path	toAbsolutePath() - ���������� ���� -   " + testFilePath.toAbsolutePath() + "\n");
 
 		// 15_Path	toRealPath(LinkOption... options) - Returns the real path of an existing file.

 		// 16_File	toFile() -  Returns a File object representing this path.
 System.out.println("16_File	toFile() - ���������� File ���� -   " + testFilePath.toFile() + "\n");
 
 		// 17_boolean	isAbsolute() -  Tells whether or not this path is absolute.
 System.out.println("17_boolean	isAbsolute() - testFilePath ��� ���������� ����?  -   " + testFilePath.isAbsolute());
 Path UnproperTestFilePath = Paths.get("My_works\\Lessons\\src\\Copy1.txt");
 System.out.println("17_boolean	isAbsolute() - UnproperTestFilePath ��� ���������� ����?  -   " + UnproperTestFilePath.isAbsolute());
 System.out.println("17_boolean	isAbsolute() - NonExistingFilePath ��� ���������� ����?  -   " + NonExistingFilePath.isAbsolute() + "\n");
 
 		//18_equals() ���������� ���� � ���������� Boolean
 Path path1 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt"); 
 Path path2 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt"); 
 Path path3 = Paths.get(".\\Copy1.txt");
 Path path4 = Paths.get("Copy1.txt");
 System.out.println("18_equals()_�������� ���� ��� �������������� path3- " + path3.toRealPath(LinkOption.NOFOLLOW_LINKS));
 System.out.println("18_equals()_�������� ���� ��� �������������� path4- " + path4.toRealPath(LinkOption.NOFOLLOW_LINKS));
 System.out.println("18_equals()_ ��� ���������� ���������� �����-  "    + (path1.equals(path2))); 
 System.out.println("18_equals()_ ��� ������ ����������� � �������������� �����-  "    + (path1.equals(path3)));
 System.out.println("18_equals()_ ��� ������ ����������� � �������������� ����� ����� ���������� � ����������� ���� � ������������ -  "    + 
		 	(path1.equals(path3.normalize().toAbsolutePath())));
 System.out.println("18_equals()_ ��� ������ �������������� ���� ��� ����� � �������������� ���� � ������ ����� ������������ -  "    + 
		 	(path4.equals(path3.normalize())) + "\n");
 
  		/* 19_����� compareTo() ���������� ���� ����������� � ����������: 0, ���� ���� �����; ������������� ����� ��������, ����
 ���� � ������� ���������� ����� ����������������� ������ ���� � �������, ���������� � �������� ���������; ������������� ����� 
 �������� � ��������������� ������. */
 Path path5 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt");
 Path path6 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons");
 System.out.println("19_compareTo()_��� ���������� ���������� �����-  "    + (path5.compareTo(path5)));
 System.out.println("19_compareTo()_ ���� ���� ������-  "    + (path5.compareTo(path6))); 
 System.out.println("19_compareTo()_ ���� ���� ������ -  "    + (path6.compareTo(path5)));
 
 
	}
}

