package DynamicProgramming;

//Variation of Painters Partition Problem.

import java.util.Arrays;
import java.util.Scanner;

public class AGGRCOW {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int c = s.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = s.nextInt();
			Arrays.sort(arr);
			int l, r;
			//Minimum distance will be when cows are assigned adjacent stalls. n cows are required for this.
			l = arr[1]-arr[0];
			for(int i=2;i<n;i++)
				if(l>arr[i]-arr[i-1])
					l = arr[i]-arr[i-1];
			//Maximum distance will be when cows are assigned the end most stalls. 2 cows are required for this.
			r = arr[n-1]-arr[0];
			int ans = -1;
			while(l<=r)
			{
				int m = (l+r)/2;
				int numcows = numcowsaccomodate(arr,m);
				//If we can accommodate less number of cows, decrease min distance so that more cows can be accommodated.
				if(numcows<c)
					r = m-1;
				else
				{
					//Save current valid distance.
					ans  = getactualmin(arr,m);
					//Increase min distance and search for a valid distance greater than current ans.
					l = m+1;
				}
			}
			System.out.println(ans);
		}
	}
	
	public static int numcowsaccomodate(int[] arr, int d)
	{
		int num = 1, si = 0;
		for(int i=1;i<arr.length;i++)
		{
			int val = arr[i]-arr[si];
			if(val>=d)
			{
				num++;
				si = i;
			}
		}
		return num;
	}
	
	public static int getactualmin(int[] arr, int d)
	{
		int ans = Integer.MAX_VALUE, si = 0;
		for(int i=1;i<arr.length;i++)
		{
			int val = arr[i]-arr[si];
			if(val>=d)
			{
				if(ans>val)
					ans = val;
				si = i;
			}
		}
		return ans;
	}
}
