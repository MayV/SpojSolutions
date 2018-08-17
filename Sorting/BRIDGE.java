package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.util.Arrays;
import java.util.Comparator;

public class BRIDGE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader s = new FastReader();
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			pair[] arr = new pair[n];
			for(int i=0;i<n;i++)
				arr[i] = new pair();
			for(int i=0;i<n;i++)
				arr[i].first = s.nextInt();
			for(int i=0;i<n;i++)
				arr[i].second = s.nextInt();
			Arrays.sort(arr, new mycompare());
			//Find longest increasing subsequence.
			int[] dp = new int[n];
			for(int i=0;i<n;i++)
			{
				dp[i] = 1;
				for(int j=i-1;j>=0;j--)
					//arr is already sorted according to first, so just check second.
					if(arr[j].second<=arr[i].second && dp[j]+1>dp[i])
						dp[i] = dp[j]+1;
			}
			int maxval = 1;
			for(int i=0;i<n;i++)
				if(maxval<dp[i])
					maxval = dp[i];
			System.out.println(maxval);
		}
	}
	
	public static class pair{
		int first;
		int second;
	}
	
	public static class mycompare implements Comparator<pair>
	{
		public int compare(pair lhs, pair rhs)
		{
			return lhs.first-rhs.first;
		}
	}
	
	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

}
