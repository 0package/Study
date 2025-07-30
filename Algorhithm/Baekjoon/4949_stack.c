// baekjoon 4949. 균형잡힌 세상
// 단계별로 풀어보기: 스택, 큐, 덱

//스택 구현 방식: '('와 '['만 스택에 저장 후 ')' 또는 ']'를 만났을 경우 최상위 스택 문자와 비교. 짝이 맞으면 pop, 틀리면 "no" 출력.
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	char ch[101], stk[101]; //ch: 문자 받는 배열, stk: stack
	int a, i = 0, s = -1; //a: getchar 함수에 쓸 변수, i: 문자열 길이, s: 스택 인덱스
	int cmp = 0, c = 0; //cmp: 중복으로 출력하지 않기 위한 확인 변수, c: '.' 하나만 들어와 프로그램이 모두 완료되었음을 확인하기 위한 변

	while (c == 0) {
		while (1) {
			a = getchar();
			ch[i] = a;
			i++;
			if (a == '.') {
				break;
			}
		}
		// getchar(); 쓸 때 두번 째 문장부터 ' '(공백)이 앞에 붙던데 이유를 정확히 찾진 못함(3월 9일 기준). 백준 기준 정답이지만 처음에 '.'이 오면 틀림. 이를 고치기 위해 while 문 밑에 getchar 함수 따로 하나 적는게 더 정확할 듯.
		if (i == 2 && ch[1] == '.') { 
			c = 1;
			break;
		}

		for (int k = 0;k < i;k++) {
			if (ch[k] == '(') {
				s++;
				stk[s] = ch[k];
			}
			else if (ch[k] == ')') {
				if (s < 0) {
					printf("no\n");
					cmp = 1;
					break;
				}
				else {
					if (stk[s] == '(') {
						s--;
					}
					else if (stk[s] == '[') {
						printf("no\n");
						cmp = 1;
						break;
					}
				}
			}
			else if (ch[k] == '[') {
				s++;
				stk[s] = ch[k];
			}
			else if (ch[k] == ']') {
				if (s < 0) {
					printf("no\n");
					cmp = 1;
					break;
				}
				else {
					if (stk[s] == '[') {
						s--;
					}
					else if (stk[s] == '(') {
						printf("no\n");
						cmp = 1;
						break;
					}
				}
			}
		}
		if (c == 1) {
			break;
		}
		if (cmp == 0) {
			if (s != -1) {
				printf("no\n");
			}
			else {
				printf("yes\n");
			}
		}
		cmp = 0;
		s = -1;
		i = 0;
	}
}
