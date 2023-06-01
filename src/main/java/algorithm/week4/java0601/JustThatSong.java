package algorithm.week4.java0601;

import java.util.ArrayList;
import java.util.List;

class JustThatSong {


  public String solution(String m, String[] musicinfos) {
    String answer = "";
    Integer[] musicLen = new Integer[musicinfos.length];
    String[] musicTit = new String[musicinfos.length];
    String[] musicCon = new String[musicinfos.length];
    List<String> list = new ArrayList<>();
    int max = 0;
    m = convert(m);

    for (int i = 0; i < musicinfos.length; i++) {
      String[] split = musicinfos[i].split(",");
      String[] splitTime1 = split[0].split(":"); //12:59
      String[] splitTime2 = split[1].split(":"); //13:06
      int h1 = Integer.parseInt(splitTime1[0]); //12
      int m1 = Integer.parseInt(splitTime1[1]); //59
      int h2 = Integer.parseInt(splitTime2[0]); //13
      int m2 = Integer.parseInt(splitTime2[1]); //06
      //시간 추출
      int hLong = h2 - h1;
      m2 += hLong * 60;
      musicLen[i] = m2 - m1;

      musicTit[i] = split[2];
      convert(split[3]);
      char[] arr = split[3].toCharArray();
      musicCon[i] = "";
      StringBuilder sb = new StringBuilder(); // 재싱시간동안 재생된 전체멜로디
      for (int j = 0; j < musicLen[i]; j++) { // 전체멜로디 만들기
        sb.append(split[3].charAt(j % split[3].length()));
      }
      musicCon[i] = sb.toString();


    }
    for (int i = 0; i < musicCon.length; i++) {
      if (musicCon[i].contains(m)) {
        if (max < musicCon[i].length()) {
          max = musicCon[i].length();
        }
        answer = musicTit[i];
      }

    }
    return answer;

  }
  private String convert(String m) {
    m = m.replaceAll("A#", "a");
    m = m.replaceAll("C#", "c");
    m = m.replaceAll("D#", "d");
    m = m.replaceAll("F#", "f");
    m = m.replaceAll("G#", "g");
    return m;
  }
}
