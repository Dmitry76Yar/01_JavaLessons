package Combinatorika.Perestanovka;

//������� ��� ���������� ������������ � ������������.  ��������, ��� aaaa ����� ������ ���� ������� - aaaa
//��� aaab ����� aaab, aaba, aaab, aaba, abaa, abaa, aaab, aaba, aaab, aaba, abaa, abaa, aaab, aaba, aaab, aaba, abaa, abaa, baaa, baaa, baaa, baaa, baaa, baaa]

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

//Java-��������� ��� ������ ���� ������������ ������ ������

/*
	�� ����� �������		�� ������ �������				�� ����� �������		�� ������ �������	
i=0		str		ans				�h		ros						
		abc		""				a		bc						
									
i=0		str		ans				ch		str					i=1		str		ans			ch		str
		bc		"a"				b		c							bc		"a"			c		b
									
i=0		str		ans				ch		str					i=0		str		ans			ch		str
		c		"ab"			c		null						b		"ac"		b		null
									
		str		ans			Output ans								str		ans			Output ans	
		null	"abc"			abc									null	"acb"			acb	
									
									
�� ����� �������		�� ������ �������				�� ����� �������		�� ������ �������	
i=1		str		ans				�h		ros						
		abc		""				b		ac						
									
i=0		str		ans				ch		str					i=1		str		ans			ch		str
		ac		"b"				a		c							ac		"c"			c		a
									
i=0		str		ans				ch		str					i=0		str		ans			ch		str
		c		"ba"			c		null						a		"bc"		a		null
									
		str		ans				Output ans							str		ans			Output ans	
		null	"bac"				bac								null	"bca"			bca	
									
									
�� ����� �������		�� ������ �������				�� ����� �������		�� ������ �������	
i=2		str		ans				�h		ros						
		abc		""				c		ab						
									
i=0		str		ans				ch		str					i=1		str		ans			ch		str
		ab		"c"				a		b							ab		"c"			b		a
										
i=0		str		ans				ch		str					i=0		str		ans			ch		str
		b		"ca"			b		null						a		"cb"		a		null
									
		str		ans				Output ans							str		ans			Output ans	
		null	"cab"				cab								null	"cba"			cba	
*/

public class t01_Perest_s_povtor_algoritm {
	static int count = 0;
	
 	     // ������� ��� ������ ���� ������������ str
	static void printPermutn(String str, String ans) {
		//		System.out.println("����� ������� � ������  " + str + "   " + ans);
        // ���� ������ �����
        if (str.length() == 0) {
           count++;
           System.out.println(ans + " " + " count = " + count); 
        }
        
        for (int i = 0; i < str.length(); i++) {
//        	System.out.println("i = " + i);
            // i-� ������ ������
       char ch = str.charAt(i);
//       System.out.print("ch =" + ch);

          // ��������� ����� ������ ����� ����������
          // i-� ������
       String ros = str.substring(0, i) + str.substring(i + 1);
//       System.out.println("    ros =" + ros);
          // ����������� �����
       printPermutn(ros, ans + ch);
       }
	}
	
public static void main(String[] args) {
	String str = "abcd";
    printPermutn(str, "");
    
	}
}
