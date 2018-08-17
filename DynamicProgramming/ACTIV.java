package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ACTIV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		while(true)
		{
			int n = s.nextInt();
			if(n==-1)
				break;
			pair[] arr = new pair[n];
			for(int i=0;i<n;i++)
			{
				int st = s.nextInt();
				int et = s.nextInt();
				arr[i] = new pair(st,et);
			}
			Arrays.sort(arr,new mycompare());
			long[] dp = new long[n];
			dp[n-1] = 1;
			for(int i=n-2;i>=0;i--)
			{
				int si = lower_bound(arr,i,i+1,n-1);
				long val;	//Denotes the subsets to which arr[i] can belong
				if(si==-1)
					val = 1;
				else
					val = (1+dp[si])%100000000;
				dp[i] = (val+dp[i+1])%100000000;
			}
			long ans = dp[0];
			int numofzero = 8;
			if(ans==0)
				numofzero--;
			else
			{
				long temp = ans;
				while(temp!=0)
				{
					temp = temp/10;
					numofzero--;
				}
			}
			for(int i=0;i<numofzero;i++)
				System.out.print("0");
			System.out.println(ans);
		}
	}
	
	public static class pair{
		int first;
		int second;
		
		pair(int first, int second)
		{
			this.first = first;
			this.second = second;
		}
	}
	
	public static class mycompare implements Comparator<pair>{
		public int compare(pair lhs, pair rhs)
		{
			//if(lhs.first!=rhs.first)
				return lhs.first-rhs.first;
		}
	}
	
	public static int lower_bound(pair[] arr, int si, int l, int r)
	{
		int ans = -1;
		while(l<=r)
		{
			int m = (l+r)/2;
			if(arr[m].first>=arr[si].second)
			{
				ans = m;
				r = m-1;
			}
			else
				l = m+1;
		}
		return ans;
	}

}
