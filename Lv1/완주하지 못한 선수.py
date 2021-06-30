def solution(participant, completion):
    counter = {}
    for member in participant:
        counter[member] = 0
    for member in completion:
        counter[member] += 1
    for member in participant:
        if counter[member] == 0: return member
        else: counter[member] -= 1