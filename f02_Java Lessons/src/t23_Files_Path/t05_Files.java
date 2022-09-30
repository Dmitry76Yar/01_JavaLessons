package t23_Files_Path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*  Немного истории
Изначально Java предоставляла класс File (в пакете java.io) для доступа к файловым системам. Этот класс представляет файл/каталог в
файловой системе и позволяет выполнять такие операции, как проверка на существование файла/каталога, получении свойств, и удаление 
файла/каталога. Тем не менее, ощущалась явная необходимость доработки I/O API.
I/O (input/output, Ввод-вывод ) — взаимодействие между обработчиком информации и её поставщиком и/или получателем. 
Краткий список недостатков первой I/O API:
Классу File не хватало функциональности. Например не было метода copy для копирования файла/каталога.
В классе File определено много методов, которые возвращают Boolean-значение. В случае ошибки, возвращалось false, а не бросалось 
исключение, что затрудняло обнаружение и исправление ошибок.
Класс File не предоставляет хорошей обработки символьных ссылок.
Класс File обрабатывает файлы/каталоги неэффективно (проблемы с масштабированием);
Класс File предоставляет доступ к ограниченному набору атрибутов файлов, который зачастую недостаточен.
Для преодоления этих проблем, в Java 4 введен NIO (New IO). NIO (Non-blocking I/O, New I/O) — коллекция прикладных программных
интерфейсов для языка Java, предназначенных для реализации высокопроизводительных операций ввода-вывода.
Ключевые особенности NIO:
- Каналы и селекторы: NIO поддерживает различные типы каналов. Канал является абстракцией объектов более низкого уровня файловой системы
(например, отображенные в памяти файлы и блокировки файлов), что позволяет передавать данные с более высокой скоростью. Каналы не
блокируются и поэтому Java предоставляет еще такие инструменты, как селектор, который позволяет выбрать готовый канал для передачи 
данных, и сокет, который является инструментом для блокировки.
- Буферы: в Java 4 была введена буферизация для всех классов-обёрток примитивов (кроме Boolean). Появился абстрактный класс Buffer,
который предоставляет такие операции, как clear, flip, mark и т.д. Его подклассы предоставляют методы для получения и установки данных
- Кодировки: в Java 4 появились кодировки (java.nio.charset), кодеры и декодеры для отображения байт и символов Unicode.

В Java 7 был введён пакет java.nio.file для лучшей поддержки и обработки символьных ссылок, полного доступа к атрибутам и работы с
файловой системой через интерфейсы или классы, такие как Path, Paths, and Files. */

/* 		Класс Files (введён в Java 7, пакет java.nio.file) можно использовать для выполнения различных операций с файлами и каталогами
 Files является служебным классом, это означает, что это final-класс с private-конструктором и содержит только статические методы. 
 В этом классе находится множество методов для выполнения различных действий. 
		Выше был показан пример кода, в котором выяснялось, указывают ли два пути на один файл. 
Сущесвует способ проверить это с помощью метода isSameFile () из класса Files:
		Методы
 - 01_isSameFile () проверяет указывают ли два пути на один файл
 - 02_isDirectory() - проверяет, имеем ли мы дело с файлом или директорией (папкой)
 - 03_ exists() - проверяет существование файлов или папки
 - 04_isReadable() для проверки возможности чтения
 - 05_isWriteable() для проверки возможности записи
 - 06_isExecutable() для проверки возможности выполнения файлов:
*/

public class t05_Files {
public static void main(String[] args) throws IOException {
		// 01_isSameFile () проверяет указывают ли два пути на один файл
	// Т.к. тут сравниваются файлы, а не пути, то существование соответствующего файла обязательно, иначе ошибка java.nio.file.NoSuchFileException.
Path path1 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt"); 
Path path2 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt"); 
Path path3 = Paths.get(".\\Copy1.txt");		// Относительный путь
Path path4 = Paths.get("Copy1.txt");		// Видимо тоже относительный путь с точкой (требует нормализации)
Path path5 = Paths.get("CopyIn.txt");
System.out.println("01_isSameFile()_Реальный путь для относительного path3- " + path3.toRealPath(LinkOption.NOFOLLOW_LINKS));
System.out.println("01_isSameFile()_Реальный путь для относительного path4- " + path4.toRealPath(LinkOption.NOFOLLOW_LINKS));
System.out.println("01_isSameFile()_ для одинаковых абсолютных путей-  "    + Files.isSameFile(path1, path2)); 
System.out.println("01_isSameFile()_ для равных абсолютного и относительного путей-  "    + Files.isSameFile(path1, path3));
System.out.println("01_isSameFile()_ для разных абсолютного и относительного путей -  " + Files.isSameFile(path3, path5) + "\n");
	
		// 02_isDirectory() - проверяет, имеем ли мы дело с файлом или директорией (папкой)
	// Работает как для существующих, так и не существующих фалов/папок. Для несуществующих папок выдает false
Path path6 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\");
Path path7 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\1.txt");
System.out.println("02_isDirectory()_Выдает для существующего файла для path3- " + Files.isDirectory(path1, LinkOption.NOFOLLOW_LINKS));
System.out.println("02_isDirectory()_Выдает для существующей папки для path6- " + Files.isDirectory(path6, LinkOption.NOFOLLOW_LINKS));
System.out.println("02_isDirectory()_Выдает для несуществующего файла для path7- " + Files.isDirectory(path7, LinkOption.NOFOLLOW_LINKS) + "\n");

		// 03_ exists() - проверяет существование файлов или папки
Path path8 = Paths.get("C:\\");
System.out.println("03_ exists()_Для корневого каталого С выдает - " + Files.exists(path8, LinkOption.NOFOLLOW_LINKS));
System.out.println("03_ exists()_Выдает для существующего файла для path3- " + Files.exists(path1, LinkOption.NOFOLLOW_LINKS));
System.out.println("03_ exists()_Выдает для существующей папки для path6- " + Files.exists(path6, LinkOption.NOFOLLOW_LINKS));
System.out.println("03_ exists()_Выдает для несуществующего файла для path7- " + Files.exists(path7, LinkOption.NOFOLLOW_LINKS) + "\n");

		// 04_isReadable() для проверки возможности чтения файлов и папок
			// Для несуществующих файлов и папок выдает false
System.out.println("04_isReadable()_Можно ли читать существующий файл для path3- " + Files.isReadable(path3));
System.out.println("04_isReadable()_Можно ли читать несуществующий файл для path7- " + Files.isReadable(path7));
System.out.println("04_isReadable()_Можно ли читать существующую папку для path- " + Files.isReadable(path6)+ "\n");

		// 05_isWriteable() для проверки возможности записи чтения файлов и папок
			// Для несуществующих файлов и папок выдает false
System.out.println("05_isWriteable()_Можно ли записать существующий файл для path3- " + Files.isWritable(path3));
System.out.println("05_isWriteable()_Можно ли записать несуществующий файл для path7- " + Files.isWritable(path7));
System.out.println("05_isWriteable()_Можно ли записать существующую папку для path- " + Files.isWritable(path6)+ "\n");
	
		// 06_isExecutable() для проверки возможности выполнения файлов
			// Для несуществующих файлов и папок выдает false
System.out.println("06_isExecutable()_Можно ли выполнить существующий файл для path3- " + Files.isExecutable(path3));
System.out.println("06_isExecutable()_Можно ли выполнить несуществующий файл для path7- " + Files.isExecutable(path7));
System.out.println("06_isExecutable()_Можно ли выполнить существующую папку для path- " + Files.isExecutable(path6)+ "\n");

		//06_1_isHidden() для проверки скрыт ли файл		Только для существующих файлов и папок
System.out.println("06_1_isHidden() - скрыт ли этот существующий файл? для path1- " + Files.isHidden(path1));
System.out.println("06_1_isHidden()_- скрыта ли эта существующая папка для path- " + Files.isHidden(path6)+ "\n");
//System.out.println("06_1_isHidden()_- скрыт ли этот несуществующий файл для path7- " + Files.isHidden(path7));	

		//07_getLastModifiedTime() - выдает время последней модификации файла или папки   	Только для существующих файлов и папок
System.out.println("07_getLastModifiedTime()_Выдает для существующего файла для path1- " + Files.getLastModifiedTime(path1, LinkOption.NOFOLLOW_LINKS));
System.out.println("07_getLastModifiedTime()_Выдает для существующей папки для path6- " + Files.getLastModifiedTime(path6, LinkOption.NOFOLLOW_LINKS) + "\n");
//System.out.println("07_getLastModifiedTime()_Выдает для несуществующего файла для path7- " + Files.getLastModifiedTime(path7, LinkOption.NOFOLLOW_LINKS) + "\n");

		//08_getFileStore() - выдает корневую директорию (локальный диск) расположения файла или папки 		Только для существующих файлов и папок
System.out.println("08_getFileStore()_Выдает для существующего файла для path1- " + Files.getFileStore(path1));
System.out.println("08_getFileStore()_Выдает для существующей папки для path6- " + Files.getFileStore(path6)  + "\n");
//System.out.println("08_getFileStore()_Выдает для несуществующего файла для path7- " + Files.getFileStore(path7) + "\n");

		// 09_getOwner - Выдает имя пользователя (User name Windows)         Только для существующих файлов и папок
System.out.println("09_getOwner()Выдает User name для существующего файла для path1- " + Files.getOwner(path1, LinkOption.NOFOLLOW_LINKS));
System.out.println("09_getOwner()_Выдает для существующей папки для path6- " + Files.getOwner(path6, LinkOption.NOFOLLOW_LINKS)  + "\n");
//System.out.println("09_getOwner()_Выдает для несуществующего файла для path7- " + Files.getOwner(path7, LinkOption.NOFOLLOW_LINKS) + "\n");

		//10_size()  - Выдает размер файла        Только для существующих файлов и папок
System.out.println("10_size()  - Выдает размер файла для существующего файла для path1- " + Files.size(path1));
System.out.println("10_size()  - Выдает для существующей папки для path6- " + Files.size(path6)  + "\n");
//System.out.println("10_size()  - Выдает размер файла для несуществующего файла для path7- " + Files.size(path7) + "\n");


			
		/* 10_Метод getAttribute() позволяет получить свойства (атрибуты) файла. Метод принимает переменное число параметров:
	первый — объект Path; второй — имя атрибута; далее от нуля до нескольких значений LinkOption (это enum)  */
System.out.println("10_Метод getAttribute() позволяет получить свойства (атрибуты) файла");
Path path9 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt");
try { 
    Object object = Files.getAttribute(path9, "creationTime"); 
    System.out.println("Creation time: " + object); 
    
    //Здесь указан третий параметр 
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

	/* 11_Files.create()  - создание файла и папок
  Если данный код без изменений скомпилировать и выполнить повторно, то будет  исключение java.nio.file.FileAlreadyExistsException. */
System.out.println("11_Files.create()  - создание файла и папок \n");
Path path10 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\2.txt");
// System.out.println("11_Files.create()  Создание файла, когда нет такого файла - " + Files.createFile(path10));
// System.out.println("12_Files.create()  Создание файла, когда такой файл уже есть - " + Files.createFile(path10));

	/* 12_Files.copy()_Копирование файлов и директоий (папок) 
Path copy(Path source, Path target, CopyOption. . . options)
Первый параметр — путь к исходному файлу, второй — путь к копии, далее можно задать параметры копирования,а можно и не задать, как ниже: 
Следует отметить, что при копировании директории не будут копироваться содержащиеся в ней файлы и директории. */

System.out.println("12_Files.copy()_Копирование файлов и директоий (папок)");  /*
System.out.println("Путь для path9- " + path9.toRealPath(LinkOption.NOFOLLOW_LINKS));
Path pathDestination = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\CopyOfCopy1.txt");
	try {
		Files.copy(path9, pathDestination);
		System.out.println("Sourse file was copied successfully");}
	catch (IOException e) {
		e.printStackTrace();}  */

/* Если данный код без изменений скомпилировать и выполнить повторно, то будет  исключение java.nio.file.FileAlreadyExistsException.
  Оно связано с тем, что целевой файл уже существует. Для избежания таких проблем можно указать, чтобы в случае его существования он
  перезаписывался. Для этого надо указать Files.copy(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING) */
	
	System.out.println("12_1_Files.copy() с перезаписью");
	System.out.println("Путь для path9- " + path9.toRealPath(LinkOption.NOFOLLOW_LINKS));
	Path pathDestination1 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1OfCopy1.txt");
		try {
			Files.copy(path9, pathDestination1, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Sourse file was copied successfully \n");}
		catch (IOException e) {
			e.printStackTrace();}
		
		//13_Способ копирования папок вместе со всем их содержимым
	// Смотри файл t06_Files_directory_with_files.java

		/* 14_move() - Перемещения файла и папки 
  Метод для перемещения файла очень похож на метод для копирования: Path move(Path source, Path target, CopyOption. . . options)
  Как показано выше, при копировании директории содержащиеся в ней файлы и директории не копировались, 
  Но при перемещении директории, в случае отсутствия ошибок, перемещается и всё ее содержимое. */
	System.out.println("14_move() - Перемещения файла и папки");
	Path pathSource = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1OfCopy1.txt");
	Path pathDestination2 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Copy1OfCopy1.txt");
	try {
		Files.move(pathSource, pathDestination2, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("14_move() - Source file copied successfully \n"); 	}
	catch (IOException e) { 
        e.printStackTrace();   }	
	
		// 15_delete() - Удаление файлов и папок
/* Несколько моментов, которые необходимо помнить относительно метода Files.delete():
 - В случае удаления каталога, необходимо, чтобы он был пустым, иначе исключение (java.nio.file.DirectoryNotEmptyException)
 - Если передать в данный метод символьную ссылку, то будет удалена ссылка, а не целевой файл.
 - Для данного метода необходимо, чтобы файл существовал, иначе будет получено исключение (java.nio.file.NoSuchFileException). 
Если необходимо игнорировать данные случаи, то лучше подойдёт метод deleteIfExists(), который удаляет файл в случае его существования  и не бросает подобное исключение при его отсутствии.*/
	System.out.println("15_delete() - Удаление файлов и папок");
	Path path11 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Copy1OfCopy1.txt");
	try { 
        Files.delete(path11); 
        System.out.println("15_delete() - File deleted successfully \n"); 
    } catch (IOException e) { 
        e.printStackTrace();  }
	
		// 16_deleteIfExists(path)- Удаление файлов и папок, если они существуют
	System.out.println("16_deleteIfExists(path)- Удаление файлов и папок, если они существуют");
	System.out.println("Удаление несуществующего файла");
	Files.deleteIfExists(path11);
	System.out.println("16_deleteIfExists(path) - Метод не бросает исключение в случае отсутствия файла \n");
	
		
	
	
	
	}

}
