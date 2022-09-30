package f04_Rekursiya;
class Demo{
    int result;
    public int Factorial(int n) {
        System.out.println("    n = " +  n);
            if (n==1) return 1;
            else result = n*Factorial(n-1); 
            return result;  
    }
}

class t1_Recursiya_factorial{
    public static void main(String[] args) {
        int chislo; 
        Demo ob = new Demo();
        chislo = ob.Factorial(5);
        System.out.println(chislo);
        
        int res=1;
        for (int i=5; i>0; i--)  res = res*i; 
        System.out.println(res);   
        
                     }
} 
   