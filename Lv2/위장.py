# 풀이(1)
import collections

class Sub:
    clothes_type = []
    count = []
    answer = 1
    def sep(self, clothes):
        for cloth in clothes:
            self.clothes_type.append(cloth[1])
        self.count = list(collections.Counter(self.clothes_type).values())
        self.count[0] += 1
        self.answer = self.count[0]
        for i in range(1, len(self.count)):
            self.answer += self.answer * self.count[i]
        return self.answer - 1

def solution(clothes):
    a = Sub()
    return a.sep(clothes)

# 풀이(2) => best performance
from collections import Counter
from functools import reduce

def solution(clothes):
    return reduce(lambda x, y: x*y, [a+1 for a in Counter([b[1] for b in clothes]).values()]) - 1