#include <iostream>
#include <cstring>
#include <string>
#include <cstdlib>

using namespace std;
int Strlen(char A[]) {
	int len = 0;

	for (int i = 0; A[i] != '\0'; i++) {
		len++;
	}
	return len;
}
int Strcmp(char A[], char B[]) {
	int idx = 0;
	while (A[idx] != '\0') {
		if (A[idx] != B[idx]) {
			break;
		}
		idx++;
	}
	return A[idx] - B[idx];
}
void Strcpy(char A[], char B[]) {
	
	while (*B != '\0') {
		*A = *B;
		A++;
		B++;
	}
	*A = '\0';
}
void Reverse(char A[]) {
	int len = strlen(A);
	for (int i = 0; i < len/2; i++) {
		char temp = A[i];
		A[i] = A[len- 1 - i];
		A[len - 1 - i] = temp;
	}
}
int Atoi(char A[]) {
	int num=0;

	for (int i = 0; i < strlen(A); i++) {
		int digit =  (A[i] - '0');
		num = (num * 10) + digit;
	}

	return num;
}
int main() {
	char A[10] = "123aaa123";
	char B[20] = "123456";
	/*
	strcpy(A, B);

	cout << A << endl;
	cout << B<<endl;

	scanf("%s", B);
	strcpy(A, B);
	cout << A << endl;
	cout << B;
	*/
	Reverse(B);
	cout << B<<endl;
	reverse(B,B+strlen(B)-1);
	cout << B << endl;

	cout << atoi(A) <<endl;
	cout << atoi(B) << endl;

	string s = "qwe";

	strcpy(A, s.c_str());
	cout << A << endl;


	char input[100] = "A adf!afdaf, afawf !asdf";
	char *token = strtok(input, ",!");
	while (token != NULL) {
		string sa(token);
		cout << sa << endl;
		token = strtok(NULL, ",!");
	}

	cout << Atoi("123") << endl;
}