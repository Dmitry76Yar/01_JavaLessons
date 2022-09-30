package Combinatorika.Perestanovka;

//Выводит все комбинации перестановки С повторениями.  Например, для aaaa будет только один вариант - aaaa
//															Для aaab будет aaab, aaba, aaab, aaba, abaa, abaa, aaab, aaba, aaab, aaba, abaa, abaa, aaab, aaba, aaab, aaba, abaa, abaa, baaa, baaa, baaa, baaa, baaa, baaa]

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class t01_Perest_s_povt_in_methode {
	static int count = 0;
	static ArrayList<String> arrlist = new ArrayList<String>();
	
	static ArrayList<String> printPermutn(String str, String ans) {
		 if (str.length() == 0) {
           count++;
           arrlist.add(ans);
        }
        for (int i = 0; i < str.length(); i++) {
       char ch = str.charAt(i);
       String ros = str.substring(0, i) + str.substring(i + 1);
       printPermutn(ros, ans + ch);
       }
       return arrlist;
	}
	
public static void main(String[] args) {
	ArrayList<String> result = new ArrayList<String>();
	String str = "aaab";
	result = printPermutn(str, "");
	System.out.println(result);
    
	}
}
