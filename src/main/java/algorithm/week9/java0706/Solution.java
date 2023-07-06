package algorithm.week9.java0706;

//공원산책 문제 풀이 실패
class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    //solution.solution(new String[]{"SOO","OOO","OOO"},	new String[]{"E 2","S 2","W 1"});
    solution.solution(new String[]{"OSO","OOO","OXO","OOO"},	new String[]{"E 2","S 3","W 1"});
  }
  public int[] solution(String[] park, String[] routes) {
    int[] answer = {0, 0};
    for(int i=0; i<park.length; i++){
      for(int j=0; j<park[0].length(); j++){
        if(park[i].charAt(j)=='S'){
          answer = new int[]{i, j};
          break;
        }

      }
    }
    for(int i=0; i<routes.length; i++){
      int[] point = getPoint(routes[i]);
      int nY = answer[0]+point[0];
      int nX = answer[1]+point[1];
      System.out.println(""+answer[0]+", "+answer[1]+"");
      //System.out.println(nY+", "+nX);
      if(nY<0 || nY>park.length-1 || nX<0 || nX>park.length-1)
        continue;

      if(point[0] >0){
        for(int j=0; j<point[0]; j++){
          if(park[answer[0]+j].charAt(answer[1])=='X')
            continue;
        }
      }else if(point[0]<0){
        for(int j=0; j>point[0]; j--){
          if(park[answer[0]+j].charAt(answer[1])=='X')
            continue;
        }
      }else if(point[1]>0){
        for(int j=0; j<point[1]; j++){
          if(park[answer[0]].charAt(answer[1]+j)=='X')
            continue;
        }
      }else if(point[1]<0){
        for(int j=0; j>point[1]; j--){
          if(park[answer[0]].charAt(answer[1]+j)=='X')
            continue;
        }
      }


      answer = new int[]{nY, nX};
      //System.out.println(""+answer[0]+", "+answer[1]+"");
    }
    return answer;
  }
  private static int[] getPoint(String route){
    int[] point={0,0};
    String[] str = route.split(" ");
    int dis = Integer.parseInt(str[1]);
    if(str[0].equals("N"))
      point = new int[]{-1*dis, 0, -1*dis};
    else if(str[0].equals("E"))
      point = new int[]{0, dis, dis};
    else if(str[0].equals("S"))
      point = new int[]{dis, 0, dis};
    else if(str[0].equals("W"))
      point = new int[]{0, -1*dis, -1*dis};

    return point;
  }
}
