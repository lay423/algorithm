package algorithm.y2024.month2.week3.java0223;
class FoodFighterCompetition {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        String[] st = new String[food.length];
        for(int i=1; i<food.length; i++){
            if(food[i]%2==1)
                food[i] -=1;
            StringBuilder sb1 = new StringBuilder();
            for(int j=0; j<food[i]/2; j++){
                sb1.append(i);
            }
            st[i] = sb1.toString();
            sb.append(st[i]);
        }
        sb.append(0);
        for(int i=food.length-1; i>0; i--){
            sb.append(st[i]);
        }
        return sb.toString();
    }
}