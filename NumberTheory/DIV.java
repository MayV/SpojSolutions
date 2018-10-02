package NumberTheory;

public class DIV {

	public static pair[] arr = new pair[1000000+1];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<=1000000;i++)
			arr[i] = new pair();
		for(int i=2;i<=1000000;i++)
			if(arr[i].minprime==0)
			{
				arr[i].minprime = i;
				arr[i].numprimediv++;
				for(int j=2*i;j<=1000000;j+=i)
				{
					if(arr[j].minprime==0)
						arr[j].minprime = i;
					arr[j].numprimediv++;
				}
			}
		int ctr = 0;
		for(int i=2;i<=1000000;i++)
		{
			int temp = i;
			int numdiv = 1;
			while(temp!=1)
			{
				int p = 0;
				while(arr[temp].minprime==arr[temp/arr[temp].minprime].minprime)
				{
					temp = temp/arr[temp].minprime;
					p++;
				}
				temp = temp/arr[temp].minprime;
				p++;
				numdiv *= (p+1);
			}
			if(arr[numdiv].numprimediv==2 && ((numdiv/arr[numdiv].minprime)/arr[(numdiv/arr[numdiv].minprime)].minprime)==1)
				ctr++;
			if(ctr==9)
			{
				System.out.println(i);
				ctr = 0;
			}
		}
	}
	
	public static class pair{
		int minprime;
		int numprimediv;
		
		pair()
		{
			this.minprime = 0;
			this.numprimediv = 0;
		}
	}
}
