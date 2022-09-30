package Work_with_files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class t01_Search_file {
	
	public static void searchFile (File rootFile, List<File> fileList)	 {	
											// rootFile - корневая папка для поиска,fileList - список для добавления найденных файлов
		if (rootFile.isDirectory()) {							// Проверка является ли корневая папка папкой
			System.out.println("searching at " + rootFile.getAbsolutePath());
			File [] directoryFiles = rootFile.listFiles();		// Получение списка файлов корневой директории
			if (directoryFiles != null) {
				for (File file: directoryFiles) {		 		// Если найденный файл яв-ся папкой, то вызов метода для этой папки
					if (file.isDirectory()) searchFile(file, fileList); 
					else {										// Если это файл, то проверяем необходимое условие для имени файла
						if (file.getName().toLowerCase().endsWith(".jpg")) fileList.add(file);
					}
				}
			}
		}
	}
	
public static void main(String[] args) {
	ArrayList<File> fileList = new ArrayList<File>();
	searchFile(new File ("C:\\JavaTXT\\FileSearch"), fileList);
	System.out.println();
	for (File file : fileList) System.out.println(file.getAbsolutePath());
	
	

	}

}
