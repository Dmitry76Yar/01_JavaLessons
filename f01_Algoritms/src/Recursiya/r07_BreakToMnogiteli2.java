package Recursiya;

import java.util.ArrayList;

public class r07_BreakToMnogiteli2 {
	static ArrayList<Integer> arl = new ArrayList<Integer>();
	
	public static void recursion(int n) {
		if (n==1) return;
		for (int i = 2; i<=n; i++) {
			if (n%i == 0) {
				arl.add(i);
				recursion(n/i);
				break;
			}
		}
	}

public static void main(String[] args) {
    	int n = 180;
    	recursion(n);
    	System.out.println(arl);
    }
}



