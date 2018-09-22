package Classical;

import java.util.Scanner;

public class QUADAREA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0)
		{
			double a = scn.nextDouble();
			double b = scn.nextDouble();
			double c = scn.nextDouble();
			double d = scn.nextDouble();
			double s = (a+b+c+d)/2;
			double ans = Math.sqrt(s-a)*Math.sqrt(s-b)*Math.sqrt(s-c)*Math.sqrt(s-d);
			System.out.printf("%.2f\n",ans);
		}
	}
}
