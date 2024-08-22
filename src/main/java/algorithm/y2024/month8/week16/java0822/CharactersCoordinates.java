package algorithm.y2024.month8.week16.java0822;

import java.util.Arrays;

class CharactersCoordinates {
    static int[] location;
    static int[] margin;

    public static void main(String[] args) {
        CharactersCoordinates s = new CharactersCoordinates();
        int[] solution = s.solution(new String[]{"left", "right", "up", "right", "right"}, new int[]{11, 11});
        System.out.println(Arrays.toString(solution));

    }
    public int[] solution(String[] keyinput, int[] board) {
        location = new int[2];
        margin = board.clone();
        for (String s : keyinput) {
            getLocation(s);
            System.out.println(Arrays.toString(location));
        }
        return location;
    }
    public void getLocation(String input){
        int now=0;
        if(input.equals("left")){
            now = location[0]-1;
            changeLocation(true, now);
        }
        else if(input.equals("right")){
            now = location[0]+1;
            changeLocation(true, now);
        }
        else if(input.equals("up")){
            now = location[1]+1;
            changeLocation(false, now);
        }
        else{
            now = location[1]-1;
            changeLocation(false, now);
        }
    }
    public void changeLocation(boolean isX, int now){
        if(isOutOfBoard(isX, now)){
            if(isX)
                location[0] = now;
            else
                location[1] = now;
        }
    }
    public boolean isOutOfBoard(boolean isX, int now){

        if(isX && Math.abs(now) <= margin[0]/2)
            return true;
        else return !isX && Math.abs(now) <= margin[1] / 2;
    }
}