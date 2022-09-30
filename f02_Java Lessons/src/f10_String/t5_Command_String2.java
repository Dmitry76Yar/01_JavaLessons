package f10_String;
// Многие программы получают параметры, задаваемые в командной строке. Это так называемые аргументы командной строки. 
// Они представляют собой данные, указываемые непосредственно после имени запускаемой на выполнение программы.
// Отображение всех данных, указываемых в командной строке

class t5_Command_String {
    public static void main (String args []) {
        System.out.println("To programm was transferred " + args.length + " following arguments from command string");
        System.out.println("List of arguments: ");
        
// ВАЖНО, чтобы файл был сохранен в той же папке от куда вызывается командная строк (С\Users\ae3920)
// Если набрать в командной строке С\Users\ae3920>java пробел Command_string((название файла)
// и далее через пробел One Two Three, то командная строка выведет  arg[0] = One, arg[1] = Two, arg[2] = Three
        
for(int i=0; i<args.length; i++)
    System.out.println("arg[" + i + "]: " + args[i]);
    }
}