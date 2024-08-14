package algorithm.y2024.month8.week16.java0814;

class SplitWithBlank {
    public String[] solution(String my_string) {
        my_string = my_string.replaceAll("\\s+", " ").trim();
        return my_string.split(" ");
    }
}