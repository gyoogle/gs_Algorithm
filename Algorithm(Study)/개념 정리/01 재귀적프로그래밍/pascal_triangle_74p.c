#include <stdio.h>

#define MAXN 200
int pascal_triangle(int n, int k)
{
	int cnt = 0;
	static int memo[MAXN][MAXN];
	
	if (memo[n][k] > 0)
	{
		return memo[n][k];
	}
	if (k == 0 || n == k)
	{
		return memo[n][k] = 1;
	}

	return memo[n][k] = pascal_triangle(n - 1, k - 1) + pascal_triangle(n - 1, k);
	
	
}
int main()
{
	int n = 0;
	scanf("%d", &n);
	//pascal_triangle(n);
	for (int i=1;i<=n ;i++)
	{
		for (int j = 0; j <i; j++)
		{
			printf("%d ", pascal_triangle(i - 1, j));
		}
		
		printf("\n");
	}

}