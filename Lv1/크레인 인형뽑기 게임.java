// 선입후출 자료형 = Stack
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> blk = new Stack<>();
        for(int x : moves){
            for(int y=0; y<=(board.length-1); y++){
                if(board[y][x-1]!=0){
                    if(blk.isEmpty() || blk.peek() != board[y][x-1])
                        blk.add(board[y][x-1]);
                    else{
                        blk.pop();
                        answer += 2; }
                    board[y][x-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}