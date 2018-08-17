package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Scanner;

public class ADAORANG {

	public static final int MAXN = 450001;
	public static final int LEVEL = 21;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
			int n = s.nextInt();
			int q = s.nextInt();
			int root = s.nextInt();
			int[] color = new int[n];
			for(int i=0;i<n;i++)
				color[i] = s.nextInt();
			ArrayList<Integer>[] grph = new ArrayList[n];
			for(int i=0;i<n;i++)
				grph[i] = new ArrayList<>();
			for(int i=0;i<n-1;i++)
			{
				int u = s.nextInt();
				int v = s.nextInt();
				grph[u].add(v);
				grph[v].add(u);
			}
			
			int[][] parent = new int[MAXN][LEVEL];
			int[] depth = new int[MAXN];
			int[] res = new int[MAXN];//Initialize
			dfs(root,grph,color,parent,depth,res,1,-1);
			//Precompute.
			precompute(n,grph,parent);
			while(q-->0)
			{
				int u = s.nextInt();
				int v = s.nextInt();
				int lca = getlca(u,v,parent,depth);
				System.out.println(res[lca]);
			}
		}
	}
	
	public static boolean[] dfs(int u, ArrayList<Integer>[] grph, int[] color, int[][] parent, int[] depth, int[] res, int d, int p)
	{
		depth[u] = d;
		parent[u][0] = p;
		boolean[] hash = new boolean[250+1];
		hash[color[u]] = true;
		boolean[] retval;
		for(int i=0;i<grph[u].size();i++)
		{
			int v = grph[u].get(i);
			if(v!=p)
			{
				retval = dfs(v,grph,color,parent,depth,res,d+1,u);
				for(int j=0;j<=250;j++)
					if(retval[j])
						hash[j] = true;
			}
		}
		int count = 0;
		for(int i=0;i<=250;i++)
			if(hash[i])
				count++;
		res[u] = count;
		return hash;
	}
	
	public static void precompute(int n, ArrayList<Integer>[] grph, int[][] parent)
	{
		for(int i=1;i<LEVEL;i++)
			for(int j=0;j<n;j++)
			{
				if(parent[j][i-1]!=-1)
					parent[j][i] = parent[parent[j][i-1]][i-1];
				else
					parent[j][i] = -1;
			}
	}
	
	public static int getlca(int x, int y, int[][] parent, int[] depth)
	{
		if(depth[x]>depth[y])
		{
			int temp = x;
			x = y;
			y = temp;
		}
		int diff = depth[y]-depth[x];
		for(int i=LEVEL-1;i>=0;i--)
			if((diff&(1<<i))!=0)
				y = parent[y][i];
		if(x==y)
			return x;
		for(int i=LEVEL-1;i>=0;i--)
			if(parent[x][i]!=parent[y][i])
			{
				x = parent[x][i];
				y = parent[y][i];
			}
		return parent[x][0];
	}

}
