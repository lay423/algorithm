package algorithm.y2024.month4.week11.java0409;

//단어 변환
class WordConversion {
    private static boolean[] visited;
    private static int answer;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        answer = 0;
        dfs(begin, target, 0, words);
        return answer;
    }
    private static void dfs(String begin, String target, int cnt, String[] words){
        if(begin.equals(target)){
            answer = cnt;
            return;
        }
        for(int i=0; i<words.length; i++){
            if(visited[i])
                continue;
            int k=0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j))
                    k++;
            }
            if(k == begin.length()-1){
                visited[i] = true;
                dfs(words[i], target, cnt + 1, words);
                visited[i] = false;
            }
        }
    }
}