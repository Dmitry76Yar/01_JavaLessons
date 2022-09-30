package f08_Class;
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
          p1.guess();
          p2.guess();
          p3.guess();
          guess_pl1 = p1.number; System.out.println("игрок 1 назвал число = " + guess_pl1);
          guess_pl2 = p2.number; System.out.println("игрок 2 назвал число = " + guess_pl2);
          guess_pl3 = p3.number; System.out.println("игрок 3 назвал число = " + guess_pl3);
          
          if (p1.number == Target_number) Answer_pl1 = true;
          if (p2.number == Target_number) Answer_pl2 = true;
          if (p3.number == Target_number) Answer_pl3 = true;
          
          if (Answer_pl1 || Answer_pl2 || Answer_pl3) {
              System.out.println("У нас есть победитель");
              System.out.println("Ответ 1-го игрока = " + Answer_pl1);
              System.out.println("Ответ 2-го игрока = " + Answer_pl2);
              System.out.println("Ответ 3-го игрока = " + Answer_pl3);
              System.out.println("Конец игры");
            break;}  
            else System.out.println("\t Никто не отгадал");
                // End method IF
        } // End method While
    } // End method StartGame
 }// End class GuessName

  class Player {
     int number = 0;
     public void guess() { 
        number = (int)(Math.random()*10);}
}
 
 public class Game{
 public static void main (String [] args){
     GuessGame Game1 = new GuessGame();
     Game1.startGame();
    }
}
 