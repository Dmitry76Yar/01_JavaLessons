package f01_Converts;
public class t9_Char_to_Int { 
public static void main(String args[]) {
	char ch = '2';

    // c использованием метода getNumericValue
    // класса Character
    int i1 = Character.getNumericValue(ch);
    System.out.println(i1); 

    // c использованием метода digit класса Character
    int i2 = Character.digit(ch,10); 
    System.out.println(i2);
     
}
}