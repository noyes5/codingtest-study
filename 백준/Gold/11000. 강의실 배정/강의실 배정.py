import heapq
import sys

input = sys.stdin.readline

N = int(input())
lecture_time = []

for _ in range(N):
    start, end = map(int, input().split())
    lecture_time.append((start, end))

lecture_time.sort(key=lambda x: x[0])

end_time_q = []

for lecture in lecture_time:
    if end_time_q and end_time_q[0] <= lecture[0]:
        heapq.heappop(end_time_q)
    heapq.heappush(end_time_q, lecture[1])

print(len(end_time_q))