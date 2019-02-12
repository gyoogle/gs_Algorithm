#include <stdio.h>
#define MAX(X,Y) ((X)>(Y) ? (X) : (Y))

int subset_sum(int s[], int n, int m)
{
	if (n == 0)
	{
		if (m == 0)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	return MAX(subset_sum(s,n-1,m),subset_sum(s,n-1,m-s[n-1]));
}
int main()
{
	int m, n;
	int s[10] = { 0, };
	printf("input m,n : ");
	scanf("%d %d", &m, &n);
	for(int i=0;i<n;i++)
	{
		scanf("%d", &s[i]);
	}

	printf("%d\n", subset_sum(s,n,m));
}