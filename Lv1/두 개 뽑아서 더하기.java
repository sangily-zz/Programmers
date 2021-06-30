// 중복을 허용하지 않는 자료형 Set
import java.util.Set;
// Set의 두 유형 중 순서가 있는(오름차순) 자료형 TreeSet
import java.util.TreeSet;
// Set에서 데이터 추출을 위한 Iterator
import java.util.Iterator;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        // 두 수의 합을 잠시 담아 둘 Set 정의
        Set<Integer> tmp = new TreeSet<>();
        // 정수 배열의 두 수를 더하는 모든 경우를 셈하기 위한 이중반복문
        for(int i=0;i<=(numbers.length-2);i++){
            for(int j=i+1;j<=(numbers.length-1);j++){
                tmp.add(numbers[i]+numbers[j]);
            }
        }
        // answer가 이미 초기화 안된 채로 정의되어 있어서,,
        // tmpArray를 TreeSet의 사이즈로 만들어서 클론으로 복제할 계획
        int[] tmpArray = new int[tmp.size()];
        // Iterator로 TreeSet의 데이터 하나씩 tmpArray에 저장
        Iterator<Integer> data = tmp.iterator();
        for(int index=0;data.hasNext()==true;index++){
            tmpArray[index] = data.next();
        }
        // 배열 복제
        answer = tmpArray.clone();
        
        return answer;
    }
}