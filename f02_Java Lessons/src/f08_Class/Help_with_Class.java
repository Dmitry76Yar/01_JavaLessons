package f08_Class;
import java.util.Scanner;

class Help {
    // showmenu // Метод для отображения исходного меню выбора справочной информации
    // help_on  // Метод для обработки запроса и выведения информации по выбранному варианту
    // isvalid  // Метод проверки правильности выбора
   
void help_on(char what){
 switch(what) {
            case '1': 
                System.out.println("Oпepaтop if:\n if{ycлoвиe) оператор; \n else оператор;" );
                break;
            case '2':   
                System.out.println("Oпepaтop switch:\n switch(выpaжeниe){ \n\t case константа: \n\t\t последовательность операторов \n\t\t" +
                " break \n default:  последоватеность операторов \n }");
                break;
            case '3':   
                System.out.println("Oпepaтop For:\n For(инициализация счетчика; условие для счетчика; итерация) { \n\t" +
                " последовательность операторов \n\t }");
                break;
            case '4':
                System.out.println("Oпepaтop While:\n while(ycлoвиe) оператор;");
                break;
            case '5':
                System.out.println("Oпepaтop do-while:\n\t do{ \n\t\t оператор \n\t } \t while(ycлoвиe);");
                break;   
            case 'q': 
                System.out.println("Вы вышли"); break;
        default: System.out.println("Запрос не найден");}
 }
void showmenu() {
     System.out.println("Справка: '\n' 1. Оператор If '\n' 2. Оператор Switch '\n' 3.Оператор For '\n' 4.Оператор While '\n'"+  "5.Оператор Do-While '\n' Выберите q для выхода '\n'");
}

boolean isvalid(char ch){
    //if (ch>'5' | ch<='0' | ch=='q') return false;
    if (ch=='1' | ch=='2' | ch=='3' | ch=='4' | ch=='5' | ch=='q') return true;
    else return false; }
} 
    
class Help_with_Class {
    public static void main (String[] args)
    throws java.io.IOException { 
        Help Help1 = new Help();
        char a;
        char ignore;
        
    for(;;) {
        Help1.showmenu();        
        System.out.println (" Введите число ");
        a = (char)System.in.read();
        do{
            ignore = (char)System.in.read();}
        while (ignore!= '\n');
        
        if (Help1.isvalid(a) == true) Help1.help_on(a);
        else System.out.println (" Неправильно ввели число");
        
        if (a == 'q') break;
        }
    }
}