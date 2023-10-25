package algorithm.month0.week13.java0804;

class SumOfSubsequence { // MODEL ANSWER
  public int[] solution(int[] sequence, int k) {
    int size = sequence.length;
    int left = 0;
    int right = 0;
    int sum = sequence[0];
    int len = Integer.MAX_VALUE;

    int leftAnswer = left;
    int rightAnswer = right;

    while (right < size && left < size) {
      if (sum < k && right + 1 <= size) {
        sum += sequence[++right];
      }
      else if (sum > k) {
        sum -= sequence[left++];
      }
      else {
        if (right - left < len) {
          len = right - left;
          leftAnswer = left;
          rightAnswer = right;
        }

        sum += sequence[left++];
      }
    }
    return new int[] { leftAnswer, rightAnswer };
  }
}
