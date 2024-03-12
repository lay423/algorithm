package algorithm.y2024.month3.week6.java0313;

import java.util.*;

//숫자 카드 나누기
class CardDivision1 {
    public int solution(int[] arrayA, int[] arrayB) {
        int MAX = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int n1 = arrayA[0], n2 = arrayB[0];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i=1; i<=(int)Math.sqrt(n1); i++){
            if(n1 % i ==0){
                list1.add(i);
                if(n1/i != i){
                    list1.add(n1/i);
                }
            }
        }
        for(int i=1; i<=(int)Math.sqrt(n2); i++){
            if(n2 % i ==0){
                list2.add(i);
                if(n2/i != i){
                    list2.add(n2/i);
                }
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);

        for(int i=list1.size()-1; i>0; i--){
            int j = list1.get(i);
            boolean flag = true;
            for(int num : arrayA){
                if(num%j != 0){
                    flag = false;
                    break;
                }
            }
            if(!flag)
                continue;
            for(int num : arrayB){
                if(num%j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                MAX = j;
                break;
            }

        }
        for(int i=list2.size()-1; i>0; i--){
            int j = list2.get(i);
            boolean flag = true;
            for(int num : arrayB){
                if(num%j != 0){
                    flag = false;
                    break;
                }
            }
            if(!flag)
                continue;
            for(int num : arrayA){
                if(num%j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                MAX = Math.max(MAX, j);
                break;
            }
        }

        return MAX;
    }
}