//baekjoon 10815. 숫자 카드

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int compare(const int* a, const int* b) {
	if (*a > *b) {
		return 1;
	}
	else return -1;
}

int main() {
	int n, s, cmp;
	int left = 0, right = 0;
	int zip[500001] = { 0 }, count[500001] = { 0 }, sang[500001] = { 0 };
	
	scanf("%d", &n);
	for (int i = 0;i < n;i++) {
		scanf("%d", &zip[i]);
	}

	qsort(zip, n, sizeof(int), compare);
	
	scanf("%d", &s);
	for (int i = 0;i < s;i++) {
		scanf("%d", &sang[i]);
		left = 0;
		right = n - 1;
		while (left <= right) {
			cmp = (left + right) / 2;
			if (zip[cmp] == sang[i]) {
				if (count[i] == 0) count[i]++;
				break;
			}
			else if (zip[cmp] > sang[i]) {
				right = cmp - 1;
				cmp = (left + right) / 2;
			}
			else {
				left = cmp + 1;
				cmp = (left + right) / 2;
			}
		}
	}
	for (int i = 0;i < s;i++) {
		printf("%d ", count[i]);
	}

}
