package DynamicProgramming;

import java.util.Scanner;

public class CODEM4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = s.nextInt();
			int[][] dpdumb = new int[n][n];
			for(int l=2;l<=n;l++)
				for(int i=0;i<=n-l;i++)
				{
					int j = i+l-1;
					int val1 = 0, val2 = 0, val3 = 0, val4 = 0;
					if(i+2<j)
						val1 = dpdumb[i+2][j];
					val2 = dpdumb[i+1][j-1];
					val3 = dpdumb[i+1][j-1];
					if(i<j-2)
						val4 = dpdumb[i][j-2];
					dpdumb[i][j] = Math.max(arr[i]+Math.max(val1,val2),arr[j]+Math.max(val3,val4));
				}
			int[][] dpsmart = new int[n][n];
			for(int l=2;l<=n;l++)
				for(int i=0;i<=n-l;i++)
				{
					int j = i+l-1;
					int val1 = 0, val2 = 0, val3 = 0, val4 = 0;
					if(i+2<j)
						val1 = dpsmart[i+2][j];
					if(i+1<j-1)
						val2 = dpsmart[i+1][j-1];
					if(i+1<j-1)
						val3 = dpsmart[i+1][j-1];
					if(i<j-2)
						val4 = dpsmart[i][j-2];
					dpsmart[i][j] = Math.max(arr[i]+Math.min(val1,val2),arr[j]+Math.min(val3,val4));
				}			
			System.out.println(dpdumb[0][n-1]+" "+dpsmart[0][n-1]);
		}
	}

}
