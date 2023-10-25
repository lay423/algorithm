package algorithm.month0.week4.java0531;

class KeyPad {
  public String solution(int[] numbers, String hand) {
    StringBuilder sb = new StringBuilder();

    int left = 10;
    int right = 12;

    for(int i=0; i<numbers.length; i++){
      int n =numbers[i];

      if(n == 1 || n == 4 || n == 7){
        left = n;
        sb.append("L");
      }else if(n == 3 || n == 6 || n == 9){
        right = n;
        sb.append("R");
      }
      else{
        if(n==0) n = 11;

        int leftDi = (Math.abs(n-left)/3) + (Math.abs(n-left)%3);
        int rightDi = (Math.abs(n-right)/3) + (Math.abs(n-right)%3);

        if(leftDi == rightDi){
          if(hand.equals("right")){
            right = n;
            sb.append("R");
          }else{
            left=n;
            sb.append("L");
          }
        }else if(leftDi>rightDi){
          right = n;
          sb.append("R");
        }else{
          left = n;
          sb.append("L");
        }
      }
    }
    return sb.toString();
  }
}
