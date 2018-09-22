package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class CODEM5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int k = s.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = s.nextInt();
			Arrays.sort(arr);
			int[][] dp = new int[k+1][n+1];
			for(int i=0;i<=k;i++)
				for(int j=0;j<=n;j++)
				{
					if(i==0)
						dp[i][j] = 0;
					else if(j==0)
						dp[i][j] = -1;
					else if(i-arr[j-1]>=0)
					{
						int val1 = dp[i-arr[j-1]][j-1];
						int val2 = dp[i][j-1];
						if(val1!=-1 && val2!=-1)
							dp[i][j] = Math.min(1+val1,val2);
						else if(val1!=-1)
							dp[i][j] = 1+val1;
						else if(val2!=-1)
							dp[i][j] = val2;
						else
							dp[i][j] = -1;
					}
					else
					{
						if(dp[i][j-1]==-1)
							dp[i][j] = -1;
						else
							dp[i][j] = dp[i][j-1];
					}
				}
			if(dp[k][n]!=-1)
				System.out.println(dp[k][n]);
			else
				System.out.println("impossible");
		}
	}

}
