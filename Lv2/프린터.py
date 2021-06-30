from queue import deque

def solution(priorities, location):
    answer = 0
    que = deque()
    for i in range(len(priorities)):
        que.appendleft((priorities[i], i))
    while not len(que) == 0:
        if len(que) == 1:
            return answer + 1
        tmp = que.pop()
        if tmp[0] < max(que)[0]:
            que.appendleft(tmp)
        else:
            answer += 1
            if tmp[1] == location:
                break
    return answer