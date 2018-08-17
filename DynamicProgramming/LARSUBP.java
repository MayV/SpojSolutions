package DynamicProgramming;

import java.util.Scanner;

public class LARSUBP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int ti=1;ti<=t;ti++)
		{
			String str = s.next();
			int n = str.length();
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = str.charAt(i)-'0';
			long[] hash = new long[10];
			for(int i=0;i<n;i++)
			{
				long val = 1;
				for(int j=arr[i]-1;j>=0;j--)
					val = (val+hash[j])%1000000007;
				hash[arr[i]] = (hash[arr[i]]+val)%1000000007;
			}
			long res = 0;
			for(int i=0;i<10;i++)
				res = (res+hash[i])%1000000007;
			System.out.println("Case "+ti+": "+res);
		}
	}
	
	/*public static class Tree{
		private class Node{
			int data;
			Node left;
			Node right;
			int num;
			
			Node(int data)
			{
				this.data = data;
				this.left = null;
				this.right = null;
				this.num = 1;
			}
		}
		
		private Node root = null;
		
		public Tree()
		{
			this.root = null;
		}
		
		public void add(int data)
		{
			this.root = addFunc(this.root, data);
		}
		
		private Node addFunc(Node node, int data)
		{
			
		}
	}*/

}
