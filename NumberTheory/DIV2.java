package NumberTheory;

public class DIV2 {

	public static int[] minprime = new int[1000000+1];
	public static int[] numdiv = new int[1000000+1];
	public static int[] divsatisfycond = new int[1000000+1];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=2;i<=1000000;i++)
			if(minprime[i]==0)
			{
				minprime[i] = i;
				for(int j=2*i;j<=1000000;j+=i)
					if(minprime[j]==0)
						minprime[j] = i;
			}
		for(int i=2;i<=1000000;i++)
		{
			int temp = i;
			numdiv[i] = 1;
			while(temp!=1)
			{
				int p = 0;
				while(minprime[temp]==minprime[temp/minprime[temp]])
				{
					temp = temp/minprime[temp];
					p++;
				}
				temp = temp/minprime[temp];
				p++;
				numdiv[i] *= (p+1);
			}
		}
		for(int i=2;i<=1000000;i++)
			for(int j=2*i;j<=1000000;j+=i)
				if(numdiv[j]%numdiv[i]==0)
					divsatisfycond[j]++;
		int ctr = 0;
		for(int i=2;i<=1000000;i++)
		{
			if(numdiv[i]>3 && numdiv[i]==divsatisfycond[i]+2)
				ctr++;
			if(ctr==108)
			{
				System.out.println(i);
				ctr = 0;
			}
		}
	}
	
}
