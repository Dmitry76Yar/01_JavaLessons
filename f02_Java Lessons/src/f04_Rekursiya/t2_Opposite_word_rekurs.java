package f04_Rekursiya;
/* Напишите рекурсивный метод, отображающий символы, составляющие строку в обратном порядке. */

class Temp {
    String s;
    
    Temp (String s) {
    this.s = s; }
    
    void Opposite_recursiya (int n) {
        System.out.println("n = " + n);
        if (n != s.length())    Opposite_recursiya(n+1);
        else return;
            System.out.print("n = " + n);
            System.out.println("\t" + s.charAt(n));     
         
    }
}

class t2_Opposite_word_rekurs {
    static String Opposite (String a1) {
        String result = "";
        String c = "";
        for (int i = (a1.length()-1); i>=0; i--) {
        result = result + "" + a1.charAt(i);}
    return result;}
    
public static void main(String[] args) {
   String a = "abcdefgh";
   String b = Opposite(a);
   System.out.println("Обычным методом " + b);
   
   Temp ob1 = new Temp(a); 
   ob1.Opposite_recursiya(0);
   
   
   }
    }
