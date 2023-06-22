package algorithm.week7.java0622;

public class SolvingProcess {

  public static void main(String[] args) {
    SolvingProcess num = new SolvingProcess();
    num.solution(new int[]{2, 2, 2, 2, 2}, 6);
  }
  public int[] solution(int[] sequence, int k) {
    int[] answer = new int[2];
    int depth = sequence.length;
    int start =0;
    int end = 0;
    int size = depth;
    while(true){

      if(getSum(start, end, sequence) > k && start < end && start < depth-1){
        start++;
      }else if(getSum(start, end, sequence)<k && end != depth-1){
        end++;
      }
      if(getSum(start, end, sequence)==k){
        if(size > (end-start)){
          size = end-start;
          answer[0] = start;
          answer[1] = end;
        }
        end++;
      }
      System.out.println("start: "+start+" end: "+end);
      if(start == depth-1 || end == depth|| (end==depth-1 && getSum(start, end, sequence)<k))
        break;
    }//while

    return answer;
  }
  private int getSum(int start, int end, int[] sequence){
    int sum=0;
    for(int i=start; i<=end; i++){
      sum += sequence[i];
    }
    return sum;
  }
}
