package f01_Converts;
public class t2_Int_to_String { 
public static void main(String args[]) {
	// int to String
	int i = 35;
    String str = Integer.toString(i);
	System.out.println(str);
	
	//double to String
	double  i1 = 32.4e10;
   String str1 = Double.toString(i1);
   System.out.println(str1); 

	// long to String
	long  i2 = 3422222;
   String str2 = Long.toString(i2);
   System.out.println(str2 + "\n");
		
	// С использованием valueOf
   System.out.println("С использованием valueOf");
   String s = String.valueOf(i);
   System.out.println(i);	
   
   String s1 = String.valueOf(i1);
   System.out.println(i1);
   
   String s2 = String.valueOf(i2);
   System.out.println(i2);
   
}
}