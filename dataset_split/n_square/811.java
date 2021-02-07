import java.util.Scanner;

public class Amain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a[] = new int[100005];
		int vis[] = new int[100005];
		int maxx = -1;
		int n , k ;
		int e = 0  , s = 0 ;
		int ans = 0  ;
		
		n=sc.nextInt();
		k=sc.nextInt();

		for(int i = 1 ; i<=n ; i++ )
		{
			a[i]=sc.nextInt() ;
			if(a[i]== 1 )
			{
				e++ ; //记录带有test标签的网页个数 ; 
			}
			else
			{
				s++ ;// 记录带有社交标签的网站个数; 
			}
		}
	    // 题目中的  c=b+i⋅k 大概就是每隔 k 的就关一个网页 
		for(int i = 1 ; i<=k  ;i++ )
		{
			int e1 = 0 ; // 记录应该关闭的带有test标签的网页个数 
			int s1 = 0 ;  // 记录应该关闭的带有社交标签的网页个数
			for(int j = i ; j<=n ;j+=k )
			{
				if(a[j]==1 )
				{
					e1++ ;
				}
				else
				{
					s1++ ;
				}
			}
	        // s-s1 就是还剩的带有社交标签的网页个数;
	        // e-e1 就是还剩的带有test标签的网页个数; 
	 
			ans = Math.abs(  (s-s1)-(e-e1)) ; // | s -e |
			maxx = Math.max(maxx,ans) ; // 求最大的
		}
       System.out.print(maxx);
	}

}
