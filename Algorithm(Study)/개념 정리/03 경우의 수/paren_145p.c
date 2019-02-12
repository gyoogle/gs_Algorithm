#include <stdio.h>

#define L 0
#define R 1

void print_paren(int arr[], int size)
{
	for (int i = 0; i < size; i++)
	{
		if (arr[i] == L)
		{
			printf("(");
		}
		else
		{
			printf(")");
		}
	}
	printf("\n");
}
void paren(int to_open, int to_close, int arr[], int size)
{
	if (to_open == 0 && to_close == 0)
	{
		print_paren(arr, size);
		return;
	}
	if (to_open > 0)
	{
		arr[size] = L;
		paren(to_open - 1, to_close + 1, arr, size + 1);
	}

	if (to_close > 0)
	{
		arr[size] = R;
		paren(to_open, to_close - 1, arr, size + 1);
	}
}

int main()
{
	int arr[100], n;
	scanf("%d", &n);
	paren(n,0,arr,0);
	return 0;
}

//----------------------comb ÀÌ¿כ
#include <iostream>
#include <vector>
using namespace std;

void comb(vector<int> &v, int size, int n, int k, int to_open, int to_close)
{
	if (to_open < to_close)
	{
		return;
	}
	if (k == 0)
	{
		for (int i = 0; i < n; i++)
		{
			if (v[i] == 1)
			{
				cout << '(';
			}
			else
			{
				cout << ')';
			}
		}
		cout << endl;
		return;
	}
	else if (size == n)
	{
		return;
	}
	else
	{
		v[size] = 1;
		comb(v, size + 1, n, k - 1, to_open + 1, to_close);
		v[size] = 0;
		comb(v, size + 1, n, k, to_open, to_close + 1);
	}
}
int main()
{
	vector<int> v(100);
	int n;
	cin >> n;
	comb(v, 0, 2 * n, n, 0, 0);
}