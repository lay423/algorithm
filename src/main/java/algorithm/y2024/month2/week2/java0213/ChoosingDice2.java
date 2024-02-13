package algorithm.y2024.month2.week2.java0213;

import java.util.*;


//2024 KAKAO WINTER INTERNSHIP 주사위 고르기
//디시풀기:2
class ChoosingDice2 {
    static int n;
    static boolean[] visited;

    static List<int[]> diceComb;
    static List<Integer> aScore;
    static List<Integer> bScore;

    public int[] solution(int[][] dice) {
        int[] answer = new int[n / 2];
        diceComb = new ArrayList<>();
        n = dice.length;
        visited = new boolean[n];
        int max = Integer.MIN_VALUE;


        //주사위 조합
        permutation(0, 0, new int[n / 2]);


        for (int[] aComb : diceComb) {
            int[] bComb = new int[n / 2];
            int index = 0;
            boolean[] other = new boolean[n];

            for (int num : aComb) {
                other[num] = true;
            }

            for (int i = 0; i < other.length; i++) {
                if (!other[i]) {
                    bComb[index] = i;
                    index++;
                }
            }
            aScore = new ArrayList<>();
            bScore = new ArrayList<>();

            getDiceScore(0, aComb, dice, 0, aScore);
            getDiceScore(0, bComb, dice, 0, bScore);

            Collections.sort(aScore);
            Collections.sort(bScore);

            //이진 탐색 시작
            int totalWinCount = 0;

            for (Integer a : aScore) {
                int left = 0;
                int right = bScore.size();

                while (left + 1 < right) {
                    int mid = (left + right) / 2;

                    if (a > bScore.get(mid)) {
                        left = mid;
                    } else {
                        right = mid;
                    }

                }
                totalWinCount += left;
            }
            if (totalWinCount > max) {
                max = totalWinCount;
                answer = aComb;
            }

        }//for

        int[] answer2 = new int[n / 2];
        if (n == 2) {
            return new int[]{answer[0] + 1};
        } else {
            for (int i = 0; i < answer.length; i++) {
                answer2[i] = answer[i] + 1;
            }
        }


        return answer2;
    }

    private void getDiceScore(int index, int[] diceNum, int[][] originDice, int sum, List<Integer> team) {
        if (index == diceNum.length) {
            team.add(sum);
            return;
        }
        for (int i = 0; i < 6; i++) {
            getDiceScore(index + 1, diceNum, originDice, sum + originDice[diceNum[index]][i], team);
        }
    }

    private void permutation(int depth, int index, int[] arr) {
        if (depth == n / 2) {
            diceComb.add(arr.clone());
            return;
        }
        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                permutation(depth + 1, i + 1, arr);
                visited[i] = false;
            }
        }
    }
}
