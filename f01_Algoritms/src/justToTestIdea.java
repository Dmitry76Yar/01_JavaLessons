import java.time.Duration;

class Records {
	
	
}


public class justToTestIdea {
	public static void main(String[] args) {
		Duration durationOfGame = Duration.ofMillis(10009990);
		StringBuilder sb = new StringBuilder();
		int numberMines = 99;
		if (numberMines <41)  {
    		long sec = durationOfGame.toSeconds();
    		long milliSec = durationOfGame.toMillisPart();
    		sb.append(sec + " секунд ").append(milliSec + " миллисекунд");
    		System.out.println(sb.toString());
    	}
    	else if (numberMines == 99) {
    		long min = durationOfGame.toMinutes();
    		long sec = durationOfGame.toSecondsPart();
    		sb.append(min + " минут ").append(sec + " секунд");
    		System.out.println(sb.toString());
    	}
    	else {
    		long hour = durationOfGame.toHours();
    		Duration dur = durationOfGame.minusMinutes(hour*60);
    		long min = dur.toMinutes();
    		long sec = dur.toSecondsPart();
    		sb.append(hour + " часов ").append(min + " минут ").append(sec + " секунд");
    		System.out.println(sb.toString());
    	}

	}
}
