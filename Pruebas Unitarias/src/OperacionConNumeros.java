
public class OperacionConNumeros {
	
	
	public static int invertirNumeroEntero(int n){
		if(n<10 || n>999999999){
			throw new IllegalArgumentException();
		}
		int m=0;
		while(n>0){
			m=(m*10) + (n%10);
			n/=10;
		}
		return m;
	}

}
