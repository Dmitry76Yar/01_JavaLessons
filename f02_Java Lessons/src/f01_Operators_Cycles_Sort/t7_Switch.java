package f01_Operators_Cycles_Sort;
class t7_Switch{
  public static void main (String[] args){
    for (int i=1; i<=13; i++) {
        switch (i){
            case 1 : case 2 : case 12 : System.out.println("  Winter" + i); break;
            case 3 : case 4 : case 5 : System.out.println("  Spring" + i); break;
            case 6 : case 7 : case 8 : System.out.println("  Summer" + i); break;
            case 9 : case 10 : case 11 : System.out.println("  Autumn" + i); break;
            default : System.out.println("  Nothing" + i);
        }// switch
    }//for
  }//method
}//class
            