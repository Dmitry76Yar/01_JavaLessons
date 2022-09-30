package t23_Files_Path;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

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

/* 		Использование интерфейса Path
Java 7 представляет новую абстракцию для пути, а именно интерфейс Path.  
Объект пути содержит имена каталогов и файлов, которые составляют полный путь до файла/каталога, представленного объектом Path; 
Path содержит методы для извлечения элементов пути, манипуляций с ними и их добавления.
	Path, по большому счету, — это переработанный аналог класса File. Работать с ним значительно проще, чем с File.
Во-первых, из него убрали многие утилитные (статические) методы, и перенесли их в класс Files.
Во-вторых, в Path были упорядочены возвращаемые значения методов. В классе File методы возвращали то String, то boolean, то File — 
разобраться было непросто.  Например, был метод getParent(), который возвращал родительский путь для текущего файла в виде строки. 
Но при этом был метод getParentFile(), который возвращал то же самое, но в виде объекта File!
	Поэтому в интерфейсе Path метод getParent() и другие методы работы с файлами возвращают просто объект Path.
	
	Символьная ссылка (Symbolic link, симлинк) — специальный файл в файловой системе, содержащий только текстовую строку с указателем. 
Эта строка трактуется как путь к файлу, который должен быть открыт при попытке обратиться к данному файлу.
	Абсолютный путь — это путь, который указывает на одно и то же место в файловой системе, вне зависимости от текущей директории.
Полный путь всегда начинается с корневого каталога.
	Относительный путь — это путь по отношению к текущему рабочему каталогу.
	
	    Методы
 - int	compareTo(Path other) - сравнивает пути посимвольно и возвращает: 0, если пути равны; отрицательное целое значение, если
 путь в объекте вызывающем метод лексикографически меньше пути в объекте, переданном в качестве параметра; положительное целое 
 значение в противоположном случае
 - boolean	endsWith(Path other)  - Tests if this path ends with the given path.
 - boolean	endsWith(String other)  - Tests if this path ends with a Path, constructed by converting the given path string, in exactly 
the manner specified by the endsWith(Path) method.
 - boolean	equals(Object other)  - сравнивает пути и возвращает Boolean
 - Path	getFileName()  - Returns the name of the file or directory denoted by this path as a Path object.
 - FileSystem	getFileSystem()  - Returns the file system that created this object.
 - Path	getName(int index)  - Returns a name element of this path as a Path object.
 - int	getNameCount() - Returns the number of name elements in the path.
 - Path	getParent() - Returns the parent path, or null if this path does not have a parent.
 - Path	getRoot() - Returns the root component of this path as a Path object, or null if this path does not have a root component.
 - int	hashCode() - Computes a hash code for this path.
 - boolean	isAbsolute() - Tells whether or not this path is absolute.
 - Iterator<Path>	iterator() - Returns an iterator over the name elements of this path.
 - Path	normalize() -  удаляет ненужные символы (такие как “ . ” и “ .. ”) из объекта Path
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
 - Path	toAbsolutePath() - Метод toAbsolutePath() возвращает абсолютный путь от данного относительного пути. В случае, если был 
 введён абсолютный путь, метод вернёт его же
 - File	toFile() - Returns a File object representing this path.
 - Path	toRealPath(LinkOption... options) - Returns the real path of an existing file.
 - String	toString() - Returns the string representation of this path.
 - URI	toUri() - Метод toUri() возвращает URI (путь который может быть открыт из браузера).
 */

public class t04_Path {
public static void main(String[] args) throws IOException {
		/* Cоздание объекта по АБСОЛЮТНОМУ пути
	Path через вызов статического метода get() класса Paths 
	Абсолютный путь — это путь, который указывает на одно и то же место в файловой системе, вне зависимости от текущей директории. */ 
Path testFilePath = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\src\\Copy1.txt");
		
		// Другой вариант того же метода и той же ссылки
Path testFilePath2 = Paths.get("C:\\Users","dkuli", "Documents", "My_works", "Lessons", "src", "Copy1.txt");
		
		// Создание объекта для несуществующего файла
Path NonExistingFilePath = Paths.get("C:\\Users","dkuli", "Documents", "My_works", "Lessons", "src", "Copy2.txt");
	
		/* Получение абсолютного пути от ОТНОСИТЕЛЬНОГО пути и нормализация пути 
	Относительный путь — это путь по отношению к текущему рабочему каталогу.
	Метод normalize() - удаляет ненужные символы (такие как “ . ” и “ .. ”) из объекта Path*/
Path testRelatingPath = Paths.get(".\\Copy3.txt");
System.out.println("Получение абсолютного пути от относительного пути и нормализацию пути");

		/* Метод toAbsolutePath() возвращает абсолютный путь от данного относительного пути. */
System.out.println("00_toAbsolutePath() для оносительной ссылки выдает  " + testRelatingPath.toAbsolutePath()); 

		// Метод normalize() выполняет нормализацию пути, другими словами удаляет ненужные символы (такие как “ . ” и “ .. ”) из объекта Path.
System.out.println("00_normalize() для оносительной ссылки выдает  " + testRelatingPath.normalize()); 

		//Получение другого объекта строки по нормализованному относительному пути 
Path testRelatingPathNormalized = Paths.get(testRelatingPath.normalize().toString()); 
System.out.println("00_Абсолютный путь для нормализованного пути: "+ testRelatingPathNormalized.toAbsolutePath()); 

		/* Метод toRealPath () возвращает абсолютный путь от полученного пути (как toAbsolutePath ()) и нормализует его (как 
	normalize()). Кроме того, если все параметры выбраны правильно, то он может даже работать с символьными ссылками. Однако, для
 	этого метода необходимо, чтобы конечный файл/каталог существовал в файловой системе (это не является обязательным условием 
 	для других методов Path).   */	
Path testRelatingPath2 = Paths.get(".\\Copy1.txt");
System.out.println("00_toRealPath () для существующего файла: "+ testRelatingPath2.toRealPath(LinkOption.NOFOLLOW_LINKS) + "\n"); 

		// 01_Path getFileName() - Returns the name of the file or directory denoted by this path as a Path object.
System.out.println("01_Path getFileName()_Возвращает имя файла :  " + testFilePath.getFileName());
System.out.println("01_Path getFileName()_Возвращает имя файла :  " + testFilePath2.getFileName());
System.out.println("01_Path getFileName()_Для несуществующего файла также возвращает его имя :  " + NonExistingFilePath.getFileName());
System.out.println("01_Path getFileName()_Для объекта с относительной ссылкой возвращает его имя :  " + testRelatingPath.getFileName() + "\n");	
	
		// 02_FileSystem	getFileSystem() - Returns the file system that created this object.
	System.out.println("02_FileSystem	getFileSystem()_Возвращает имя файловой системы :  " + testFilePath.getFileSystem() + "\n");
		
		// 02_1_Path getName(int index) - Returns a name element of this path as a Path object.
	System.out.println("02_1_Path getName(int index)_Возвращает имя 2-го элемента пути :  " + testFilePath.getName(2) + "\n");
	
		// 03_Path	getParent() - 	Returns the parent path, or null if this path does not have a parent.
	System.out.println("03_Path	getParent()_Возвращает имя каталога выше файла :  " + testFilePath.getParent());
	System.out.println("03_Path	getParent()_Для несуществующего файла также возвращает имя каталога :  " + NonExistingFilePath.getParent() + "\n");
	
		// 04_Path	getRoot() - Returns the root component of this path as a Path object, or null if this path does not have a root component.
	System.out.println("04_Path	getRoot()_Возвращает имя верхнего каталога файла :  " + testFilePath.getRoot()  + "\n" );
	
		// 05_int	getNameCount() - Returns the number of name elements in the path.
	System.out.println("05_int	getNameCount()_Возвращает имя верхнего каталога файла :  " + testFilePath.getNameCount()  + "\n" );
		
		//06_Path ForEach_Вывод элементов пути построчно 
    System.out.println("06_Path ForEach_Вывод элементов пути построчно  "); 
    for (Path element : testFilePath) { 
        System.out.print("\t " + element);} 
    System.out.println("\n");
    
    	//07_Iterator<Path>	iterator() -  Returns an iterator over the name elements of this path.
    System.out.println("07_Iterator<Path>	iterator()_Вывод элементов пути построчно  ");
    Iterator<Path> it = testFilePath.iterator();
    while (it.hasNext())	{
 	   Path element = it.next();
 	   System.out.print(element + "\t");	} System.out.println("\n");
 	   
    	// 08_boolean	endsWith(String other) -  Tests if this path ends with a Path, constructed by converting the given path string, in exactly the manner specified by the endsWith(Path) method.
 System.out.println("08_boolean	endsWith(String other) - Путь заканчивается на  Copy1.txt -   " + testFilePath.endsWith( "Copy1.txt"));
 System.out.println("08_boolean	endsWith(String other) - Путь заканчивается на  src\\Copy1.txt -   " + testFilePath.endsWith( "src\\Copy1.txt"));
 System.out.println("08_boolean	endsWith(String other) - Путь заканчивается на  txt -   " + testFilePath.endsWith( "txt") + "\n" );
 
 		// 09_boolean endsWith(Path other) -  Tests if this path ends with the given path.
 Path CorrectEndFilePath = Paths.get("Copy1.txt");
 Path InCorrectEndFilePath = Paths.get("py1.txt");
 System.out.println("09_boolean endsWith(Path other) - Путь заканчивается на  Copy1.txt -   " + testFilePath.endsWith(CorrectEndFilePath));
 System.out.println("09_boolean endsWith(Path other) - Путь заканчивается на  py1.txt -   " + testFilePath.endsWith(InCorrectEndFilePath) + "\n");
 			
 		//10_boolean startsWith(String other) -  Tests if this path starts with a Path, constructed by converting the given path string, in exactly the manner specified by the startsWith(Path) method.
 System.out.println("10_boolean startsWith(String other) - Путь начинается на  C: -   " + testFilePath.endsWith( "C:\\"));
 System.out.println("10_boolean startsWith(String other) - Путь начинается на  C: -   " + testFilePath.endsWith( "Users"));
 System.out.println("10_boolean startsWith(String other) - Путь начинается на  C: -   " + testFilePath.endsWith( "Users\\dkuli") + "\n");
        
 		// 11_boolean	startsWith(Path other) - Tests if this path starts with the given path.
 
 		//12_Path subpath(int beginIndex, int endIndex) - Returns a relative Path that is a subsequence of the name elements of this path.
 System.out.println("12_Path subpath(int beginIndex, int endIndex) - Путь с 2-го до 5-го элемента -   " + testFilePath.subpath(2, 5) + "\n");
 
 		// 13_URI	toUri() -  Метод toUri() возвращает URI (путь который может быть открыт из браузера).
 System.out.println("13_URI	toUri() - Путь в URI выражении -   " + testFilePath.toUri() + "\n");
 
 		//14_Path	toAbsolutePath() - Returns a Path object representing the absolute path of this path.
 // Абсолютный путь — это путь, который указывает на одно и то же место в файловой системе, вне зависимости от текущей директории.
 // Полный путь всегда начинается с корневого каталога.
 System.out.println("14_Path	toAbsolutePath() - Абсолютный путь -   " + testFilePath.toAbsolutePath() + "\n");
 
 		// 15_Path	toRealPath(LinkOption... options) - Returns the real path of an existing file.

 		// 16_File	toFile() -  Returns a File object representing this path.
 System.out.println("16_File	toFile() - Возвращает File путь -   " + testFilePath.toFile() + "\n");
 
 		// 17_boolean	isAbsolute() -  Tells whether or not this path is absolute.
 System.out.println("17_boolean	isAbsolute() - testFilePath это абсолютный путь?  -   " + testFilePath.isAbsolute());
 Path UnproperTestFilePath = Paths.get("My_works\\Lessons\\src\\Copy1.txt");
 System.out.println("17_boolean	isAbsolute() - UnproperTestFilePath это абсолютный путь?  -   " + UnproperTestFilePath.isAbsolute());
 System.out.println("17_boolean	isAbsolute() - NonExistingFilePath это абсолютный путь?  -   " + NonExistingFilePath.isAbsolute() + "\n");
 
 		//18_equals() сравнивает пути и возвращает Boolean
 Path path1 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt"); 
 Path path2 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt"); 
 Path path3 = Paths.get(".\\Copy1.txt");
 Path path4 = Paths.get("Copy1.txt");
 System.out.println("18_equals()_Реальный путь для относительного path3- " + path3.toRealPath(LinkOption.NOFOLLOW_LINKS));
 System.out.println("18_equals()_Реальный путь для относительного path4- " + path4.toRealPath(LinkOption.NOFOLLOW_LINKS));
 System.out.println("18_equals()_ для одинаковых абсолютных путей-  "    + (path1.equals(path2))); 
 System.out.println("18_equals()_ для равных абсолютного и относительного путей-  "    + (path1.equals(path3)));
 System.out.println("18_equals()_ для равных абсолютного и относительного путей после приведения к абсолютному пути и нормализации -  "    + 
		 	(path1.equals(path3.normalize().toAbsolutePath())));
 System.out.println("18_equals()_ для равных относительного пути без точки и относительного пути с точкой после нормализации -  "    + 
		 	(path4.equals(path3.normalize())) + "\n");
 
  		/* 19_Метод compareTo() сравнивает пути посимвольно и возвращает: 0, если пути равны; отрицательное целое значение, если
 путь в объекте вызывающем метод лексикографически меньше пути в объекте, переданном в качестве параметра; положительное целое 
 значение в противоположном случае. */
 Path path5 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Copy1.txt");
 Path path6 = Paths.get("C:\\Users\\dkuli\\Documents\\My_works\\Lessons");
 System.out.println("19_compareTo()_для одинаковых абсолютных путей-  "    + (path5.compareTo(path5)));
 System.out.println("19_compareTo()_ Если путь короче-  "    + (path5.compareTo(path6))); 
 System.out.println("19_compareTo()_ Если путь длинее -  "    + (path6.compareTo(path5)));
 
 
	}
}

