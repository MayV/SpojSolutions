package DynamicProgramming;

import java.util.Scanner;

public class ASSIGN {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[][] pref = new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					pref[i][j] = s.nextInt();
			int powset = (int)Math.pow(2,n);
			long[] dp = new long[powset];
			dp[0] = 1;
			for(int i=0;i<powset;i++)
			{
				int personindx = ActiveBits(i);
				for(int j=0;j<n;j++)
				{
					int bitval = i&(1<<j);
					if(bitval==0 && pref[personindx][j]==1)
						dp[i|(1<<j)] += dp[i];
				}
			}
			System.out.println(dp[powset-1]);
		}
	}
	
	public static int TotalBits(int n)
	{
		int retval = 0;
		while(n!=0)
		{
			n = n/2;
			retval++;
		}
		return retval;
	}
	
	public static int ActiveBits(int n)
	{
		int retval = 0;
		while(n!=0)
		{
			int rem = n%2;
			if(rem==1)
				retval++;
			n = n/2;
		}
		return retval;
	}
}