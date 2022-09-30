package t23_Files_Path;

import java.io.IOException;
import java.nio.file.*; 
import java.nio.file.attribute.BasicFileAttributes; 

/* ����� ������ ������
��� ������ � �������� �������� ����� ���������� ������������� ������ ������ ������, �������� ��� ������ ����� ��� �����������
�������� �� ���� ��� ����������. ����� Files �������� ��� ������, ����������� �������� ������ ������. �� ��������� ��������� ����:
	 - Path walkFileTree(Path start, FileVisitor<!--? super Path--> visitor) 
	 - Path walkFileTree(Path start, Set<filevisitoption> options, int maxDepth, FileVisitor<!--? super Path--> visitor) 
��� ������ ��������� ����, � �������� ������� ����� ������ � ��������� ���� FileVisitor, ������� ����� ���������� ��������� ��� 
������ ������. ������ ����� ����� ��� �������������� ���������: Set, ���������� ����� ������, � ������������ �������. 
������������ ������� ����������, ��������� ������� ��������� ����� ����������� �����. ���� � � �������� ������� 0, �� ����� 
��������������� ������ ��������� ����, � ���� ������� MAX_VALUE, �� ����� �������� ��� �����������.
	FileVisitor � ��� ���������, ���������� ��������� ������:
- FileVisitResult preVisitDirectory(T dir, BasicFileAttributesattrs) � ����������� ����� ������� � ��������� ��������.
- FileVisitResult visitFile(T file, BasicFileAttributes attrs) � ����������� ��� ������� � �����.
- FileVisitResult postVisitDirectory(T dir, IOException exc) � �����������, ����� ��� �������� ���������� �������� .
- FileVisitResult visitFileFailed(T file, IOException exc) � �����������, ���� � ����� ��� �������.
��� ���������� ����������� ��������� FileVisitor, ����� �������� ��������������� ������ � ����� walkFileTree(). �� ���� �������������
������������� ��� ������ ������ ����� ���������� ���, �� ����� ������ ��������� ���������� ������ SimpleFileVisitor, ������������� 
���� ����������� ������.

	��� ���������� ������� ���� ����� �������� ��� ��������� �������� � ����� �� ���������� ����. ��� ��� ������� ������:
����������� ����� MyFileVisitor, �������������� �� SimpleFileVisitor, � ������� �������������� ��� ������: 
 - visitFile() (��� ������ ����� �����) � 
 - preVisitDirectory() (��� ������ ����� ����������).
 ���������� walkFileTree() � ������� ��������� ������ MyFileVisitor.
����� walkFileTree() �������� ���������� � ����������� � ���� ��������. ��� ���� ���������� ����� visitFile() ��� ������ ������� 
�����, preVisitDirectory() � ����� ���������� ��������� ����������, postVisitDirectory() � ����� ��������� ��������� ����������, 
visitFileFailed() � � ������ ���������� ������� � �����/����������.
	�� ���� ������ ������� ���� �������������� ������ ��� ��� ������ ��� ��������� � ������.
����� �������������� ����� ������ � ������� ������������ ����� �������� �������� (enum FileVisitResult). �� ������:
 - CONTINUE: ��������� �� ��, ��� ����� ������ ������� ����������.
 - TERMINATE: ���������, ��� ����� ����� ���������� ����������.
 - SKIP_SUBTREE: ���������, ��� ����������� ������ ���� ��������� ��� ������.
 - SKIP_SIBLINGS: ��������� �� ��, ��� ����� ������ ���� ���������� � ������� �������� � ��������� ������ ������ � ���. ���� ��� �������� ������������ �� preVisitDirectory(), �� ��������� �����/�������� �� ��������� � postVisitDirectory() �� �����������. ���� ��� �������� ������������ �� visitFile (), �� ��������� ����� �������� �� ���������. ���� �� ������������ �� postVisitDirectory (), �� ��������� �������� ���� �� ������ �� ����� ����������.
	*/

// �� ��������
class MyFileVisitor<FileVisitResult> extends SimpleFileVisitor { 
    public FileVisitResult visitFile(Path path,BasicFileAttributes fileAttributes) { 
        System.out.println("file name:" + path.getFileName()); 
        return FileVisitResult.CONTINUE; 
    } 
 
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) { 
        System.out.println("Directory name:" + path); 
        return FileVisitResult.CONTINUE; 
    } 
} 
 
public class t06_Walk_in_File_Tree { 
    public static void main(String[] args) { 
 
        Path pathSource = Paths.get("������� ���� ���� � ������-���� ��������, ����������� ������ �������� � �����"); 
        try { 
            Files.walkFileTree(pathSource, new MyFileVisitor()); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
} 