package algorithm.month0.week9.java0706;

//10분08초 소요
public class DesktopCleanUp {
  public int[] solution(String[] wallpaper) {
    int[] answer = new int[4];
    int n = wallpaper.length;
    int m = wallpaper[0].length();
    int[] lu = {n, m};
    int[] rd = {0, 0};

    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(wallpaper[i].charAt(j) == '#'){
          if(lu[0]>i)
            lu[0]=i;
          if(lu[1]>j)
            lu[1]=j;
          if(rd[0]<i)
            rd[0] = i;
          if(rd[1]<j)
            rd[1]=j;
        }
      }
    }
    return new int[]{lu[0], lu[1], rd[0]+1, rd[1]+1};
  }
}
