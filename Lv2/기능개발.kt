class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val tmp = mutableListOf<Int>()
        for (i in progresses.indices) {
            if ((100 - progresses[i]) % speeds[i] != 0) {
                tmp.add((100 - progresses[i]) / speeds[i] + 1)
            } else {
                tmp.add((100 - progresses[i]) / speeds[i])
            }
        }
        var count = 0
        var flag = 0
        var answer = mutableListOf<Int>()
        for (i in tmp) {
            if (flag == 0) {
                flag = i
                count++
            } else {
                if (flag >= i) {
                    count++
                } else {
                    flag = i
                    answer.add(count)
                    count = 1
                }
            }
        }
        answer.add(count)
        return answer.toIntArray()
    }
}