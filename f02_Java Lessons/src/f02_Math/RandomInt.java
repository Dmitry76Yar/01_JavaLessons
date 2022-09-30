package f02_Math;
import java.util.Random;
class Integer {}

class RandomInt{
    public static void main(String[] args) {
     Random random = new Random();
     int a;
     a = random.nextInt(100);
	 System.out.println ("a= " + a);
	 
	 // Задать Random для чисел 0-2
	 int a1;
     a1 = random.nextInt(3);
	 System.out.println ("a1= " + a1);
     
     }
  }