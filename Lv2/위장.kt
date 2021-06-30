// 풀이(1)
class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer:Int = 1
        clothes.groupBy { it[1] }
        .toList()
        .map { it.second.size + 1 }
        .map { answer *= it }
        return answer - 1
    }
}

// 풀이(2)
class Solution {
    fun solution(clothes: Array<Array<String>>) = clothes
        .groupBy { it[1] }.values
        .map { it.size + 1 }
        .reduce(Int::times)
        .minus(1)
}

// 풀이(3) => best performance
class Solution {
    fun solution(clothes: Array<Array<String>>) = clothes.groupBy { it[1] }.values.fold(1) { acc, v -> acc * (v.size + 1) }  - 1
}