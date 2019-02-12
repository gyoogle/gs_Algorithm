#include <iostream>
#include <stack>
#include <cstdio>
#include <string>
using namespace std;
int isp[4] = { -1,2,1,0 };
int icp[4] = { -1,2,1,3 };

int getToken(char ch) {
	if (ch == ')') {
		return 0;
	}
	else if (ch == '*' || ch == '/') {
		return 1;
	}
	else if (ch == '+' || ch == '-') {
		return 2;
	}
	else {
		return 3;
	}
}
int main() {


	for (int t = 0; t < 10; t++) {
		int N;
		scanf("%d", &N);
		string str;
		string postStr = "";
		cin >> str;
		stack<int> stk;
		for (int i = 0; i < str.size(); i++) {
			char ch = str[i];
			if (ch >= '0' && ch <= '9') {//숫자면 후위계산식 push
				postStr += ch;
			}
			else {
				if (stk.empty()) {
					stk.push(ch);	//스택 비어있는 경우 push
				}
				else {
					if (isp[getToken(stk.top())] < icp[getToken(ch)]) {
						stk.push(ch);	//스택에 있는 것보다 들어오는애 우선순위가 높으면 push
					}
					else {
						if (ch == ')') {	//'('만날 때까지 pop
							while (stk.top() != '(') {
								postStr += stk.top();
								stk.pop();
							}
							stk.pop();
						}
						else {
							while (isp[getToken(stk.top())] >= icp[getToken(ch)]) {
								postStr += stk.top();
								stk.pop();
							}
							stk.push(ch);
						}
					}
				}
			}
		}
		while (!stk.empty()) {
			postStr += stk.top();
			stk.pop();
		}

		stack<int> calStk;
		for (int i = 0; i < postStr.size(); i++) {
			char ch = postStr[i];

			if (ch >= '0' && ch <= '9') {
				calStk.push(ch - '0');
			}
			else {
				int num1 = calStk.top();
				calStk.pop();
				int num2 = calStk.top();
				calStk.pop();
				if (ch == '-') {
					calStk.push(num1 - num2);
				}
				else if (ch == '+') {
					calStk.push(num1 + num2);
				}
				else if (ch == '/') {
					calStk.push(num1 / num2);
				}
				else if (ch == '*') {
					calStk.push(num1 * num2);
				}
			}
		}

		cout << "#" << t + 1 << " " << calStk.top() << endl;
	}


}