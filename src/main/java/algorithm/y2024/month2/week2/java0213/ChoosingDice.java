package algorithm.y2024.month2.week2.java0213;

import java.util.*;

//2024 KAKAO WINTER INTERNSHIP 주사위 고르기
class ChoosingDice {
    static boolean[] isVisited;
    static int n;
    static List<int[]> diceComb;

    static List<Integer> diceScoreA;
    static List<Integer> diceScoreB;


    public static void main(String[] args) {
        ChoosingDice s = new ChoosingDice();
        int[][] dice = new int[][] {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
        s.solution(dice);
    }
    public int[] solution(int[][] dice) {
        int[] answer = new int[n / 2];
        n = dice.length;
        isVisited = new boolean[n];
        diceComb = new ArrayList<>();
        permutation(0, 0, new int[n / 2]);
        int max = Integer.MIN_VALUE;


        for (int[] combA : diceComb) {
            int index = 0;
            int[] combB = new int[n / 2];
            boolean[] other = new boolean[n];

            for (int num : combA) {
                other[num] = true;
            }

            for (int i = 0; i < other.length; i++) {
                if (!other[i]) {
                    combB[index] = i;
                    index++;
                }
            }

            diceScoreA = new ArrayList<>();
            diceScoreB = new ArrayList<>();

            combDice(0, combA, dice, 0, diceScoreA);
            combDice(0, combB, dice, 0, diceScoreB);

            Collections.sort(diceScoreA);
            Collections.sort(diceScoreB);

            int totalWinCount = 0;

            for (Integer a : diceScoreA) {
                int left = 0;
                int right = diceScoreB.size();

                while (left + 1 < right) {
                    int mid = (left + right) / 2;

                    if (a > diceScoreB.get(mid)) {
                        left = mid;
                    } else {
                        right = mid;
                    }

                }
                totalWinCount += left;
            }
            if (totalWinCount > max) {
                max = totalWinCount;
                answer = combA;
            }


        }
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

    private void combDice(int index, int[] dices, int[][] originDice, int sum, List<Integer> team) {
        if (index == dices.length) {
            team.add(sum);
            return;
        }

        for (int i = 0; i < 6; i++) {
            combDice(index + 1, dices, originDice, sum + originDice[dices[index]][i], team);
        }
    }


    private void permutation(int depth, int index, int[] arr) {
        if (depth == n / 2) {
            diceComb.add(arr.clone());
            return;
        }
        for (int i = index; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                arr[depth] = i;
                permutation(depth + 1, i + 1, arr);
                isVisited[i] = false;
            }
        }
    }
}