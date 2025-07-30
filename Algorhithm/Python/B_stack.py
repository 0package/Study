#Baekjoon 10828

#명령의 수 N(1<=N<=10000)
#주어진 정수 1<=X<=100,000
##명령 종류
#push X: 정수 X를 스택에 넣기
#pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력. 스택이 빈 경우 -1 출력
#size: 스택에 들어있는 정수 개수 출력
#empty: 스택이 비어있으면 1, 아니면 0 출력
#top: 스택의 가장 위에 있는 정수 출력. 스택이 빈 경우 -1 출력.

import sys
input = sys.stdin.readline

N = int(input()) #명령의 수
stack = []       #스택으로 사용할 list 선언
for i in range(N):
    command = list(input().split())
    if command[0] == 'push':
        stack.append(int(command[1]))
    elif command[0] == 'pop':
        if len(stack) != 0:
            peak = stack.pop()
            print(peak)
        else:
            print(-1)
    elif command[0] == 'size':
        print(len(stack))
    elif command[0] == 'empty':
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    elif command[0] == 'top':
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[-1])
        
