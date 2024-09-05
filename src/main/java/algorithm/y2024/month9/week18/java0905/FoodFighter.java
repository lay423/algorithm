package algorithm.y2024.month9.week18.java0905;

class FoodFighter {
    static StringBuilder sb = new StringBuilder();
    public String solution(int[] food) {
        for(int i=0; i<food.length; i++){
            append(food, i);
        }
        sb.append("0");
        for(int i=food.length-1; i>=0; i--){
            append(food, i);
        }

        return sb.toString();
    }

    private static void append(int[] food, int idx){
        int num = food[idx];
        for(int i=0; i<num/2; i++)
            sb.append(idx);
    }
}