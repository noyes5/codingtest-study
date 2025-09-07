from itertools import combinations

def solution(orders, course):
    orders = [''.join(sorted(o)) for o in orders]
    result = []

    for r in course:
        freq = {}  # 조합별 빈도수 기록

        # 주문별 r개 조합 만들기
        for o in orders:
            if len(o) < r:
                continue
            for comb in combinations(o, r):
                menu = ''.join(comb)
                if menu in freq:
                    freq[menu] += 1
                else:
                    freq[menu] = 1

        # 최빈값 찾기
        max_cnt = 0
        for cnt in freq.values():
            if cnt > max_cnt:
                max_cnt = cnt

        # 최빈값이 2 이상인 조합들만 결과에 추가
        if max_cnt >= 2:
            for menu, cnt in freq.items():
                if cnt == max_cnt:
                    result.append(menu)

    result.sort()
    return result