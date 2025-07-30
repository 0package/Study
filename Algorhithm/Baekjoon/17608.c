#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int n, num, max = 0;
	int stk[1001] = { 0 }, s = -1;
	int count = 0;
	scanf("%d", &n);
	for (int i = 0;i < n;i++) {
		scanf("%d", &num);
		s++;
		stk[s] = num;
	}
	for (int i = n - 1;i >= 0;i--) {
		if (stk[i] > max) {
			count++;
			max = stk[i];
		}
	}

	printf("%d", count);
}
