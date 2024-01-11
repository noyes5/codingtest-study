from collections import deque
import sys


def dfs(number):
    dfs_result.append(number)
    visited[number] = True

    for i in range(1, n + 1):
        if graph[number][i] == 1 and not visited[i]:
            dfs(i)


def bfs(number):
    q = deque()
    q.append(number)
    visited[number] = True

    while q:
        node = q.popleft()
        bfs_result.append(node)

        for nv in range(1, n + 1):
            if graph[node][nv] == 1 and not visited[nv]:
                visited[nv] = True
                q.append(nv)


# 입력 처리
n, m, start = map(int, sys.stdin.readline().strip().split())

graph = [[0] * (n + 1) for _ in range(n + 1)]
visited = [False] * (n + 1)

for _ in range(m):
    first, second = map(int, sys.stdin.readline().strip().split())
    graph[first][second] = 1
    graph[second][first] = 1

dfs_result = []
bfs_result = []

dfs(start)
visited = [False] * (n + 1)
bfs(start)

print(' '.join(map(str, dfs_result)))
print(' '.join(map(str, bfs_result)))
