package algorithm.y2024.month2.week4.java0228;

import java.util.*;

class DataAnalysis {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int targetIdx = findNumByCategory(ext);
        int sortIdx = findNumByCategory(sort_by);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            if (data[i][targetIdx] < val_ext) {
                list.add(i);
            }
        }
        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = data[list.get(i)];
        }

        Arrays.sort(answer, (o1, o2) -> {
            if (o1[sortIdx] > o2[sortIdx]) {
                return 50;
            } else if (o1[sortIdx] < o2[sortIdx]) {
                return -50;
            }
            return 0;
        });


        return answer;
    }

    private static int findNumByCategory(String category) {
        int targetIdx = -1;
        switch (category) {
            case "code":
                targetIdx = 0;
                break;
            case "date":
                targetIdx = 1;
                break;
            case "maximum":
                targetIdx = 2;
                break;
            case "remain":
                targetIdx = 3;
                break;
        }
        return targetIdx;
    }
}
