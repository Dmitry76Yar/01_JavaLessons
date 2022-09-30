package f09_Arrays;

class t2_Massive_min_max {
public static void main (String[] args) {
     int max = 0; int min = 0;
     int nums [] = new int [10];
        nums[0] = 99;
        nums[1] = -10;
        nums[2] = 100112;
        nums[3] = 18;
        nums[4] = -978;
        nums[5] = 5623;
        nums[6] = 463;
        nums[7] = -9;
        nums[8] = 287;
        nums[9] = 49;
    // int nums[] = {99, -10, 100112, 18, -978, 5623, 463, -9, 287, 49};
    
     for (int i=0; i < nums.length; i++) {
         if (nums[i] > max) max = nums[i];
         if (nums[i] < min) min = nums[i];}
         
       //  int i = 0;
      //while (true) {
      //     if( nums[i] > max) max = nums[i];
       //    if (nums[i] < min) min = nums[i];
       //    i++; 
     // if (i==10) break;}
     
 System.out.println ("Минимальное значение массива =  " + min);
 System.out.println ("Максимальное значение массива =  " + max);
 
}
}
 