import math

def get_arr_gcd(arr):
    gcd = arr[0]
    for x in arr[1:]:  
        gcd = math.gcd(gcd, x)
    return gcd

def valid(a, other):
	return all(o % a != 0 for o in other)

def solution(arrayA, arrayB):
    gA = get_arr_gcd(arrayA)
    gB = get_arr_gcd(arrayB)

    answer = 0
    if valid(gA, arrayB):
        answer = max(answer, gA)
    if valid(gB, arrayA):
        answer = max(answer, gB)
    return answer