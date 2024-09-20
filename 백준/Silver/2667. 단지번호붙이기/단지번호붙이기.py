import sys


def dfs(x, y):
    global cnt
    dxs = [-1, 0, 1, 0]
    dys = [0, 1, 0, -1]

    for d in range(4):
        nx, ny = x + dxs[d], y + dys[d]

        if can_go(nx, ny):
            visited[nx][ny] = True
            cnt += 1
            dfs(nx, ny)


def can_go(nx, ny):
    return 0 <= nx < n and 0 <= ny < n and arr[nx][ny] == 1 and not visited[nx][ny]


n = int(sys.stdin.readline().strip())
arr = [list(map(int, list(sys.stdin.readline().strip()))) for _ in range(n)]
visited = [[False] * n for _ in range(n)]

ans = []

for i in range(n):
    for j in range(n):
        if arr[i][j] == 1 and not visited[i][j]:
            visited[i][j] = True
            cnt = 1
            dfs(i, j)
            ans.append(cnt)

ans.sort()
print(len(ans))
for data in ans:
    print(data)