#include <stdio.h>

#define M 100
#define N 100

long long map[M][N];
long long path[M][N];
long long num_path(int m, int n)
{
	if (map[m][n] == 0)
	{
		return 0;
	}
	if (m == 0 && n == 0)
	{
		return 1;
	}

	return ((m > 0) ? num_path(m - 1, n) : 0) + ((n>0) ? num_path(m,n-1 ) : 0);
}
long long calculate_path(int m, int n)
{
	for (int i = 0; i < m; i++)
	{
		path[i][0] = map[i][0];
	}
	for (int i = 0; i < n; i++)
	{
		path[0][i] = map[0][i];
	}

	for (int i = 1; i < m; i++)
	{
		for (int j = 1; j < n; j++)
		{
			if (map[i][j] == 0)
			{
				path[i][j] = 0;
			}
			else {
				path[i][j] = path[i - 1][j] + path[i][j - 1];
			}
		}
	}

	return path[m-1][n-1];
}

int main()
{
	int m, n;

	scanf("%d %d", &m, &n);
	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < n; j++)
		{
			scanf(" %d", &map[i][j]);
		}
	}
	printf("%lld\n", calculate_path(m, n));
	
	return 0;
}