from queue import deque

def solution(progresses, speeds):
    answer = []
    tmp = deque(progresses)
    ref = deque(speeds)
    while len(tmp) != 0:
        count = 0
        for i in range(len(tmp)):
            tmp[i] += ref[i]
        while len(tmp) != 0 and tmp[0] >= 100:
            count += 1
            tmp.popleft()
            ref.popleft()
        if count!=0:
            answer.append(count)
    return answer