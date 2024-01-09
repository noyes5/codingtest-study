import sys
from collections import deque

def main():
    N = int(sys.stdin.readline())
    in_cars = deque()
    out_cars = deque()

    for _ in range(N):
        in_cars.append(sys.stdin.readline())

    for _ in range(N):
        out_cars.append(sys.stdin.readline())

    count = 0

    while out_cars:
        out_car = out_cars.popleft()

        if in_cars[0] == out_car:
            in_cars.popleft()
        else:
            count += 1
            remove_car(in_cars, out_car)

    print(count)

def remove_car(queue, car):
    temp = deque()
    while queue:
        current_car = queue.popleft()
        if current_car != car:
            temp.append(current_car)
    queue.extend(temp)

if __name__ == "__main__":
    main()