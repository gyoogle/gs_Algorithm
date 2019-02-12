#include <stdio.h>

#define MAXN 20
void print_gray_reverse(int code[], int n, int index);

void print_code(int code[], int len)
{
	for (int i = 0; i < len; i++)
	{
		printf("%d", code[i]);
	}
	printf("\n");
}

void print_gray(int code[], int n, int index)
{
	if (n == index)
	{
		print_code(code, n);
		return;
	}
	code[index] = 0;
	print_gray(code,n,index +1);
	code[index] = 1;
	print_gray_reverse(code, n, index + 1);
}

void print_gray_reverse(int code[], int n, int index)
{
	if (n == index)
	{
		print_code(code, n);
		return;
	}
	code[index] = 1;
	print_gray(code, n, index + 1);
	code[index] = 0;
	print_gray_reverse(code, n, index + 1);

}
void print_gray2(int code[], int n, int index, int reverse)
{
	if (n == index)
	{
		print_code(code, n);
		return;
	}
	code[index] = reverse;
	print_gray2(code, n, index + 1, 0);
	code[index] = 1 - reverse;
	print_gray2(code, n, index + 1, 1);
}

void binTogray(int code[], int _len)
{
	int gray_code[MAXN];
	int len = _len;
	gray_code[0] = code[0];

	for (int i = 1; i < len; i++)
	{
		gray_code[i] = code[i - 1] ^ code[i];
	}
	print_code(gray_code, len);
}
int main()
{
	int code[MAXN], n,len;
	//scanf("%d", &n);
	//print_gray2(code, n, 0,0);

	int bin[] = { 0,1,1,0 };
	len = sizeof(bin) / sizeof(bin[0]);
	binTogray(bin,len);
	return 0;
}