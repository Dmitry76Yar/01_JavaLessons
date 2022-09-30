package t23_Files_Path;

import java.io.IOException;
import java.nio.file.*; 
import java.nio.file.attribute.BasicFileAttributes; 

/* Обход дерева файлов
При работе с файловой системой может возникнуть необходимость обхода дерева файлов, например при поиске файла или копировании
каталога со всем его содержимым. Класс Files содержит два метода, позволяющих обходить дерево файлов. Их сигнатуры приведены ниже:
	 - Path walkFileTree(Path start, FileVisitor<!--? super Path--> visitor) 
	 - Path walkFileTree(Path start, Set<filevisitoption> options, int maxDepth, FileVisitor<!--? super Path--> visitor) 
Оба метода принимают путь, с которого начнётся обход дерева и экземпляр типа FileVisitor, который будет определять поведение при 
обходе дерева. Второй метод имеет два дополнительных параметра: Set, содержащий опции обхода, и максимальную глубину. 
Максимальная глубина определяет, насколько уровней каталогов будет происходить обход. Если в её качестве указать 0, то будет 
рассматриваться только указанный файл, а если указать MAX_VALUE, то будут пройдены все подкаталоги.
	FileVisitor — это интерфейс, содержащий следующие методы:
- FileVisitResult preVisitDirectory(T dir, BasicFileAttributesattrs) — выполняется перед достуом к элементам каталога.
- FileVisitResult visitFile(T file, BasicFileAttributes attrs) — выполняется при доступе к файлу.
- FileVisitResult postVisitDirectory(T dir, IOException exc) — выполняется, когда все элементы директории пройдены .
- FileVisitResult visitFileFailed(T file, IOException exc) — выполняется, если к файлу нет доступа.
Вам необходимо реализовать интерфейс FileVisitor, чтобы передать соответствующий объект в метод walkFileTree(). Но если необходимости
реализовывать все четыре метода этого интерфейса нет, то можно просто расширить реализацию класса SimpleFileVisitor, переопределив 
лишь необходимые методы.

	При выполнении данного кода будут выведены все вложенные каталоги и файлы по указанному пути. Вот что следует понять:
Объявляется класс MyFileVisitor, унаследованный от SimpleFileVisitor, в котором переопределены два метода: 
 - visitFile() (для вывода имени файла) и 
 - preVisitDirectory() (для вывода имени директории).
 Вызывается walkFileTree() в который передаётся объект MyFileVisitor.
Метод walkFileTree() начинает выполнение с переданного в него каталога. При этом вызывается метод visitFile() при каждом проходе 
файла, preVisitDirectory() — перед просмотром элементов директории, postVisitDirectory() — после просмотра элементов директории, 
visitFileFailed() — в случае отсутствия доступа к файлу/дириктории.
	Из этих четырёх методов были переопределены только два для вывода имён каталогов и файлов.
Можно контролировать поток обхода с помощью возвращаемых этими методами значений (enum FileVisitResult). Их четыре:
 - CONTINUE: указывает на то, что обход дерева следует продолжить.
 - TERMINATE: указывает, что обход нужно немедленно прекратить.
 - SKIP_SUBTREE: указывает, что подкаталоги должны быть пропущены для обхода.
 - SKIP_SIBLINGS: указывает на то, что обход должен быть остановлен в текущем каталоге и каталогах одного уровня с ним. Если это значение возвращается из preVisitDirectory(), то вложенные файлы/каталоги не обходятся и postVisitDirectory() не срабатывает. Если это значение возвращается из visitFile (), то остальные файлы каталога не обходятся. Если он возвращается из postVisitDirectory (), то остальные каталоги того же уровня не будут обходиться.
	*/

// НЕ РАБОТАЕТ
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
 
        Path pathSource = Paths.get("Введите сюда путь к какому-либо каталогу, содержащему другие каталоги и файлы"); 
        try { 
            Files.walkFileTree(pathSource, new MyFileVisitor()); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
} 