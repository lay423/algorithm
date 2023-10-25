package algorithm.month0.week7.java0621;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class OverTimeIndex {
  public long solution(int n, int[] works) {
    long answer = 0;

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int work : works) {
      pq.add(work);
    }

    while (n-- > 0) {
      if (pq.peek() == 0) {
        break;
      }

      pq.add(pq.poll() - 1);

    }

    return getOvertimeIdx(pq);
  }
  static long getOvertimeIdx(Queue<Integer> q) {
    long sum = 0;
    while (!q.isEmpty()) {
      Integer num = q.poll();
      sum += (long)num * num;
    }

    return sum;
  }
}
