//baekjoon 10773. 제로(stack)
#define _CRT_SECURE_NO_WARNINGS //c에서 scanf 경고 무시
#include <stdio.h> //표준입출력 헤더파일

int main() {
	int n, a; // 총 개수, 들어온 수
	int sum = 0; // 구하려는 합계
	int stk[100001] = { 0 }, idx = -1; //스택 및 스택 인덱스 변수

	scanf("%d", &n);

	for (int i = 0;i < n;i++) {
		scanf("%d", &a);
		if (a != 0) {
			idx++;
			stk[idx] = a;
			sum = sum + stk[idx];
		}
		else if (a == 0) {
			if (idx != -1) { //idx == -1이면 이전 값이 없으므로 빼지 않아도 됨.
				sum = sum - stk[idx];
				idx--;
			}
		}
	}

	printf("%d", sum);
}
