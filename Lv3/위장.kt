class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val sep = HashMap<String, Int>()
        for (cloth in clothes) {
            sep[cloth[1]]?.let { sep.put(cloth[1], it + 1) } ?: sep.put(cloth[1], 1)
        }
        for (i in sep) { answer *= (i.value + 1) }
        return (answer - 1)
    }
}