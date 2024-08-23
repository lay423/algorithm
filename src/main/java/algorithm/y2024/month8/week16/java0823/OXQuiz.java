package algorithm.y2024.month8.week16.java0823;

class OXQuizd {
    public String[] solution(String[] quiz) {
        String[] result = new String[quiz.length];
        for(int i=0; i<quiz.length; i++){
            if(isCorrect(quiz[i]))
                result[i] = "O";
            else
                result[i] = "X";
        }
        return result;
    }
    private boolean isCorrect(String quiz){
        String[] arr = quiz.split(" ");
        int X = stringToInt(arr[0]);
        int Y = stringToInt(arr[2]);
        int Z = stringToInt(arr[4]);
        if(arr[1].equals("+")){
            if((X + Y) == Z)
                return true;
        }else if(arr[1].equals("-")){
            if(Y<0){
                Y *= -1;
                if((X + Y) == Z)
                    return true;
            }else{
                if((X - Y) == Z)
                    return true;
            }

        }
        return false;
    }
    private int stringToInt(String str){
        int result = 1;
        if(str.charAt(0) == '-'){
            str = str.substring(1);
            result *= -1;
        }
        return result * Integer.parseInt(str);
    }
}