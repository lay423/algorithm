package algorithm.month0.week4.java0529;

class Solution {
  public String solution(int[] numbers, String hand) {
    String answer="";
    int[][] pad = {{1,2,3,},{4,5,6},{7,8,9},{10,0,11}};
    int[][] location = new int[numbers.length][2];

    for(int i=0; i<numbers.length; i++){
      int num = numbers[i];
      int[] loc = getLocation(num);
      location[i][0] = loc[0];
      location[i][1] = loc[1];
    }
    for(int i=0; i<numbers.length; i++){
      int lr = 3;
      int lc = 0;
      int rr = 3;
      int rc = 2;
      if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
        answer+= "L";
        int[] loc1 = getLocation(numbers[i]);
        lr = loc1[0];
        lc = loc1[1];
      }else if(numbers[i]==3 || numbers[i]==6 || numbers[i]== 9){
        answer += "R";
        int[] loc1 = getLocation(numbers[i]);
        rr = loc1[0];
        rc = loc1[1];
      }
      else{
        if(isLeft(lr, lc, rr, rc, getLocation(numbers[i]), hand)){
          answer+= "L";
          int[] loc1 = getLocation(numbers[i]);
          lr = loc1[0];
          lc = loc1[1];
        }
        else
        {
          answer += "R";
          int[] loc1 = getLocation(numbers[i]);
          rr = loc1[0];
          rc = loc1[1];
        }
      }
    }



    return answer;
  }
  private static int[] getLocation(int num){
    int[] location = new int[2];
    if(num == 0){
      return new int[]{1, 3};
    }
    num -=1;
    location[0] = num/3;
    location[1] = num%3;
    return location;

  }

  private static boolean isLeft(int lr, int lc, int rr, int rc, int[] location, String hand){
    String answer="";
    for(int i=0; i<location.length; i++){
      int ld = Math.abs(lr - location[0]) + Math.abs(lc - location[1]);
      int rd = Math.abs(rr - location[0]) + Math.abs(rc - location[1]);

      if(ld > rd || (ld == rd && hand == "right")){
        answer += "R";
        rr = location[0];
        rc = location[1];
        return false;
      }else if(ld < rd || (ld == rd && hand == "left")){
        answer += "L";
        lr = location[0];
        lc = location[1];
        return true;
      }
    }
    return true;
  }
}