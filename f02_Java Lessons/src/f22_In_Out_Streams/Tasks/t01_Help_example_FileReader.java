package f22_In_Out_Streams.Tasks;

import java.io.*;
/*  	???????? ?????????? ???????, ??????????? ?? ?????
 	? ????? ???????? ?????????? ?????????? ?????? ????????? ? ?????. ??? ????? ??????? ????????? ????, ??????? ????? ????????, ??
 ?????????? ???????? ??? ?????????. ??? ???? ????? ???????? ??????? ?? ??????????? ???????, ??????? ?????? ???????? ????. ???????
 ????? ?????? ??????????????? ?????? ? ?????. ???? ????? ?????????? ???????, ?????????? ?????????? ????? ???????? ?? ????? 
  	???? Help.txt -  ?????????? ?????????? ?? ?????????? Javf. 
  	???? ???????????, ??? ???????? ????.
		#if
		if(???????) ????????;
		else ????????;
		
		#switch
		swit?h(?????????)
		case ?????????:
	???????? ?????? ???? ????????????? ? ????????? ?????? ? ???????????? ???????? #. ??????? ???????????? ??????? ? ?????? 
(? ?????? ?????? - #) ????????? ????????? ?????? ????? ?????? ???????. ????? ??????? ??????? ?????? ???? ??????? ?????? ??????. 
????? ????, ? ????? ????? ?? ?????? ???? ?????? ????????.
???? ???????? ?????? ???????? ????? ?? ?????????? ???????????, ???????
????? ???????????? ?????? ? ????? ??????? ?????????? ???????. ? ??? ????????
???????? ?? ?????????? Java.
 */

class Help {
	String path;
			// ???????????. ? ???? ?????????? ???? ? ????? Help.txt.   ?.?. ????? ???????????? ????? ?????????? ??????????????? ??????
	Help(String path) {
		this.path = path; }
	
	/* ?????  helpon (String target)- ? ???? ???????? ??????, ????????, "if", ?? ??????? ?? ??????? ???????? ?????? ? ????? Help.txt
	?????, ??? ? ?????? helpon () ?????????????? ??? ??????????, ????????? ? ??????-???????, ??????? ? ????????? ?????? ??
	??????? ???????? ????? throws. ????????? ?????? ??????? ?????????? ?????????? ???????, ? ??????? ???????????? ????? helpon ()
	? ?????????? ?????? ?????????? ?????????? ? ?????? helpon (), ?? ???????? ??? ????? ? ???? try / catch. 
	 	????? helpon () ????????? ????????? ???????. ?????????? ??????, ?????????? ???????? ????, ?????????? ?????? ? ????????
	 ?????????. ??????? ????? ????????? ???? ?? ?????????? ???????????. ????? ? ????? ?????????????? ?????, ?.?. ??????????? 
	?????????? ??????????? ?????????? target ? ???????? ????. ? ????? ????????? ???? ???????????? ???????? #, ??????? ?????
	??????? ???? ?????? ??????. ???? ?????? ??????, ???????????? ????????? ?????????? ?? ??? ???????? ???? ? ?????????? 
	?????????? target. ???? ???????????? ?????? ?????????, ?? ???????????? ?????????? ?????????? ?? ?????? ????. ? ???? ?????????
	???? ??????, ?? ????? helpon () ?????????? ?????????? ???????? true, ? ????????? ?????? - ?????????? ???????? false.*/
	
	boolean helpon (String target) {
	char a;  
	int a1;
	String topic = "";
	String temp;
			/* ??????? ???????. ????? ?????? ?? ?????
	??? ???????? ????? ?? ?????????? ??????????? ?????? ????? FileReader, ????????? ???????? ???????? ????? BufferedReader. 
	? ?????????? ????? ?????????? 	?????, ? ??????? ?????????? ??????? ??????? ???????????? ????? ?????????? ?????? ?????-??????.*/
		try (BufferedReader bfr = new BufferedReader(new FileReader(path))) {
						// ?????????? ?????? ?????, ???? ????? bfr.read() ?? ?????? -1, ??? ???????? ????? ?????
			do {
				a1 = bfr.read();		
				a = (char)a1;
						/* ??????? ??????, ???????????? ? ??????? #, ??? ???????? ????????? ? ???? ??????. 
						   ? ??????????? ????????? ?????? (??? ????? ??? ?????????? ??????? #) ?????????? topic  */
 				if(a == '#') {topic = bfr.readLine();}
						// ?????????? ????????????? ?? ???? ????????? ????, ??????? ?? ??????????? ? ??????
				if (target.compareTo(topic) == 0) {
					System.out.println(topic);
						/* ???? ?????????????, ?? ?????? ??? ????????? ?????? ???? ?? ??????? ? ?????? ?????? (?????????? ????? ???????????)
					       ??? ? ????? ????? (null)  */  
					do {
						temp = bfr.readLine();
						if (temp!= null) System.out.println(temp);}
					while ((temp != null)&&(temp.compareTo("")) !=0);
					return true;
				}
						}
			while (a1!= -1);
		}
		catch (IOException e) {
			System.out.println("?????? ?????? ?????"); 	}
		return false;
	}
		/* ???????? ???? ???????
		 ?????? ???????? ? ????????? ????? ? ?????????? ?????????? ?????? ?????? ? ??????? ? ???, ? ?? ? main
		 */
	
	String getTopic() {
		String topic = "";
		BufferedReader bfr =  null;
		System.out.print("Y?a???e ????: ");
		try {
			bfr = new BufferedReader(new InputStreamReader(System.in));
			topic = bfr.readLine();				}
		catch (IOException e) {
			System.out.println("?????? ?????? ?? ???????");	}
		/* try { bfr.close(); }
			catch (IOException e) { e.printStackTrace(); }  ?????? ?? ?????????e??? ? close()*/  
		return topic;
		} 
}
			
public class t01_Help_example_FileReader {
public static void main(String[] args) {
		/* ??? ????? ?? ?????????? ??????????? ?????????? ???????????? ?????? Help ? ???????????? ? ?????????? ?????????? path
	? ????????? ?????? ????????? ?????? Help ???????? ????????? ????? ?????????? helpfile, ?? ?????? ?? ??? ?????
	????????????????? ? ????????? ??????. ??? ???? ??????????? ????????? ???????? ?????? ?????????? ?????? ?? ?????? ????.  */
	Help call1 = new Help("C:\\Users\\dkuli\\Documents\\My_works\\Lessons\\Help.txt");
	System.out.println("Boc?o???y??ec? ?????????? ????????.\n" + "??? ?????? ?? ??????? ??????? 'stop'.");
	String input = null;
		do {	
				// ???????? ???? ???????
			input = call1.getTopic();
			if (input.equals("stop")) break;
				// ??????? ?????????? ?????????? ?? ???????? ????.
		    if (call1.helpon(input) == false) System.out.println("????? ?? ??????"); 
			}
				// ????? ?? ????? ??? ?????? stop
		while  (input.compareTo("stop") != 0); 
	}
}
