package algorithm.y2024.month3.week7.java0321;

import java.util.Arrays;

//이모티콘 할인행사
class EmoticonDiscountEvent {
    static int[] discount;
    static int N;
    static int M;
    static int maxPlusCnt=0;
    static int maxSales=0;
    static int[][] userInfo;
    static int[] emo;

    public static void main(String[] args) {
        EmoticonDiscountEvent s = new EmoticonDiscountEvent();
        System.out.println(Arrays.toString(s.solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000})));
    }
    public int[] solution(int[][] users, int[] emoticons) {

        userInfo = users.clone();
        emo = emoticons.clone();
        N = emoticons.length;
        M = users.length;
        discount = new int[N];

        getDiscount(0);

        return new int[] {maxPlusCnt, maxSales};
    }
    private static void getDiscount(int depth){
        if(depth == N){
            int pCnt=0;
            int sales=0;
            for(int i=0; i<M; i++){
                int sum=0;
                int disInfo = userInfo[i][0];
                int plusInfo = userInfo[i][1];
                for(int j=0; j<N; j++){

                    if(discount[j] >= disInfo){
                        int emoPrice = emo[j]*(100-discount[j])/100;
                        sum += emoPrice;
                    }
                    if(sum >= plusInfo){
                        sum = 0;
                        pCnt++;
                        break;
                    }
                }
                sales += sum;
            }
            if((maxPlusCnt < pCnt) || (maxPlusCnt == pCnt && maxSales < sales)){
                maxPlusCnt = pCnt;
                maxSales = sales;
            }
            return;
        }
        for(int i=1; i<=4; i++){
            discount[depth] = i * 10;
            getDiscount(depth+1);
        }
    }

}