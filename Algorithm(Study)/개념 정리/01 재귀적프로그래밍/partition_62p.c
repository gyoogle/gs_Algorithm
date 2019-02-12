#include <stdio.h>

#define MAXN 2000

void print_arr(int arr[], int arr_len)
{
	for (int i = 0; i < arr_len; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}
int print_partition(int n, int m , int arr[], int arr_len)
{
	int cnt = 0;
	
	if (n < m)
	{
		m = n;
	}
	
	if (n == 0)
	{
		print_arr(arr, arr_len);
		return 1;
	}
	for (int i = 1; i <= m; i++)
	{
		arr[arr_len] = i;
		cnt +=print_partition(n - i, i,arr,arr_len+1);
	}
	return cnt;
}
int partition(int n, int m)	//순서에 상관없이 
{
	int cnt = 0;
	
	static int memo[MAXN][MAXN];

	if (n < m)
	{
		m = n;
	}
	if (memo[n][m] > 0)
	{
		return memo[n][m];
	}
	if (n == 0)
	{
		return memo[n][m] = 1;
	}

	for (int i = 1; i <= m; i++)
	{
		cnt += partition(n-i,i);
	}
	return memo[n][m] = cnt;
}
int partition2(int n)	//순서구분 2^(n-1)
{
	int cnt = 0;
	if (n < 1)return 1;
	for (int i = 1; i <=n; i++)
	{
		cnt += partition2(n - i);
	}
	return cnt ;
}

int partition3(int n)	//순서구분 2^(n-1)
{
	int cnt = 0;
	
	for (int i = 1; i < n; i++)
	{
		cnt += partition2(n - i);
	}
	return cnt+1;
}
int main()
{
	//printf("%d  %d\n",partition2(10),partition3(10));
	int num[MAXN],arr_len=0;
	print_partition(3, 3, num, arr_len);

}