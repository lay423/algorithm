package algorithm.y2024.month4.week13.java0427;

public class S3 {
    public boolean solution(String amountText) {
        int n = amountText.length();
        if(amountText.equals("0"))
            return true;
        if(amountText.charAt(0) == '0' || amountText.charAt(0) == ',')
            return false;
        if(amountText.charAt(n-1) == ',')
            return false;
        for(int i=0; i<n; i++) {
            char now = amountText.charAt(i);
            if (!(('0' <= now && now <= '9') || now == ',')) {
                return false;
            }
        }
        if(amountText.contains(",")){
            String[] split = amountText.split(",");
            for(int i=1; i<split.length; i++){
                if(split[i].length() != 3)
                    return false;
            }
        }

        return true;
    }
}
