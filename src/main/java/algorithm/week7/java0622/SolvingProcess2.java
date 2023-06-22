package algorithm.week7.java0622;

public class SolvingProcess2 {

  public static void main(String[] args) {
    SolvingProcess2 so = new SolvingProcess2();
    so.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
  }
  public int solution(int[] stones, int k) {
    int answer = 0;
    int cnt = 0;

    while(true){
      for(int i=0; i<stones.length; i++){
        if(stones[i] < 0)
          cnt++;
        else if(stones[i] != 0)
          cnt = 0;
        if(cnt == k)
          return answer;
      }

      int min = getMin(stones);
      answer += min;
      for(int i=0; i<stones.length; i++){
        stones[i] = stones[i] - min;
      }
      System.out.println(answer);
    }
  }
  private int getMin(int[] stones){
    int min=Integer.MAX_VALUE;
    for(int stone : stones){
      if(stone < min && stone > 0)
        min = stone;
    }
    return min;
  }
}
