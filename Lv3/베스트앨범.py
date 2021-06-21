def find_best_and_pop(d):
    best = list(d.keys())[0]
    for key in d:
        if d[key] > d[best]:
            best = key
    d.pop(best)
    return best

def last(lst, idx):
    retbool = False
    ret = 0
    if len(lst) >= idx + 2:
        if lst[idx][0] == lst[idx + 1][0]:
            ret = last(lst, idx + 1)[0]
            retbool = True
        else:
            return (idx, retbool)
    else:
        return (idx, retbool)
    return (ret, retbool)

def solution(genres, plays):
    answer = []
    genre = dict()
    total = dict()
    last_idx = 0

    for idx in range(len(plays)):
        genre.setdefault(genres[idx], list())
        genre[genres[idx]].append((plays[idx], idx))
        total.setdefault(genres[idx], 0)
        total[genres[idx]] += plays[idx]
    for key in genre:
        genre[key].sort(reverse=True)
    for cnt in range(len(total)):
        best = find_best_and_pop(total)
        if len(genre[best]) == 1:
            answer.append(genre[best][0][1])
        else:
            if last(genre[best], 0)[1] == True:
                last_idx = last(genre[best], 0)[0]
                answer.append(genre[best][last_idx][1])
                answer.append(genre[best][last_idx - 1][1])
            else:
                answer.append(genre[best][0][1])
                last_idx = last(genre[best], 1)[0]
                answer.append(genre[best][last_idx][1])
    return answer