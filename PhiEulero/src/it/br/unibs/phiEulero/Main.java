package it.br.unibs.phiEulero;

import it.unibs.fp.mylib.InputDati;

public class Main {

	public static void main(String[] args) {
		int n,phi=0,scelta;
		do {
			scelta=InputDati.leggiInteroNonNegativo("Dammi un numero per scegliere che fare"
					+ "\n0) per terminare"
					+ "\n1) per calcolare la phi\n");
			switch(scelta) {
				case 1:  n= InputDati.leggiInteroNonNegativo("Dammi un numero\n");
				phi=calcoloPhi(n);
				System.out.println("Il phi del numero è "+ phi);
				break;
				
				case 0: System.out.println("FINE PROGRAMMAAAAAAAAAAAAA");
				    break;
			}
		}while(scelta!=0);
	}

	private static int calcoloPhi(int n) {
		if(n==1)
			return 1;
		if(primo(n)) {
			return n-1;
		}
		int i;
		for(i=2; i<n; i++) {
			if(primo(i)) {
				for(int j=1; j<n && Math.pow(i, j)<=n; j++) {
					if(Math.pow(i, j)==n) {
						return (int) ((i-1)*Math.pow(i, j-1));
					}
				}
			}
		}	
		int j;
		for(i=1; i<n; i++) {
			for(j=1; j<n; j++) {
				if(i*j==n) {
					if(MCD(i,j)==1) {
						return 1* calcoloPhi(i) * calcoloPhi(j);
					}
				}
			}
		}
		return 0;
	}
	
	public static boolean primo(int n) {
		for (int i=2; i<n; i++) {
			if (n%i==0)
				return false;
			}
			if (n<2)
			return false;
			return true;
	}

	public static int MCD (int x, int y){
		if ( x == 0 && y == 0 || x < 0 || y < 0 )
	            throw new IllegalArgumentException("MCD ad operandi negativi!");
	        while ( y != 0 ) {
	        	int k = y;
	            y = x % y;
	            x = k;
	        }
	        return x;
	}
}
