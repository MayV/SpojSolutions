package Graph;

import java.util.Scanner;

public class ALCATRAZ3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int k = s.nextInt();
		int x = s.nextInt();
		int y = s.nextInt();
		char[][] arr = new char[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				arr[i][j] = s.next().charAt(0);
		boolean[][] visited = new boolean[n][m];
		boolean ans = dfs(n,m,k,x,y,arr,visited,x,y);
		if(ans)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	public static boolean dfs(int n, int m, int k, int x, int y, char[][] arr, boolean[][] visited, int i, int j)
	{
		if(k<=0 && i==x && j==y)
			return true;
		boolean flag = false;
		if(i+1<n && arr[i+1][j]=='.' && !visited[i+1][j])
		{
			visited[i+1][j] = true;
			flag = dfs(n,m,k-1,x,y,arr,visited,i+1,j);
			if(flag)
				return true;
			visited[i+1][j] = false;
		}
		if(i-1>=0 && arr[i-1][j]=='.' && !visited[i-1][j])
		{
			visited[i-1][j] = true;
			flag = dfs(n,m,k-1,x,y,arr,visited,i-1,j);
			if(flag)
				return true;
			visited[i-1][j] = false;
		}
		if(j+1<m && arr[i][j+1]=='.' && !visited[i][j+1])
		{
			visited[i][j+1] = true;
			flag = dfs(n,m,k-1,x,y,arr,visited,i,j+1);
			if(flag)
				return true;
			visited[i][j+1] = false;
		}
		if(j-1>=0 && arr[i][j-1]=='.' && !visited[i][j-1])
		{
			visited[i][j-1] = true;
			flag = dfs(n,m,k-1,x,y,arr,visited,i,j-1);
			if(flag)
				return true;
			visited[i][j-1] = false;
		}
		return false;
	}

}
