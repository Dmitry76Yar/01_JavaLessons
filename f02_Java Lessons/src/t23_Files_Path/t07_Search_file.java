package t23_Files_Path;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class t07_Search_file {
	
	public static void searchFile (File rootFile, List<File> fileList)	 {	
											// rootFile - �������� ����� ��� ������,fileList - ������ ��� ���������� ��������� ������
		if (rootFile.isDirectory()) {							// �������� �������� �� �������� ����� ������
			System.out.println("searching at " + rootFile.getAbsolutePath());
			File [] directoryFiles = rootFile.listFiles();		// ��������� ������ ������ �������� ����������
			if (directoryFiles != null) {
				for (File file: directoryFiles) {		 		// ���� ��������� ���� ��-�� ������, �� ����� ������ ��� ���� �����
					if (file.isDirectory()) searchFile(file, fileList); 
					else {										// ���� ��� ����, �� ��������� ����������� ������� ��� ����� �����
						if (file.getName().toLowerCase().endsWith(".jpg")) fileList.add(file);
					}
				}
			}
		}
	}
	
public static void main(String[] args) {
	ArrayList<File> fileList = new ArrayList<File>();
	searchFile(new File ("C:\\JavaTXT\\FileSearch"), fileList);
	for (File file : fileList) System.out.println(file.getAbsolutePath());
	
	

	}

}
