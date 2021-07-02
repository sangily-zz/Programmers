// 풀이(1)
class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val q = ArrayList<Pair<Int, Int>>()
        var max_val:Int = 0
        priorities.forEachIndexed { 
            index, value -> q.add(Pair(index, value))
            max_val = if (value > max_val) {value} else {max_val}
        }
        var pop_key:Int? = null

        while (pop_key != location) {
            if (q.get(0).second == max_val) {
                pop_key = q.get(0).first
                q.removeAt(0)
                answer++
                max_val = 0
                q.forEachIndexed { 
                    i, (idx, value) -> max_val = if (value > max_val) {value} else {max_val}
                 }
            } else {
                q.add(q.get(0))
                q.removeAt(0)
            }
        }
        return answer
    }
}

// 풀이(2)
import java.util.*
class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val q = ArrayDeque<Pair<Int, Int>>()
        var max_val:Int = 0
        priorities.forEachIndexed { 
            index, value -> q.offer(Pair(index, value))
            max_val = if (value > max_val) {value} else {max_val}
        }

        while (!q.isEmpty()) {
            var first = q.poll()
            if (first!!.second == max_val) {
                answer++
                if (first.first == location) return answer
                max_val = 0
                q.forEachIndexed { 
                    i, (key, value) -> max_val = if (value > max_val) {value} else {max_val}
                }
            } else q.offer(first)
        }
        return 0
    }
}