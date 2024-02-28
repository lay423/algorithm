package algorithm.y2024.month2.week4.java0229;
class TakeGroupPhoto {
    static int answer;
    static char[][] condition;

    public int solution(int n, String[] data) {
        answer = 0;
        char[] cArr = new char[] {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        boolean[] visited = new boolean[cArr.length];
        condition = new char[data.length][4];

        for(int i=0; i<n; i++){
            condition[i][0] = data[i].charAt(0);
            condition[i][1] = data[i].charAt(2);
            condition[i][2] = data[i].charAt(3);
            condition[i][3] = data[i].charAt(4);
        }

        permutation(0, cArr, visited, "");

        return answer;
    }
    private static void permutation(int depth, char[] cArr, boolean[] visited, String str){
        if(depth == cArr.length){
            if(checkCondition(str))
                answer++;
            return;
        }

        for(int i=0; i<cArr.length; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            permutation(depth+1, cArr, visited, str+ cArr[i]);
            visited[i] = false;
        }
    }

    private static boolean checkCondition(String str){
        for(char[] cond : condition){
            int idx1 = str.indexOf(cond[0]);
            int idx2 = str.indexOf(cond[1]);
            int distance = Math.abs(idx2 - idx1) - 1;
            int detail = cond[3] - '0';

            switch(cond[2]){
                case '>':
                    if(distance <= detail){
                        return false;}
                    break;
                case '=':
                    if(distance != detail){
                        return false;
                    }
                    break;
                case '<':
                    if(distance >= detail){
                        return false;
                    }

                    break;
            }

        }
        return true;
    }
}