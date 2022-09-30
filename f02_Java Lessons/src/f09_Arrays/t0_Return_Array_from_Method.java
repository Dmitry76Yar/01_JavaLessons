package f09_Arrays;
class t0_Return_Array_from_Method {
	
public static int[] m1() {
return new int[] {1,2,3};}	

public static void main(String args[]){
int arr[] = m1();
for (int i=0; i<arr.length; i++) 
	System.out.print(arr[i] + "\t  ");
}
}