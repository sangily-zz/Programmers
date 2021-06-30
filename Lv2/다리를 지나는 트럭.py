from queue import deque

def solution(bridge_length, weight, truck_weights):
    line = deque([0]*bridge_length)
    trucks = deque(truck_weights)
    time = tmp = 0
    while len(line):
        time += 1
        tmp -= line.popleft()
        if len(trucks):
            if tmp + trucks[0] <= weight:
                tmp += trucks[0]
                line.append(trucks.popleft())
            else:
                line.append(0)
    return time