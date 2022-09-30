package f23_Scanner;
 import java.util.Scanner;
 
 class GuessGame {
     Player p1;
     Player p2;
     Player p3;
     
 public void startGame() {
     p1 = new Player();         p2 = new Player();        p3 = new Player();
     int guess_pl1 = 0;         int guess_pl2 = 0;        int guess_pl3 = 0;
     boolean Answer_pl1 = false;        boolean Answer_pl2 = false;       boolean Answer_pl3 = false; 
     int Target_number = Target_number = (int)(Math.random()*10); 
     System.out.println("Система загадала число " + Target_number);        
     while (true) {
          Scanner sc1 = new Scanner(System.in);
          System.out.print("\t игрок 1 введите число =  \t"); 
          guess_pl1 = (int)sc1.nextInt(); 
            System.out.print("\t игрок 2 введите число =  \t"); 
            guess_pl2 = (int)sc1.nextInt(); 
                System.out.print("\t игрок 3 введите число =  \t"); 
                guess_pl3 = (int)sc1.nextInt(); 
          
          if (guess_pl1 == Target_number) Answer_pl1 = true;
          if (guess_pl2 == Target_number) Answer_pl2 = true;
          if (guess_pl3 == Target_number) Answer_pl3 = true;
          
          if (Answer_pl1 || Answer_pl2 || Answer_pl3) System.out.println("У нас есть победитель");
          else System.out.println("Никто не отгадал");
          
          if (Answer_pl1) { System.out.println("Победил 1-ый игрок"); System.out.println("Конец игры"); break;}
          else if (Answer_pl2 == true)  {System.out.println("Победил 2-oй игрок"); System.out.println("Конец игры"); break;}
          else if (Answer_pl3 == true)  {System.out.println("Победил 3-ий игрок"); System.out.println("Конец игры"); break;}
           
        } // End method While
    } // End method StartGame
 }// End class GuessName

 class Player {}
 
 public class t04_Scanner_Guess_for_3_players{
 public static void main (String [] args){
     GuessGame Game1 = new GuessGame();
     Game1.startGame();
    }
}
 