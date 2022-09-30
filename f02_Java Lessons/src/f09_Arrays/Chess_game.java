package f09_Arrays;
class Start_Finish_Points {   // Класс для определения координат исходной и финишной точек
     int x = 0; int y = 0;
     public void Initial_Point() {  // Метод для определения координат исходной и финишной точек
        x = (int)(Math.random()*10); while (x>=8)  x = (int)(Math.random()*10);  // ограничивает координаты 0-7
        y = (int)(Math.random()*10); while (y>=8)  y = (int)(Math.random()*10);}
}        

class Chess_game {
    public static void main (String[] args) {
             
     int M[][] = new int[8][8];
      for (int i=0; i<8; i++) {
        for (int j=0; j<8; j++)     M[i][j] = 15;}

           
     int x_start, y_start, x_finish, y_finish = 0; 
     Start_Finish_Points Start = new Start_Finish_Points();
     Start_Finish_Points Finish = new Start_Finish_Points();
     Start.Initial_Point();
     Finish.Initial_Point();
     x_start = Start.x;     y_start = Start.y;
     x_finish = Finish.x;   y_finish = Finish.y;
     System.out.print(" x_start=  " + x_start + "\t");
     System.out.println(" y_start =  " + y_start);  
     System.out.print(" x_finish=  " + x_finish + "\t");
     System.out.println(" y_finish =  " + y_finish);  
     M[x_start][y_start] = 0;
     M[x_finish][y_finish] = 10;
     
    for (int i=0; i<8; i++) {System.out.print("\t " + i + " ");
        for (int j=0; j<8; j++)     System.out.print(" \t | " + M[i][j] + "\t ");
        System.out.println(" | "); }

for (int n=0; n<10; n++) {
    for (int x=0; x<8; x++) {
        for (int y=0; y<8; y++)     {
        if (M[x][y] == n)  {
                if ( ((x-2)<8)& ((x-2)>=0)&((y+1)<8)&((y+1)>=0) )  {
                    if ((M[x-2][y+1])>n) M[x-2][y+1] = (n+1);}
                        //else break;
                if ( ((x-2)<8)& ((x-2)>=0)&((y-1)<8)&((y-1)>=0) ) {
                    if ((M[x-2][y-1])>n) M[x-2][y-1] = (n+1);}
                        //else break;
                if ( ((x-1)<8)& ((x-1)>=0)&((y+2)<8)&((y+2)>=0) ) {
                    if ((M[x-1][y+2])>n) M[x-1][y+2] = (n+1);}
                        //else break;
                if ( ((x+1)<8)& ((x+1)>=0)&((y+2)<8)&((y+2)>=0) )  {
                    if ((M[x+1][y+2])>n) M[x+1][y+2] = (n+1);}
                        //else break;
                if ( ((x-1)<8)& ((x-1)>=0)&((y-2)<8)&((y-2)>=0) )  {
                    if ((M[x-1][y-2])>n) M[x-1][y-2] = (n+1);}
                        //else break;
                if ( ((x+1)<8)& ((x+1)>=0)&((y-2)<8)&((y-2)>=0) ) {
                    if ((M[x+1][y-2])>n) M[x+1][y-2] = (n+1);}
                        //else break;
                if ( ((x+2)<8)& ((x+2)>=0)&((y+1)<8)&((y+1)>=0) ) {
                    if ((M[x+2][y+1])>n) M[x+2][y+1] = (n+1);}
                        //else break;
                if ( ((x+2)<8)& ((x+2)>0)&((y-1)<8)&((y-1)>0) )  {
                    if ((M[x+2][y-1])>n) M[x+2][y-1] = (n+1);}
                        //else break;
                } // End IF
            }// End for with y
        }// End for with x
       
         System.out.println("  \n           (n+1) = " + (n+1));
     
    for (int i=0; i<8; i++) {System.out.print(" " + i + " ");
    for (int j=0; j<8; j++)     System.out.print(" |\t " + M[i][j] + " \t ");
        System.out.println(" | "); }
    
    int a= 0;
    for (int k=0; k<8; k++) {
    for (int l=0; l<8; l++) { if (M[k][l] == 15) {System.out.print("1"); a++;}
    }  }   
   System.out.println("  a= " + a);    
    if (a==0) n=10;
      
  
    }// End for with n
    
  
 System.out.println(" \n   Количество ходов до достижения цели " + M[x_finish][y_finish]);
     }
}
