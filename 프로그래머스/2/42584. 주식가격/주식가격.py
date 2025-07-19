def solution(prices):
    N = len(prices)
    answer = [0] * N
    for i in range(N):
        count = 0
        for j in range(i + 1, N):
            count += 1
            if prices[i] > prices[j]:
                break
        answer[i] = count
    return answer 