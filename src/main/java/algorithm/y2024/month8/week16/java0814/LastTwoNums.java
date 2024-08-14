package algorithm.y2024.month8.week16.java0814;

class LastTwoNums {
    public int[] solution(int[] num_list) {
        int size = num_list.length;
        int[] answer = new int[size+1];
        for(int i=0; i<size; i++){
            answer[i] = num_list[i];
        }
        int num1 = answer[size-2];
        int num2 = answer[size-1];
        if(num1 >= num2){
            answer[size] = num2*2;
        }else
            answer[size] = num2-num1;


        return answer;
    }
}
