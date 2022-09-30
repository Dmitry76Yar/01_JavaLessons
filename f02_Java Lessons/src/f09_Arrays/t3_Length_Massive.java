package f09_Arrays;
class t3_Length_Massive {
public static void main(String args[]) {
    int list[] = new int[10];
    int nums[] = {1, 2, 3};
    int table[][] = 
            {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
System.out.println("Paзмep списка: " + list.length);
System.out.println("Paзмep nums: " + nums.length);
System.out.println("Paзмep tаblе: " + table.length);

System.out.println("Paзмep tаblе: " + table[0].length);
System.out.println("Paзмep tаblе: " + table[1].length);
System.out.println("Paзмep tаblе: " + table[2].length);
System.out.println();
}
    }