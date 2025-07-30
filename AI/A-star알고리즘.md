# 탐색:  A* 알고리즘

### A* 알고리즘은주어진 출발 노드에서부터 목표 노드까지 가는 최단 경로를 찾아내는 그래프 탐색 중 하나이다.
다익스트라 알고리즘과 유사하나 차이점은 목표 노드까지의 휴리스틱(Heuristic) 거리 측정값인 h(n)도 사용한다는 점이다.

# <Heuristic cost function>

<aside>
🔑

## f(n) = g(n) + h(n)

</aside>

f(n): total cost

g(n): cost from start

h(n): cost to end

# 2*5 크기의 퍼즐 맞추기

### 1. 빈칸이 1개일 때

```python
import heapq

# 목표 상태
GOAL_STATE = [[1, 2, 3, 4, 5], [6, 7, 8, 9, 0]]

# 이동 방향 (UP, DOWN, LEFT, RIGHT)
DIRECTIONS = {'U': (-1, 0), 'D': (1, 0), 'L': (0, -1), 'R': (0, 1)}

class SlicePuzzle:
    def __init__(self, board):
        self.start = board
        self.empty_pos = self.find_empty(board)

    def find_empty(self, board):
        for i in range(2):
            for j in range(5):
                if board[i][j] == 0:
                    return (i, j)

    #맨해튼 거리 기반 휴리스틱 계산
    def heuristic(self, board):
        distance = 0
        for i in range(2):
            for j in range(5):
                value = board[i][j]
                if value == 0:
                    continue
                goal_x, goal_y = (value - 1) // 5, (value - 1) % 5
                distance += abs(goal_x - i) + abs(goal_y - j)
        return distance

    def move(self, board, empty_pos, direction):
        """빈칸 이동 후 새로운 상태 반환"""
        i, j = empty_pos
        di, dj = DIRECTIONS[direction]
        new_i, new_j = i + di, j + dj
        if 0 <= new_i < 2 and 0 <= new_j < 5:  # 범위 체크
            new_board = [row[:] for row in board]  # 기존 보드 복사
            new_board[i][j], new_board[new_i][new_j] = new_board[new_i][new_j], new_board[i][j]
            return new_board, (new_i, new_j)
        return None, None

    # A* 알고리즘 이용
    def solve(self):
        priority_queue = []
        visited = set()

        # 초기 상태
        heapq.heappush(priority_queue, (self.heuristic(self.start), 0, self.start, self.empty_pos, []))
        visited.add(tuple(map(tuple, self.start)))

        while priority_queue:
            _, cost, board, empty_pos, path = heapq.heappop(priority_queue)

            # 목표 상태 도달 시 경로 반환
            if board == GOAL_STATE:
                return path

            # 가능한 이동 수행
            for direction in DIRECTIONS.keys():
                new_board, new_empty_pos = self.move(board, empty_pos, direction)
                if new_board and tuple(map(tuple, new_board)) not in visited:
                    visited.add(tuple(map(tuple, new_board)))
                    heapq.heappush(priority_queue, (cost + 1 + self.heuristic(new_board), cost + 1, new_board, new_empty_pos, path + [direction]))

        return None  # 해결 불가능한 경우

# 초기 숫자판 (0은 빈칸)
initial_board = [
    [9, 2, 8, 4, 7],
    [1, 3, 5, 6, 0]
]

solver = SlicePuzzle(initial_board)
solution = solver.solve()

if solution:
    print("해결 경로:", " -> ".join(solution))
    print(f"총 {len(solution)}번 이동")
else:
    print("해결 불가능한 퍼즐입니다!")
```

### 2. 빈칸이 2개 일 때

```python
import heapq

# 목표 상태 (빈칸 2개)
GOAL_STATE = [[1, 2, 3, 4, 5], [6, 7, 8, 0, 0]]

# 이동 방향 (UP, DOWN, LEFT, RIGHT)
DIRECTIONS = {'U': (-1, 0), 'D': (1, 0), 'L': (0, -1), 'R': (0, 1)}

class SlicePuzzle:
    def __init__(self, board):
        self.start = board
        self.empty_positions = self.find_empty(board)

    def find_empty(self, board):
        return [(i, j) for i in range(2) for j in range(5) if board[i][j] == 0]

    #맨해튼 거리 기반 휴리스틱 계산
    def heuristic(self, board):
        distance = 0
        for i in range(2):
            for j in range(5):
                value = board[i][j]
                if value == 0: 
                    continue
                goal_x, goal_y = (value - 1) // 5, (value - 1) % 5
                distance += abs(goal_x - i) + abs(goal_y - j)
        return distance

    #이동 후 상태 반환
    def move(self, board, empty_positions, direction):
        new_boards = []
        for empty_pos in empty_positions:
            i, j = empty_pos
            di, dj = DIRECTIONS[direction]
            new_i, new_j = i + di, j + dj

            if 0 <= new_i < 2 and 0 <= new_j < 5 and (new_i, new_j) not in empty_positions:
                new_board = [row[:] for row in board]  # 기존 보드 복사
                new_board[i][j], new_board[new_i][new_j] = new_board[new_i][new_j], new_board[i][j]
                new_boards.append((new_board, (new_i, new_j)))

        if len(new_boards) == 2:
            # 두 빈칸이 모두 이동했을 때
            return [new_boards[0][0], [new_boards[0][1], new_boards[1][1]]]
        elif new_boards:
            # 한 개만 이동 가능한 경우
            return [new_boards[0][0], [new_boards[0][1], empty_positions[1] if empty_positions[0] == new_boards[0][1] else empty_positions[0]]]
        return None

    def solve(self):
        """A* 알고리즘을 이용한 퍼즐 해결"""
        priority_queue = []
        visited = set()

        # 초기 상태
        heapq.heappush(priority_queue, (self.heuristic(self.start), 0, self.start, self.empty_positions, []))
        visited.add(tuple(map(tuple, self.start)))

        while priority_queue:
            _, cost, board, empty_positions, path = heapq.heappop(priority_queue)

            # 목표 상태 도달 시 경로 반환
            if board == GOAL_STATE:
                return path

            # 가능한 이동 수행
            for direction in DIRECTIONS.keys():
                result = self.move(board, empty_positions, direction)
                if result:
                    new_board, new_empty_positions = result
                    if tuple(map(tuple, new_board)) not in visited:
                        visited.add(tuple(map(tuple, new_board)))
                        heapq.heappush(priority_queue, (cost + 1 + self.heuristic(new_board), cost + 1, new_board, new_empty_positions, path + [direction]))

        return None  # 해결 불가능한 경우

# 초기 숫자판 (0은 빈칸)
initial_board = [
    [3, 1, 4, 2, 5],
    [6, 0, 7, 8, 0]
]

solver = SlicePuzzle(initial_board)
solution = solver.solve()

if solution:
    print("해결 경로:", " -> ".join(solution))
    print(f"총 {len(solution)}번 이동")
else:
    print("해결 불가능한 퍼즐입니다!")
```
