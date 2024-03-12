package algorithm.y2024.month3.week6.java0312;

//호텔 대실
class HotelRoom {
    public int solution(String[][] book_time) {
        int answer = 0;
        int MAX_TIME = 24 * 60 + 10;
        int[] rooms = new int[MAX_TIME];
        for(String[] time : book_time){
            String inTime = time[0];
            String outTime = time[1];

            rooms[convertTime(inTime)] += 1;
            rooms[convertTime(outTime)+10] -= 1;
        }

        for(int i = 1; i< MAX_TIME; i++){
            rooms[i] += rooms[i-1];
            answer = Math.max(answer, rooms[i]);
        }
        return answer;
    }

    private static int convertTime(String time){
        String[] str = time.split(":");
        String hour = str[0];
        String minute = str[1];
        return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
    }
}