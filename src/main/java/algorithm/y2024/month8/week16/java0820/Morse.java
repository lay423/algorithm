package algorithm.y2024.month8.week16.java0820;

class Morse {
    public String solution(String letter) {
        StringBuilder sb = new StringBuilder();
        String[] morse = new String[] {
                ".-","-...","-.-.","-..",".","..-.","--."
                ,"....","..",".---","-.-",".-..","--"
                ,"-.","---",".--.","--.-",".-.","..."
                ,"-","..-","...-",".--","-..-","-.--","--.."
        };
        String[] split = letter.split(" ");
        for (String s : split) {
            for (int j = 0; j < morse.length; j++) {
                if (s.equals(morse[j])) {
                    sb.append((char) (j + 'a'));
                    break;
                }
            }
        }
        return sb.toString();
    }
}
