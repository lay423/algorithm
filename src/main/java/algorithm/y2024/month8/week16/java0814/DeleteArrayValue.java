package algorithm.y2024.month8.week16.java0814;
import java.util.*;

class DeleteArrayValue {
    public static void main(String[] args) {
        DeleteArrayValue s = new DeleteArrayValue();
        int[] solution = s.solution(new int[]{293, 1000, 395, 678, 94}, new int[]{94, 777, 104, 1000, 1, 12});
        System.out.println(Arrays.toString(solution));
    }
    public int[] solution(int[] arr, int[] delete_list) {
        List<String> list = new ArrayList<>();
        for(int num : arr){
            list.add(""+num);
        }
        for(int num : delete_list){
            list.remove(""+num);
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = Integer.parseInt(list.get(i));
        }
        return answer;
    }
}