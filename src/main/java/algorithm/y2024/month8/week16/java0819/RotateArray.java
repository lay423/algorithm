package algorithm.y2024.month8.week16.java0819;

class RotateArray {
    public int[] solution(int[] numbers, String direction) {

        if(direction.equals("right")){
            int tmp = numbers[numbers.length-1];
            for(int i=numbers.length-1; i>0; i--){
                numbers[i] = numbers[i-1];
            }
            numbers[0] = tmp;
        }else{
            int tmp = numbers[0];
            for(int i=0; i<numbers.length-1; i++){
                numbers[i] = numbers[i+1];
            }
            numbers[numbers.length-1] = tmp;
        }
        return numbers;
    }
}