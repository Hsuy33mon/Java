package classEx3;
import java.util.*;
public class StatMiddleValue 
{
	public static double mean(double[] arr,int n)
	{
		double mean_ans = 0.0;
		for(int i=0;i<n;i++)
		{
			mean_ans+=arr[i];
		}
		return mean_ans/2;
	}
	
	public static double median(double[] arr,int n)
	{
		int neven = n/2;
		int nodd = (n+1)/2;
		if(n%2==0)
		{
			return (arr[neven-1]+arr[neven])/2;
		}
		return arr[nodd-1];
	}
	public static double mode(double[] arr,int n)
	{
		int Maxcount=0;
		double value = 0;
		for (int i=0;i<n;i++)
		{
			int count =0;
			for (int j=0;j<n;++j)
			{
				if(arr[i]==arr[j]) count++;
			}
			if(count>Maxcount)
			{
				Maxcount = count;
				value = arr[i];
			}
		}
		return value;
	}

	public static void main(String[] args) 
	{
		Random rd = new Random();
		double[] nums =new double [100] ;
		for(int i=0;i<nums.length;i++)
		{
			nums[i]=rd.nextInt(100);
		}
		 Arrays.sort(nums);
		 System.out.println("Mean: " + mean(nums,nums.length));
		 System.out.println("Median: " + median(nums,nums.length));
		 System.out.println("Mode: " + mode(nums,nums.length));
	}

}
