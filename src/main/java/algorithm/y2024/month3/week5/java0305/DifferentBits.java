package algorithm.y2024.month3.week5.java0305;

//2개 이하로 다른 비트
class DifferentBits {
    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for(int i=0; i<numbers.length; i++){
            answer[i]++;
            answer[i] += (answer[i] ^ numbers[i]) >>2;
        }
        return answer;
    }
}