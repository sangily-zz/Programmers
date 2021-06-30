// queue 사용을 위해 java.util을 import
import java.util.*;

// 중복된 자료를 구분하기 위해 인덱스가 필요하므로 클래스 Data 정의
class Data {
    int address, prior;

    public Data(int address, int prior){
        this.address = address;
        this.prior = prior;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // Data를 로드하기 위한 queue 정의
        Queue<Data> list = new LinkedList<>();
        for(int num=0;num<=(priorities.length-1);num++)
            list.offer(new Data(num, priorities[num]));

        // 값을 모두 출력할때까지 반복(안전장치 : 리미트 개념)
        while(!list.isEmpty()) {
            // 탐색할 때 사용될 트리거
            boolean trigger = false;
            // 대기목록 가장 앞의 문서의 중요도 꺼냄
            int tmp = list.peek().prior;

                // 나머지 대기목록에서 중요도가 더 높은것 순차적 탐색
                for(Data d : list){
                    if(d.prior > tmp)
                        trigger = true;
                }
                // 없으면 출력하고 제외, 단 지정 데이터일 시 반복문 종료
                if(trigger==false){
                    answer++;
                    if(list.peek().address == location)
                        break;
                    else
                        list.poll();
                }
                    // 있으면 문서를 꺼내서 대기목록의 맨 뒤로
                else
                    list.offer(list.poll());

        }
        return answer;
    }
}