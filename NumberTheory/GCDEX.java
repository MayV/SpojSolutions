package NumberTheory;

import java.util.Scanner;

public class GCDEX {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int[] phi = new int[1000000+1];
		for(int i=2;i<=1000000;i++)
			phi[i] = i;
		for(int i=2;i<=1000000;i++)
			if(phi[i]==i)
				for(int j=2*i;j<=1000000;j+=i)
					phi[j] = (phi[j]/i)*(i-1);
		for(int i=2;i<=1000000;i++)
			if(phi[i]==i)	//Number of coprimes of a prime number p are (p-1).
				phi[i] = i-1;
		/*
		 * If gcd(i,j) = g, then gcd(i/g,j/g) = 1.
		 * So, for j, total contribution to answer is g*phi(j/g) for all values of g. Now g will
		 * be a divisor of j. This process can be done for all values of j between 2 to n.
		 */
		long[] result = new long[1000000+1];
		for(int g=1;g<=1000000;g++)
			for(int j=2*g;j<=1000000;j+=g)
				result[j] += (long)g*(long)phi[j/g];
		for(int i=2;i<=1000000;i++)
			result[i] += result[i-1];
		int n = s.nextInt();
		while(n!=0)
		{
			System.out.println(result[n]);
			n = s.nextInt();
		}	
	}
}
