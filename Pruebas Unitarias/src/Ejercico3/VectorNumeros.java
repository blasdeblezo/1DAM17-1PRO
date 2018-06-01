package Ejercico3;

import java.util.Scanner;

public class VectorNumeros {
	
	static Scanner teclado =  new Scanner(System.in);
	
	public static int buscarValor(int [] ve, String valor) {
		
		int x = Integer.parseInt(valor);
		for(int j=0; j<ve.length; j++) {
			 if(ve[j]==x)
				 return j + 1;
		 }
		 return -1;
	}
	
	public static void main(String [] args) {
		int [] vector = {0,1,4,3,8,5,2,7};
		
		int posicion = buscarValor(vector, teclado.next());
	}

	public static void buscarValor(int i, String valor) {
		// TODO Auto-generated method stub
		
	}

	

}
