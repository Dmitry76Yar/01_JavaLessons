package f01_Converts;
// Напишите класс, который принимает с клавиатуры фамилию, имя и отчество, а затем выводит на
//  экран инициалы (без пробела между инициалами).

import java.util.Scanner;

 public class Char_from_String {
   static Scanner reader = new Scanner(System.in); 
   public static void main(String[] args) {
         System.out.println("Введите фамилия");
         String family = reader.next();    // Считывает первое слово до пробела
         
         System.out.println("Введите имя");
         String name = reader.next(); 
         
         System.out.println("Введите отчество");
         String otchestvo = reader.next(); 
         
         // charAt() возвращает символ из массива строки по указанному индексу.
         System.out.println("Первая буква фамилия " + family.charAt(0));
         System.out.println("Первая буква фамилия " + family.charAt(3));
         System.out.println("Первая буква фамилия " + name.charAt(0));
         System.out.println("инициалы: " + family.charAt(0) + "." + name.charAt(0) + "." + otchestvo.charAt(0) + " ");
         
            }
   } 