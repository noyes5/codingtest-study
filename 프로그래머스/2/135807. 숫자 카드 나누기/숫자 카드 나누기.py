import math

def arr_gcd(arr):
    gcd = arr[0]
    for x in arr[1:]:
        gcd = math.gcd(gcd, x)
    
    return gcd

def valid(gcd, other):
    for x in other:
        if x % gcd == 0:
            return False
        
    return True

def solution(arrayA, arrayB):
    gA = arr_gcd(arrayA)
    gB = arr_gcd(arrayB)

    answer = 0
    if valid(gA, arrayB):
        answer = max(answer, gA)
    if valid(gB, arrayA):
        answer = max(answer, gB)
    return answer