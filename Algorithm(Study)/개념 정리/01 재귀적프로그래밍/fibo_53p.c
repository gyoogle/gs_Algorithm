#include <stdio.h>

#define MAXN 200

long long fibo(int n)
{
	if (n == 1 || n == 2) return 1;
	else
		return fibo(n - 1) + fibo(n - 2);
}

long long fibo2(int n)
{
	static long long memo[MAXN];

	if (memo[n] > 0) return memo[n];


	if (n == 1 || n == 2) return memo[n] = 1;
	else
		return memo[n] = fibo2(n - 1) + fibo2(n - 2);
}
int main()
{
	printf("%lld\n", fibo2(50));
}

/*----------------dynamic-----------------
#include <stdio.h>

#define MAXN 200
long long f[MAXN];

long long fibo(int n)
{
	f[1] = f[2] = 1;
	for (int i = 3; i <= n; i++)
	{
		f[i] = f[i - 2] + f[i - 1];
	}
	return f[n];
}
int main()
{
	int n = 0;
	scanf("%d", &n);
	printf("%lld\n", fibo(n));
}
*/