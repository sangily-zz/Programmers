def solution(phone_book):
    
    for i in range(len(phone_book)):
        for j in range(len(phone_book)):
            if i==j: continue
            if phone_book[j].startswith(phone_book[i]): return False
    return True