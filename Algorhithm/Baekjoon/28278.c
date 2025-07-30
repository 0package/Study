// baekjoon 28278. 스택2(stack)

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int n, a;
	int stk[1000001] = { 0 };
	int x, idx = -1;
 
	scanf("%d", &n);
 
	for (int i = 0;i < n;i++) {
		scanf("%d", &a);
		if (a == 1) {
			scanf("%d", &x);
			idx++;
			stk[idx] = x;
		}
		else if (a == 2) {
			if (idx == -1) {
				printf("-1\n");
			}
			else if (idx != -1) {
				printf("%d\n", stk[idx]);
				idx--;
			}
		}
		else if (a == 3) {
			printf("%d\n", idx + 1);
		}
		else if (a == 4) {
			if (idx == -1) {
				printf("1\n");
			}
			else printf("0\n");
		}
		else if (a == 5) {
			if (idx != -1) {
				printf("%d\n", stk[idx]);
			}
			else if (idx == -1) {
				printf("-1\n");
			}
		}
	}
 
}
