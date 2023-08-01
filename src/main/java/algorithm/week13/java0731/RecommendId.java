package algorithm.week13.java0731;

class RecommendId {
  public String solution(String new_id) {
    String answer = new_id;

    answer = answer.toLowerCase();
    answer = answer.replaceAll("[^a-z0-9-_.]","");
    answer = answer.replaceAll("[.]{2,}",".");
    answer = answer.replaceAll("^[.]|[.]$","");

    if(answer.equals(""))
      answer += "a";

    if(answer.length()>15){
      answer = answer.substring(0, 15);
      answer = answer.replaceAll("[.]$","");
    }


    if(answer.length()==1){
      String str = answer + answer;
      answer = str + answer;
    }else if(answer.length()==2){
      answer = answer + answer.charAt(1);
    }

    return answer;
  }
}
